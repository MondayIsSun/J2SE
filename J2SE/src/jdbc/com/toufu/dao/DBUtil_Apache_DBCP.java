package jdbc.com.toufu.dao;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.com.toufu.util.PropertiesReader;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

@SuppressWarnings("static-access")
public class DBUtil_Apache_DBCP {

	/*
	 * Apache DBCP���ӳ�
	 */

	/*
	 * ʹ�����ݿ����ӳؼ��� ����ĸ������⼰ʱconn����������ȡ ����:�����ӳ��л�ȡ
	 * 
	 * ���ӳؼ������Զ��������ǹ��������
	 */

	private static BasicDataSource dataSource = null;

	@SuppressWarnings("unused")
	private static Connection conn = null;

	private DBUtil_Apache_DBCP() {

	}

	static {

		/*
		 * �þ�̬������Ǵ���һ����������ȡ��dataSource
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

	// �����ȡ���ӵķ���
	public static Connection getConn() {

		try {
			/*
			 * ��dataSource�л�ȡ����
			 */
			return dataSource.getConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
