package fr.lewon.client.exceptions;

public abstract class CliException extends Exception {

	private static final long serialVersionUID = 1131575186185750600L;

	public CliException(String message) {
		this(message, null);
	}
	
	public CliException(String message, Exception cause) {
		super(message, cause);
	}
	
}
