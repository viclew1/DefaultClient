package fr.lewon.client.menus;

import fr.lewon.client.exceptions.ActionException;
import fr.lewon.client.util.input.UserInputReader;

public abstract class Action<R extends UserInputReader> extends AbstractMenu<R> {

	public Action(R reader, AbstractMenu<R> containingMenu) {
		super(reader, containingMenu);
	}

	@Override
	public AbstractMenu<R> run(AbstractMenu<R> caller) throws ActionException {
		return processAction(caller);
	}

	protected abstract AbstractMenu<R> processAction(AbstractMenu<R> caller) throws ActionException;

}
