package fr.lewon.client.util.parameters.impl;

import fr.lewon.client.exceptions.NotAnIntegerException;
import fr.lewon.client.exceptions.ParameterizedAppException;
import fr.lewon.client.util.parameters.Parameter;

public class BooleanParameter extends Parameter {

	public BooleanParameter(String key, boolean required) {
		super(key, required);
	}
	
	public boolean getBooleanValue() {
		return Boolean.parseBoolean(getValue());
	}

	@Override
	protected void processVerifications() throws ParameterizedAppException {
		if (!"true".equalsIgnoreCase(getValue()) && !"false".equalsIgnoreCase(getValue())) {
			throw new NotAnIntegerException(this);
		}
	}

}
