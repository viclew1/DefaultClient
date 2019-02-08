package fr.lewon.client.menus;

import fr.lewon.client.exceptions.CliException;

public enum MenuRunner {

	INSTANCE;
	
	public void runMenu(Menu root) throws CliException {
		AbstractMenu previousMenu = null;
		AbstractMenu nextMenu = root;
		while (nextMenu != null) {
			AbstractMenu previousMenuTmp = nextMenu;
			nextMenu = nextMenu.run(previousMenu);
			previousMenu = previousMenuTmp;
		}
	}
	
}
