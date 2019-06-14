package fr.lewon.client.util.parameters.impl;

import java.io.File;

import fr.lewon.client.exceptions.ParameterizedAppException;
import fr.lewon.client.exceptions.NotADirectoryException;

public class DirParameter extends AbstractFileParameter {

	public DirParameter(String key, boolean required, boolean mustExist) {
		super(key, required, mustExist);
	}

	@Override
	protected void processAdditionalVerifications(File f) throws ParameterizedAppException {
		if (f.exists() && !f.isDirectory()) {
			throw new NotADirectoryException(this);
		}
	}

	@Override
	protected void initFile(File f) throws ParameterizedAppException {
		f.mkdirs();
	}

}
