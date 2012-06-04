package com.aman.Jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.Ignore;

import com.aman.Jdbc.ConnectionUtils;

public class ConnectionUtilsTest {

	@Test
        @Ignore
	public void testGetConnection() {
		Connection connection = ConnectionUtils.getConnection();
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
