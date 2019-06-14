package fr.lewon.client.util.parameters.impl;

import fr.lewon.client.exceptions.ParameterizedAppException;
import fr.lewon.client.util.parameters.Parameter;

public class SimpleParameter extends Parameter {

	public SimpleParameter(String key, boolean required) {
		super(key, required);
	}

	@Override
	protected void processVerifications() throws ParameterizedAppException {
		// Nothing to do in this case
	}

}
