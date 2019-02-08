package fr.lewon.client.preferences;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public enum PropertiesUtil {
	
	INSTANCE;
	
	public Properties generateProperties(String pathFile) throws IOException {
		return generateProperties(new File(pathFile));
	}
	
	public Properties generateProperties(File f) throws IOException {
		try (FileInputStream fis = new FileInputStream(f)) {
			return generateProperties(fis);
		}
	}
	
	public Properties generateProperties(FileInputStream fis) throws IOException {
		Properties props = new Properties();
		props.load(fis);
		return props;
	}
}
