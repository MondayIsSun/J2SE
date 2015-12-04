package test.observerP.javaObserverP;

import java.util.Observable;
import java.util.Observer;

import test.observerP.DisplayElement;

public class CurrentConditionDisplay implements Observer, DisplayElement {

	private Observable observable;
	private float temperature;
	private float humidity;

	public CurrentConditionDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(arg);
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) o;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
	}

	@Override
	public void display() {
		System.out.println("temperature:" + temperature + "  humidity:" + humidity);
	}

}