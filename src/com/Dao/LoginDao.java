package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pojo.Login;
import com.pojo.Register;

public class LoginDao {
	

	public static boolean loginC(Login login) {

		boolean status=false;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usersmultiple","root", "root");
			PreparedStatement preparedStatement = con
					.prepareStatement(" select * from register where username=? and password=?");
			preparedStatement.setString(1, login.getUsername());
			preparedStatement.setString(2, login.getPassword());

			ResultSet rs = preparedStatement.executeQuery();
			status=rs.next();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
           System.out.println("hello");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	           System.out.println("bee");
		}
		return status;

	}

}
