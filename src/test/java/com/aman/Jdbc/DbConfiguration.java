package com.aman.Jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;


public class DbConfiguration {

	public static void populateSqls() throws SQLException {
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		ClassPathResource sqlFile = new ClassPathResource("test-schema.sql");
		ClassPathResource[] scripts = new ClassPathResource[1];
		scripts[0] = sqlFile;
		databasePopulator.setScripts(scripts);
		Connection connection = ConnectionUtils.getConnection();
		try {
			databasePopulator.populate(connection);
		} finally {
			connection.close();
		}
	}
	
	public static void tearDownSchema(){
		Connection connection = ConnectionUtils.getConnection();
		try {
			java.sql.PreparedStatement prepareStatement = connection.prepareStatement("DROP SCHEMA PUBLIC CASCADE");
			prepareStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
