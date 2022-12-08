package usermanagement.entity;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usermanagement.bean.UserDao;

@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	public void init() {
		userDao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Getting ID for deletion
		int id = Integer.parseInt(request.getParameter("id"));

		// Calling deleteUser method of Database for deleting the data and then
		// redirecting to the ViewUser page again
		try {
			userDao.deleteUser(id);
			response.sendRedirect("ViewUser");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}