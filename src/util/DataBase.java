package util;

import java.sql.*;

/**
 * 
 * @author 18069 ����ģʽ
 */
public class DataBase
{
	// ����·��
	private static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// ���ݿ��ַ
	private static final String DBURL = "jdbc:sqlserver://localhost:1433; DataBaseName=master";
	// ���ݿ��¼�û���
	private static final String DBUSER = "WRB";
	// ���ݿ��û�����
	private static final String DBPASSWORD = "123456";
	// ���ݿ�����
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
			throw new RuntimeException("���ݿ�����ʹ��");
		}
		return instance;
	}


	// ������ں���
	public static void main(String[] args)
	{
		try
		{
			// ������������
			Class.forName(DBDRIVER);
			// �������ݿ�
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
