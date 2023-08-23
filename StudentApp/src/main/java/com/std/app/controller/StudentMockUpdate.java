package com.std.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class StudentMockUpdate extends GenericServlet {

		@Override
		public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
			PrintWriter pw = resp.getWriter();
			int sid = Integer.parseInt(req.getParameter("sid")); 
			String contact = req.getParameter("contactno");
			String subject = req.getParameter("subject");
			String tech = req.getParameter("tech");
			String comm = req.getParameter("comm");
			String comments = req.getParameter("comments");

//
//		System.out.println("id:"+id);
//		System.out.println("name:"+contact);
//		System.out.println("sub:"+subject);
//		System.out.println("tech:"+tech);
//		System.out.println("communication:"+comm);
//		System.out.println("comments:"+comments);
		
			resp.setContentType("text/html");
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cfje3", "root", "Root");
				pstmt = con.prepareStatement("insert into mockrating values(?,?,?,?,?,?)");
				pstmt.setInt(1, sid);
				pstmt.setString(2, contact);
				pstmt.setString(3, subject);
				pstmt.setString(4, tech);
				pstmt.setString(5, comm);
				pstmt.setString(6, comments);
				int nori=0;
				try {
					nori = pstmt.executeUpdate();
				}
				catch (Exception e) {
				e.printStackTrace();
					
				}
				

				if (nori == 0) {
					pw.println("Record not Submitted......!!!!!!!!!!" +"<br> " + "<a href='mock.html'>home</a>");
				} else {
					pw.println("Record Stored into Database Sucessfully" +"<br> " + "<a href='mock.html'>home</a>");
				}
			} catch (Exception e) {
				e.printStackTrace();
				pw.println("Student contact is not valid"+"<br> " + "<a href='mock.html'>home</a>");
				
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					if (pstmt != null) {
						try {
							pstmt.close();

						} catch (SQLException e) {
							e.printStackTrace();
						}
					}

				}
			}
		}
	}
