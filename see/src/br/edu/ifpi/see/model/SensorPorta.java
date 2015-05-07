package br.edu.ifpi.see.model;

public class SensorPorta {
	
	private boolean ativo;
	private String valor;
	
	public SensorPorta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SensorPorta(boolean ativo, String valor) {
		super();
		this.ativo = ativo;
		this.valor = valor;
	}
	
	public SensorPorta(boolean ativo) {
		super();
		this.ativo = ativo;
	}
	
	public SensorPorta(String valor) {
		super();
		this.valor = valor;
	}

	public boolean isAtivo() {
		return ativo;
	}
	
	public String getAtivo(){
		if(this.ativo){
			return "Sim";
		}else{
			return "Não";
		}
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "SensorPorta [ativo=" + ativo + ", valor=" + valor + "]";
	}

}
