package test.observerP.client;

import test.observerP.javaObserverP.CurrentConditionDisplay;
import test.observerP.javaObserverP.WeatherData;


public class WeatherStation {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		/*
		final WeatherData weatherData = new WeatherData();

		CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

		// 模拟天气的变化
		new Thread() {
			public void run() {
				try {
					for (int i = 0; i < 10; i++) {
						Thread.sleep(2000);
						weatherData.setMeasurements(10 + i, 20 + 2 * i, 30 + 4 * i);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		}.start();
		*/
		
		final WeatherData weatherData = new WeatherData();

		CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);

		// 模拟天气的变化
		new Thread() {
			public void run() {
				try {
					for (int i = 0; i < 10; i++) {
						Thread.sleep(2000);
						weatherData.setMeasurements(10 + i, 20 + 2 * i, 30 + 4 * i);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		}.start();
	}
}
