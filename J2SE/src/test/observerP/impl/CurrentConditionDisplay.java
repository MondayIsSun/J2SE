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

	// �ڴ���������۲��ߵ�ʱ��Ϳ���ָ����Ҫ�۲�˭
	// ��Ȼ��Ҳ���Ժ���ͨ��������Ҫ�۲�˭ ---> ע������
	// �����Ƴ�����
	public CurrentConditionDisplay(Subject subject) {
		this.subject = subject;
		subject.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("temperature:" + temperature + "  humidity:" + humidity);
	}

	// ���update�Ǳ����������õģ�ּ�ڵ���������״̬�����ı��ʱ��ص������������֪ͨ�۲��������ⷢ���ı���
	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		// this.pressure = pressure;

		// �������״̬�����ı���ҵ���߼�
		display();
	}

}
