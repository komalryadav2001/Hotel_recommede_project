package org.recommend.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.recommend.model.ReviewModel;

import org.recommend.service.ReviewService;
import org.recommend.service.ReviewServiceImpl;

@WebServlet("/addreview")
public class AddReviewController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    
		    String rating = request.getParameter("rating");
		    String review = request.getParameter("review");
		    String hid = request.getParameter("hotel_id");  // Get hotel_id from request

		    ReviewModel rmodel = new ReviewModel();
		    rmodel.setRating(rating);
		    rmodel.setReview(review);
		    rmodel.setHid(hid);  // Set hotel_id into ReviewModel

		    ReviewService reviewserv = new ReviewServiceImpl(); 
		    boolean b = reviewserv.isAddReview(rmodel);
		    if (b) {
		        RequestDispatcher r = request.getRequestDispatcher("userdashboard.jsp");
		        r.forward(request, response);
		    } else {
		        out.println("<h1>Failed to add Review....</h1>");
		    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
