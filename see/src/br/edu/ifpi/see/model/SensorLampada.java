package br.edu.ifpi.see.model;

public class SensorLampada {
	
	private boolean ativo;
	private String valor;
	
	public SensorLampada() {
		super();
	}

	public SensorLampada(boolean ativo, String valor) {
		super();
		this.ativo = ativo;
		this.valor = valor;
	}
	
	public SensorLampada(boolean ativo) {
		super();
		this.ativo = ativo;
	}
	
	public SensorLampada(String valor) {
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
