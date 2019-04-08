package scissorRockPaper;


public class Player {
	
	public Player(String nome, String jogada) {
		this.nome = nome;
		this.jogada = jogada;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getJogada() {
		return jogada;
	}
	public void setJogada(String jogada) {
		this.jogada = jogada;
	}
	private String nome;
	private String jogada;

}
