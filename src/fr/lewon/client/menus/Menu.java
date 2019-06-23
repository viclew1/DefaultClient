package fr.lewon.client.menus;

import java.util.List;
import java.util.stream.Collectors;

import fr.lewon.client.exceptions.ParameterizedAppException;
import fr.lewon.client.util.input.Choice;
import fr.lewon.client.util.input.UserInputReader;

public abstract class Menu<R extends UserInputReader> extends AbstractMenu<R> {

	private String description;

	public Menu(R reader, AbstractMenu<R> containingMenu, String description) {
		super(reader, containingMenu);
		this.description = description;
	}
	
	@Override
	public AbstractMenu<R> run(AbstractMenu<R> caller) throws ParameterizedAppException {
		System.out.println("\n############\n");
		System.out.println(getLabel());

		List<AbstractMenu<R>> menus = getMenuOptions();
		if (getContainingMenu() != null) {
			menus.add(getContainingMenu());
		}

		List<Choice<AbstractMenu<R>>> choices = menus.stream()
				.map(m -> new Choice<>(m.getLabel(), m))
				.collect(Collectors.toList());

		return getReader().askChoice(description, true, choices);
	}

	protected abstract List<AbstractMenu<R>> getMenuOptions();
}
