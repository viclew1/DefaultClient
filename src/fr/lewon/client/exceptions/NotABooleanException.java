package fr.lewon.client.exceptions;

import fr.lewon.client.util.parameters.Parameter;

public class NotABooleanException extends ParameterizedAppException {

	private static final long serialVersionUID = 3104340328461889335L;

	public NotABooleanException(Parameter param) {
		super(param.getKey() + " [" + param.getValue() + "] is not a boolean");
	}

	
	
}
