package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Account;
import bean.Order;
import dao.AccountDAO;
import dao.OrderDAO;

public class OrderHistoryListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession hs = request.getSession();
		Account a = (Account)hs.getAttribute("accountList");

		// ① UniformDAOをインスタンス化する
		OrderDAO orderDaoObj = new OrderDAO();
		ArrayList<Order> list = new ArrayList<Order>();
		SimpleDateFormat sf = new SimpleDateFormat( "MM" );

		//管理者
		if(a.getAuthority()==2) {

		int sales_present = 0;
		int sales_past = 0;
		// 現在日時情報で初期化されたインスタンスの生成
		Date dateObj = new Date();
		// 日時情報を指定フォーマットの文字列で取得
		int nowmonth = Integer.parseInt(sf.format( dateObj ));

		// ②関連メソッドを呼び出し、戻り値としてUniformオブジェクトのリストを取得する
		try{

			request.setAttribute("cmd", "");

			boolean result = false;

			if(AccountDAO.loginCheck(result, request, response)) {

				request.getRequestDispatcher("/logout").forward(request, response);

				return;

			}


			list = orderDaoObj.selectAll();

			//売上チェック
			for(int i=0; i < list.size(); i++) {
				int ordermonth = Integer.parseInt(sf.format(list.get(i).getOrderdate()));
				if(list.get(i).getDeposit().equals("入金済")) {
				if(ordermonth == nowmonth) {
					sales_present += (list.get(i).getPrice()*list.get(i).getQuantity());
				}
				if(ordermonth == (nowmonth-1)) {
					sales_past += (list.get(i).getPrice()*list.get(i).getQuantity());
				}
				}
			}

		}catch(Exception e) {
			//エラー画面へ移動
			request.setAttribute("error", "DB接続エラーの為、一覧表示は行えませんでした。");
//			request.setAttribute("cmd", "logout");
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
		}

		// ③②で取得したListをリクエストスコープに"uniform_list"という名前で格納する
		request.setAttribute("sales_past", sales_past);
		request.setAttribute("sales_present", sales_present);
		request.setAttribute("nowmonth", nowmonth);

		}else {
			//ユーザー
			int id = a.getId();
			System.out.println(id);
			try{
				list = orderDaoObj.selectByUserId(id);

			}catch(Exception e) {
				//エラー画面へ移動
				request.setAttribute("error", "DB接続エラーの為、一覧表示は行えませんでした。");
//				request.setAttribute("cmd", "logout");
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}

		}

		request.setAttribute("order_list", list);
		request.getRequestDispatcher("/view/orderHistoryList.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
