package com.vcs.struts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AbstractDao {
	
	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Connection getConnection() {
		return connection;
	}

	private PreparedStatement createStatement(String query) throws SQLException{
		
		return connection.prepareStatement(query);
		
	}
	
	private void setData(PreparedStatement psmt,List data) throws SQLException{
		
		for(int i=0;i<data.size();i++){
			
			if(data.get(i) instanceof String ){
				psmt.setString(i+1, (String)data.get(i));
			}
			if(data.get(i) instanceof Integer){
				psmt.setInt(i+1, (Integer)data.get(i));
			}
		}
	}
	
			protected final Object execute(String query,List data) throws SQLException{
				Connection connection=getConnection();
				PreparedStatement psStatement=createStatement(query);
				setData(psStatement,data);
				
				return executeInternal(query,psStatement);
			}

	private Object executeInternal(String query, PreparedStatement psStatement) throws SQLException {
		
		if(query.contains("SELECT")){
			ResultSet resultSet=psStatement.executeQuery();
			return processResultSet(resultSet);
		}else{
		return psStatement.executeUpdate();
	}
	
}

	protected List processResultSet(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
	}
}