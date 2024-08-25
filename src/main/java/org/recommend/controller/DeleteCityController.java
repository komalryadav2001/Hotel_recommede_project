package org.recommend.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.recommend.service.CityService;
import org.recommend.service.CityServiceImpl;


@WebServlet("/delcity")
public class DeleteCityController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int cityId=Integer.parseInt(request.getParameter("cid"));
		CityService cityServ=new CityServiceImpl();
		boolean b=cityServ.isDeleteCityById(cityId);
		if(b) {
			RequestDispatcher r=request.getRequestDispatcher("View.jsp");
			r.include(request, response);
//			out.println("<h1>City Delete Successfully....</h1>");
		}
		else {
			out.println("<h1>Some Problem For Delete City</h1>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
