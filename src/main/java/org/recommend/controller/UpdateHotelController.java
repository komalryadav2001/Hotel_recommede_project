package org.recommend.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.recommend.model.HotelModel;
import org.recommend.service.HotelService;
import org.recommend.service.HotelServiceImpl;

@WebServlet("/updatehotel")
public class UpdateHotelController extends HttpServlet {
	
	 private HotelService hotelService;

	    @Override
	    public void init() throws ServletException {
	        hotelService = new HotelServiceImpl(); // Assuming you have a constructor or setter for this
	    }

	
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/html");

	        String hotelIdStr = request.getParameter("hotel_id");
	        if (hotelIdStr == null || hotelIdStr.isEmpty()) {
	            response.getWriter().println("<html><body>");
	            response.getWriter().println("<h2>Error: Missing hotel_id</h2>");
	            response.getWriter().println("</body></html>");
	            return;
	        }

	        int hotelId;
	        try {
	            hotelId = Integer.parseInt(hotelIdStr);
	        } catch (NumberFormatException e) {
	            response.getWriter().println("<html><body>");
	            response.getWriter().println("<h2>Error: Invalid hotel_id format</h2>");
	            response.getWriter().println("</body></html>");
	            return;
	        }

	        // Retrieve existing hotel details to populate the form
	        HotelModel hotel = hotelService.isViewHotelList().stream()
	                .filter(h -> h.getHid() == hotelId)
	                .findFirst()
	                .orElse(null);

	        if (hotel == null) {
	            response.getWriter().println("<html><body>");
	            response.getWriter().println("<h2>Error: Hotel not found</h2>");
	            response.getWriter().println("</body></html>");
	            return;
	        }

	        request.setAttribute("hotel_name", hotel.getHname());
	        request.setAttribute("price", hotel.getPrice());
	        request.setAttribute("amenities", hotel.getAmenities());
	        request.setAttribute("hotel_id", hotelId);

	        RequestDispatcher r = request.getRequestDispatcher("updatehotel.jsp");
	        r.forward(request, response);
	    }
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/html");

	        String hotelIdStr = request.getParameter("hotel_id");
	        if (hotelIdStr == null || hotelIdStr.isEmpty()) {
	            response.getWriter().println("<html><body>");
	            response.getWriter().println("<h2>Error: Missing hotel_id</h2>");
	            response.getWriter().println("</body></html>");
	            return;
	        }

	        int hotelId;
	        try {
	            hotelId = Integer.parseInt(hotelIdStr);
	        } catch (NumberFormatException e) {
	            response.getWriter().println("<html><body>");
	            response.getWriter().println("<h2>Error: Invalid hotel_id format</h2>");
	            response.getWriter().println("</body></html>");
	            return;
	        }

	        String hotelName = request.getParameter("hotel_name");
	        String price = request.getParameter("price_per_night");
	        String amenities = request.getParameter("amenities_name");

	        // Validate required fields
	        if (hotelName == null || price == null || amenities == null || hotelName.isEmpty() || price.isEmpty() || amenities.isEmpty()) {
	            response.getWriter().println("<html><body>");
	            response.getWriter().println("<h2>Error: All fields are required</h2>");
	            response.getWriter().println("</body></html>");
	            return;
	        }

	        boolean isUpdated = hotelService.isUpdateCityById(hotelId, hotelName, price, amenities);

	        if (isUpdated) {
	            // Forward to a success page or reload the form with updated values
	            request.setAttribute("hotel_name", hotelName);
	            request.setAttribute("price", price);
	            request.setAttribute("amenities", amenities);
	            request.setAttribute("hotel_id", hotelId);

	            RequestDispatcher r = request.getRequestDispatcher("viewhotel.jsp");
	            r.forward(request, response);
	        } else {
	            response.getWriter().println("<html><body>");
	            response.getWriter().println("<h2>Error: Hotel not updated</h2>");
	            response.getWriter().println("</body></html>");
	        }
	    }
}
