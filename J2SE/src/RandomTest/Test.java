package RandomTest;

import java.util.Random;

public class Test {

	public static void main(String[] args) {

		// �������ⷶΧ�������
		Random r = new Random();
		//r.setSeed(1);

		int i = 0;
		while (i++ <= 1000) {
			System.out.println(r.nextInt());
		}

	}

}
