package com.deloitte;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PassengerServlet
 */
public class PassengerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassengerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		String dest=request.getParameter("city");
		DBHelper db=new DBHelper();
		ArrayList<PassengerVO> al=new ArrayList<PassengerVO>();
		al=db.getAllPassengers(dest);
		String str="<head><style>th,td{color:white;}</style></head><body bgcolor=#11aaff><table align=center border=1 cellspacing=0 cellpadding=20px bordercolor=red>"
				+ "<tr>"
				+ "<th>First Name</th>"
				+ "<th>Last Name</th>"
				+ "<th>Source</th>"
				+ "<th>Destination</th>"
				+ "<th>Gender</th>"
				+ "</tr>";
		pw.println(str);
		for(int i=0;i<al.size();i++)
		{
			PassengerVO pvo=al.get(i);
			pw.println("<tr>"
					+ "<td>" + pvo.getFname() + "</td>"
					+ "<td>" + pvo.getLname() + "</td>"
					+ "<td>" + pvo.getSrc() + "</td>"
					+ "<td>" + pvo.getDst() + "</td>"
					+ "<td>" + pvo.getSex() + "</td>"
							+ "</tr>");
		}
		pw.println("</table></body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
