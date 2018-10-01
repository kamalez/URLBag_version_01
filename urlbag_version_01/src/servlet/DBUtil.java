package servlet;
import java.sql.*;
public class DBUtil {
	static Connection con=null;
	public Connection getConnection(){
		if(con==null){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/web_student_tracker","root","root");
				System.out.println("Connection created");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return con;
	}
	public boolean insertData(String name,String pwd,String rpwd){
		try{
			Statement s = con.createStatement();
			s.executeUpdate("insert into data1 values('"+name+"','"+pwd+"','"+rpwd+"')");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	public boolean fetchData(String name,String tpwd){
		int res=0;
		try{
			Statement s = con.createStatement();
			ResultSet ss= s.executeQuery("select pwd from data1 where name ='"+name+"'");
			while(ss.next()){
				String sa = ss.getString("pwd");
				if(sa.equals(tpwd)){
					res = 1;
				}
				else{
					res =0;
				}
			}			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		if(res ==1){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String getrpwd(String name) throws Exception
	{
		Statement s= con.createStatement();
		ResultSet ans=s.executeQuery("Select rpwd from data1 where name='"+name+"'");
		String res = null;
		while(ans.next()) {
			 res = ans.getString("rpwd");
			
		}
		return res;
	}
	public void changeData(String name,String pwd, String rpwd)  throws Exception {
		
		Statement s= con.createStatement();
		ResultSet ans=s.executeQuery("Select rpwd from data1 where name='"+name+"'");
		String res = null;
		while(ans.next()) {
			 res = ans.getString("rpwd");
			
		}
		System.out.println(res);
		
		rpwd=res+" "+rpwd;
		Statement s1= con.createStatement();
		s1.executeUpdate("update data1 set rpwd='"+rpwd+"' where name='"+name+"'");
	}
}
