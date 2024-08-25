package org.recommend.repository;
import java.sql.*;
import java.io.*;
import java.util.*;

public class DBConfig {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	private static DBConfig db=null;
	private DBConfig(String path) {
		try {
//			File f= new File(".");
//			String path=f.getAbsolutePath().substring(0, f.getAbsolutePath().length()-1)+"resources\\db.properties";
			FileInputStream fin= new FileInputStream(path);
			Properties p= new Properties();
			System.out.println(path);
			p.load(fin);
			String username=p.getProperty("db.username");
			String password=p.getProperty("db.password");
			String url=p.getProperty("db.url");
			String driverClassName=p.getProperty("db.driverClassName");
			Class.forName(driverClassName);
			conn=DriverManager.getConnection(url,username,password);
			if(conn!=null) {
				System.out.println("Database Is Connected");
			}
			else {
				System.out.println("Database Is Not Connected");
			}
		}
		catch(Exception ex) {
			//System.out.println("Error In DBConfig Class: "+ex);
		}
	}
	public static DBConfig getInstance(String path) {
		if(db==null) {
			db=new DBConfig(path);
		}
		return db;
	}
	public Connection getConnection() {
		return conn;
	}
	public PreparedStatement getPreparedStatement() {
		return stmt;
	}
	public ResultSet getResultSet() {
		return rs;
	}
}
