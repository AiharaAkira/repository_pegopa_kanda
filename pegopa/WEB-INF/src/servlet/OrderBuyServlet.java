package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Account;
import bean.Order;
import bean.Uniform;
import dao.AccountDAO;
import dao.OrderDAO;
import dao.UniformDAO;
import util.SendMail;

public class OrderBuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		int cmd = Integer.parseInt(request.getParameter("cmd"));
		UniformDAO uniformDaoObj = new UniformDAO();
		OrderDAO orderDaoObj = new OrderDAO();
		Uniform uniform = null;
		String name = null;
		Order order = new Order();



		try{

			request.setAttribute("cmd", "");




			if(cmd==1) {



			uniform = uniformDaoObj.selectById(id);
			int stock = uniform.getStock();
			request.setAttribute("stock", stock);
			name = uniform.getName();
			}
			//購入情報入力
			if(cmd==2) {
				String user_name = request.getParameter("user_name");
				String address = request.getParameter("address");
				String email = request.getParameter("email");
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				String content = request.getParameter("content");
				name = uniformDaoObj.selectById(id).getName();
				int price = uniformDaoObj.selectById(id).getPrice();
				order.setUser_name(user_name);
				order.setAddress(address);
				order.setEmail(email);
				order.setQuantity(quantity);
				order.setContent(content);
				order.setUniform_id(id);
				order.setUniform_name(name);
				order.setPrice(price);

				request.setAttribute("order", order);
				HttpSession hs = request.getSession();

				hs.setAttribute("order", order);

			}
			//購入確認画面
			if(cmd==3) {
				HttpSession hs = request.getSession();
				Account a = (Account)hs.getAttribute("accountList");




				int account_id = 0;
				if(a != null) {
					account_id = a.getId();
				}

				String user_name = request.getParameter("user_name");
				String address = request.getParameter("address");
				String email = request.getParameter("email");
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				String content = request.getParameter("content");
				name = uniformDaoObj.selectById(id).getName();
				int price = uniformDaoObj.selectById(id).getPrice();
				order.setUser_name(user_name);
				order.setAddress(address);
				order.setEmail(email);
				order.setQuantity(quantity);
				order.setContent(content);
				order.setUniform_id(id);
				order.setUniform_name(name);
				order.setPrice(price);
				order.setAccount_id(account_id);

				orderDaoObj.insertOrder(order);
				uniform = uniformDaoObj.selectById(id);
				int stock = uniform.getStock();
				uniform.setStock(stock-quantity);
				uniformDaoObj.update(uniform);

				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				System.out.println(timestamp);
				order.setOrderdate(timestamp);
				mail_buy(order);
				request.setAttribute("order", order);

				request.getRequestDispatcher("/view/orderBuyConfirm.jsp").forward(request, response);

			}

		}catch(Exception e) {
			//エラー画面へ移動
			request.setAttribute("error", "DB接続エラーの為、一覧表示は行えませんでした。");
			System.out.println("dbエラー");
//			request.setAttribute("cmd", "logout");
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
		}

		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.getRequestDispatcher("/view/orderBuy.jsp").forward(request, response);

	}

	//修正する
	private void mail_buy(Order order) {

		DecimalFormat df = new DecimalFormat("###,###");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日");
		SimpleDateFormat sf1 = new SimpleDateFormat("E");
		String day = sf1.format(order.getOrderdate());
		SimpleDateFormat sf2 = new SimpleDateFormat("HH時mm分");
		String mail = order.getUser_name()+"様\r\n" +
				"\r\n" +
				"\r\n" +
				"ご注文ありがとうございます。\r\n" +
				"\r\n" +
				"下記の注文内容で受け付けましたので、\r\n" +
				"お手数ですがお間違いないかご確認くださいませ。\r\n" +
				"\r\n" +
				"━━━　ご注文内容　━━━━━━━━━━━━━━━━━━━━━━━━\r\n" +
				"\n【注文日時】\r\n" +
				sf.format(order.getOrderdate())+"("+day+") "+sf2.format(order.getOrderdate())+
				"\n【ご注文内容】\r\n" +
				"商品名："+order.getUniform_name()+
				"\n購入数："+order.getQuantity()+
				"\n金額："+df.format(order.getPrice()*order.getQuantity())+"円\n"+
				"【備考】\r\n" +order.getContent()+
				"\n\r\n" +
				"━━━　注文内容届け先　━━━━━━━━━━━━━━━━━━━━━━━━\r\n" +
				"\r\n" +
				"【お名前】\r\n" +
				order.getUniform_name() +
				"\n【住所】\r\n" +
				order.getAddress()+
				"\n【メールアドレス】\r\n" +
				order.getEmail()+
				"\n\r\n" +
				"━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\r\n" +
				"\r\n" +
				"また、振込先につきましては\r\n" +
				"〇月〇日の〇時までにお振込みいただきますようお願いいたします。\r\n" +
				"\r\n" +
				"■振込み内容\r\n" +
				"金額："+df.format(order.getPrice()*order.getQuantity())+"円\r\n" +
				"振込先：〇〇銀行〇〇支店　普通　口座番号〇〇〇〇〇〇\r\n" +
				"\r\n" +
				"\r\n" +
				"この度は神田ユニフォームをご利用いただき、誠にありがとうございます。\r\n" +
				"引き続きよろしくお願いいたします。\r\n" +
				"\r\n" +
				"※本メールは、お買い物と同時に送信される自動返信メールです。\r\n" +
				"重要な情報を含んでおりますので、お手元に商品が届くまで\r\n" +
				"大切に保管くださいますようお願いいたします。\r\n" +
				"\r\n" +
				"━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\r\n" +
				"会社名：株式会社神田ユニフォーム\r\n" +
				"氏名：白石大\r\n" +
				"住所：▲▲▲▲▲▲▲▲\r\n" +
				"電話番号：✖✖✖-✖✖✖✖-✖✖✖✖\r\n" +
				"メールアドレス：■■■■@gmail.com\r\n" +
				"━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━";

		SendMail sendmail = new SendMail();


		sendmail.setFromInfo("test.sender@kanda-it-school-system.com", "株式会社神田ユニフォーム");
		//テスト用メール
		sendmail.setRecipients(order.getEmail());
		sendmail.setSubject("【神田ユニフォーム】ご注文ありがとうございます");
		sendmail.setText(mail);
		sendmail.forwardMail();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
