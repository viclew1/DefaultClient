package fr.lewon.client.util.parameters.impl;

import fr.lewon.client.exceptions.NotAnIntegerException;
import fr.lewon.client.exceptions.ParameterizedAppException;
import fr.lewon.client.util.parameters.Parameter;

public class IntegerParameter extends Parameter {

	public IntegerParameter(String key, boolean required) {
		super(key, required);
	}

	@Override
	protected void processVerifications() throws ParameterizedAppException {
		try {
			Integer.parseInt(getValue());
		} catch (NumberFormatException e) {
			throw new NotAnIntegerException(this);
		}
	}

}
