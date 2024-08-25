package org.recommend.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.recommend.service.CityService;
import org.recommend.service.CityServiceImpl;

@WebServlet("/updatecity")
public class UpdateCityController extends HttpServlet {

    private CityService cityService;

    @Override
    public void init() throws ServletException {
        cityService = new CityServiceImpl(); // Assuming you have a constructor or setter for this
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String cityName = request.getParameter("cname");
        int cityId = Integer.parseInt(request.getParameter("cid"));

        request.setAttribute("cityName", cityName);
        request.setAttribute("cityId", cityId);

        RequestDispatcher r = request.getRequestDispatcher("updatecity.jsp");
        r.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cityName = request.getParameter("cname");
        int cityId = Integer.parseInt(request.getParameter("cid"));

        boolean isUpdated = cityService.isUpdateCityById(cityId, cityName);

        if (isUpdated) {
            // Redirect to success page or message
        	  RequestDispatcher r = request.getRequestDispatcher("View.jsp");
              r.forward(request, response);
          } else {
              // Print "City not updated" on the current page
              response.setContentType("text/html");
              response.getWriter().println("<html><body>");
              response.getWriter().println("<h2>City not updated</h2>");
              response.getWriter().println("</body></html>");
          }
    }
}
