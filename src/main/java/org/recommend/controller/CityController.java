 package org.recommend.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.recommend.model.viewCityListModel;
import org.recommend.service.CityService;
import org.recommend.service.CityServiceImpl;


@WebServlet("/savecity")
public class CityController extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String cityName=request.getParameter("cname");
		viewCityListModel cmodel = new viewCityListModel();
		cmodel.setCname(cityName);
		CityService cityService=new CityServiceImpl();
		boolean b=cityService.isAddNewCity(cmodel);
		if(b) {
			RequestDispatcher r=request.getRequestDispatcher("View.jsp");
			r.forward(request, response);
		}
		else {
			out.println("<h1>Failed to add City....</h1>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
