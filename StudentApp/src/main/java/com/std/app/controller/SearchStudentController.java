package com.std.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.std.app.dao.StudentDAO;
import com.std.app.dto.Student;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class SearchStudentController extends GenericServlet{
	private StudentDAO dao =new StudentDAO();

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter(); 
		int sid =Integer.parseInt(req.getParameter("sid"));
		Student dto = dao.searchStudent(sid);
		if(dto!=null) {
			pw.println("<h2>Fetched Student Details Are  <a href='index.html'>home</a></h2>");
			pw.println("<table border=5>");
			
			pw.println("<tr><th>SID</th><th>SNAME</th><th>SPRCE</th></tr>");
			pw.println("<tr><td>"+dto.getSid()+"</td><td>"+dto.getSname()+"</td><td>"+dto.getSprce()+"</td></tr>");
			pw.println("</table>");

		}
		else {
			pw.println("<h2>Invalid Student id:  <a href='index.html'>home</a></h2>");
		}
		
	}
 

}
