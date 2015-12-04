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
			 * ��Apache��DBCP���C3P0����Ҫȥ��ȡ�����ļ�������ֱ���ڴ���������
			 */

			ds.setDriverClass(PropertiesReader.getDriver());

			ds.setUser(PropertiesReader.getUser());

			ds.setPassword(PropertiesReader.getPassword());

			ds.setJdbcUrl(PropertiesReader.getURL());

			ds.setMaxPoolSize(20);

			ds.setMinPoolSize(20);

			/*
			 * ע��: һ�����Ƕ�����С������������������һ��
			 */

			/*
			 * ��Ȼ���������������Լ�������Ҫȥ����
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
