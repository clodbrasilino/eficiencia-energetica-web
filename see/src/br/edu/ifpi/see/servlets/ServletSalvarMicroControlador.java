package br.edu.ifpi.see.servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpi.see.model.MicroControlador;
import br.edu.ifpi.see.model.Sala;
import br.edu.ifpi.see.request.HttpRequest;
import br.edu.ifpi.see.request.Response;
import br.edu.ifpi.see.util.Message;

public class ServletSalvarMicroControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletSalvarMicroControlador() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String ip = request.getParameter("ip");
		String porta = request.getParameter("porta");
		String presenca = request.getParameter("presenca");
		String lampadas = request.getParameter("lampadas");
		String ar = request.getParameter("ar");
		
		Sala s = (Sala) request.getSession().getAttribute("sala");
		
		Calendar data = Calendar.getInstance();
		data.setTime(new Date(System.currentTimeMillis()));
		
		HttpRequest r = new HttpRequest();
		MicroControlador mc = new MicroControlador();
		mc.setDtInstalacao(data);
		mc.setIp(ip);
		mc.setSensorPorta(Boolean.parseBoolean(porta));
		mc.setSensorPresenca(Boolean.parseBoolean(presenca));
		mc.setSensorLampada(Boolean.parseBoolean(lampadas));
		mc.setSensorAr(Boolean.parseBoolean(ar));
		
		try {
			Response resp = r.sendGet(mc);
			int code = resp.getCode();
			if(code != 0){
				if(s.getListaMicroControlador() == null) s.setListaMicroControlador(new LinkedList<MicroControlador>());
				s.getListaMicroControlador().add(mc);
				response.sendRedirect("/"+ getServletContext().getInitParameter("app-name")+ "/JSP/gerente/novaSala.jsp");
			}
		} catch (Exception e) {
			Message msg = new Message(request, response, "O Micro Controlador informado n�o foi encontrado!", "/JSP/gerente/novoMicroControlador.jsp");
			msg.show();
		}
		
	}

}
