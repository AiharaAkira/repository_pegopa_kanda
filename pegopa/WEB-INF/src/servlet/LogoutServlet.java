package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import dao.OrderDAO;

public class LogoutServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String error = "";
		String cmd = "";
		String link = "";


		try {

			request.setCharacterEncoding("UTF-8");


			AccountDAO.logout(request);

		} catch (IllegalStateException e) {

			error = "DBError";
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				request.setAttribute("cmd", cmd);
				// エラーが無い場合はListServletにフォワード
				request.getRequestDispatcher("/view/login.jsp").forward(request, response);

			} else {

				// エラーが有る場合はerror.jspにフォワードする
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);

			}

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
