package com.google.demodb;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class MySqlConnect {

	static Connection getConnection() throws Exception {
	    //JDBCドライバのロード
	    Class.forName("com.mysql.jdbc.Driver");
	    //各設定
	    String url = "jdbc:mysql://127.0.0.1/demo";
	    String user = "demouser";
	    String pass = "suzupuro";
	    //データベースに接続
	    Connection con = (Connection) DriverManager.getConnection(url,user,pass);
	    return con;
	  }




}
