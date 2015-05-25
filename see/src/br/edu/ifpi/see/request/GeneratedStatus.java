package br.edu.ifpi.see.request;

import java.util.ArrayList;

import br.edu.ifpi.see.model.MicroControlador;
import br.edu.ifpi.see.model.Status;

public class GeneratedStatus {
	
	public Status getStatus(ArrayList<MicroControlador> microControladores){
		HttpRequest request = new HttpRequest();
		for(MicroControlador mc : microControladores){
			try {
				Response response = request.sendGet(mc.getIp());
				mc.setSensorPorta(Integer.parseInt(response.getPorta()));
				mc.setSensorPresenca(Integer.parseInt(response.getPresenca()));
				mc.setSensorLampada(Integer.parseInt(response.getLampadas()));
				mc.setSensorAr(Integer.parseInt(response.getAr()));
				
				return geraStatus(mc.getSensorPorta(), mc.getSensorPresenca(), mc.getSensorLampada(), mc.getSensorAr());
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
		}else if((lampadas == 1 || ar == 1) && (presenca == 0) && (porta == 0)){
			s.setTexto("Desperdício");
		}else if((lampadas == 1 || ar == 1) && (presenca == 1) && porta == 1){
			s.setTexto("Consumo normal");
		}else if(lampadas == 0 && ar == 0){
			s.setTexto("Consumo normal");
		}else{
			s.setTexto("Verifique!");
		}
		return s;
	}

}
