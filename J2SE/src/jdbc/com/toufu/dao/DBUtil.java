package jdbc.com.toufu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jdbc.com.toufu.util.PropertiesReader;


//最基础的操作数据库
public class DBUtil {
	
	/*
	 * 加载数据库的驱动——>Class.forName(driver);
	 * 
	 * 链接数据库——>conn = DriverManager.getConnection(url, user, password);
	 * 
	 * 执行Sql语句——>
	 * 
	 * 执行Sql语句后的返回结果——>
	 */
	
	/*
	 * 大部分的工具类里面的方法都是静态方法
	 */

	/*
	 * 三层架构中的数据访问层
	 * 一般会有
	 * 专门负责数据库连接和关闭相关对象的---DBUtil
	 * DAO对象---一般是一张表对应一个DAO对象
	 * PO对象---参与数据转换的具体的对象
	 */
	
	/*
	 * 不能实例化
	 */
	private DBUtil(){
		
	}
	
	
	//这些信息都应该写在配置文件里面
	private static String driver = PropertiesReader.getDriver();
	private static String url = PropertiesReader.getURL();
	private static String user = PropertiesReader.getUser();
	private static String password = PropertiesReader.getPassword();
	private static Connection conn = null;
	
	//负责连接的方法
	public static Connection getConn(){	
		try {
			//加载并注册数据库驱动
			Class.forName(driver);
			//连接数据库
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {		
			e.printStackTrace();		
		}	
		return conn;
	}
	
	//负责关闭的方法---关闭rs,stat,conn
	
	//一次性关闭三个对象的方法
	public static void close(ResultSet rs,Statement stat,Connection conn){
		try {
			//关闭结果集对象
			if(rs != null && !rs.isClosed()){
				stat.close();
			}
			
			//关闭语句对象
			if(stat != null && !stat.isClosed()){
				stat.close();
			}
			
			//关闭连接对象
			if(conn != null && !conn.isClosed()){
				stat.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();		
		}	
	}
	
	
	//一次性关闭单个对象的方法
	public static void close(ResultSet rs){
		close(rs, null, null);
	}
	
	public static void close(Statement stat){
		close(null, stat, null);	
	}
	
	public static void close(Connection conn){
		close(null, null, conn);
	}
	
	
	//一次性关闭两个对象
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
