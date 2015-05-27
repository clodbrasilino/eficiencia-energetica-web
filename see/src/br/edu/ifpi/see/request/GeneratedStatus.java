package br.edu.ifpi.see.request;

import java.util.List;

import br.edu.ifpi.see.model.MicroControlador;
import br.edu.ifpi.see.model.Status;

public class GeneratedStatus {
	
	public Status getStatus(List<MicroControlador> microControladores){
		HttpRequest request = new HttpRequest();
		for(MicroControlador mc : microControladores){
			try {
				Response response = request.sendGet(mc.getIp());
				return geraStatus(Integer.parseInt(response.getPorta()), Integer.parseInt(response.getPresenca()), Integer.parseInt(response.getLampadas()), Integer.parseInt(response.getAr()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	// FIXME Alterar método para a estrutura de dados nova de sensores
	
	private Status geraStatus(int porta, int presenca, int lampadas, int ar){
		Status s = new Status();
		if((lampadas == 1 || ar == 1) && (presenca == 0)){
			s.setTexto("Desperdício");
			s.setCor("#ff0000");
		}else if((lampadas == 1 || ar == 1) && (presenca == 0) && (porta == 0)){
			s.setTexto("Desperdício");
			s.setCor("#ff0000");
		}else if((lampadas == 1 || ar == 1) && (presenca == 1) && porta == 1){
			s.setTexto("Consumo normal");
			s.setCor("#00ff00");
		}else if(lampadas == 0 && ar == 0){
			s.setTexto("Consumo normal");
			s.setCor("#00ff00");
		}else{
			s.setTexto("Verifique!");
			s.setCor("#ffa500");
		}
		return s;
	}

}
