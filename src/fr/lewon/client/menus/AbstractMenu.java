package fr.lewon.client.menus;

import java.io.IOException;
import java.rmi.ServerException;

import fr.lewon.client.exceptions.CliException;

public abstract class AbstractMenu {

	private final AbstractMenu containingMenu;

	public AbstractMenu(AbstractMenu containingMenu) {
		this.containingMenu = containingMenu;
	}

	/**
	 * executes the treatment of an abstract menu
	 * @param caller calling abstract menu
	 * @return nextMenu
	 * @throws IOException
	 * @throws ServerException
	 */
	public abstract AbstractMenu run(AbstractMenu caller) throws CliException;

	public abstract String getLabel();

	public AbstractMenu getContainingMenu() {
		return containingMenu;
	}
}
