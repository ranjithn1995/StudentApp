package com.std.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.std.app.dao.StudentDAO;
import com.std.app.dto.Student;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class AddStudentController extends GenericServlet{
	private StudentDAO dao =new StudentDAO();

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String msg ="";
		int sid = Integer.parseInt(req.getParameter("sid")); 
		String sname = req.getParameter("sname");
		double sprce = Double.parseDouble(req.getParameter("sprce"));
		
		Student dto = new Student(sid, sname, sprce);
		
		if(dao.addStudent (dto))
		{
			msg = "<h1>Student Added Sucessfully....<br><a href='index.html'>Home</h1>";
		}
		else {
			msg = "<h1>Oops Something Went Wrong....<br><a href='index.html'>Home</h1>";
		}
pw.println(msg);
		
	}

}
