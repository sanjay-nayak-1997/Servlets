package com.deloitte;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookiesDemo
 */
public class CookiesDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookiesDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] allCookie=request.getCookies();
		PrintWriter pw=response.getWriter();
		if(allCookie==null)
		{
		Cookie c=new Cookie("Location","Bangalore");
		c.setMaxAge(24*60*60);
		response.addCookie(c);
		pw.println("<body bgcolor=yellow>Welcome to my store for the first time</body>");
		}
		else
		{
			for(int i=0;i<allCookie.length;i++)
			{
				Cookie cc=allCookie[i];
				System.out.println(cc.getName() + " and " + cc.getValue());
				String name=cc.getName();
				String val=cc.getValue();
				if(name.equals("Location") && val.equals("Bangalore"))
				{
					pw.println("<body bgcolor=pink>Welcome back to the store</body>");
				}
				
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
