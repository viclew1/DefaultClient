package fr.lewon.client.exceptions;

import fr.lewon.client.util.parameters.Parameter;

public class ParentDirDoesNotExist extends CliException {

	private static final long serialVersionUID = 6069448444950090073L;

	public ParentDirDoesNotExist(Parameter param, String parentPath) {
		super(createMessage(param, parentPath));
	}

	private static String createMessage(Parameter param, String parentPath) {
		return "Parent file does not exist [" + param.getKey() + "] - " + param.getValue() + ", parent : " + parentPath; 
	}

}
