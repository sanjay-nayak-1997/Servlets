package com.deloitte;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeCalculate
 */
@WebServlet("/EmployeeCalculate")
public class EmployeeCalculate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeCalculate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("name");
		int sal=Integer.parseInt(request.getParameter("salary"));
		String grd=request.getParameter("grade");
		double bonus=0;
		if(sal>=100000 && grd.equals("A"))
			bonus=sal*0.05;
		else if(sal>=50000 && sal<100000 && grd.equals("B"))
			bonus=sal*0.07;
		else if(sal<50000 && grd.equals("C"))
			bonus=sal*0.2;
		double tax=sal*0.25;
		double netsal=sal+bonus-tax;
		pw.println("<table border=1 cellspacing=0 cellpadding=20px><tr><th>Employee name</th><th>Basic salary</th><th>Bonus</th><th>Tax</th><th>Net salary</th></tr>");
		pw.println("<tr><td>" + name + "</td>");
		pw.println("<<td>" + sal + "</td>");
		pw.println("<td>" + bonus + "</td>");
		pw.println("<<td>" + tax + "</td>");
		pw.println("<td>" + netsal + "</td></tr></table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
