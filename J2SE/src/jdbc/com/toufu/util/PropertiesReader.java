package jdbc.com.toufu.util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	private static Properties prop;

	// 获取Properties对象
	// 用获取Properties对象加载需要解析的Properties配置文件信息
	// 只需要传递给这个获取到的Properties对象Properties配置文件的在工程的路径即可解析
	public static Properties getProp(String fileName) {

		if (prop == null) {

			prop = new Properties();

			try {
				// 注意:类的加载器不仅仅可以加载类到虚拟机中，而且可以加载资源
				prop.load(PropertiesReader.class.getClassLoader()
						.getResourceAsStream("config/" + fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return prop;
	}

	public static String getURL() {
		// 通过Properties对象的getPropety()方法即可获取到配置文件的指定信息
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
