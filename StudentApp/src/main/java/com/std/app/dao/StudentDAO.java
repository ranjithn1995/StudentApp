package com.std.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.std.app.dto.Student;

public class StudentDAO {
	public boolean addStudent(Student dto) {
		boolean res = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cfje3", "root", "Root");
			pstmt = con.prepareStatement("insert into student values(?,?,?)");
			pstmt.setInt(1, dto.getSid());
			pstmt.setString(2, dto.getSname());
			pstmt.setDouble(3, dto.getSprce());
			int nori = pstmt.executeUpdate();
			if (nori == 1) {
				res = true;
			}

		} catch (Exception e1) {
			e1.printStackTrace();

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
		return res;
	}
	public boolean deleteStudent(int sid) {
		boolean res = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cfje3", "root", "Root");
			pstmt = con.prepareStatement("delete from student where sid=?");
			pstmt.setInt(1, sid);
			
			int nori = pstmt.executeUpdate();
			if (nori == 1) {
				res = true;
			}

		} catch (Exception e1) {
			e1.printStackTrace();

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
		return res;
	}

	public Student searchStudent(int sid) {
		Student dto = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cfje3", "root", "Root");
			pstmt = con.prepareStatement("select * from student where sid = ?");
			pstmt.setInt(1,sid);
			
		ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new Student();
				dto.setSid(rs.getInt(1));
				dto.setSname(rs.getString(2));
				dto.setSprce(rs.getDouble(3));
				
			}

		} catch (Exception e1) {
			e1.printStackTrace();

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
		return dto;
		
		
	}
	public List<Student> getAllStudents(){
		List<Student> students = new ArrayList<Student>();

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cfje3", "root", "Root");
			pstmt = con.prepareStatement("select * from student");
			
			
		ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
		        Student dto = new Student();
				dto.setSid(rs.getInt(1));
				dto.setSname(rs.getString(2));
				dto.setSprce(rs.getDouble(3));
				students.add(dto);
				
			}

		} catch (Exception e1) {
			e1.printStackTrace();

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
		return students;
		
		
	}
	
}
