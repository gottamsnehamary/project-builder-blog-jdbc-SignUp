package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utility.ConnectionManager;

public class UserDAO implements UserDaoInterface {

	public int signUp(User user) throws SQLException {
		String Table = "INSERT INTO USERS(email, password)VALUES(?,?)";


			Connection con = null;
			try {
				con = ConnectionManager.getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			PreparedStatement preparedStatement = con.prepareStatement(Table);
			preparedStatement.setString(1,user.getEmail());
			preparedStatement.setString(2,user.getPassword());
			System.out.println(preparedStatement);
			int result = preparedStatement.executeUpdate();

		return result;
	}
	
	public boolean loginUser(User user) throws Exception {
		boolean results = false;
			Connection con = ConnectionManager.getConnection();
		
		PreparedStatement preparedStatement = con.prepareStatement("select * from users where email = ? and password = ? ");
		
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());

			System.out.println(preparedStatement);
			ResultSet resultset = preparedStatement.executeQuery();
			results = resultset.next();

	
		return results;
	}

}
