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
		/* Código anterior
		 * if((lampadas == 1 || ar == 1) && (presenca == 0)){
			s.setTexto("Desperdício");
			s.setCor("#ff0000");
		}else if((lampadas == 1 || ar == 1) && (presenca == 0) && (porta == 0)){
			s.setTexto("Desperdício");
			s.setCor("#ff0000");
		}else if(presenca == 0 && lampadas == 0 && ar == 0){
			s.setTexto("Sala livre");
			s.setCor("#00ff00");
		}else if(lampadas == 0 && ar == 0){
			s.setTexto("Sem consumo");
			s.setCor("#00ff00");
		}else if((lampadas == 1 || ar == 1) && (presenca == 1) && porta == 1){
			s.setTexto("Consumo normal");
			s.setCor("#00ff00");
		}else if(lampadas == 0 && ar == 0){
			s.setTexto("Consumo normal");
			s.setCor("#00ff00");
		}else{
			s.setTexto("Verifique!");
			s.setCor("#ffa500");
		}*/
		
		// Código atual
		if(lampadas == 0 && ar == 0){
			if(presenca == 0 && lampadas == 0 && ar == 0){
				// Sala livre
				s.setTexto("Sala livre");
				s.setCor("#00ff00");
			}else{
				// Sem consumo
				s.setTexto("Sem consumo");
				s.setCor("#00ff00");
			}
		}else{
			if((lampadas == -1 && ar == -1) || (lampadas == -1 && ar == 0) || (lampadas == 0 && ar == -1)){
				// Verifique
				s.setTexto("Verifique!");
				s.setCor("#ffa500");
			}else{
				if(presenca == 0){
					// Desperdício
					s.setTexto("Desperdício");
					s.setCor("#ff0000");
				}else if((porta == 0 && presenca == -1 && ar == 1) && (lampadas == -1 || lampadas == 0 || lampadas == 1)){
					// Desperdício
					s.setTexto("Desperdício");
					s.setCor("#ff0000");
				}else if((porta == 0 && presenca == 1 && ar == 1) && (lampadas == -1 || lampadas == 0 || lampadas == 1)){
					// Desperdício
					s.setTexto("Desperdício");
					s.setCor("#ff0000");
				}else if(porta == 1 && presenca == 1){
					// Normal
					s.setTexto("Consumo normal");
					s.setCor("#00ff00");
				}else if((presenca == 1 && lampadas == 1 && ar == 0) && (porta == -1 || porta == 0)){
					// Normal
					s.setTexto("Consumo normal");
					s.setCor("#00ff00");
				}else{
					// Verifique
					s.setTexto("Verifique!");
					s.setCor("#ffa500");
				}
			}
		}
		return s;
	}

}
