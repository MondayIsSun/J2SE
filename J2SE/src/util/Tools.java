package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tools {

	public static String input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String result = "";
		try {
			result = br.readLine();

			while ("".equals(result)) {
				System.out.print("�����������Ϊ�գ�����������---> ");
				result = br.readLine();
			}

			return result;

		} catch (IOException e1) {
			e1.printStackTrace();
		}// finally {
			// if (br != null) {
			// try {
			// br.close();
			// } catch (IOException e) {
			// e.printStackTrace();
			// }
			// }
			// }

		return null;
	}
}
