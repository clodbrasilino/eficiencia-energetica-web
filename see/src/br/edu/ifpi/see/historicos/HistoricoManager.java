package br.edu.ifpi.see.historicos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import br.edu.ifpi.see.dao.HistoricoSalaDAO;
import br.edu.ifpi.see.model.HistoricoSala;
import br.edu.ifpi.see.model.Sala;
import br.edu.ifpi.see.model.TempoStatus;

public class HistoricoManager {
	
	private List<Sala> salas;
	private List<HistoricoSala> historicos;
	private HistoricoSalaDAO dao;
	
	public HistoricoManager(List<Sala> salas){
		this.salas = salas;
		this.dao = new HistoricoSalaDAO();
	}
	
	public void createHistorico(Calendar data){
		for(Sala s : this.salas){
			s.setListaHistorico(dao.pesquisar(s, data));
			s.setTempoStatus(this.createHistoricoConsumoAtual(s));
		}
	}
	
	public void createHistorico(Calendar dataInicial, Calendar dataFinal){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dtInicial = sdf.format(dataInicial.getTime());
		String dtFinal = sdf.format(dataFinal.getTime());
		
		if(dtInicial.equals(this.createDataAtual()) && dtFinal.equals(this.createDataAtual())){
			this.createHistorico(dataInicial);
		}else{
			for(Sala s : this.salas){
				s.setListaHistorico(dao.pesquisar(s, dataInicial, dataFinal));
				s.setTempoStatus(this.createHistoricoConsumoPorData(s, dataInicial, dataFinal));
			}
		}
		
	}
	
	private HashMap<String, TempoStatus> createHistoricoConsumoAtual(Sala sala){
		this.historicos = sala.getListaHistorico();
		
		HistoricoSala historicoAtual = null;
		HistoricoSala historicoFinal = null;
		long tempo = 0;
		List<TempoStatus> tempoStatus = new ArrayList<TempoStatus>();
		
		if(this.historicos.size() == 1){
			historicoAtual = this.historicos.get(0);
			tempo = System.currentTimeMillis() - historicoAtual.getHora().getTimeInMillis();
			tempoStatus.add(new TempoStatus(historicoAtual.getStatus(), tempo));
		}else if(this.historicos.size() > 1){
			for(int i=0; i<this.historicos.size()-1; i++){
				historicoAtual = this.historicos.get(i);
				historicoFinal = this.historicos.get(i+1);
				tempo = historicoFinal.getHora().getTimeInMillis() - historicoAtual.getHora().getTimeInMillis();
				tempoStatus.add(new TempoStatus(historicoAtual.getStatus(), tempo));
			}
			historicoAtual = this.historicos.get(this.historicos.size()-1);
			tempo = System.currentTimeMillis() - historicoAtual.getHora().getTimeInMillis();
			tempoStatus.add(new TempoStatus(historicoAtual.getStatus(), tempo));
		}
		
		HashMap<String, TempoStatus> times = new HashMap<String, TempoStatus>();
		for(TempoStatus ts : tempoStatus){
			if(times.containsKey(ts.getDescicao())){
				TempoStatus tempoStatusAtual = times.get(ts.getDescicao());
				tempoStatusAtual.setTempo(tempoStatusAtual.getTempoMilisegundos() + ts.getTempoMilisegundos());
				times.put(ts.getDescicao(), tempoStatusAtual);
			}else{
				times.put(ts.getDescicao(), new TempoStatus(ts.getDescicao(), ts.getTempoMilisegundos()));
			}
		}
		
		return times;
	}
	
	private HashMap<String, TempoStatus> createHistoricoConsumoPorData(Sala sala, Calendar dataInicial, Calendar dataFinal){
		this.historicos = sala.getListaHistorico();
		
		HistoricoSala historicoAtual = null;
		HistoricoSala historicoFinal = null;
		long tempo = 0;
		List<TempoStatus> tempoStatus = new ArrayList<TempoStatus>();
		
		if(this.historicos.size() == 1){
			historicoAtual = this.historicos.get(0);
			dataFinal.set(Calendar.HOUR_OF_DAY, 23);
			dataFinal.set(Calendar.MINUTE, 59);
			dataFinal.set(Calendar.SECOND, 59);
			tempo = dataFinal.getTimeInMillis() - historicoAtual.getHora().getTimeInMillis();
			tempoStatus.add(new TempoStatus(historicoAtual.getStatus(), tempo));
		}else if(this.historicos.size() > 1){
			for(int i=0; i<this.historicos.size()-1; i++){
				historicoAtual = this.historicos.get(i);
				historicoFinal = this.historicos.get(i+1);
				tempo = historicoFinal.getHora().getTimeInMillis() - historicoAtual.getHora().getTimeInMillis();
				tempoStatus.add(new TempoStatus(historicoAtual.getStatus(), tempo));
			}
			historicoAtual = this.historicos.get(this.historicos.size()-1);
			dataFinal.set(Calendar.HOUR_OF_DAY, 23);
			dataFinal.set(Calendar.MINUTE, 59);
			dataFinal.set(Calendar.SECOND, 59);
			tempo = dataFinal.getTimeInMillis() - historicoAtual.getHora().getTimeInMillis();
			tempoStatus.add(new TempoStatus(historicoAtual.getStatus(), tempo));
		}
		
		HashMap<String, TempoStatus> times = new HashMap<String, TempoStatus>();
		for(TempoStatus ts : tempoStatus){
			if(times.containsKey(ts.getDescicao())){
				TempoStatus tempoStatusAtual = times.get(ts.getDescicao());
				tempoStatusAtual.setTempo(tempoStatusAtual.getTempoMilisegundos() + ts.getTempoMilisegundos());
				times.put(ts.getDescicao(), tempoStatusAtual);
			}else{
				times.put(ts.getDescicao(), new TempoStatus(ts.getDescicao(), ts.getTempoMilisegundos()));
			}
		}
		
		return times;
	}
	
	private String createDataAtual(){
		Calendar dataAtual = Calendar.getInstance();
		dataAtual.setTime(new Date());
		return new SimpleDateFormat("dd/MM/yyyy").format(dataAtual.getTime());
	}
}
