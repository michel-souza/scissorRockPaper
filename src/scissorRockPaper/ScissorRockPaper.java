package scissorRockPaper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScissorRockPaper {
	static List<Player> winners = new ArrayList<Player>();
	
	public static void main(String[] args) {
		String[][] dados = {{"jose", "P"}, {"joao", "R"},{"pedro", "S"}, {"Ricardo", "R"}};
		Player winner;
		try {
			winner = scissorRockPaper(convertArrayToList(dados));
			String vencedor = String.format("o vencedor foi %s com a escolha %s", winner.getNome(), winner.getJogada());
			System.out.println(vencedor);
		} catch (WrongNumberOfPlayerError | NoSuchStrategyError e) {			
			e.printStackTrace();
		}		
	}

	private static List<Player> convertArrayToList(String[][] dados) {
		List<Player> players = new ArrayList<Player>();
		for (String[] p : Arrays.asList(dados)) {
			Player player = new Player(p[0].toString(), p[1].toString());
			players.add(player);
		}
		return players;
	}
	
	private static Player scissorRockPaper(List<Player> dados) throws WrongNumberOfPlayerError, NoSuchStrategyError {				
		Player vencedor = jogar(dados);
		dados = removeJogadores(dados, vencedor);		
		if (!dados.isEmpty() && dados.size() != 1) {
			scissorRockPaper(dados);
		}				
		return dados.get(0);
	}

	private static List<Player> removeJogadores(List<Player> dados, Player vencedor) {
		dados.remove(0);
		dados.remove(0);
		dados.add(vencedor); 
		
		return dados;
	}

	private static void validarRegras(Player p1, Player p2,
			List<String> valoresValidos) throws WrongNumberOfPlayerError,
			NoSuchStrategyError {
		if (p1 == null || p2 == null) {
			throw new WrongNumberOfPlayerError();
		}
		
		if (!valoresValidos.contains(p1.getJogada()) || !valoresValidos.contains(p2.getJogada())) {
			throw new NoSuchStrategyError();
		}
	}

	private static Player jogar(List<Player> dados) throws WrongNumberOfPlayerError, NoSuchStrategyError {
		List<String> valoresValidos = new ArrayList<String>();
		popularValoresValidos(valoresValidos);
		Player player1 = dados.get(0);		
		Player player2 = dados.get(1);
		validarRegras(player1, player2, valoresValidos); 
		Player winner = Jogada.play(player1, player2);
		return winner;
	}

	private static void popularValoresValidos(List<String> valoresValidos) {
		valoresValidos.add("S");
		valoresValidos.add("R");
		valoresValidos.add("P");
	}
	
}