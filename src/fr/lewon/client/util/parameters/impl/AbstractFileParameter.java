package fr.lewon.client.util.parameters.impl;

import java.io.File;

import fr.lewon.client.exceptions.CliException;
import fr.lewon.client.exceptions.FileDoesNotExistException;
import fr.lewon.client.exceptions.ParentDirDoesNotExist;
import fr.lewon.client.util.parameters.Parameter;

public abstract class AbstractFileParameter extends Parameter {

	private boolean mustExist;

	public AbstractFileParameter(String key, boolean required, boolean mustExist) {
		super(key, required);
		this.mustExist = mustExist;
	}

	@Override
	protected void processVerifications() throws CliException {
		File f = new File(getValue());

		File parentFile = f.getParentFile();

		if (!parentFile.exists() || !parentFile.isDirectory() || !parentFile.canWrite()) {
			throw new ParentDirDoesNotExist(this, parentFile.getAbsolutePath());
		}

		if (!f.exists()) {
			if (mustExist) {
				throw new FileDoesNotExistException(this);
			} else {
				initFile(f);
			}
		}

		processAdditionalVerifications(f);
	}

	protected abstract void initFile(File f) throws CliException;

	protected abstract void processAdditionalVerifications(File f) throws CliException;

}
