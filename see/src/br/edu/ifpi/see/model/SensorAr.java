package br.edu.ifpi.see.model;

public class SensorAr {
	
	private boolean ativo;
	private String valor;
	
	public SensorAr() {
		super();
	}

	public SensorAr(boolean ativo, String valor) {
		super();
		this.ativo = ativo;
		this.valor = valor;
	}

	public SensorAr(boolean ativo) {
		super();
		this.ativo = ativo;
	}

	public SensorAr(String valor) {
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
		return "SensorAr [ativo=" + ativo + ", valor=" + valor + "]";
	}
	
}
