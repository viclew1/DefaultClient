package fr.lewon.client.util.parameters;

import java.util.Properties;

import fr.lewon.client.exceptions.ParameterizedAppException;

public abstract class Parameter {

	private final String key;
	private String value;
	private final boolean required;
	
	
	public Parameter(String key, boolean required) {
		this.key = key;
		this.required = required;
	}

	
	public boolean initParameter(Properties props) {
		this.value = props.getProperty(key);
		if (this.value == null && this.required) {
			return false;
		}
		return true;
	}

	public void verify() throws ParameterizedAppException {
		if (getValue() == null && !isRequired()) {
			return;
		}
		processVerifications();
	}
	
	protected abstract void processVerifications() throws ParameterizedAppException;
	
	public String getKey() {
		return key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isRequired() {
		return required;
	}
}
