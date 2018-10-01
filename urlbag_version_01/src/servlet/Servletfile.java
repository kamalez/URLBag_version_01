package servlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servletfile")
public class Servletfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Servletfile() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		DBUtil db = new DBUtil();
		db.getConnection();
		RequestDispatcher rd = request.getRequestDispatcher("storage.jsp");
		if(db.fetchData(name, pwd)){
			String rpwd = null;
			try {
				rpwd = db.getrpwd(name);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			request.setAttribute("DATA", rpwd);
			request.setAttribute("NAME", name);
			request.setAttribute("PWD", pwd);
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rf = request.getRequestDispatcher("Login.html");
			rf.forward(request, response);
		}
	}
}