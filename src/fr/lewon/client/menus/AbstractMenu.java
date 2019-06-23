package fr.lewon.client.menus;

import java.io.IOException;
import java.rmi.ServerException;

import fr.lewon.client.exceptions.ParameterizedAppException;
import fr.lewon.client.util.input.UserInputReader;

public abstract class AbstractMenu<R extends UserInputReader> {

	private final AbstractMenu<R> containingMenu;
	private final R reader;

	public AbstractMenu(R reader, AbstractMenu<R> containingMenu) {
		this.reader = reader;
		this.containingMenu = containingMenu;
	}

	protected R getReader() {
		return reader;
	}
	
	/**
	 * executes the treatment of an abstract menu
	 * @param caller calling abstract menu
	 * @return nextMenu
	 * @throws IOException
	 * @throws ServerException
	 */
	public abstract AbstractMenu<R> run(AbstractMenu<R> caller) throws ParameterizedAppException;

	public abstract String getLabel();

	public AbstractMenu<R> getContainingMenu() {
		return containingMenu;
	}
}
