package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import dao.AccountDAO;
import dao.OrderDAO;

public class AccountInsertServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String error = "";
		String cmd = "";
		String link = "";

		try {

			OrderDAO oda = new OrderDAO();
			oda.selectAll();


		} catch (IllegalStateException e) {

			error = "DBError";
			e.printStackTrace();

		}finally {
			if(error.equals("DBError")) {
				request.getRequestDispatcher("/view/error.jsp").forward(request,response);
				return;
			}
		}


		try {

		} catch (IllegalStateException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {

				request.setAttribute("cmd", cmd);
				// エラーが無い場合はListServletにフォワード
				request.getRequestDispatcher("view/accountInsert.jsp").forward(request, response);;

			} else {

				// エラーが有る場合はerror.jspにフォワードする
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);

			}

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String error = "";
		String cmd = "";
		String link = "";


		try {

			OrderDAO oda = new OrderDAO();
			oda.selectAll();


		} catch (IllegalStateException e) {

			error = "DBError";
			e.printStackTrace();

		}finally {
			if(error.equals("DBError")) {
				request.getRequestDispatcher("/view/error.jsp").forward(request,response);
				return;
			}
		}

		try {

			String name = request.getParameter("name");
			String pw = request.getParameter("pw");
			String address = request.getParameter("address");
			String email = request.getParameter("email");

			Account a = new Account(pw, name, address, email, 1);

			if (!AccountDAO.searchByEmailPw(email, pw)) {
				error = "isAccount";
				cmd = "既に存在している会員です。";

				return;
			}

			AccountDAO.insert(a);

		} catch (IllegalStateException e) {
			error = "DBError";
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				// エラーが無い場合はListServletにフォワード
				response.sendRedirect("view/confirmLogin.jsp?cmd= ");

			} else if (error.equals("isAccount")) {
				request.setAttribute("cmd", cmd);

				request.getRequestDispatcher("/view/accountInsert.jsp").forward(request, response);;

			} else {

				// エラーが有る場合はerror.jspにフォワードする
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);

			}

		}

	}

}
