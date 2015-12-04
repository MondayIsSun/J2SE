package jdbc.com.toufu.util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	private static Properties prop;

	// ��ȡProperties����
	// �û�ȡProperties���������Ҫ������Properties�����ļ���Ϣ
	// ֻ��Ҫ���ݸ������ȡ����Properties����Properties�����ļ����ڹ��̵�·�����ɽ���
	public static Properties getProp(String fileName) {

		if (prop == null) {

			prop = new Properties();

			try {
				// ע��:��ļ��������������Լ����ൽ������У����ҿ��Լ�����Դ
				prop.load(PropertiesReader.class.getClassLoader()
						.getResourceAsStream("config/" + fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return prop;
	}

	public static String getURL() {
		// ͨ��Properties�����getPropety()�������ɻ�ȡ�������ļ���ָ����Ϣ
		return getProp("db.properties").getProperty("url");
	}

	public static String getDriver() {
		return getProp("db.properties").getProperty("driver");
	}

	public static String getUser() {
		return getProp("db.properties").getProperty("user");
	}

	public static String getPassword() {
		return getProp("db.properties").getProperty("password");
	}

}
