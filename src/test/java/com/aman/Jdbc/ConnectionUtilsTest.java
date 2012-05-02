package com.aman.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.aman.Jdbc.ConnectionUtils;

public class ConnectionUtilsTest {

	@Test
	public void testGetConnection() {
		Connection connection = ConnectionUtils.getConnection();
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
