package br.edu.ifpi.see.request;

import java.util.ArrayList;
import br.edu.ifpi.see.model.MicroControlador;
import br.edu.ifpi.see.model.SensorAr;
import br.edu.ifpi.see.model.SensorLampada;
import br.edu.ifpi.see.model.SensorPorta;
import br.edu.ifpi.see.model.SensorPresenca;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<MicroControlador> lista = new ArrayList<MicroControlador>();
		
		SensorPorta porta = new SensorPorta();
		SensorPresenca presenca = new SensorPresenca();
		SensorLampada lampada = new SensorLampada();
		SensorAr ar = new SensorAr();
		
		MicroControlador mc = new MicroControlador();
		mc.setIp("127.0.0.1:8080/see/control");
		mc.setsPorta(porta);
		mc.setsPresenca(presenca);
		mc.setsLampada(lampada);
		mc.setsAr(ar);
		
		lista.add(mc);
		
		GeneratedStatus s = new GeneratedStatus();
		System.out.println("Status da sala: " + s.getStatus(lista));
		
	}

}
