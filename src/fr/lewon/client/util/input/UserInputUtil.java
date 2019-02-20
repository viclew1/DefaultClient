package fr.lewon.client.util.input;

import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public enum UserInputUtil {

	INSTANCE;

	private final Console console;

	private UserInputUtil() {
		console = System.console();
	}

	/**
	 * Asks the user to enter a value
	 * @param prompt
	 * @param needed
	 * @return Entered value
	 * @throws TechnicalException
	 */
	public String askString(String prompt, boolean hidden, boolean needed) {
		System.out.println(prompt + (needed ? "" : " (ENTER to skip)"));
		String input;
		while ("".equals(input = getNextLine(hidden)) && needed) {
			System.out.println("Invalid value - Empty input");
		}
		return input;
	}

	/**
	 * Asks the user to enter an integer value
	 * @param prompt
	 * @param hidden
	 * @param needed
	 * @param minValue
	 * @param maxValue
	 * @return
	 */
	public Integer askInteger(String prompt, boolean hidden, boolean needed, Integer minValue, Integer maxValue) {

		System.out.println(prompt + (needed ? "" : " (ENTER to skip)"));
		while (true) {
			String inputStr = getNextLine(hidden);
			if ("".equals(inputStr)) {
				if (!needed) {
					return null;
				}
				System.out.println("Invalid value - Empty input");
				continue;
			}

			Integer val;
			try {
				val = Integer.parseInt(inputStr);
			} catch (NumberFormatException e) {
				System.out.println("Invalid value - Not a number");
				continue;
			}

			if (minValue != null && val < minValue) {
				System.out.println("Invalid value - Minimum value : " + minValue);
				continue;
			}
			if (maxValue != null && val > maxValue) {
				System.out.println("Invalid value - Maximum value : " + maxValue);
				continue;
			}

			return val;
		}
	}

	/**
	 * Asks the user to enter a date value
	 * @param prompt
	 * @param hidden
	 * @param needed
	 * @param format
	 * @return
	 */
	public Date askDate(String prompt, boolean hidden, boolean needed, String format) {
		System.out.println(prompt + " (format : " + format + ")" + (needed ? "" : " (ENTER to skip)"));
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		while (true) {
			String inputStr = getNextLine(hidden);
			
			if ("".equals(inputStr)) {
				if (!needed) {
					return null;
				}
				System.out.println("Invalid value - Empty input");
				continue;
			}

			try {
				return sdf.parse(inputStr);
			} catch (ParseException e) {
				System.out.println("Invalid value - Not a date");
				continue;
			}

		}
	}

	/**
	 * Asks the user to chose between multiple options.
	 * @param header line to display before the options (null if no header to display)
	 * @param quitOption if true, the user will be able to press q to quit
	 * @param choices choices
	 * @return the chosen Choice. 
	 * If options is empty or if user chooses to exit, returns null. 
	 */
	public <T> T askChoice(String header, boolean quitOption, List<Choice<T>> choices) {

		if (choices.size() == 0) {
			return null;
		}

		if (header != null && !"".equals(header)) {
			System.out.println(header);
		}

		System.out.println("----------");
		for (int i = 0 ; i < choices.size() ; i++) {
			System.out.println("  (" + (i + 1) + ") " + choices.get(i).getLabel());
		}
		System.out.println("----------");

		while (true) {
			System.out.println("Your choice ? " + (quitOption ? "(q to quit)" : ""));

			String choiceStr = getNextLine(false);

			if (quitOption && "q".equalsIgnoreCase(choiceStr)) {
				return null;
			}

			Integer choiceIndex;;
			try {
				choiceIndex = Integer.parseInt(choiceStr) - 1;
			} catch (NumberFormatException e) {
				System.out.println("Invalid choice - Not a number");
				continue;
			}

			if (choiceIndex < 0 || choiceIndex >= choices.size()) {
				System.out.println("Invalid choice - Not an option");
				continue;
			}

			return choices.get(choiceIndex).getChoiceObj();
		}

	}

	/**
	 * returns the next user input (and hides it if needed)
	 */
	private String getNextLine(boolean hidden) {
		return hidden ? new String(console.readPassword()) : console.readLine();
	}

}
