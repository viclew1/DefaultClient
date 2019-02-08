package fr.lewon.client.util.parameters.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import fr.lewon.client.exceptions.CliException;
import fr.lewon.client.exceptions.InvalidEnumException;
import fr.lewon.client.util.ICliEnum;
import fr.lewon.client.util.parameters.Parameter;

public class EnumParameter<E extends Enum<E> & ICliEnum> extends Parameter {

	private final Class<E> enumClass;
	
	@SuppressWarnings("unchecked")
	public EnumParameter(String key, boolean required) {
		super(key, required);
		Type inferedType = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.enumClass = (Class<E>) inferedType;
	}

	public Class<E> getEnumClass() {
		return enumClass;
	}

	@Override
	protected void processVerifications() throws CliException {
		ICliEnum enumVal = Enum.valueOf(enumClass, getValue());
		if (enumVal == null) {
			throw new InvalidEnumException(this);
		}
	}

}