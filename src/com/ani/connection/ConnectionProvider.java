package com.ani.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider 
{
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String Url =  "jdbc:oracle:thin:@localhost:1521:orcl";
	private static String DbUname = "MYDB9AM";
	private static String DbPwd = "MYDB9AM";
	
	private static Connection con = null;
	
	private ConnectionProvider()
	{
		
	}
	
	public static Connection getConnection()
	{
		if(con == null)
		{
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(Url,DbUname,DbPwd);
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return con;
	}
}
