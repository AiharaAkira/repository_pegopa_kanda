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

public class UniformUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int uniformid = Integer.parseInt(request.getParameter("id"));
		int cmd = Integer.parseInt(request.getParameter("cmd"));

		UniformDAO uniformDaoObj = new UniformDAO();
		Uniform uniform = new Uniform();

		try{

			request.setAttribute("cmd", "");

			boolean result = false;

			if(AccountDAO.loginCheck(result, request, response)) {

				request.getRequestDispatcher("/logout").forward(request, response);

				return;

			}


			uniform = uniformDaoObj.selectById(uniformid);

			//ユニフォーム情報更新
			if(cmd==2) {
				String name = request.getParameter("name");
				int price = Integer.parseInt(request.getParameter("price"));
				String img = request.getParameter("img");
				int stock = Integer.parseInt(request.getParameter("stock"));
				uniform.setId(uniformid);
				uniform.setName(name);
				uniform.setPrice(price);
				uniform.setImg(img);
				uniform.setStock(stock);
				uniformDaoObj.update(uniform);

				request.getRequestDispatcher("/uniformList").forward(request, response);
			}

			//ユニフォーム情報削除
			if(cmd==3) {
				uniformDaoObj.delete(uniformid);
				request.getRequestDispatcher("/uniformList").forward(request, response);
			}

		}catch(Exception e) {
			//エラー画面へ移動
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
		}

		request.setAttribute("uniform", uniform);
		request.getRequestDispatcher("/view/uniformUpdate.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("UTF-8");
		request.setAttribute("cmd", "");

		UniformDAO uniformDaoObj = new UniformDAO();
		Uniform uniform = new Uniform();

		String directory = request.getSession().getServletContext().getRealPath("/")+"img";
		int sizeLimit = 1000*1024*1024;		//1000MB

		MultipartRequest multi = new MultipartRequest(request, directory, sizeLimit,"UTF-8",new DefaultFileRenamePolicy() );

		int id = Integer.parseInt(multi.getParameter("id"));
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		int stock = Integer.parseInt(multi.getParameter("stock"));
		String img_original = multi.getParameter("img_original");
		String img = multi.getFilesystemName("img");

		uniform.setId(id);
		uniform.setName(name);
		uniform.setPrice(price);
		uniform.setPrice(price);
		uniform.setStock(stock);
		if(img==null||img.equals("")) uniform.setImg(img_original);
		else uniform.setImg(img);

		try{
			Uniform uniform1 = uniformDaoObj.selectById(id);
			if(uniform1.getName()==null) {

				request.setAttribute("uniform", uniform1);
				request.getRequestDispatcher("/view/uniformUpdate.jsp").forward(request, response);

			}
			uniformDaoObj.update(uniform);

		}catch(Exception e) {
			//エラー画面へ移動
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
		}

		response.sendRedirect("uniformList");


	}
}
