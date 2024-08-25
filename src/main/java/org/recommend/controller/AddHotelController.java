package org.recommend.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.recommend.model.HotelModel;
import org.recommend.service.HotelService;
import org.recommend.service.HotelServiceImpl;

@WebServlet("/addhotel")
public class AddHotelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String hotelName=request.getParameter("hotel_name");
		String hcity=request.getParameter("city");
		String harea=request.getParameter("area");
		String price=request.getParameter("price_per_night");
		String amenities=request.getParameter("amenities_name");
		HotelModel hmodel = new HotelModel();
		hmodel.setHname(hotelName);
		hmodel.setCity(hcity);
		hmodel.setArea(harea);
		hmodel.setPrice(price);
		hmodel.setAmenities(amenities);
		HotelService hotelService=new HotelServiceImpl();
		boolean b=hotelService.isAddNewHotel(hmodel);
		if(b) {
			RequestDispatcher r=request.getRequestDispatcher("viewhotel.jsp");
			r.forward(request, response);
		}
		else {
			out.println("<h1>Failed to add hotel....</h1>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
