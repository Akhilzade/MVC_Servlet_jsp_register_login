package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.RegisterDao;
import com.pojo.Register;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

	private RegisterDao registerDao;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = req.getParameter("name");
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String status = req.getParameter("status");

		Register register = new Register();
		register.setName(name);
		register.setUsername(username);
		register.setEmail(email);
		register.setPassword(password);
		register.setStatus(status);

		try {

		int result=	RegisterDao.registerC(register);
			
			if (result == 1) {

				RequestDispatcher dispatcher = req.getRequestDispatcher("Success.jsp");
				dispatcher.forward(req, resp);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block

              e.printStackTrace();		
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
		dispatcher.forward(req, resp);

	}
}
