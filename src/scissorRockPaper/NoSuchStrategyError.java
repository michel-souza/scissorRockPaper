package scissorRockPaper;

public class NoSuchStrategyError extends Exception {
	
	private static final long serialVersionUID = -6283746751023086332L;

	public NoSuchStrategyError() {
		super("Estrategia não valida");
	}

}
