package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Uniform;
import dao.AccountDAO;
import dao.UniformDAO;

public class UniformListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ① UniformDAOをインスタンス化する
		UniformDAO uniformDaoObj = new UniformDAO();
		ArrayList<Uniform> list = null;


		// ②関連メソッドを呼び出し、戻り値としてUniformオブジェクトのリストを取得する
		try{

			request.setAttribute("cmd", "");

			list = uniformDaoObj.selectAll();

		}catch(Exception e) {
			//エラー画面へ移動
			request.setAttribute("error", "DB接続エラーの為、一覧表示は行えませんでした。");
//			request.setAttribute("cmd", "logout");
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
		}

		// ③②で取得したListをリクエストスコープに"uniform_list"という名前で格納する
		request.setAttribute("uniform_list", list);


		// ④list.jspにフォワード
		request.getRequestDispatcher("/view/uniformList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
