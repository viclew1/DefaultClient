package fr.lewon.client.util.input.impl;

import java.util.Scanner;

import fr.lewon.client.util.input.IInputReader;

public class ScannerInputReader implements IInputReader {

	private Scanner scanner = new Scanner(System.in);

	@Override
	public String getNextLine(boolean hidden) {
		return scanner.nextLine();
	}
	
}
