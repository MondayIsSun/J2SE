package jdbc.com.toufu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jdbc.com.toufu.util.PropertiesReader;


//������Ĳ������ݿ�
public class DBUtil {
	
	/*
	 * �������ݿ����������>Class.forName(driver);
	 * 
	 * �������ݿ⡪��>conn = DriverManager.getConnection(url, user, password);
	 * 
	 * ִ��Sql��䡪��>
	 * 
	 * ִ��Sql����ķ��ؽ������>
	 */
	
	/*
	 * �󲿷ֵĹ���������ķ������Ǿ�̬����
	 */

	/*
	 * ����ܹ��е����ݷ��ʲ�
	 * һ�����
	 * ר�Ÿ������ݿ����Ӻ͹ر���ض����---DBUtil
	 * DAO����---һ����һ�ű��Ӧһ��DAO����
	 * PO����---��������ת���ľ���Ķ���
	 */
	
	/*
	 * ����ʵ����
	 */
	private DBUtil(){
		
	}
	
	
	//��Щ��Ϣ��Ӧ��д�������ļ�����
	private static String driver = PropertiesReader.getDriver();
	private static String url = PropertiesReader.getURL();
	private static String user = PropertiesReader.getUser();
	private static String password = PropertiesReader.getPassword();
	private static Connection conn = null;
	
	//�������ӵķ���
	public static Connection getConn(){	
		try {
			//���ز�ע�����ݿ�����
			Class.forName(driver);
			//�������ݿ�
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {		
			e.printStackTrace();		
		}	
		return conn;
	}
	
	//����رյķ���---�ر�rs,stat,conn
	
	//һ���Թر���������ķ���
	public static void close(ResultSet rs,Statement stat,Connection conn){
		try {
			//�رս��������
			if(rs != null && !rs.isClosed()){
				stat.close();
			}
			
			//�ر�������
			if(stat != null && !stat.isClosed()){
				stat.close();
			}
			
			//�ر����Ӷ���
			if(conn != null && !conn.isClosed()){
				stat.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();		
		}	
	}
	
	
	//һ���Թرյ�������ķ���
	public static void close(ResultSet rs){
		close(rs, null, null);
	}
	
	public static void close(Statement stat){
		close(null, stat, null);	
	}
	
	public static void close(Connection conn){
		close(null, null, conn);
	}
	
	
	//һ���Թر���������
	public static void close(ResultSet rs,Statement stat){
		close(rs, stat, null);
	}
	
	public static void close(ResultSet rs,Connection conn){
		close(rs, null, conn);
	}
	
	public static void close(Statement stat,Connection conn){
		close(null, stat, conn);
	}
	
	
	
}
