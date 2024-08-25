package org.recommend.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.recommend.model.LoginModel;
import org.recommend.repository.DBConfig;
import org.recommend.repository.DBParent;
import org.recommend.service.*;
import java.io.*;
@WebServlet("/Valid")
public class ValidateServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String path=this.getServletContext().getRealPath("/")+"resources\\db.properties";//current folder path
		DBParent.path=path;
		String username=request.getParameter("uname");
		String password=request.getParameter("pass");
		LoginModel model = new LoginModel();
		model.setUsername(username);
		model.setPassword(password);
		ValidateUserService validService=new ValidateUserServiceImpl();
		model=validService.isValidate(model);
		
		if(model.getLoginType().equals("super admin")|| model.getLoginType().equals("employee")) {
			RequestDispatcher r=request.getRequestDispatcher("admindashboard.jsp");
			r.forward(request, response);
		}
		else if(model.getLoginType().equals("user")) {
			RequestDispatcher r=request.getRequestDispatcher("userdashboard.jsp");
			r.forward(request, response);
		}
		else {
			out.println("Invalid Username and password");
		}
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
