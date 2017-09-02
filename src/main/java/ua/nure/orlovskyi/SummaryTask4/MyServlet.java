package ua.nure.orlovskyi.SummaryTask4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/test")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private Logger log = Logger.getLogger(MyServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        log.debug("IN CONSTRUCtor");
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("GET");
		 String url = "jdbc:mysql://localhost/practice8?useSSL=false";
		 String user = "practice8";
		 String password = "123456";
	
		String result="";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IllegalAccessException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		


			try {
				Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = st.executeQuery("select name from menu where id_menu = 1;");
				
			if (rs.next()) {
				result = rs.getString(1);
			}
			}
				catch (Exception e) {
					System.err.println(e);
				}
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
	        rd.forward(request, response);  
			 //request.getRequestDispathcer("login.jsp").forward(request, response);
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<body>");
//		out.println("<h1>"+result+"</h1>");
//		out.println("</body>");
//		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
