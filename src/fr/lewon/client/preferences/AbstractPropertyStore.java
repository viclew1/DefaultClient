package fr.lewon.client.preferences;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import fr.lewon.client.exceptions.InitializationException;

public abstract class AbstractPropertyStore {

	private Properties props = new Properties();
	
	public void init(String proxyPropsFilePath) throws InitializationException {
		try (InputStream is = new FileInputStream(proxyPropsFilePath)) {
			props.load(is);
		} catch (IOException e) {
			throw new InitializationException(e);
		}
		verifyNeededKeys();
	}
	
	protected abstract List<String> getNeededKeys();
	
	private void verifyNeededKeys() throws InitializationException {
		List<String> missingKeys = new ArrayList<>();
		for (String key : getNeededKeys()) {
			if (props.get(key) == null) {
				missingKeys.add(key);
			}
		}
		if (!missingKeys.isEmpty()) {
			throw new InitializationException("Missing properties :" + missingKeys, null);
		}
	}
	
	protected Properties getProperties() {
		return props;
	}
	
}
