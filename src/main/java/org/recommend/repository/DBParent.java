package org.recommend.repository;

import java.sql.*;

import org.recommend.model.viewCityListModel;

public class DBParent {
	public static String path;
	protected DBConfig config=DBConfig.getInstance(path);
	protected Connection conn=config.getConnection();
	protected PreparedStatement stmt=config.getPreparedStatement();
	protected ResultSet rs=config.getResultSet();
	
}
