package br.edu.ifpi.see.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Message {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String mensagem;
	private String page;
	
	public Message(HttpServletRequest request, HttpServletResponse response, String mensagem, String page){
		this.request = request;
		this.response = response;
		this.mensagem = mensagem;
		this.page = page;
	}
	
	public void show(){
		response.setContentType("text/html");
		try {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('"+mensagem+"')");
			out.println("window.location.href='/"+request.getServletContext().getInitParameter("app-name")+page+"'");
			out.println("</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
