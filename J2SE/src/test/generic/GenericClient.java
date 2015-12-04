package test.generic;

public class GenericClient {

	public static void main(String[] args) {

		// ���ʱ��������ʹ�÷���
		Child<String, Integer> c1 = new Child<String, Integer>();

		// ������д�Ĵ�����Զ��ؽ��з��ͼ��
		// �Ӷ�û�б�Ҫ�������͵�ת����Ҳ����Ҫ�������͵��жϣ��Զ�����װ�����
		c1.setJavaScore("79");// ���ͼ��
		c1.setMathScore(new Integer(86));// �������ͼ��

		String jc = c1.getJavaScore();// �������ͼ��
		c1.setMathScore(87);// ����ط������Զ�װ��
		int mc = c1.getMathScore();// ����ط������Զ�����

		System.out.println(jc + "   " + mc);
	}
}

// ���ʱ�������ڶ��巺��
class Child<T1, T2> {

	public T1 javaScore;
	public T2 mathScore;

	public T1 getJavaScore() {
		return javaScore;
	}

	public void setJavaScore(T1 javaScore) {
		this.javaScore = javaScore;
	}

	public T2 getMathScore() {
		return mathScore;
	}

	public void setMathScore(T2 mathScore) {
		this.mathScore = mathScore;
	}
}
