package fr.lewon.client.exceptions;

import fr.lewon.client.util.parameters.Parameter;

public class NotAnIntegerException extends ParameterizedAppException {

	private static final long serialVersionUID = 6429299167046177802L;

	public NotAnIntegerException(Parameter param) {
		super(param.getKey() + " [" + param.getValue() + "] is not an integer");
	}

	
	
}
