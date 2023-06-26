package servlet;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Order;
import dao.AccountDAO;
import dao.OrderDAO;
import util.SendMail;

public class OrderHistoryListUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		int cmd = Integer.parseInt(request.getParameter("cmd"));
		int orderid = Integer.parseInt(request.getParameter("orderid"));
		String deposit = request.getParameter("deposit");
		String shipping = request.getParameter("shipping");

		OrderDAO orderDaoObj = new OrderDAO();
		Order order = null;

		try{

			request.setAttribute("cmd", "");

			boolean result = false;

			if(AccountDAO.loginCheck(result, request, response)) {

				request.getRequestDispatcher("/logout").forward(request, response);

				return;
			}


			order = orderDaoObj.selectByOrderID(orderid);

			String deposit_origin = order.getDeposit();
			String shipping_origin = order.getShipping();

			if(cmd==2) {
				orderDaoObj.updateOrder(orderid, deposit, shipping);
				if((!deposit_origin.equals("deposit"))&&deposit.equals("入金済")) {
					//入金状況変更メール送信
					order = orderDaoObj.selectByOrderID(orderid);
					mail_deposit(order);
				}
				if((!shipping_origin.equals("shipping"))&&shipping.equals("発送済")) {
					//発送状況変更メール送信
					order = orderDaoObj.selectByOrderID(orderid);
					mail_shipping(order);
				}
				request.getRequestDispatcher("/orderHistory").forward(request, response);
			}
			order = orderDaoObj.selectByOrderID(orderid);


		}catch(Exception e) {
			//エラー画面へ移動
			request.setAttribute("error", "DB接続エラーの為、一覧表示は行えませんでした。");
//			request.setAttribute("cmd", "logout");
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
		}

		request.setAttribute("order", order);
		request.getRequestDispatcher("/view/orderHistoryUpdate.jsp").forward(request, response);

	}

	private void mail_deposit(Order order) {
		DecimalFormat df = new DecimalFormat("###,###");
		String mail = order.getUser_name()+"様\n\nこの度は「"+order.getUniform_name()+"」をご購入いただき誠にありがとうございます。"
				+ "\n\n━━━━━━━━━━━━━━━━━━━━━━━━━━\n■ご注文内容\n━━━━━━━━━━━━━━━━━━━━━━━━━━\n商品名："
				+order.getUniform_name()+"\n数量："+order.getQuantity()+"点\n金額："+df.format(order.getQuantity()*order.getPrice())
				+"円（税込）\n━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n本日付けで、"+df.format(order.getQuantity()*order.getPrice())
				+"円のご入金を確認いたしました。\n誠にありがとうございます。\n\n引き続きよろしくお願いいたします。\n\n※本メールは、お買い物と同時に送信される自動返信メールです。\n"
				+ "重要な情報を含んでおりますので、お手元に商品が届くまで\n大切に保管くださいますようお願いいたします。\n\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n"
				+ "会社名：株式会社神田ユニフォーム\n氏名：白石大\n住所：▲▲▲▲▲▲▲▲\n電話番号：✖✖✖-✖✖✖✖-✖✖✖✖\nメールアドレス：■■■■@gmail.com\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━";

		SendMail sendmail = new SendMail();


		sendmail.setFromInfo("test.sender@kanda-it-school-system.com", "株式会社神田ユニフォーム");
		//テスト用メール
		sendmail.setRecipients(order.getEmail());
		sendmail.setSubject("【神田ユニフォーム】ご入金ありがとうございます。");
		sendmail.setText(mail);
		sendmail.forwardMail();

	}

	private void mail_shipping(Order order) {
		DecimalFormat df = new DecimalFormat("###,###");
		String mail = order.getUser_name()+"様\n\nこのたびは、神田ユニフォームをご利用いただきまして誠にありがとうございます。\n神田ユニフォームの白石です。\n\n下記の商品の発送が完了いたしました。"
				+ "\n\n■ご注文内容\n━━━━━━━━━━━━━━━━━━━━━━━━━━\n商品名："+order.getUniform_name()+"\n数量："+order.getQuantity()+"点\n━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n"
				+ "この度は神田ユニフォームにてご注文いただき誠にありがとうございました。\nまたのご利用を心よりお待ち申し上げております。\n\n※本メールは、お買い物と同時に送信される自動返信メールです。"
				+ "\n重要な情報を含んでおりますので、お手元に商品が届くまで\n大切に保管くださいますようお願いいたします。\n\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n"
				+ "会社名：株式会社神田ユニフォーム\n氏名：白石大\n住所：▲▲▲▲▲▲▲▲\n電話番号：✖✖✖-✖✖✖✖-✖✖✖✖\nメールアドレス：■■■■@gmail.com\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━";

		SendMail sendmail = new SendMail();

		sendmail.setFromInfo("####", "株式会社神田ユニフォーム");
		//テスト用メール
		sendmail.setRecipients(order.getEmail());
		sendmail.setSubject("【神田ユニフォーム】商品を発送いたしました。");
		sendmail.setText(mail);
		sendmail.forwardMail();


	}




	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
