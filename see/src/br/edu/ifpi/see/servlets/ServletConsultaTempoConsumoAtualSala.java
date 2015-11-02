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
import br.edu.ifpi.see.dao.SalaDAO;
import br.edu.ifpi.see.historicos.HistoricoManager;
import br.edu.ifpi.see.model.Sala;

public class ServletConsultaTempoConsumoAtualSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletConsultaTempoConsumoAtualSala() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SalaDAO salaDao = new SalaDAO();
		
		Calendar data = Calendar.getInstance();
		data.setTime(new Date(System.currentTimeMillis()));
		
		List<Sala> salas = (List<Sala>) salaDao.pesquisar("select s from Sala s");
		
		HistoricoManager hm = new HistoricoManager(salas);
		hm.createHistorico(data);
		
		DateFormat df = new SimpleDateFormat("EEEE',' dd 'de' MMMM 'de' yyyy',' HH:mm:ss");
		
		request.setAttribute("data", df.format(data.getTime()));
		request.setAttribute("salas", salas);
		request.getRequestDispatcher("/JSP/gerente/tempoConsumo.jsp").forward(request, response);
		
	}

}
