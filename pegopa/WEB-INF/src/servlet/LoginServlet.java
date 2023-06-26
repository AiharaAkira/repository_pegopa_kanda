package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";
		String link = "";

		try {

			request.setCharacterEncoding("UTF-8");

			if (AccountDAO.loginCheck(request, response)) {
				error = "noSession";
				return;
			}

		} catch (IllegalStateException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				request.setAttribute("cmd", cmd);

				// エラーが無い場合はListServletにフォワード
				request.getRequestDispatcher("/view/login.jsp").forward(request, response);

			} else if (error.equals("noSession")) {
				request.getRequestDispatcher("/logout").forward(request, response);

			} else {

				// エラーが有る場合はerror.jspにフォワードする
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);


			}


		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";
		String link = "";

		try {

			request.setCharacterEncoding("UTF-8");

			String name = request.getParameter("name");
			String pw = request.getParameter("pw");

			if (AccountDAO.searchByEmailPw(name, pw)) {

				error = "loginError";
				cmd = "ユーザーID又はパスワードに誤りがあります。";
				return;
			}

			AccountDAO.login(name, pw, request);

			if (AccountDAO.loginCheck(request, response)) {
				error = "noSession";
				return;
			}

		} catch (IllegalStateException e) {


			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {

				// エラーが無い場合はmenuにフォワード
				request.getRequestDispatcher("/view/menu.jsp").forward(request, response);

			} else if (error.equals("noSession")) {
				request.getRequestDispatcher("/logout").forward(request, response);

			} else if (error.equals("loginError")) {
				request.setAttribute("cmd", cmd);
				// エラーが有る場合
				request.getRequestDispatcher("/view/login.jsp").forward(request, response);

			} else {
			}

			// エラーが有る場合はerror.jspにフォワードする
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);

		}

	}

}
