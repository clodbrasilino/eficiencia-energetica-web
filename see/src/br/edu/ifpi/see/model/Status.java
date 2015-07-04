package br.edu.ifpi.see.model;

import java.util.Calendar;

public class Status {

	private String descricao;
	private String cor;
	private Calendar time;

	public Status() {
		super();
	}

	public Status(String descricao, String cor) {
		super();
		this.descricao = descricao;
		this.cor = cor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public Calendar getTime(){
		return time;
	}
	
	public void setTime(Calendar time){
		this.time = time;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Status other = (Status) obj;
		return other.getDescricao().equals(this.getDescricao());
	}

	@Override
	public String toString() {
		return "Status [descricao=" + descricao + ", cor=" + cor + ", time="
				+ time + "]";
	}
	
}
