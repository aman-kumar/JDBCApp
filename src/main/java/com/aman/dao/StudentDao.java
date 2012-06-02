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
        String query = "INSERT into Student values(?,?,?,?,?,?)";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, student.getStudentId());
        statement.setString(2, student.getFirstName());
        statement.setString(3, student.getLastName());
        statement.setString(4, student.getAddress());
        statement.setInt(5, student.getPhoneNumber());
        statement.setString(6, student.getEmailId());
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
        List<Student> studentList = new ArrayList<Student>();
        
        String querry = "SELECT studentId,firstName,lastName,email,address,phoneNumber from Student";
        PreparedStatement statement = con.prepareStatement(querry);
        ResultSet resultset = statement.executeQuery();

        while (resultset.next()) {
            Student student = new Student();
            student.setStudentId(resultset.getString("studentId"));
            student.setFirstName(resultset.getString("firstName"));
            student.setLastName(resultset.getString("lastName"));
            student.setEmailId(resultset.getString("email"));
            student.setAddress(resultset.getString("address"));
            student.setPhoneNumber(resultset.getInt("phoneNumber"));
            studentList.add(student);
        }

        return studentList;
    }
}
