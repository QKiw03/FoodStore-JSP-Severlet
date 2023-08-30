package util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	// Email: tungletest1.email@gmail.com
		// Password: nebeekfipcstxcox
		static final String from = "nvquang180303@gmail.com";
		static final String password = "qtfpukmxkngohlkm";

		public static boolean sendEmail(String to, String tieuDe, String noiDung) {
			// Properties : được sử dụng để cấu hình các thuộc tính liên quan đến gửi email.
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
			props.put("mail.smtp.port", "587"); // TLS 587, SSL 465
			props.put("mail.smtp.auth", "true"); // Chế độ xác thực email
			props.put("mail.smtp.starttls.enable", "true"); // Mã hóa email

			// create Authenticator
			Authenticator auth = new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// TODO Auto-generated method stub
					return new PasswordAuthentication(from, password);
				}
			};

			// Phiên làm việc
			Session session = Session.getInstance(props, auth);

			// Tạo một tin nhắn
			MimeMessage msg = new MimeMessage(session);

			try {
				// Cấu hình nội dung
				msg.addHeader("Content-type", "text/HTML; charset=UTF-8");

				// Người gửi
				msg.setFrom(from);

				// Người nhận
				msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

				// Tiêu đề email
				msg.setSubject(tieuDe);

				// Quy đinh ngày gửi
				msg.setSentDate(new Date());

				// set Nội dung
				msg.setContent(noiDung, "text/HTML; charset=UTF-8");

				// Gửi email
				Transport.send(msg);
				System.out.println("Gửi email thành công");
				return true;
			} catch (Exception e) {
				System.out.println("Gặp lỗi trong quá trình gửi email");
				e.printStackTrace();
				return false;
			}
		}

		public static void main(String[] args) {
			String noiDung = "\"<!DOCTYPE html>\\r\\n\"\r\n"
					+ "						+ \"<html lang=\\\"en\\\">\\r\\n\"\r\n"
					+ "						+ \"<head>\\r\\n\"\r\n"
					+ "						+ \"    <title>XÁC NHẬN EMAIL</title>\\r\\n\"\r\n"
					+ "						+ \"    <p>Vui lòng ấn vào link bên dưới để xác nhận đăng ký</p>\\r\\n\"\r\n"
					+ "						+ \"</head>\\r\\n\"\r\n"
					+ "						+ \"<body>\\r\\n\"\r\n"
					+ "						+ \"    <img src=\\\"https://upload.wikimedia.org/wikipedia/commons/c/c6/Sign-check-icon.png\\\" width=\\\"100\\\">\\r\\n\"\r\n"
					+ "						+ \"</body>\\r\\n\"\r\n"
					+ "						+ \"</html>\"";
				Email.sendEmail("vanquang1833@gmail.com", "Đơn xác nhận đăng ký",noiDung );

		}

}
