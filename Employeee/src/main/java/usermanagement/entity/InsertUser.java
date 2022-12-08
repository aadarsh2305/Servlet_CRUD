package usermanagement.entity;

import usermanagement.bean.*;
import usermanagement.entity.validations.Validations;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertUser")
public class InsertUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Global variable

	private UserDao userDao;
	private Validations validations;

	// Initialization of database Object
	@Override
	public void init() {
		userDao = new UserDao();
		validations = new Validations(this.userDao);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Getting all parameters from adduser.jsp and putting in local variables
		String name = request.getParameter("userName");
		String password = request.getParameter("userPass");
		String email = request.getParameter("userEmail");
		String country = request.getParameter("userCountry");
		String confirmPass = request.getParameter("confirmPass");

		// Sending all fields values in User.java file constructor
		User user = new User(name, password, email, country, confirmPass);

		validations.checkValidation(user, response);

		// When click on "Add new user" which is in adduser.jsp ....we will be
		// redirected to InsertUser and this method will get run
		try {
			insertUser(user, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void insertUser(User user, HttpServletResponse response) throws SQLException, IOException {

		// Inserting all field values in the database with the help of insertUser method
		// which is present inside UserDao.java
		userDao.insertUser(user);

		// Redirecting the page to ViewUser
		response.sendRedirect("ViewUser");

	}

}
