package rest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/clock")
public class ClockController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		String pathInfo = request.getPathInfo(); // clock/hour/minute
		String[] pathParts = pathInfo.split("/");
		String hour = pathParts[1];
		String minute = "0";
		Clock clock = new Clock();
		int angle;
		
		if(pathParts.length>2)
			minute = pathParts[2];
		
		clock.setHour(Integer.parseInt(hour));
		clock.setMinute(Integer.parseInt(minute));
		angle = clock.angleInHistory(clock.getHour(), clock.getMinute());
		if (angle==-1)
			angle = clock.getAngleHourAndMinute();
		
		String json = "{\"angle\":"+angle+"}";
		response.setContentType("text/json");
	    
		response.getWriter().write(json);	    
	    
	}
}