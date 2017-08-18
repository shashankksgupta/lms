package processing;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.controller.DBConnection;

import users.UserDAO;

@WebServlet("/FilterEmp")
public class SmtpEmail extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
Connection con=null;
Statement stmt=null;
ResultSet rs=null;
UserDAO dao;
String column;
	public SmtpEmail() {
		super();
		con = DBConnection.getConnection();
		dao=new UserDAO();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
String to = "lms.atidanmumbai@gmail.com";
String from = "lms.atidanmumbai@gmail.com";
String host = "smtp.gmail.com";
String user="lms.atidanmumbai@gmail.com";
String pass="Atidan@123";
String sub="Test Mail";
String msg="Body here";
Properties props = System.getProperties();
props.setProperty("mail.smtp.host", host);

props.put("mail.smtp.port", "587");		
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable", "true");

Authenticator auth = new Authenticator() {
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, pass);
    }
};

Session session = Session.getInstance(props,auth);
try {
	MimeMessage message = new MimeMessage(session);
	message.setFrom(new InternetAddress(from));
	message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
	message.setSubject(sub);
	message.setText(msg);
	Transport.send(message);
} catch (MessagingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}




		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String sql="select email from lms.applicationmaster innerjoin lms.employeemaster on lms.applicationmaster.aid=lms.employeemaster.eid where ";
		
	}

}
