package servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String rpwd = request.getParameter("adding1");
		String rpwd1 = request.getParameter("adding2");
		rpwd="<tr><td> <a href=\"http://"+rpwd+"\" > "+rpwd+" </a> </td> <td>"+rpwd1+"</td></tr>";
		System.out.println(rpwd);
		String name= (String) request.getParameter("name");
		String pwd= (String) request.getParameter("pwd");
		DBUtil db = new DBUtil();
		db.getConnection();
		try {
			
			db.changeData(name,pwd,rpwd);
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("storage.jsp");
		
			try {
				rpwd = db.getrpwd(name);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			request.setAttribute("DATA", rpwd);
			request.setAttribute("NAME", name);
			request.setAttribute("PWD", pwd);
			rd.forward(request, response);
		
		
} }
