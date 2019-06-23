package fr.lewon.client;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import fr.lewon.client.exceptions.MissingParameterException;
import fr.lewon.client.exceptions.ParameterizedAppException;
import fr.lewon.client.util.parameters.Parameter;

public abstract class AbstractParameterizedApp {
	
	/**
	 * @return The List of Parameters needed by this client. These will be looked for in the System properties.
	 */
	protected abstract List<Parameter> getParamsToInit();
	
	/**
	 * Initializes the parameters by looking for their values in system properties.
	 * @param params the parameters to initialize
	 * @throws MissingParameterException if one or more of the needed parameters aren't found in system properties
	 */
	private static void initParams(List<Parameter> params) throws MissingParameterException {
		Properties props = System.getProperties();
		
		List<Parameter> missingParameters = params.stream()
				.filter(p -> !p.initParameter(props))
				.collect(Collectors.toList());
		
		if (!missingParameters.isEmpty()) {
			throw new MissingParameterException(missingParameters);
		}
	}
	
	/**
	 * Processes all the steps to launch the client :
	 * <ul>
	 * <li>Calls {@link #init()}</li>
	 * <li>Calls {@link #run()}</li>
	 * </ul>
	 * @throws ParameterizedAppException 
	 */
	public void launch() throws ParameterizedAppException {
		init();
		run();
	}
	
	/**
	 * Processes all the initialization steps :
	 * <ul>
	 * <li>Calls {@link #initParams(List)}</li>
	 * <li>Verifies every initialized parameter</li>
	 * </ul>
	 * @throws ParameterizedAppException
	 */
	protected void init() throws ParameterizedAppException {
		List<Parameter> params = getParamsToInit();
		initParams(params);
		for (Parameter param : params) {
			param.verify();
		}
	}
	
	/**
	 * Should contain the actions the client should execute once everything is successfully initialized
	 * 
	 * @throws ParameterizedAppException
	 */
	protected abstract void run() throws ParameterizedAppException;
}
