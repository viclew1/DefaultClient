package fr.lewon.client.exceptions;

public class InitializationException extends CliException {

	private static final long serialVersionUID = 4767328399146461498L;

	public InitializationException() {
		this(null);
	}
	
	public InitializationException(Exception e) {
		super("Initialization KO", e);
	}

}
