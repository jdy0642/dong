package com.dong.web.usr;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
	public void insertUser(User user);

	public User selectUserByIdPw(User user);

	public int existId(String uid);

	public int countUsers();
	
	public void createUser(HashMap<String, String> paramMap);

	public void dropUser(HashMap<String, String> paramMap);

	public void createDB(HashMap<String, String> paramMap);
	public void createRes(HashMap<String, String> paramMap);
	public void createLolTable(HashMap<String, String> paramMap);

	public void createReportTable(HashMap<String, String> paramMap);
	public void createShipDb(HashMap<String,String> map);
	public void truncateUser(HashMap<String, String> paramMap);


}