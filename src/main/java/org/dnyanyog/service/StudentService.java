package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.dnyanyog.common.DBUtils;

public class StudentService {

	public String getFirstName(String rollNumber) {
		try {
			ResultSet rs = DBUtils.executeSelectQuery("select * from student where roll_number = '" + rollNumber + "'");
			rs.next();
			return rs.getString(2);
		} catch (SQLException e) {
			return "Some error occured";
		}
	}

	public String getLastName(String rollNumber) {
		try {
			ResultSet rs = DBUtils.executeSelectQuery("select * from student where roll_number ='" + rollNumber + "'");
			rs.next();
			return rs.getString(3);
		} catch (SQLException e) {
			return "Some error occured";
		}
	}

	public String getEmail(String rollNumber) {
		try {
			ResultSet rs = DBUtils.executeSelectQuery("select * from student where roll_number ='" + rollNumber + "'");
			rs.next();
			return rs.getString(4);
		} catch (SQLException e) {
			return "Some error occured";
		}
	}

	public String getMobile(String rollNumber) {
		try {
			ResultSet rs = DBUtils.executeSelectQuery("select * from student where roll_number ='" + rollNumber + "'");
			rs.next();
			return rs.getString(5);
		} catch (SQLException e) {
			return "Some error occured";
		}
	}}
