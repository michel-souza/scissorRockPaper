package scissorRockPaper;

import java.util.Arrays;


public enum Jogada {
	SCISSOR("S"), ROCK("R"), PAPER("P");
	
	private String escolha;
	
	Jogada(String escolha) {
		this.setEscolha(escolha);
	}
	
	public static Jogada getJogada(String jogada) {
		return Arrays.asList(Jogada.values()).stream().filter(j -> j.getEscolha().equals(jogada)).findFirst().orElse(null);
	}
	
	public static Player play(Player player1, Player player2) {
		Jogada escolhaJogadorUm = Jogada.getJogada(player1.getJogada());
		Jogada escolhaJogadorDois = Jogada.getJogada(player2.getJogada());
		Player winner = null;
		
		if (escolhaJogadorUm == escolhaJogadorDois) {
			winner = player1;
        } else {
            switch (escolhaJogadorUm){
            case ROCK:
                if (escolhaJogadorDois == SCISSOR)
                	winner = player1;
                else
                	winner = player2;
                break;
            case SCISSOR:
                if (escolhaJogadorDois == PAPER)
                	winner = player1;
                else
                	winner = player2;
                break;
            case PAPER:
                if (escolhaJogadorDois == ROCK)
                	winner = player1;
                else
                	winner = player2;
                break;
            }
        }
		return winner;
	}

	public String getEscolha() {
		return escolha;
	}

	public void setEscolha(String escolha) {
		this.escolha = escolha;
	}
}
