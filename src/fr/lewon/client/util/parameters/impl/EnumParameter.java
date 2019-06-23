package fr.lewon.client.util.parameters.impl;

import fr.lewon.client.exceptions.InvalidEnumException;
import fr.lewon.client.exceptions.ParameterizedAppException;
import fr.lewon.client.util.ICliEnum;
import fr.lewon.client.util.parameters.Parameter;

public class EnumParameter<E extends Enum<E> & ICliEnum> extends Parameter {

	private Class<E> enumClass;
	
	public EnumParameter(String key, boolean required, Class<E> enumClass) {
		super(key, required);
		this.enumClass = enumClass;
	}

	public Class<E> getEnumClass() {
		return enumClass;
	}
	
	public E getEnumValue() {
		return Enum.valueOf(enumClass, getValue());
	}
	
	@Override
	protected void processVerifications() throws ParameterizedAppException {
		try {
			getEnumValue();
		} catch (IllegalArgumentException e) {
			throw new InvalidEnumException(this);
		}
	}

}