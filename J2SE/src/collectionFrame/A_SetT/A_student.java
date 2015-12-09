package collectionFrame.A_SetT;

public class A_student {

	// ����
	private String name;
	private int id;

	// ���췽��
	public A_student() {
		super();
	}

	// get��setԭ��
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return this.id;
	}

	// @Override
	// public int hashCode() {
	// // TODO Auto-generated method stub
	// return super.hashCode();
	// }
	// ����Ĺ�ϣ����ָ�����ڱ�������ʱ�򶼻Ὣ������ڲ�λ��ת��Ϊһ��������ʵ�ֵ�
	// ������֤ÿ������Ĺ�ϣֵ��һ��...�Ӷ����ԴﵽΨһ��ʶһ�������Ч��...
	// ʵ������Object���ϵ�equals()�������бȽ����������Ƿ����ʱ�����ڱȽ�����������Ĺ�ϣ���Ƿ����

	/*
	 * ��Java��set��һ������,��Ϊset��������඼�ǲ������ظ���,���Ծ��б�Ҫʵ�ֶ����ıȽϷ���
	 * ����Ϊԭ����equals()�������ܴﵽ�Ƚ����������Ƿ���ȵ�Ч��,���Գ����б�Ҫȥ��д�������ϵ�equals()����
	 * ����Ϊ�ڵ��ö����equals()����һ�㶼��ʹ�õ�����Ĺ�ϣֵ���бȽ�...��ÿ������Ĺ�ϣֵ��Ψһ��,
	 * �����ù�ϣֵ���бȽ�����������Ⱦ͵�ͬ���ö���ľ���Ƚϴ�С,���Ǵﲻ��Ч����
	 * ���Գ����б�Ҫȥ��д��������hashCode()����...��д��ԭ����:����equals��Ȼ����ȵ�hashֵ,
	 * hashֵ��ȵĶ���һ��equals... ������д����equals()��hashCode()�����Ķ����ڱȽ�ʱ��Ч��Ҳ�����...
	 * ��Ϊ��ͳ�ıȽϷ����ǰ�ÿ�������������е����Խ��бȽϿ��Ƿ����,�����Ƚ�Ч�ʺܵ�
	 */

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof A_student) {
			// instanceof���������ж��Ƿ���ĳ�����ʵ��
			A_student s = (A_student) obj;
			if (s.id == this.id && s.name.equals(this.name))
				return true;
			else
				return false;
		} else
			return false;
	}

	// @Override
	// public boolean equals(Object obj) {
	// // TODO Auto-generated method stub
	// return super.equals(obj);
	// ע�⵽:ԭ����equals����ʵ����ֻ�ǵ����Ƚ���������ľ���Ƿ����,�����Ƚϳ����϶��ǲ���ȵ�,��Ϊ����ľ��ʵ���Ͼ��Ǵ��������ڴ��е�Ψһλ��,�϶������
	// ���Գ����б�Ҫȥ��д�������ϵ�equals()����,����Ҫע�����:String��һ�������ϵ�equals�����Ѿ�����д������...
	// }

	@Override
	public String toString() {
		return this.id + "=" + this.name;
	}

}
