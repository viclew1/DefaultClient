package fr.lewon.client.menus;

import fr.lewon.client.exceptions.ParameterizedAppException;

public enum MenuRunner {

	INSTANCE;
	
	public void runMenu(Menu root) throws ParameterizedAppException {
		AbstractMenu previousMenu = null;
		AbstractMenu nextMenu = root;
		while (nextMenu != null) {
			AbstractMenu previousMenuTmp = nextMenu;
			nextMenu = nextMenu.run(previousMenu);
			previousMenu = previousMenuTmp;
		}
	}
	
}
