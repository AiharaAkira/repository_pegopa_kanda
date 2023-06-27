package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Account;
import dao.AccountDAO;

public class AccountUpdateServlet extends HttpServlet {

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
				request.getRequestDispatcher("/view/accountUpdate.jsp").forward(request, response);

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

			if (AccountDAO.loginCheck(request, response)) {
				error = "noSession";
				return;
			}

			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String pw = request.getParameter("pw");
			String email = request.getParameter("email");
			String address = request.getParameter("address");

			Account a = new Account(id, pw, name, address, email);

			HttpSession hs = request.getSession();
			Account accountList = (Account) hs.getAttribute("accountList");

			if(!accountList.getEmail().equals(email)&&AccountDAO.searchByEmailPw(email, pw,id)) {

				error="emailDupli";
				cmd="正しいメールアドレスのみ入力できます。";
				return;

			}

			AccountDAO.update(a);

		} catch (IllegalStateException e) {


			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {

				// エラーが無い場合はListServletにフォワード
				response.sendRedirect("view/confirmLogin.jsp?cmd= ");

			}else if (error.equals("noSession")) {
				request.getRequestDispatcher("/logout").forward(request, response);

			} else if(error.equals("emailDupli")){

				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/accountUpdate.jsp").forward(request, response);

			}else {

				// エラーが有る場合はerror.jspにフォワードする
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);

			}

		}
	}

}
