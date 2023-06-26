package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

import bean.Account;
import dao.AccountDAO;

public class AccountDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";
		String link = "";



		try {

			if (AccountDAO.loginCheck(request, response)) {
				error = "noSession";
				return;
			}

			request.setCharacterEncoding("UTF-8");

		} catch (IllegalStateException e) {


			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {

				// エラーが無い場合はListServletにフォワード
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/accountDelete.jsp").forward(request, response);

			}else if (error.equals("noSession")) {
				request.getRequestDispatcher("/logout").forward(request, response);

			}  else {

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


			String name = request.getParameter("name");
			String pw = request.getParameter("pw");
			String email = request.getParameter("email");

			Account a = new Account(pw, name, email);


			HttpSession hs = request.getSession();
			Account accountList = (Account) hs.getAttribute("accountList");

			if(!accountList.getName().equals(name)||!accountList.getPw().equals(pw)||!accountList.getEmail().equals(email)) {

				error = "errorData";
				cmd = "会員情報に誤りがあります。";
				return;
			}



			if(AccountDAO.delete(a)!=1) {
				error = "noData";
				cmd = "会員情報に誤りがあります。";
				return;
			}



		} catch (IllegalStateException e) {


			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {

				// エラーが無い場合はListServletにフォワード
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/confirmLogin.jsp").forward(request, response);

			}else if (error.equals("noSession")) {
				request.getRequestDispatcher("/logout").forward(request, response);

			}  else if (error.equals("noData")) {


				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/accountDelete.jsp").forward(request, response);

			}else if (error.equals("errorData")) {


				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/accountDelete.jsp").forward(request, response);

			}  else {

				// エラーが有る場合はerror.jspにフォワードする
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);

			}

		}
	}
}
