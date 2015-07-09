package br.edu.ifpi.see.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
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

public class ServletConsultaHistoricoSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletConsultaHistoricoSala() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dataInicialTexto = request.getParameter("dataInicial");
		String dataFinalTexto = request.getParameter("dataFinal");
		
		HistoricoSalaDAO dao = new HistoricoSalaDAO();
		
		List<HistoricoSala> historicos = null;
		
		if(dataInicialTexto != null && dataFinalTexto != null){
			
			Calendar dataInicial = null;
			Calendar dataFinal = null;
			
			try {
				Date dtInicial = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicialTexto);
				dataInicial = Calendar.getInstance();
				dataInicial.setTime(dtInicial);
				
				Date dtFinal = new SimpleDateFormat("dd/MM/yyyy").parse(dataFinalTexto);
				dataFinal = Calendar.getInstance();
				dataFinal.setTime(dtFinal);
				
				System.out.println("Data Inicial: " + dataInicial);
				System.out.println("Data Final: " + dataFinal);
				
			} catch(ParseException e){
				return;
			}
			
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			
			request.setAttribute("dataInicial", df.format(dataInicial.getTime()));
			request.setAttribute("dataFinal", df.format(dataFinal.getTime()));
			historicos = dao.pesquisar(dataInicial, dataFinal);
			
		}
		
		request.setAttribute("historicos", historicos);
		request.getRequestDispatcher("/JSP/gerente/historicoConsumo.jsp").forward(request, response);

	}

}
