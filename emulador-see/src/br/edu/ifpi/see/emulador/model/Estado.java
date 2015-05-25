package br.edu.ifpi.see.emulador.model;

public enum Estado {
	LIGADO(1),
	DESLIGADO(0),
	DESATIVADO(-1);
	
	private Integer valor;

	private Estado(Integer valor){
		this.valor = valor;
	}
	
	public Integer getValor(){
		return this.valor;
	}

}
