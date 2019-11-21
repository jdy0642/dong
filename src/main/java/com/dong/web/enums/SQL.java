package com.dong.web.enums;

public enum SQL {
	CREATE_USER, DROP_USER,CREATE_DB,CREATE_RES,CREATEFUTTAB,CREATEPOSTTAB
	 ,CREATE_GAME, CREATE_LOL,CREATE_REPORT,CREATE_TABLE,DROP_TABLE,CREATE_ADMIN,CREATE_REVENUE;
	
	@Override
	public String toString() {
		String result = "";
		switch (this) {
		case CREATE_USER:
			result = "CREATE TABLE USER(" + 
					" USERID VARCHAR(10) PRIMARY KEY," + 
					" USERNAME VARCHAR(20)," + 
					" USERPW VARCHAR(20)," + 
					" USERTEL VARCHAR(15)," + 
					" USERPOINT VARCHAR(10)," + 
					" AGE VARCHAR(5)," + 
					" LOC VARCHAR(10)," + 
					" GENDER VARCHAR(6)," + 
					" EMAIL VARCHAR(20)," + 
					" BOOKMARK VARCHAR(30)," + 
					" LOLBLACK VARCHAR(30)," + 
					" FUTBLACK VARCHAR(30)" + 
					")";
			break;
			
		case CREATEFUTTAB:
			result = "CREATE TABLE FUTSAL (" + 
					"NICKNAME VARCHAR(10) PRIMARY KEY," + 
					"SCORE VARCHAR(10)," + 
					"USERID VARCHAR(20)," + 
					"SCORE VARCHAR(10)," +  
					"WIN VARCHAR(20)," + 
					"HITMAP VARCHAR(20)," + 
					"KM VARCHAR(20)," + 
					"HEART VARCHAR(100)," + 
					"FUTBLACK VARCHAR(20)," + 
					"REPORTNUM VARCHAR(100)," + 
					"USERID VARCHAR(10), FOREIGN KEY (USERID) REFERENCES USER (USERID)" +
					")";
			break;
			
		case CREATEPOSTTAB:
			result = "CREATE TABLE ARTICLE (" + 
					"ARTSEQ INT AUTO_INCREMENT PRIMARY KEY," + 
					"TITLE VARCHAR(30)," + 
					"CONTENT VARCHAR(30)," + 
					"COMMENTS VARCHAR(30)," + 
					"FILE VARCHAR(30)," +
					"USERID VARCHAR(10) REFERENCES USER" + 
					")";
			break;
			
		case CREATE_GAME:
			result = "CREATE TABLE GAME(" + 
					" GAMEID VARCHAR(30) PRIMARY KEY," + 
					" STADIUMNAME VARCHAR(30)," + 
					" STADIUMLOC VARCHAR(30)," + 
					" STADIUMSIZE VARCHAR(30)," + 
					" STADIUMTEL VARCHAR(30)," + 
					" SHOWER VARCHAR(30)," + 
					" PARKING VARCHAR(30)," + 
					" GAMEDATE VARCHAR(30)," + 
					" USERCOUNT VARCHAR(30)" + 
					" ADMINID VARCHAR(30), FOREIGN KEY (ADMINID) REFERENCES ADMIN (ADMINID)" +
					")";
			break;
			
		case CREATE_RES :
			result = "CREATE TABLE RESERVATION(\r\n" +
                    "RESNUM VARCHAR(30) PRIMARY KEY,\r\n" +
                    "RESDATE VARCHAR(30),\r\n" +
                    "USERPOINT VARCHAR(30),\r\n" +
                    "RESCAN VARCHAR(30),\r\n" +
                    "PAYNUM VARCHAR(30),\r\n" +
                    "PAYAMOUNT VARCHAR(30),\r\n" +
                    "PAYWAY VARCHAR(30),\r\n" +
                    "PAYCAN VARCHAR(30),\r\n" +
                    "ADMINID VARCHAR(30)\r\n" +
                    "USERID VARCHAR(10), FOREIGN KEY (USERID) REFERENCES ADMIN (USERID)" +
					"INCOMEDAY VARCHAR(30), FOREIGN KEY (INCOMDAY) REFERENCES ADMIN (INCOMDAY)" +
					"GAMEID VARCHAR(30), FOREIGN KEY (GAMEID) REFERENCES ADMIN (GAMEID)" +
                    ")";
			break;
			
		case CREATE_LOL : 
			result = "CREATE TABLE LOL(\r\n" + 
					"LOLNAME VARCHAR(30) PRIMARY KEY,\r\n" + 
					"USERID VARCHAR(30),\r\n" + 
					"ROOMNUM VARCHAR(30),\r\n" + 
					"ROOMMAKE VARCHAR(30),\r\n" + 
					"INVITE VARCHAR(30),\r\n" + 
					"LOLSTART VARCHAR(30),\r\n" + 
					"LOLBLACK VARCHAR(30),\r\n" + 
					"REPORTNUM VARCHAR(30)\r\n" + 
					")";
			break;
			
		case CREATE_REPORT :
			result = "CREATE TABLE REPORT(\r\n" + 
					"REPORTNUM VARCHAR(30) PRIMARY KEY,\r\n" + 
					"REPLY VARCHAR(30),\r\n" + 
					"IMG VARCHAR(30),\r\n" + 
					"STADIUMID VARCHAR(30),\r\n" + 
					"USERID VARCHAR(30)\r\n" + 
					"LOLNAME VARCHAR(30)\r\n" + 
					" ADMINID VARCHAR(30), FOREIGN KEY (ADMINID) REFERENCES ADMIN (ADMINID)" +

					")";
			break;
			
		case CREATE_ADMIN:
			result = "CREATE TABLE ADMIN(\n" + 
					"	ADMINID VARCHAR(30) PRIMARY KEY,\n" + 
					"    ADMINPW VARCHAR(30),\n" + 
					"    ADMINNAME VARCHAR(30),\n" + 
					"    ADMINTEL VARCHAR(30),\n" + 
					"    ADMINEMAIL VARCHAR(30),\n" + 
					"    REGISTER VARCHAR(30),\n" + 
					"    REGISTERNUM VARCHAR(30),\n" + 
					"    STADIUMID VARCHAR(30),\n" + 
					"    STADIUMNUM VARCHAR(30)\n" + 
					")";
			break;
			
		case CREATE_REVENUE:
			result = "CREATE TABLE INCOME(\r\n" + 
					"	INCOMEDAY VARCHAR(30) PRIMARY KEY,\r\n" + 
					"    INCOMESTADIUM VARCHAR(30),\r\n" + 
					"    STADIUMID VARCHAR(30),\r\n" + 
					"    INCOMEDATE VARCHAR(30)\r\n" + 
					")";
			break;
			
		case CREATE_TABLE:
			result ="CREATE TABLE USER";
			break;
			
		case DROP_TABLE:
			result = "DROP TABLE USER";
			break;
			
		case CREATE_DB:
			result = "CREATE DATABASE SHIPDB";
			break;
			
		}
		return result;
	}
}