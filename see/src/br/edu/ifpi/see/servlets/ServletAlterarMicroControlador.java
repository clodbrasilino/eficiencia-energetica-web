package br.edu.ifpi.see.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpi.see.dao.MicroControladorDAO;
import br.edu.ifpi.see.model.MicroControlador;
import br.edu.ifpi.see.model.Sala;
import br.edu.ifpi.see.util.Message;

public class ServletAlterarMicroControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletAlterarMicroControlador() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id = Integer.parseInt(request.getParameter("id"));
		
		MicroControladorDAO dao = new MicroControladorDAO();
		MicroControlador mc = dao.pesquisar(id);
		
		request.getSession().setAttribute("micro", mc);
		
		response.sendRedirect("/see/JSP/gerente/alterarMicroControlador.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Sala s = (Sala) request.getSession().getAttribute("sala");
		
		MicroControladorDAO dao = new MicroControladorDAO();
		MicroControlador mc = (MicroControlador) request.getSession().getAttribute("micro");
		
		mc.setIp(request.getParameter("ip"));
		mc.setSensorAr(Boolean.parseBoolean(request.getParameter("ar")));
		mc.setSensorLampada(Boolean.parseBoolean(request.getParameter("lampadas")));
		mc.setSensorPorta(Boolean.parseBoolean(request.getParameter("porta")));
		mc.setSensorPresenca(Boolean.parseBoolean(request.getParameter("presenca")));
		
		dao.atualizar(mc);
		
		request.getSession().removeAttribute("micro");
		Message msg = new Message(request, response, "Micro Controlador atualizado com sucesso!", "/ServletAlterarSala?id=" + s.getId());
		msg.show();
		
	}

}
