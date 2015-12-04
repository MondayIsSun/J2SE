package jdbc.com.toufu.dao;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.com.toufu.util.PropertiesReader;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

@SuppressWarnings("static-access")
public class DBUtil_Apache_DBCP {

	/*
	 * Apache DBCP连接池
	 */

	/*
	 * 使用数据库连接池技术 解决的根本问题及时conn从哪里来获取 答案是:从连接池中获取
	 * 
	 * 连接池技术会自动帮助我们管理好链接
	 */

	private static BasicDataSource dataSource = null;

	@SuppressWarnings("unused")
	private static Connection conn = null;

	private DBUtil_Apache_DBCP() {

	}

	static {

		/*
		 * 该静态代码段是创建一个工厂来获取到dataSource
		 */

		BasicDataSourceFactory factory = new BasicDataSourceFactory();

		try {
			dataSource = (BasicDataSource) factory
					.createDataSource(PropertiesReader
							.getProp("dbcp.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 负责获取连接的方法
	public static Connection getConn() {

		try {
			/*
			 * 从dataSource中获取链接
			 */
			return dataSource.getConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
