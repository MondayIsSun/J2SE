package designPatterns.strategyP;

import designPatterns.strategyP.impl.FlyNoWay;

public class BigYellow extends Duck {

	// ���Ѽ

	public BigYellow() {
		super();
		super.setFlyingStragety(new FlyNoWay());
	}

	@Override
	public void display() {
		System.out.println("������ܴ�ȫ��ƻ�");
	}

	// ע������Ĵ��Ѽ�ǲ���еģ��������ڼ̳еĹ�ϵ���Ѽ���ǻ�У����ԱȽϱ��ķ��������㻹��ȥ��д����quack����ʵ��Ϊ�����
	// ����ѧϰ��ʹ�ò���ģʽ���������ǵ�Ѽ���Ժ����Ӧ�ö���ʹ�ò���ģʽ������Ѽ�ӵ�����������

}
