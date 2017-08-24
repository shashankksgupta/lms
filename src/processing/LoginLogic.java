package processing;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employeebean.EmployeeBean;

import users.LoginDAO;

@WebServlet("/LoginLogic")
public class LoginLogic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
LoginDAO ldao;
    public LoginLogic() {
    	
        super();
       ldao=new LoginDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeBean emb=new EmployeeBean();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		emb=ldao.doLogin(username, password);
		HttpSession session=request.getSession();
		int empid=emb.getEmpid();
		System.out.println(empid);
		session.setAttribute("empid", empid);
		RequestDispatcher view = request.getRequestDispatcher("Registration.jsp");
		view.forward(request, response);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
