package fr.lewon.client.menus;

import java.util.List;
import java.util.stream.Collectors;

import fr.lewon.client.exceptions.CliException;
import fr.lewon.client.util.input.Choice;
import fr.lewon.client.util.input.UserInputUtil;

public abstract class Menu extends AbstractMenu {

	private String description;

	public Menu(AbstractMenu containingMenu, String description) {
		super(containingMenu);
		this.description = description;
	}

	@Override
	public AbstractMenu run(AbstractMenu caller) throws CliException {
		System.out.println("\n############\n");
		System.out.println(getLabel());

		List<AbstractMenu> menus = getMenuOptions();
		if (getContainingMenu() != null) {
			menus.add(getContainingMenu());
		}

		List<Choice<AbstractMenu>> choices = menus.stream()
				.map(m -> new Choice<>(m.getLabel(), m))
				.collect(Collectors.toList());

		return UserInputUtil.INSTANCE.askChoice(description, true, choices);
	}

	protected abstract List<AbstractMenu> getMenuOptions();
}
