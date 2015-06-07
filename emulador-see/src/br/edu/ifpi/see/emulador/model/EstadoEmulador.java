package br.edu.ifpi.see.emulador.model;

public class EstadoEmulador {

	private Estado ar;
	private Estado luz;
	private Estado porta;
	private Estado presenca;
	
	public EstadoEmulador(Estado ar, Estado luz, Estado porta,
			Estado presenca) {
		this.ar = ar;
		this.luz = luz;
		this.porta = porta;
		this.presenca = presenca;
	}
	
	@Override
	public String toString() {
		return "ar="+this.ar.getValor()
		      +"&luz="+this.luz.getValor()
		      +"&porta="+this.porta.getValor()
		      +"&presenca="+this.presenca.getValor();
	}
	
	public String getAr(){
		if(ar==Estado.LIGADO){
			return "Ligado";
		}
		if(ar==Estado.DESLIGADO){
			return "Desligado";
		}
		return "Desativado";
	}
	
	public String getLuz(){
		if(luz==Estado.LIGADO){
			return "Ligada";
		}
		if(luz==Estado.DESLIGADO){
			return "Desligada";
		}
		return "Desativado";
	}
	
	public String getPorta(){
		if(porta==Estado.LIGADO){
			return "Fechada";
		}
		if(porta==Estado.DESLIGADO){
			return "Aberta";
		}
		return "Desativado";
	}
	
	public String getPresenca(){
		if(presenca==Estado.LIGADO){
			return "Detectando";
		}
		if(presenca==Estado.DESLIGADO){
			return "Nao detectando";
		}
		return "Desativado";
	}

	public void setAr(Estado ar) {
		this.ar = ar;
	}

	public void setLuz(Estado luz) {
		this.luz = luz;
	}

	public void setPorta(Estado porta) {
		this.porta = porta;
	}

	public void setPresenca(Estado presenca) {
		this.presenca = presenca;
	}
}
