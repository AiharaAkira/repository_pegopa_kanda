package util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;

public class LoginCheck extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String name = request.getParameter("name");
		PrintWriter out = response.getWriter();

		boolean checkID = AccountDAO.loginCheck(name);

		if (checkID) {
			out.print("not-usable");
		} else {
			out.print("usable");
		}
	}
}