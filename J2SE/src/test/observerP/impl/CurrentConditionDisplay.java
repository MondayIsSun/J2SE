package test.observerP.impl;

import test.observerP.DisplayElement;
import test.observerP.Observer;
import test.observerP.Subject;

public class CurrentConditionDisplay implements Observer, DisplayElement {

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

	// 在创建出这个观察者的时候就可以指定他要观察谁
	// 当然你也可以后期通过设置我要观察谁 ---> 注册主题
	// 或者移除主题
	public CurrentConditionDisplay(Subject subject) {
		this.subject = subject;
		subject.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("temperature:" + temperature + "  humidity:" + humidity);
	}

	// 这个update是被主题对象调用的，旨在当主题对象的状态发生改变的时候回调这个方法，来通知观察者们主题发生改变了
	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		// this.pressure = pressure;

		// 当主题的状态发生改变后的业务逻辑
		display();
	}

}
