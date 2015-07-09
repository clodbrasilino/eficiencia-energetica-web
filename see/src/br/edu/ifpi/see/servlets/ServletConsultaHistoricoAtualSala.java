package br.edu.ifpi.see.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpi.see.dao.HistoricoSalaDAO;
import br.edu.ifpi.see.model.HistoricoSala;

public class ServletConsultaHistoricoAtualSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletConsultaHistoricoAtualSala() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HistoricoSalaDAO dao = new HistoricoSalaDAO();
		
		Calendar data = Calendar.getInstance();
		data.setTime(new Date(System.currentTimeMillis()));
		
		List<HistoricoSala> historicos = dao.pesquisar(data);
		
		DateFormat df = new SimpleDateFormat("EEEE',' dd 'de' MMMM 'de' yyyy");
		
		request.setAttribute("data", df.format(data.getTime()));
		request.setAttribute("historicos", historicos);
		request.getRequestDispatcher("/JSP/gerente/historicoConsumo.jsp").forward(request, response);
		
	}

}
