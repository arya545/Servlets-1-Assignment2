package com.inf;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Refresh
 */
@WebServlet("/Refresh")
public class Refresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Refresh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setIntHeader("Refresh", 10);
		response.setContentType("text/html");
		Calendar calendar=Calendar.getInstance();
		String am_pm;
		int hour=calendar.get(calendar.HOUR);
		int minute=calendar.get(calendar.MINUTE);
		int second=calendar.get(calendar.SECOND);
		
		if ((calendar.get(calendar.AM_PM))==0)
		{
			am_pm="AM";
		}
		else
		{
			am_pm="PM";
		}
		
		String CT=hour+ ":" +minute +":"+second+":"+am_pm;
		PrintWriter out=response.getWriter();
		String title="Auto Refresh Header Setting";
		String doctype="<!doctype html public \"-//w3c//dtd html 4.0 " +
         "transitional//en\">\n";
		
		out.println(doctype+"<html>\n"+
		 "<head><title>"+title+"</title></head>\n"+
		 "<body bgcolor=\"#f0f0f0\">\n"+
		 "<h1 align=\"center\">"+title+"</h1>\n"+
		 "<p>Current Time is "+CT+"</p>\n"
		 +"</html>\n");
				
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
