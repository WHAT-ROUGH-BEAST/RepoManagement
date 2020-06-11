package util;

import java.sql.*;

/**
 * 
 * @author 18069 单例模式
 */
public class DataBase
{
	// 驱动路径
	private static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// 数据库地址
	private static final String DBURL = "jdbc:sqlserver://localhost:1433; DataBaseName=master";
	// 数据库登录用户名
	private static final String DBUSER = "WRB";
	// 数据库用户密码
	private static final String DBPASSWORD = "123456";
	// 数据库连接
	public static Connection conn = null;
	
	private static DataBase instance = null;

	private DataBase()
	{
	}

	synchronized public static DataBase getInstance()
	{
		if (null == instance)
		{
			instance = new DataBase();
		}
		else
		{
			throw new RuntimeException("数据库正在使用");
		}
		return instance;
	}


	// 程序入口函数
	public static void main(String[] args)
	{
		try
		{
			// 加载驱动程序
			Class.forName(DBDRIVER);
			// 连接数据库
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			System.out.println(conn);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		try
		{
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
