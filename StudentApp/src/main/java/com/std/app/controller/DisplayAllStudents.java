package com.std.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.std.app.dao.StudentDAO;
import com.std.app.dto.Student;


import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class DisplayAllStudents extends GenericServlet{
	private StudentDAO dao = new StudentDAO();

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		List<Student> students = dao.getAllStudents();
		pw.println("<h2><a href='index.html'>home</a></h2>");
		pw.println("<table border=5>");
		pw.println("<tr><th>SID</th><th>SNAME</th><th>SPRCE</th></tr>");
		for(Student dto:students) {
			pw.println("<tr><td>"+dto.getSid()+"</td><td>"+dto.getSname()+"</td><td>"+dto.getSprce()+"</td></tr>");
		}
		pw.println("</table>");
	}

}
