package br.edu.ifpi.see.model;

public class Status {

	private String texto;
	private String cor;

	public Status() {
		super();
	}

	public Status(String texto, String cor) {
		super();
		this.texto = texto;
		this.cor = cor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return "Status [texto=" + texto + ", cor=" + cor + "]";
	}

}
