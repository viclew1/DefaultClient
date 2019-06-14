package fr.lewon.client.util.parameters.impl;

import java.io.File;
import java.io.IOException;

import fr.lewon.client.exceptions.CantCreateFileException;
import fr.lewon.client.exceptions.ParameterizedAppException;
import fr.lewon.client.exceptions.NotAFileException;

public class FileParameter extends AbstractFileParameter {

	public FileParameter(String key, boolean required, boolean mustExist) {
		super(key, required, mustExist);
	}

	@Override
	protected void processAdditionalVerifications(File f) throws ParameterizedAppException {
		if (f.exists() && !f.isFile()) {
			throw new NotAFileException(this);
		}
	}

	@Override
	protected void initFile(File f) throws ParameterizedAppException {
		try {
			f.createNewFile();
		} catch (IOException e) {
			throw new CantCreateFileException(this, e);
		}
	}

}
