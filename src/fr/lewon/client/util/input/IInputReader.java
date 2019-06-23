package fr.lewon.client.util.input;

public interface IInputReader {


	/**
	 * returns the next user input (and hides it if needed)
	 * 
	 * @param hidden if the text should be displayed on screen or not
	 * @return
	 */
	String getNextLine(boolean hidden);
	
}
