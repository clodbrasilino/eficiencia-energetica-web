package br.edu.ifpi.see.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Control
 */
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Control() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setStatus(200);
		response.setContentType("text/plain");
		//out.println("Valor dos Sensores<br>");
		Double random = Math.random();
		if(random>0.9) out.println("porta=1&presenca=1&lampada=1&ar=1");
		else if(random>0.8) out.println("porta=0&presenca=1&lampada=1&ar=1");
		else if(random>0.7) out.println("porta=0&presenca=0&lampada=1&ar=1");
		else if(random>0.6) out.println("porta=0&presenca=0&lampada=0&ar=1");
		else if(random>0.5) out.println("porta=1&presenca=1&lampada=0&ar=0");
		else if(random>0.4) out.println("porta=1&presenca=0&lampada=1&ar=0");
		else if(random>0.3) out.println("porta=0&presenca=1&lampada=0&ar=1");
		else if(random>0.2) out.println("porta=1&presenca=1&lampada=0&ar=1");
		else if(random>0.1) out.println("porta=1&presenca=0&lampada=1&ar=1");
		else           out.println("porta=0&presenca=0&lampada=0&ar=0");
	}

}
