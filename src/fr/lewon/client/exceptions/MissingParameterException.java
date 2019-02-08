package fr.lewon.client.exceptions;

import java.util.Iterator;
import java.util.List;

import fr.lewon.client.util.parameters.Parameter;

public class MissingParameterException extends CliException {

	private static final long serialVersionUID = -3221949866357848023L;

	public MissingParameterException(List<Parameter> missingParams) {
		super(generateMessage(missingParams));
	}

	private static String generateMessage(List<Parameter> missingParams) {
		String msg = "[";
		Iterator<Parameter> it = missingParams.iterator();
		while (it.hasNext()) {
			String paramKey = it.next().getKey();
			msg += paramKey;
			if (it.hasNext()) {
				msg += ", ";
			}
		}
		msg += "]";
		return msg;
	}

	
	
}
