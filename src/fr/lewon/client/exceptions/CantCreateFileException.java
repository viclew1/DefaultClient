package fr.lewon.client.exceptions;

import fr.lewon.client.util.parameters.Parameter;

public class CantCreateFileException extends CliException {

	private static final long serialVersionUID = 7052795718213554871L;

	public CantCreateFileException(Parameter param) {
		this(param, null);
	}
	
	public CantCreateFileException(Parameter param, Exception cause) {
		super(createMessage(param), cause);
	}

	private static String createMessage(Parameter param) {
		return "Can't create file [" + param.getKey() + "] - " + param.getValue(); 
	}
	
}
