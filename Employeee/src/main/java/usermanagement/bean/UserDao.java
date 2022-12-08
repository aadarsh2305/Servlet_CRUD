package usermanagement.bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;

import com.mysql.cj.jdbc.BlobFromLocator;
import com.mysql.cj.protocol.Resultset;

import usermanagement.entity.InsertUser;

public class UserDao {
	/**
	 * @author Aadarsh Gupta
	 * 
	 */
	private String Insert_Users= "insert into users(name,password,email,country) values(?,?,?,?)";
	private String Delete_Users="delete from users where id=?";
	private String Select_All_Users="select * from users";
	private String Update_User="update users set name=?,password=?,email=?,country=? where id=?";
	private String Fetch_User="select name,password,email,country from users where id=?";
	private String Check_Mail="select email from users";

	// Providing Database details
	private String url = "jdbc:mysql://localhost:3306/employee?useSSL=false";
	private String root = "root";
	private String pass = "Addy@9111";
	
	

	public UserDao() {
		super();
	}

	// Making connection to the Database
	protected Connection getConnection() {
		Connection con = null;

		try {
			// Driver class for MYSQL
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, root, pass);
			System.out.println("Connection established ....");

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return con;

	}

	// Inserting or Add new User to the Database
	public void insertUser(User user) throws SQLException {

		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(Insert_Users);

		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getCountry());

		ps.executeUpdate();
		System.out.println("User Dao completed");

	}

	// Deleting User from the database with the help of "id"
	public boolean deleteUser(int id) throws SQLException {
		boolean delete;
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(Delete_Users);
		ps.setInt(1, id);
		delete = ps.executeUpdate() > 0;
		return delete;
	}

	// Selecting all existing users to display on ViewUser
	public List<User> selectAllUsers() throws SQLException {
		List<User> users = new ArrayList<>();
		Connection conn = getConnection();

		PreparedStatement ps = conn.prepareStatement(Select_All_Users);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String pass = rs.getString("password");
			String email = rs.getString("email");
			String country = rs.getString("country");

			users.add(new User(id, name, pass, email, country));
		}

		return users;
	}

	// Updating the database with particular "id"
	public boolean updateUser(User update) throws SQLException {
		boolean rowUpdate;
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(Update_User);
		ps.setString(1, update.getName());
		ps.setString(2, update.getPassword());
		ps.setString(3, update.getEmail());
		ps.setString(4, update.getCountry());
		ps.setInt(5, update.getId());
		rowUpdate = ps.executeUpdate() > 0;
		return rowUpdate;
	}

	// fetching previous User's data from the database for UpdateUser for that
	// particular "id"
	public User fetchUser(int id) throws SQLException {
		User fetch = null;
		System.out.println("================" + id + "===================");
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(Fetch_User);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

			String name = rs.getString("name");
			String pass = rs.getString("password");
			String email = rs.getString("email");
			String country = rs.getString("country");
			fetch = new User(id, name, pass, email, country);
		}
		return fetch;
	}
	public boolean checkMail(String mail) throws SQLException, IOException {
		boolean check = true;
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(Check_Mail);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String email = rs.getString("email");
			if (email.equalsIgnoreCase(mail)) {
				System.out.println("Email already been used");
				return false;
			}
		}
		return check;
	}

	

}
