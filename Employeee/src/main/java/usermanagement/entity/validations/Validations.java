package usermanagement.entity.validations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import usermanagement.bean.User;
import usermanagement.bean.UserDao;

public class Validations{
	private UserDao userDao;

	public Validations(UserDao userDao) {
		this.userDao = userDao;
	}

	public void checkValidation(User user, HttpServletResponse response) throws IOException {
		String name = user.getName();
		String password = user.getPassword();
		String confirmPass = user.getConfirmPass();
		String email = user.getEmail();
		String country = user.getCountry();
		// TODO Auto-generated method stub
		if (name.equals("") || email.equals("") || password.equals("") || country.equals("")) {
			PrintWriter out = response.getWriter();
			out.print("<script type=\"text/javascript\"> alert('All fields must be filled');");
			out.print("location='adduser.jsp';</script>");

		} else if (!password.equals(confirmPass)) {
			PrintWriter out = response.getWriter();
			out.print("<script type=\"text/javascript\"> alert('Password and Confirm Password must be same');");
			out.print("location='adduser.jsp';</script>");

		} else {
			try {
				if (email.length() < 10) {
					PrintWriter out = response.getWriter();
					out.print("<script type=\"text/javascript\"> alert('Length of email is not enough !!!!');");
					out.print("location='adduser.jsp';</script>");
				} else if (userDao.checkMail(email) == false) {
					PrintWriter out = response.getWriter();
					out.print("<script type=\"text/javascript\"> alert('This Mail ID is already registered !!!!');");
					out.print("location='adduser.jsp';</script>");
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}


}
