package com.std.app.dto;

public class Student {
	private int sid;
	private String sname;
	private double sprce;
	public Student() {}
	public Student(int sid, String sname, double sprce) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sprce = sprce;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public double getSprce() {
		return sprce;
	}
	public void setSprce(double sprce) {
		this.sprce = sprce;
	}

}
