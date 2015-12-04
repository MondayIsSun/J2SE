package designPatterns.strategyP;

import designPatterns.strategyP.impl.FlyNoWay;

public class RubberDuck extends Duck {

	// ��Ѽ

	public RubberDuck() {
		super();
		// ���÷��в���
		// ���÷��в���Ϊ�������
		super.setFlyingStragety(new FlyNoWay());
	}

	@Override
	public void display() {
		System.out.println("��ȫ���ƣ���ͺܺ�");
	}

	// ��Ѽ�Ľ�������ͨѼ�ӵĽ�����ͬ����������Ҫ��д����quack����
	public void quack() {
		System.out.println("��~��~��~");
	}

}
