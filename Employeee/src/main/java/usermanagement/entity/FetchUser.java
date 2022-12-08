package usermanagement.entity;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usermanagement.bean.User;
import usermanagement.bean.UserDao;

@WebServlet("/FetchUser")
public class FetchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao;

	public FetchUser() {
		super();
		this.userDao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Getting "id" to which we want to fetch data and update that data
		int id = Integer.parseInt(request.getParameter("id"));

		User existingUser = null;
		try {
			// Calling database method fetchUser to fetch the data from that particular id
			existingUser = userDao.fetchUser(id);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		// Redirecting the page to update-user.jsp for Updating
		RequestDispatcher dispatcher = request.getRequestDispatcher("update-user.jsp");

		// Setting all attribute to the update-user.jsp page
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}

}
