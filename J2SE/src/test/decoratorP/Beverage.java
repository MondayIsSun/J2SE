package test.decoratorP;

public abstract class Beverage {

	protected String description = "Unknown Beverage";

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public abstract double cost();

}