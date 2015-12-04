package test.observerP.javaObserverP;

import java.util.Observable;

public class WeatherData extends Observable {

	private float temperature;
	private float humidity;
	private float pressure;

	public void measurementsChanged() {
		// 通知观察者状态改变

		// 直接调用Observable上的方法进行通知
		setChanged();
		notifyObservers();
	}

	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
		measurementsChanged();
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
		measurementsChanged();
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
		measurementsChanged();
	}

}
