package com.aman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aman.Jdbc.ConnectionUtils;
import com.aman.domain.Student;

public class StudentDao {
	Connection con = null;

	public void create(Student student) {
		con = ConnectionUtils.getConnection();
		try {
			PreparedStatement statement = createStudent(student);
			int result = statement.executeUpdate();
			if (result == 1) {
				System.out.println("Querry has been suceesfully implemented");
			} else {
				System.out
						.println("Querry has not been suceesfully implemented");
			}
		} catch (SQLException ex) {
			throw new IllegalStateException(ex);
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				throw new IllegalStateException(ex);
			}
		}
	}

	private PreparedStatement createStudent(Student student)
			throws SQLException {
		String query = "INSERT into swtudentdetails values(?,?,?,?,?)";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, student.getFirstName());
		statement.setString(2, student.getLastName());
		statement.setString(3, student.getEmailId());
		statement.setString(4, student.getAddress());
		statement.setInt(5, student.getPhoneNumber());
		return statement;
	}

	public List<Student> getList() {
		con = ConnectionUtils.getConnection();

		try {
			return getStudentList();
		} catch (SQLException ex) {
			throw new IllegalStateException(ex);
		}
	}

	private List<Student> getStudentList() throws SQLException {
		Student student = new Student();
		String querry = "SELECT firstName,lastName,emailId,address,phoneNumber from studentdetails";
		PreparedStatement statement = con.prepareStatement(querry);
		ResultSet resultset = statement.executeQuery();
		while (resultset.next()) {
			student.setFirstName(resultset.getString("firstName"));
			student.setLastName(resultset.getString("lastName"));
			student.setEmailId(resultset.getString("emailId"));
			student.setAddress(resultset.getString("address"));
			student.setPhoneNumber(resultset.getInt("phoneNumber"));
		}
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(student);
		return studentList;
	}
}
