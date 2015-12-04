package jdbc.com.toufu.dao;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import jdbc.com.toufu.util.PropertiesReader;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil_C3P0 {

	private static ComboPooledDataSource ds = null;

	private DBUtil_C3P0() {

	}

	static {

		ds = new ComboPooledDataSource();

		try {

			/*
			 * 与Apache的DBCP相比C3P0不需要去读取配置文件，可以直接在代码中设置
			 */

			ds.setDriverClass(PropertiesReader.getDriver());

			ds.setUser(PropertiesReader.getUser());

			ds.setPassword(PropertiesReader.getPassword());

			ds.setJdbcUrl(PropertiesReader.getURL());

			ds.setMaxPoolSize(20);

			ds.setMinPoolSize(20);

			/*
			 * 注意: 一般我们都把最小和最大的链接数都设置一样
			 */

			/*
			 * 当然还有其他的设置自己根据需要去设置
			 */

		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() {

		try {

			return ds.getConnection();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return null;
	}
}
