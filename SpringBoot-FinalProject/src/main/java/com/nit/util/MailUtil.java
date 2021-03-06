package com.nit.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.nit.constants.AppConstants;
import com.nit.entity.EmployeeEntity;

@Component
public class MailUtil {
	private Logger logger =LoggerFactory.getLogger(MailUtil.class);
	@Autowired
	private JavaMailSender mailSender;

	public boolean sendPasswordToEmail(EmployeeEntity emp) {
		logger.debug(AppConstants.METHOD_START);
		MimeMessage mimeMsg = null;
		MimeMessageHelper helper=null; 
		try {
			// create message and set properties
			mimeMsg = mailSender.createMimeMessage();
			helper=new MimeMessageHelper(mimeMsg);
			helper.setTo(emp.getEmail());
			helper.setSubject(AppConstants.FORGOT_PWD_MAIL_SUB);
			helper.setText(mailBodyForPwd(emp),true);
			mailSender.send(mimeMsg);
			logger.info(AppConstants.MAIL_SENT);
			logger.debug(AppConstants.METHOD_ENDED);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean sendEmail(EmployeeEntity emp) {
		logger.debug(AppConstants.METHOD_START);
		MimeMessage mimeMsg = null;
		MimeMessageHelper helper=null; 
		try {
			// create message and set properties
			mimeMsg = mailSender.createMimeMessage();
			helper=new MimeMessageHelper(mimeMsg);
			helper.setTo(emp.getEmail());
			helper.setSubject(AppConstants.MAIL_SUB);
			helper.setText(mailBody(emp),true);
			mailSender.send(mimeMsg);
			logger.info(AppConstants.MAIL_SENT);
			logger.debug(AppConstants.METHOD_ENDED);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private String mailBodyForPwd(EmployeeEntity entity) throws Exception {
		logger.debug(AppConstants.METHOD_START);
		Reader fileReader = null;
		BufferedReader br = null;
		String mailBody = new String();
		StringBuilder builder = null;
		try {
			// Create builder
			builder = new StringBuilder();
			// get Reader
			fileReader = new FileReader(new File(this.getClass().getClassLoader().getResource(AppConstants.FORGOT_PWD_MAIL_BODY_TEMPLETE).getFile()));
			logger.info(AppConstants.MAIL_BODY_TEMPLETE_LOADED);
			br = new BufferedReader(fileReader);
			mailBody = br.readLine();
			while (mailBody != null) {
				builder.append(mailBody);
				mailBody = br.readLine();
			}
			// convert builder to string
			mailBody = builder.toString()
								.replace("{FNAME}", entity.getFirstName())
								.replace("{LNAME}", entity.getLastName())
								.replace("{USER_MAIL}", entity.getEmail())
								.replace("{PWD}", entity.getPassword());
			logger.info(AppConstants.MAIL_BODY_READY);
		} finally {
			// close stream
			if (br != null)
				br.close();
		}
		logger.debug(AppConstants.METHOD_ENDED);
		return mailBody;
	}
	
	
	private String mailBody(EmployeeEntity entity) throws Exception {
		logger.debug(AppConstants.METHOD_START);
		Reader fileReader = null;
		BufferedReader br = null;
		String mailBody = new String();
		StringBuilder builder = null;
		try {
			// Create builder
			builder = new StringBuilder();
			// get Reader
			fileReader = new FileReader(new File(this.getClass().getClassLoader().getResource(AppConstants.MAIL_BODY_TEMPLETE).getFile()));
			logger.info(AppConstants.MAIL_BODY_TEMPLETE_LOADED);
			br = new BufferedReader(fileReader);
			mailBody = br.readLine();
			while (mailBody != null) {
				builder.append(mailBody);
				mailBody = br.readLine();
			}
			// convert builder to string
			mailBody = builder.toString()
								.replace("{FNAME}", entity.getFirstName())
								.replace("{LNAME}", entity.getLastName())
								.replace("{USER_MAIL}", entity.getEmail())
								.replace("{TMP_PWD}", entity.getPassword());
			logger.info(AppConstants.MAIL_BODY_READY);
		} finally {
			// close stream
			if (br != null)
				br.close();
		}
		logger.debug(AppConstants.METHOD_ENDED);
		return mailBody;
	}
}
