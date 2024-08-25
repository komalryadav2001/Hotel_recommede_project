package org.recommend.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.recommend.model.HotelModel;
import org.recommend.model.viewCityListModel;
import org.recommend.service.HotelService;
import org.recommend.service.HotelServiceImpl;

@WebServlet("/searchhotel")
public class SearchHotelController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); 

        int i=1;
        
        String city = request.getParameter("city");
        String area = request.getParameter("area");

        HotelService hotelService = new HotelServiceImpl();
        List<HotelModel> hlist = hotelService.isViewHotelListByCityArea(city, area);

        if (hlist == null || hlist.isEmpty()) {
            out.println("<tr><td colspan='8' class='text-center'>No hotels found</td></tr>");
        } else {
        	out.println("<table class='table'>");
    		out.println("<thead class='thead-dark'>");
    		out.println("<tr>");
    		out.println("<th scope='col'>ID</th>");
    		out.println("<th scope='col'>Hotel NAME</th>");
    		out.println("<th scope='col'>CITY</th>");
    		out.println("<th scope='col'>AREA</th>");
    		out.println("<th scope='col'>PRICE</th>");
    		out.println("<th scope='col'>AMENITIES</th>");
    		out.println("<th scope='col'>DELETE</th>");
    		out.println("<th scope='col'>UPDATE</th>");
    		out.println("</tr>");
    		out.println("</thead>");
    		out.println("<tbody>");
            for (HotelModel h : hlist) {
                out.println("<tr>");
                out.println("<td scope='col'>" + i++ + "</td>");
                out.println("<td scope='col'>" + h.getHname() + "</td>");
                out.println("<td scope='col'>" + h.getCity() + "</td>");
                out.println("<td scope='col'>" + h.getArea() + "</td>");
                out.println("<td scope='col'>" + h.getPrice() + "</td>");
                out.println("<td scope='col'>" + h.getAmenities() + "</td>");
                out.println("<td scope='col'><a href='delhotel?hotel_id=" + h.getHid() + "'>DELETE</a></td>");
                out.println("<td scope='col'><a href='updatehotel?hotel_id=" + h.getHid() + "&hotel_name=" + h.getHname() + "&price_per_night=" + h.getPrice() + "&amenities_name=" + h.getAmenities() + "'>UPDATE</a></td>");
                out.println("</tr>");
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}