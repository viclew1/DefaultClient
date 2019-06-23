package fr.lewon.client.util.input.impl;

import java.io.Console;

import fr.lewon.client.util.input.IInputReader;

public class ConsoleInputReader implements IInputReader {

	private Console console = System.console();
	
	@Override
	public String getNextLine(boolean hidden) {
		return hidden ? new String(console.readPassword()) : console.readLine();
	}

}
