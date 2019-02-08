package fr.lewon.client.exceptions;

import java.util.Arrays;
import java.util.List;

import fr.lewon.client.util.ICliEnum;
import fr.lewon.client.util.parameters.impl.EnumParameter;

public class InvalidEnumException extends CliException {

	private static final long serialVersionUID = -5659535491623101072L;

	public <E extends Enum<E> & ICliEnum> InvalidEnumException(EnumParameter<E> param) {
		super(generateExceptionMessage(param, Arrays.asList(param.getEnumClass().getEnumConstants())));
	}
	
	private static <E extends Enum<E> & ICliEnum> String generateExceptionMessage(EnumParameter<E> param, List<E> availableValues) {
		String msg = "Wrong enum [" + param.getKey() + "] - " + param.getValue() + "\n";
		msg += "Available choices :\n";
		for (E e : availableValues) {
			msg += "  - " + e.getKey() + " : " + e.getDescription() + "\n";
		}
		return msg;
	}

}
