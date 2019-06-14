package fr.lewon.client.exceptions;

import fr.lewon.client.util.parameters.Parameter;

public class NotADirectoryException extends ParameterizedAppException {

	private static final long serialVersionUID = 166739832110685862L;

	public NotADirectoryException(Parameter param) {
		super(param.getKey() + " [" + param.getValue() + "] is not a directory");
	}

}
