package scissorRockPaper;

public class WrongNumberOfPlayerError extends Exception {

	private static final long serialVersionUID = 2881471055979434980L;
	
	public WrongNumberOfPlayerError() {
		super("Nuúmero inválido de jogadores");
	}

}
