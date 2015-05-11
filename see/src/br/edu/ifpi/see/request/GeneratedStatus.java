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
				mc.getsPorta().setValor(response.getPorta());
				mc.getsPresenca().setValor(response.getPresenca());
				mc.getsLampada().setValor(response.getLampadas());
				mc.getsAr().setValor(response.getAr());
				
				return geraStatus(mc.getsPorta().getValor(), mc.getsPresenca().getValor(), mc.getsLampada().getValor(), mc.getsAr().getValor());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	private Status geraStatus(String porta, String presenca, String lampadas, String ar){
		Status s = new Status();
		
		if(porta.equals("porta=1") & presenca.equals("presenca=1") & lampadas.equals("lampada=1") & ar.equals("ar=1")){
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
		}
		
		return s;
	}

}
