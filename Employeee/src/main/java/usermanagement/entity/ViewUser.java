package usermanagement.entity;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usermanagement.bean.UserDao;
import usermanagement.bean.*;

@WebServlet("/")
public class ViewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao;

	public ViewUser() {
		super();
		this.userDao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Listing all users
		List<User> listUser = null;
		try {
			// Putting values of existing users to a list variable
			listUser = userDao.selectAllUsers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Setting attribute to list-user.jsp file
		request.setAttribute("user", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-user.jsp");
		dispatcher.forward(request, response);
	}

}
