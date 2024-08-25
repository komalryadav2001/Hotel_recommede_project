package org.recommend.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.recommend.model.SignupModel;
import org.recommend.service.SignupService;
import org.recommend.service.SignupServiceImpl;

@WebServlet("/signup")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String userName=request.getParameter("uname");
		String pass=request.getParameter("pass");
		String email=request.getParameter("email");
		SignupModel model = new SignupModel();
		model.setUsername(userName);
		model.setPassword(pass);
		model.setEmail(email);
		SignupService signService=new SignupServiceImpl();
		boolean b=signService.isAddNewUser(model);
//		out.println("added....");
		if(b) {
			RequestDispatcher r=request.getRequestDispatcher("login.jsp");
			r.forward(request, response);
		}
		else {
			out.println("<h1>Failed to add User....</h1>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
