package util;

import java.util.Properties;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

/**
 * @author kanda-it
 *
 */
public class SendMail {

	private static final String DEFAULT_CODE_TYPE = "iso-2022-jp";
	private final Properties props = System.getProperties();
	private MimeMessage mimeMessage = null;
	private String userid = "##@#####";
	private String password = "kandaReceiver";
	private String codeType;
	private String text = "";


	public SendMail() {
		// SMTPサーバのアドレスを指定（今回はxserverのSMTPサーバを利用）
		props.put("mail.smtp.host", "sv5215.xserver.jp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.debug", "true");

		this.codeType = DEFAULT_CODE_TYPE;

		Session session = Session.getInstance(
				props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						//メールサーバにログインするメールアドレスとパスワードを設定
						return new PasswordAuthentication(userid, password);
					}
				}
			);

		this.mimeMessage = new MimeMessage(session);

	}

	/** 送信元メールアドレスと送信者名を指定
	 * @param address 送信元メールアドレス
	 * @param sender  送信者名
	 */
	public void setFromInfo(String address, String sender) {

		try {
			mimeMessage.setFrom(new InternetAddress(address, sender,
					this.codeType));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 送信先メールアドレスを指定
	 *
	 * @param address 送信先アドレス
	 */
	public void setRecipients(String address) {

		try {
			mimeMessage.setRecipients(Message.RecipientType.TO, address);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * メールの件名を指定
	 *
	 * @param subject メール件名
	 */
	public void setSubject(String subject) {

		try {
			mimeMessage.setSubject(subject, this.codeType);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * メール本文を引数から書き出す。<br>
	 * このメソッドは2回目以降、前回入力された本文の後ろに改行されて付け加えられる。
	 *
	 * @param text メール本文
	 */
	public void setText(String text) {

		this.text += "\n" + text;

		try {
			mimeMessage.setText(this.text, this.codeType);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * メールの送信をおこなう<br>
	 * 送信が完了したらコンソール画面に送信成功のメッセージが出力され、
	 * 送信に失敗した場合は送信失敗のメッセージが出力される
	 */
	public void forwardMail() {

		try {

			// メールの形式を指定
			mimeMessage.setHeader("Content-Type", "text/plain; charset="
					+ this.codeType);

			// 送信日付を指定
			mimeMessage.setSentDate(new Date());

			// 送信します
			Transport.send(mimeMessage);

			// 送信成功
			System.out.println("送信に成功しました。");
		} catch (MessagingException e) {
			// 送信失敗
			e.printStackTrace();
			System.out.println("送信に失敗しました。");
		}
	}
}
