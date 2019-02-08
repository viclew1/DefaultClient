package fr.lewon.client.exceptions;

import fr.lewon.client.util.parameters.Parameter;

public class NotAFileException extends CliException {

	private static final long serialVersionUID = -1476950281480467657L;

	public NotAFileException(Parameter param) {
		super(param.getKey() + " [" + param.getValue() + "] is not a file");
	}

}
