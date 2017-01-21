package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.SignUpService;
import services.SignUpServiceImpl;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SignUpService signUpService;
	private static final String INDEX="index";
	private static final String SIGNUP="SignUp";
	private static final String GOSIGNUP="GOSignUp";
	private static final String SIGNIN="SignIN";
	private static final String SAVEUSER="SaveUser";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
	 signUpService= new SignUpServiceImpl();
	 
				
	}
	
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = request.getRequestURL().substring(31);
		
		switch(page){
		
		case INDEX :
			this.getServletContext().getRequestDispatcher("/Index.jsp").forward(request, response);
			break;
			
		case SIGNUP: 
			this.getServletContext().getRequestDispatcher("/SignUp.jsp").forward(request, response);
			break;
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		
		switch(action){
		
		case SIGNIN:
			signUpService.signIn(request);
			this.getServletContext().getRequestDispatcher("/ManageSubmission.jsp").forward(request, response);
			break;
			
		case SAVEUSER:
			signUpService.SaveUser(request); 
			this.getServletContext().getRequestDispatcher("/SignUp.jsp").forward(request, response);
			break;
		case GOSIGNUP:
			this.getServletContext().getRequestDispatcher("/SignUp.jsp").forward(request, response);
			break;
		}
		
		
		
	}

}
