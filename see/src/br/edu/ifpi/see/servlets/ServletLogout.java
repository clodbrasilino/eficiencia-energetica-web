package br.edu.ifpi.see.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletLogout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().invalidate();
		response.sendRedirect("/"+getServletContext().getInitParameter("app-name")+"/");
		
	}

}
