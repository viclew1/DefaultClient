package fr.lewon.client.exceptions;

import fr.lewon.client.util.parameters.Parameter;

public class FileDoesNotExistException extends ParameterizedAppException {

	private static final long serialVersionUID = -2512241298788375958L;

	public FileDoesNotExistException(Parameter param) {
		super(param.getKey() + " [" + param.getValue() + "] does not exist");
	}


}
