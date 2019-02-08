package fr.lewon.client.exceptions;

public class ActionException extends CliException {

	private static final long serialVersionUID = -2699904406080200457L;

	public ActionException(Exception cause) {
		super(cause.getMessage());
	}
	
	public ActionException(String message) {
		super(message);
	}

}
