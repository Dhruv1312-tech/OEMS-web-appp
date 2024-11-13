package com.user.dao;

public class UserDAO {
private String jdbcURL="jdbc:mysql://localhost:30006/event_management_db";
	private String jdbcUserName="root";
	private String jdbcPassward="root";
	
	
	private static final String INSERT_USER_SQL="INSERT INTO users"+"(uname,email,country,passward) VALUES "+"(?,?,?,?);";                     
	private static final String SELECT_USER_BY_ID="SELECT * FROM USERS WHERE ID=?;";
	private static final String SELECT_ALL_USERS="SELECT *FROM USERS;";
	private static final String DELETE_USERS_SQL="DELETE FROM USERS WHERE ID=?;";
	private static final String UPDATE_USERS_SQL="UPDATE USERS SET";
}
