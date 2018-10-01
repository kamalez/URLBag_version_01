package servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Servlet2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String rpwd = "";
		
		DBUtil db = new DBUtil();
		db.getConnection();
		db.insertData(name, pwd, rpwd);
		RequestDispatcher rd = request.getRequestDispatcher("storage.jsp");
		request.setAttribute("DATA", rpwd);
		request.setAttribute("NAME", name);
		request.setAttribute("PWD", pwd);
		rd.forward(request, response);
		
	}

}
