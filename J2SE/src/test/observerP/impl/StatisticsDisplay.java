package test.observerP.impl;

import test.observerP.DisplayElement;
import test.observerP.Observer;
import test.observerP.Subject;

public class StatisticsDisplay implements Observer, DisplayElement {

	private float temperature;
	private float humidity;
	// private float pressure;

	private Subject subject;

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public StatisticsDisplay(Subject subject) {
		this.subject = subject;
		subject.registerObserver(this);
	}

	@Override
	public void display() {
		//System.out.println("temperature:" + temperature + "  humidity:" + humidity);
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		// this.pressure = pressure;

		display();
	}

}
