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
import org.recommend.service.HotelService;
import org.recommend.service.HotelServiceImpl;

@WebServlet("/delhotel")
public class DeleteHotelController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int hotelId=Integer.parseInt(request.getParameter("hotel_id"));
		HotelService hotelserv=new HotelServiceImpl();
		boolean b=hotelserv.isDeleteHotelById(hotelId);
		if(b) {
			RequestDispatcher r=request.getRequestDispatcher("viewhotel.jsp");
			r.include(request, response);
//			out.println("<h1>City Delete Successfully....</h1>");
		}
		else {
			out.println("<h1>Some Problem For Delete City</h1>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
