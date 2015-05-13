package br.edu.ifpi.see.request;

public class Response {
	
	private int code;
	private String porta;
	private String presenca;
	private String ar;
	private String lampadas;
	
	public Response() {
		super();
	}

	public Response(int code, String porta, String presenca, String ar,
			String lampadas) {
		super();
		this.code = code;
		this.porta = porta;
		this.presenca = presenca;
		this.ar = ar;
		this.lampadas = lampadas;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getPorta() {
		return porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

	public String getPresenca() {
		return presenca;
	}

	public void setPresenca(String presenca) {
		this.presenca = presenca;
	}

	public String getAr() {
		return ar;
	}

	public void setAr(String ar) {
		this.ar = ar;
	}

	public String getLampadas() {
		return lampadas;
	}

	public void setLampadas(String lampadas) {
		this.lampadas = lampadas;
	}

}
