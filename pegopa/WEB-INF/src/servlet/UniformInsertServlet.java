package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bean.Uniform;
import dao.AccountDAO;
import dao.UniformDAO;

public class UniformInsertServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		request.setAttribute("cmd", "");

		// String directory = "C:/Users/Globalway/Desktop/pegopa/pegopa/img";
		String directory = request.getSession().getServletContext().getRealPath("/") + "img";
		int sizeLimit = 1000 * 1024 * 1024; // 1000MB

		MultipartRequest multi = new MultipartRequest(request, directory, sizeLimit, "UTF-8",
				new DefaultFileRenamePolicy());

		String name = multi.getParameter("name");
		String img = multi.getFilesystemName("img");
		int price = Integer.parseInt(multi.getParameter("price"));
		int stock = Integer.parseInt(multi.getParameter("stock"));

		Uniform uniform = new Uniform();
		uniform.setName(name);
		uniform.setImg(img);
		uniform.setPrice(price);
		uniform.setStock(stock);

		// ① UniformDAOをインスタンス化する
		UniformDAO uniformDaoObj = new UniformDAO();

		// ②関連メソッドを呼び出し、戻り値としてUniformオブジェクトのリストを取得する
		try {
			boolean result = false;

			if (AccountDAO.loginCheck(result, request, response)) {

				request.getRequestDispatcher("/logout").forward(request, response);
				return;
			}

			uniformDaoObj.insert(uniform);
			System.out.println("insert成功");
		} catch (Exception e) {
			// エラー画面へ移動
			request.setAttribute("error", "DB接続エラーの為、一覧表示は行えませんでした。");
//			request.setAttribute("cmd", "logout");
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
		}

		// ④list.jspにフォワード
		response.sendRedirect("uniformList");

	}
}
