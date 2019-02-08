package fr.lewon.client.menus;

import fr.lewon.client.exceptions.ActionException;

public abstract class Action extends AbstractMenu {

	public Action(AbstractMenu containingMenu, String label) {
		super(containingMenu, label);
	}

	@Override
	public AbstractMenu run(AbstractMenu caller) throws ActionException {
		return processAction(caller);
	}

	protected abstract AbstractMenu processAction(AbstractMenu caller) throws ActionException;

}
