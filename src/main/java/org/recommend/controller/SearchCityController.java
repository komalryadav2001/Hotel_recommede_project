package org.recommend.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.recommend.model.viewCityListModel;
import org.recommend.service.CityService;
import org.recommend.service.CityServiceImpl;

@WebServlet("/searchCity")
public class SearchCityController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int i=1;
		PrintWriter out=response.getWriter();
		String name=request.getParameter("n");
		CityService cityService=new CityServiceImpl();
		List<viewCityListModel> clist=cityService.isViewCityListByName(name);
		out.println("<table class='table'>");
		out.println("<thead class='thead-dark'>");
		out.println("<tr>");
		out.println("<th scope='col'>ID</th>");
		out.println("<th scope='col'>CITY NAME</th>");
		out.println("<th scope='col'>DELETE</th>");
		out.println("<th scope='col'>UPDATE</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		for(viewCityListModel c:clist) {
			out.println("<tr>");
			out.println("<td scope='col'>"+ i++ +"</td>");
			out.println("<td scope='col'>"+c.getCname()+"</td>");
			out.println("<td scope='col'><a href='delcity?cid="+c.getCid()+"'>DELETE</a></td>");
			out.println("<td scope='col'><a href=''>UPDATE</a></td>");
			out.println("</tr>");
		}
		out.println("</tbody");
		out.println("</table>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
