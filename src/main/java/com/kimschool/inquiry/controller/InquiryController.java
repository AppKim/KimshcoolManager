package com.kimschool.inquiry.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

	static Logger logger = Logger.getLogger("InquiryController.class");

	@RequestMapping("/index")
	public String showInquiryForm() {
        logger.info("InquiryController showInquiryForm()");
		return "WEB-INF/views/inquiry/KSC1070";
	}

	@RequestMapping("/test")
	public String testInquiry(
		Model model,
		@RequestParam String category,
		@RequestParam String name_kanji,
		@RequestParam String name_hurigana,
		@RequestParam String email,
		@RequestParam String content ) {

		logger.info("InquiryController testInquiry()");

		final String user = "testInquiry123@gmail.com";
		final String password = "kimschool";
		final String contents = "カテゴリー：" + category + "\n"
				+ "お名前：" + name_kanji + "\n"
				+ "お名前(フリガナ)：" + name_hurigana + "\n"
				+ "メールアドレス：" + email + "\n"
				+ "お問い合わせ内容：" + content;

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));

            // Receiver Mail Address
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(user));

            // Subject
            message.setSubject(name_kanji + "さんからのお問い合わせです。");

            // Text
            message.setText(contents);

            // send the message
//            Transport.send(message);

        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

		return "WEB-INF/views/inquiry/KSC1070";
	}
}
