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
		
		/*if(porta.equals("porta=1") & presenca.equals("presenca=1") & lampadas.equals("lampada=1") & ar.equals("ar=1")){
			s.setTexto("Sala em utilização");
			s.setCor("#ffd700");
		}else if(porta.equals("porta=1") & presenca.equals("presenca=1") & lampadas.equals("lampada=1") & ar.equals("ar=0")){
			s.setTexto("Sala em utilização");
			s.setCor("#ffd700");
		}else if(porta.equals("porta=1") & presenca.equals("presenca=1") & lampadas.equals("lampada=0") & ar.equals("ar=1")){
			s.setTexto("Sala em utilização");
			s.setCor("#ffd700");
		}else if(porta.equals("porta=1") & presenca.equals("presenca=1") & lampadas.equals("lampada=0") & ar.equals("ar=0")){
			s.setTexto("Sala em utilização");
			s.setCor("#ffd700");
		}else if(porta.equals("porta=1") & presenca.equals("presenca=0") & lampadas.equals("lampada=1") & ar.equals("ar=1")){
			s.setTexto("Sala com desperdício de energia");
			s.setCor("#ff4500");
		}else if(porta.equals("porta=1") & presenca.equals("presenca=0") & lampadas.equals("lampada=1") & ar.equals("ar=0")){
			s.setTexto("Sala com desperdício de energia");
			s.setCor("#ff4500");
		}else if(porta.equals("porta=1") & presenca.equals("presenca=0") & lampadas.equals("lampada=0") & ar.equals("ar=1")){
			s.setTexto("Sala com desperdício de energia");
			s.setCor("#ff4500");
		}else if(porta.equals("porta=1") & presenca.equals("presenca=0") & lampadas.equals("lampada=0") & ar.equals("ar=0")){
			s.setTexto("Sala livre");
			s.setCor("#006400");
		}else if(porta.equals("porta=0") & presenca.equals("presenca=1") & lampadas.equals("lampada=1") & ar.equals("ar=1")){
			s.setTexto("Sala com desperdício excessivo de energia");
			s.setCor("#ff0000");
		}else if(porta.equals("porta=0") & presenca.equals("presenca=1") & lampadas.equals("lampada=1") & ar.equals("ar=0")){
			s.setTexto("Sala com desperdício de energia");
			s.setCor("#ff4500");
		}else if(porta.equals("porta=0") & presenca.equals("presenca=1") & lampadas.equals("lampada=0") & ar.equals("ar=1")){
			s.setTexto("Sala com desperdício de energia");
			s.setCor("#ff4500");
		}else if(porta.equals("porta=0") & presenca.equals("presenca=1") & lampadas.equals("lampada=0") & ar.equals("ar=0")){
			s.setTexto("Sala em utilização");
			s.setCor("#ffd700");
		}else if(porta.equals("porta=0") & presenca.equals("presenca=0") & lampadas.equals("lampada=1") & ar.equals("ar=1")){
			s.setTexto("Sala com desperdício excessivo de energia");
			s.setCor("#ff0000");
		}else if(porta.equals("porta=0") & presenca.equals("presenca=0") & lampadas.equals("lampada=1") & ar.equals("ar=0")){
			s.setTexto("Sala com desperdício de energia");
			s.setCor("#ff4500");
		}else if(porta.equals("porta=0") & presenca.equals("presenca=0") & lampadas.equals("lampada=0") & ar.equals("ar=1")){
			s.setTexto("Sala com desperdício de energia");
			s.setCor("#ff4500");
		}else if(porta.equals("porta=0") & presenca.equals("presenca=0") & lampadas.equals("lampada=0") & ar.equals("ar=0")){
			s.setTexto("Sala livre");
			s.setCor("#006400");
		}else{
			s.setTexto("Impossível fazer leitura...");
			s.setCor("#a9a9a9");
		}*/
		s.setTexto("Corrigir Implementacao.");
		s.setCor("#a9a9a9");
		return s;
	}

}
