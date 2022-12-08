package usermanagement.entity;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usermanagement.bean.User;
import usermanagement.bean.UserDao;
import usermanagement.entity.validations.Validations;

@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao;
	private Validations validations;
	

	public UpdateUser() {
		super();
		this.userDao = new UserDao();
		validations=new Validations(this.userDao);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Fetching previous values from database using given "id" clicked by end user
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String pass = request.getParameter("password");
				String email = request.getParameter("email");
				String country = request.getParameter("country");

				// Sending all the values to User parameterized constructor
			User update = new User(id, name, pass, email, country);

		validations.checkValidation(update, response);
		// Sending request to updateUser
		try {
			updateUser(update, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void updateUser(User update, HttpServletResponse response)
			throws SQLException, IOException, ServletException {


		// Updating the User
		userDao.updateUser(update);
		// Redirecting to the ViewUser automatically when clicked on Update button
		response.sendRedirect("ViewUser");

	}

}
