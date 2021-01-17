package jeep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jeep.entity.Jeep;

public class JeepDao {

	public void createJeep(String name) {
		try(Connection connection = DbConnection.getConnection()) {
			String sql = "INSERT INTO jeeps (name) VALUES (?)";
			
			try(PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, name);
				statement.executeUpdate();
			}
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Jeep> listAllJeeps() {
		try(Connection connection = DbConnection.getConnection()) {
			String sql = "SELECT * FROM jeeps";
			
			try(PreparedStatement statement = connection.prepareStatement(sql)) {
				try(ResultSet rs = statement.executeQuery()) {
					List<Jeep> jeeps = new ArrayList<>();
					
					while(rs.next()) {
						long jeepId = rs.getLong("jeep_id");
						String name = rs.getString("name");
						
						Jeep jeep = new Jeep(jeepId, name);
						jeeps.add(jeep);
					}
					
					
					return jeeps;
				}
				
			}
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		
		
		
		// TODO Auto-generated method stub
	}

	public void modifyJeep(int jeepId, String name) {
		try(Connection connection = DbConnection.getConnection()) {
			String sql = "UPDATE jeeps SET name = ?  WHERE jeep_id = ?";
			
			try(PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, name);
			statement.setLong(2, jeepId);
			
			statement.executeUpdate();
			
			}
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void deleteJeep(int jeepId) {
		try(Connection connection = DbConnection.getConnection()) {
			String sql = "DELETE FROM jeeps WHERE jeep_id = ?";
			
			try(PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setLong(1, jeepId);			
			statement.executeUpdate();
			
			}
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	}


