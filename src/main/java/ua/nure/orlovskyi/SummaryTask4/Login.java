package ua.nure.orlovskyi.SummaryTask4;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.orlovskyi.SummaryTask4.service.LoginService;
import ua.nure.orlovskyi.SummaryTask4.service.SessionService;

/**
 * Servlet implementation class Login
 */
@WebServlet(name = "Login", urlPatterns = { "/Login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(SessionService.validateSession(request, response))
        {
             RequestDispatcher dispatcher = request.getRequestDispatcher("home-page.jsp");
             dispatcher.forward(request, response);
        }
        else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(login);
        System.out.println(password);
        HttpSession session;

        if(LoginService.validateLogin(login, password))
        {
            session = request.getSession();
            session.setAttribute("username", login);
            response.sendRedirect("HomePage");
            System.out.println("Login redirect to HomePage ");
        }
        else
        {
           response.sendRedirect("Login");
        }
    }
	}


