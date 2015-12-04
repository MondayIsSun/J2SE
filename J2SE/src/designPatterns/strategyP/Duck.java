package designPatterns.strategyP;

/*
 * ���࣬���е�Ѽ�Ӷ�Ҫ�̳д���
 * ������Ѽ�ӵ���Ϊ����ʾ������
 */
public abstract class Duck {

	/*
	 * Ѽ�ӷ������� ͨ����Ϊ���ɳ���ʵ��
	 */
	public void quack() {
		System.out.println("�¸¸�");
	}

	/*
	 * ��ʾѼ�ӵ���� Ѽ�ӵ���۸�����ͬ������Ϊabstract�� ������ʵ��
	 */
	public abstract void display();

	// ------------------------------------------------

	// �ڻ��൱����ϲ��Խӿڣ�ע��˴���ʹ��private�ؼ���
	private FlyingStragety flyingStragety;

	// ͬʱ����set��������FlyingStragety��ע��
	public void setFlyingStragety(FlyingStragety flyingStragety) {
		this.flyingStragety = flyingStragety;
	}

	// ͬʱ��Ѽ�ӻ���������������
	public void fly() {
		flyingStragety.performFly();
	}

	// ------------------------------------------------

}
