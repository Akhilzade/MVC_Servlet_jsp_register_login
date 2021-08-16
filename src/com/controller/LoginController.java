package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.LoginDao;
import com.Dao.RegisterDao;
import com.pojo.Login;
import com.pojo.Register;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);

		try {

			if (LoginDao.loginC(login)) {

				RequestDispatcher dispatcher = req.getRequestDispatcher("Success.jsp");
				dispatcher.forward(req, resp);

			} else {

				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.forward(req, resp);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

	}
}
