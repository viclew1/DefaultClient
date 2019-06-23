package fr.lewon.client.menus;

import fr.lewon.client.exceptions.ParameterizedAppException;
import fr.lewon.client.util.input.UserInputReader;

public enum MenuRunner {

	INSTANCE;
	
	public <T extends UserInputReader> void runMenu(Menu<T> root) throws ParameterizedAppException {
		AbstractMenu<T> previousMenu = null;
		AbstractMenu<T> nextMenu = root;
		while (nextMenu != null) {
			AbstractMenu<T> previousMenuTmp = nextMenu;
			nextMenu = nextMenu.run(previousMenu);
			previousMenu = previousMenuTmp;
		}
	}
	
}
