package fr.lewon.client.exceptions;

public abstract class ParameterizedAppException extends Exception {

	private static final long serialVersionUID = 1131575186185750600L;

	public ParameterizedAppException(String message) {
		this(message, null);
	}
	
	public ParameterizedAppException(String message, Exception cause) {
		super(message, cause);
	}
	
}
