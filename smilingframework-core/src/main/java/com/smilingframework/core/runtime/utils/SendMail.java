package com.smilingframework.core.runtime.utils;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


/**
 * 发送Email工具类
 * 
 * @author 余鸽
 *
 */
public class SendMail { 
	
	private String host;
	private String user;
	private String pwd;
	

	//发送邮件的邮箱：systemauto@mshasia.com,密码：mshch1na@sy
	//事先授权通知邮件的收件人：medical@mshasia.com
	/***
	 *  发送邮件
	 * @param from 发件人地址
	 * @param to 收件人地址
	 * @param subject 标题
	 * @param txt 内容 不上传附件，内容可以由html格式组成
	 * @param affix 附件路径 附件路径为空则代表不上传附件
	 * @param affixName 附件名称
	 */
	public  void send(String from, String to, String subject,String txt,String affix,String affixName) throws Exception{  
		
		//pwd="fdfdf";
		Properties props = new Properties();  
		// 设置发送邮件的邮件服务器的属性（这里使用网易的smtp服务器）  
		props.put("mail.smtp.host", host);  
		// 需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条） 
		props.put("mail.smtp.auth", "true"); 
		
		
		//props.put("mail.smtp.port","587");
		// 用刚刚设置好的props对象构建一个session  
		Session session = Session.getDefaultInstance(props);  
		// 有了这句便可以在发送邮件的过程中在console处显示过程信息，供调试使  // 用（你可以在控制台（console)上看到发送邮件的过程） 
		session.setDebug(false);  
		// 用session为参数定义消息对象 
		MimeMessage message = new MimeMessage(session);  
		try {   
			// 加载发件人地址  
			message.setFrom(new InternetAddress(from));   
			// 加载收件人地址   
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// 加载标题   
			message.setSubject(subject);  
			if(!affix.equals("")){
			// 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件  
			Multipart multipart = new MimeMultipart();   
			// 设置邮件的文本内容   
			BodyPart contentPart = new MimeBodyPart();   
			contentPart.setText(txt);   
			multipart.addBodyPart(contentPart);   
			//当附件路径不为空的时候添加附件
			//添加附件
            BodyPart messageBodyPart= new MimeBodyPart();
            DataSource source = new FileDataSource(affix);
            //添加附件的内容
            messageBodyPart.setDataHandler(new DataHandler(source));
            //添加附件的标题
            //这里很重要，通过下面的Base64编码的转换可以保证你的中文附件标题名在发送时不会变成乱码
            sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
            messageBodyPart.setFileName("=?GBK?B?"+enc.encode(affixName.getBytes())+"?=");
            multipart.addBodyPart(messageBodyPart);
            // 将multipart对象放到message中  
			message.setContent(multipart);  
			}else{
			// 设置邮件内容，将邮件body部分转化为HTML格式
			message.setContent(txt, "text/html;charset=gbk");	
			}
			// 保存邮件   
			message.saveChanges();   
			// 发送邮件   
			//Transport transport = session.getTransport("smtp");   
			Transport transport = session.getTransport("smtp");   
			// 连接服务器的邮箱   
			transport.connect(host, user, pwd);   
			// 把邮件发送出去   
			transport.sendMessage(message, message.getAllRecipients());   
			transport.close();  
			} catch (Exception e) {
				e.printStackTrace();  
			} 
	} 
	

	
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public static void main(String[] args) {  
		SendMail sm = new SendMail();
		try{
			sm.send("dfjzzzc@163.com", "392931818@qq.com", "test11111", "aaa2", "", "");
		}catch(Exception ex){
		System.out.println(ex.toString());	
		}
	}
}

