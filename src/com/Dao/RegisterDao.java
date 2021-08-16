package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pojo.Register;

public class RegisterDao {

	public static int registerC(Register register) {

		int result = 0;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usersmultiple","root", "root");
			PreparedStatement preparedStatement = con
					.prepareStatement(" insert into register(name,username,email,password,status) values (?,?,?,?,?)");
			preparedStatement.setString(1, register.getName());
			preparedStatement.setString(2, register.getUsername());
			preparedStatement.setString(3, register.getEmail());
			preparedStatement.setString(4, register.getPassword());
			preparedStatement.setString(5, register.getStatus());

			result = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
           System.out.println("hello");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	           System.out.println("bee");
		}
		return result;

	}

}
