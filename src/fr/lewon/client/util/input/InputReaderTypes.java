package fr.lewon.client.util.input;

import fr.lewon.client.util.ICliEnum;
import fr.lewon.client.util.input.impl.ConsoleInputReader;
import fr.lewon.client.util.input.impl.ScannerInputReader;

public enum InputReaderTypes implements ICliEnum {

	CONSOLE("InputReader using the tool java.io.Console", () -> new ConsoleInputReader()),
	SCANNER("InputReader using the tool java.util.Scanner", () -> new ScannerInputReader());

	private final String description;
	private final InputReaderBuilder builder;
	
	private InputReaderTypes(String description, InputReaderBuilder builder) {
		this.builder = builder;
		this.description = description;
	}
	
	public IInputReader initReader() {
		return builder.initReader();
	}

	@Override
	public String getKey() {
		return name();
	}

	@Override
	public String getDescription() {
		return description;
	}
	
}

interface InputReaderBuilder {
	
	IInputReader initReader();
	
}