package fr.lewon.client.util.input;

public class Choice<T> {

	private T choiceObj;
	private String label;

	
	public Choice(String label, T choiceObj) {
		this.label = label;
		this.choiceObj = choiceObj;
	}
	
	
	public T getChoiceObj() {
		return choiceObj;
	}
	public void setChoiceObj(T choiceObj) {
		this.choiceObj = choiceObj;
	}
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
