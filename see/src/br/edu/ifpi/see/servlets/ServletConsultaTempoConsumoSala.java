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
import br.edu.ifpi.see.dao.SalaDAO;
import br.edu.ifpi.see.historicos.HistoricoManager;
import br.edu.ifpi.see.model.HistoricoSala;
import br.edu.ifpi.see.model.Sala;

public class ServletConsultaTempoConsumoSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletConsultaTempoConsumoSala() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dataInicialTexto = request.getParameter("dataInicial");
		String dataFinalTexto = request.getParameter("dataFinal");
		
		SalaDAO salaDao = new SalaDAO();
		HistoricoSalaDAO historicosDao = new HistoricoSalaDAO();
		
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
			
			List<Sala> salas = (List<Sala>) salaDao.pesquisar("select s from Sala s");
			
			DateFormat hf = new SimpleDateFormat("HH:mm:ss");
			
			/*for(Sala s : salas){
				s.setListaHistorico(historicosDao.pesquisar(s, dataInicial, dataFinal));
				s.carregaStatusTempo(dataInicial, dataFinal);
				
				for(HistoricoSala hs : s.getListaHistorico()){
					System.out.println(hs.getSala().getNumero() + " - " + hf.format(hs.getHora().getTime()) + " - " + s.getStatus().getDescricao());
				}
			}*/
			
			HistoricoManager hm = new HistoricoManager(salas);
			hm.createHistorico(dataInicial, dataFinal);
			
			request.setAttribute("dataInicial", df.format(dataInicial.getTime()));
			request.setAttribute("dataFinal", df.format(dataFinal.getTime()));
			request.setAttribute("salas", salas);
			request.getRequestDispatcher("/JSP/gerente/tempoConsumo.jsp").forward(request, response);
			
		}
		
	}

}
