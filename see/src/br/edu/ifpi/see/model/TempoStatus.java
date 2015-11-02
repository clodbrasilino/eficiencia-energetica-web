package br.edu.ifpi.see.model;

import java.util.Calendar;
import java.util.Date;

public class TempoStatus {
	
	private String descicao;
	private double hora;
	private double tempo;
	
	public TempoStatus(String descricao, double tempo){
		this.descicao = descricao;
		this.tempo = tempo;
	}
	
	public String getDescicao() {
		return descicao;
	}
	
	public void setDescicao(String descicao) {
		this.descicao = descicao;
	}
	
	public double getHora() {
		return hora;
	}
	
	public void setHora(long hora) {
		this.tempo = this.tempo + (hora - this.hora);
		this.hora = hora;
	}
	
	public double getTempoMilisegundos() {
		return tempo;
	}
	
	public double getTempoSegundos() {
		return tempo / 1000.00;
	}
	
	public double getTempoMinutos() {
		return tempo / 1000.00 / 60.00;
	}
	
	public double getTempoHoras() {
		return tempo / 1000.00 / 3600;
	}
	
	public void setTempo(double tempo) {
		this.tempo = tempo;
	}
	
	public void analizaTempo(){
		if(this.tempo == 0){
			double horaAntiga = this.hora;
			
			Calendar hora = Calendar.getInstance();
			hora.setTime(new Date(System.currentTimeMillis()));
			
			this.setHora(hora.getTimeInMillis());
			this.hora = horaAntiga;
		}
	}

}
