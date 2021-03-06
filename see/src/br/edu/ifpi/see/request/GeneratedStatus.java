package br.edu.ifpi.see.request;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.edu.ifpi.see.model.MicroControlador;
import br.edu.ifpi.see.model.Status;

public class GeneratedStatus {
	
	public Status getStatus(List<MicroControlador> microControladores){
		HttpRequest request = new HttpRequest();
		List<Response> respostas = new ArrayList<Response>();
		
		// Pega as respostas dos micro controladores
		if(microControladores != null){
			for(MicroControlador mc : microControladores){
				try {
					// mc.setResponse(request.sendGet(mc));
					// mc.createResponse(request);
					respostas.add(request.sendGet(mc));
					//Response response = request.sendGet(mc.getIp());
					//return geraStatus(Integer.parseInt(response.getPorta()), Integer.parseInt(response.getPresenca()), Integer.parseInt(response.getLampadas()), Integer.parseInt(response.getAr()));
				} catch (Exception e) {
					Calendar hora = Calendar.getInstance();
					hora.setTime(new Date(System.currentTimeMillis()));
					return new Status("Micro controlador(es) n�o encontrado(s)", "#d9d9d9", hora);
				}
			}
		}else{
			Calendar hora = Calendar.getInstance();
			hora.setTime(new Date(System.currentTimeMillis()));
			return new Status("Sem Micro Controlador", "#eee", hora);
		}
		
		
		// Response resposta = sala.somaResponse();
		
		// Soma as respostas dos micro controladores
		Response resposta = new Response("0", "0", "0", "0");
		for(Response r : respostas){
			resposta = this.soma(resposta, r);
		}
		
		/*System.out.println("Resultado:");
		System.out.println("Porta: "+resposta.getPorta());
		System.out.println("Presen�a: "+resposta.getPresenca());
		System.out.println("L�mpadas: "+resposta.getLampadas());
		System.out.println("Ar: "+resposta.getAr());*/
		
		return this.geraStatus(Integer.parseInt(resposta.getPorta()), Integer.parseInt(resposta.getPresenca()), Integer.parseInt(resposta.getLampadas()), Integer.parseInt(resposta.getAr()));
	}
	
	public Status geraStatus(int porta, int presenca, int lampadas, int ar){
		Status s = new Status();
		/* C�digo anterior
		 * if((lampadas == 1 || ar == 1) && (presenca == 0)){
			s.setTexto("Desperd�cio");
			s.setCor("#ff0000");
		}else if((lampadas == 1 || ar == 1) && (presenca == 0) && (porta == 0)){
			s.setTexto("Desperd�cio");
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
		
		// C�digo atual
		if(lampadas == 0 && ar == 0){
			if(presenca == 0 && lampadas == 0 && ar == 0){
				// Sala livre
				s.setDescricao("Sala livre");
				s.setCor("#00ff00");
				Calendar time = Calendar.getInstance();
				time.setTime(new Date());
				s.setTime(time);
			}else{
				// Sem consumo
				s.setDescricao("Sem consumo");
				s.setCor("#00ff00");
				Calendar time = Calendar.getInstance();
				time.setTime(new Date());
				s.setTime(time);
			}
		}else{
			if((lampadas == -1 && ar == -1) || (lampadas == -1 && ar == 0) || (lampadas == 0 && ar == -1)){
				// Verifique
				s.setDescricao("Verifique!");
				s.setCor("#ffa500");
				Calendar time = Calendar.getInstance();
				time.setTime(new Date());
				s.setTime(time);
			}else{
				if(presenca == 0){
					// Desperd�cio
					s.setDescricao("Desperd�cio");
					s.setCor("#ff0000");
					Calendar time = Calendar.getInstance();
					time.setTime(new Date());
					s.setTime(time);
				}else if((porta == 0 && presenca == -1 && ar == 1) && (lampadas == -1 || lampadas == 0 || lampadas == 1)){
					// Desperd�cio
					s.setDescricao("Desperd�cio");
					s.setCor("#ff0000");
					Calendar time = Calendar.getInstance();
					time.setTime(new Date());
					s.setTime(time);
				}else if((porta == 0 && presenca == 1 && ar == 1) && (lampadas == -1 || lampadas == 0 || lampadas == 1)){
					// Desperd�cio
					s.setDescricao("Desperd�cio");
					s.setCor("#ff0000");
					Calendar time = Calendar.getInstance();
					time.setTime(new Date());
					s.setTime(time);
				}else if(porta == 1 && presenca == 1){
					// Normal
					s.setDescricao("Consumo normal");
					s.setCor("#00ff00");
					Calendar time = Calendar.getInstance();
					time.setTime(new Date());
					s.setTime(time);
				}else if((presenca == 1 && lampadas == 1 && ar == 0) && (porta == -1 || porta == 0)){
					// Normal
					s.setDescricao("Consumo normal");
					s.setCor("#00ff00");
					Calendar time = Calendar.getInstance();
					time.setTime(new Date());
					s.setTime(time);
				}else{
					// Verifique
					s.setDescricao("Verifique!");
					s.setCor("#ffa500");
					Calendar time = Calendar.getInstance();
					time.setTime(new Date());
					s.setTime(time);
				}
			}
		}
		return s;
	}
	
	private Response soma(Response resp1, Response resp2){
		String porta = this.geraValor(Integer.parseInt(resp1.getPorta()), Integer.parseInt(resp2.getPorta()));
		String presenca = this.geraValor(Integer.parseInt(resp1.getPresenca()), Integer.parseInt(resp2.getPresenca()));
		String lampadas = this.geraValor(Integer.parseInt(resp1.getLampadas()), Integer.parseInt(resp2.getLampadas()));
		String ar = this.geraValor(Integer.parseInt(resp1.getAr()), Integer.parseInt(resp2.getAr()));
		
		return new Response(porta, presenca, lampadas, ar);
	}
	
	public String geraValor(int valor1, int valor2){
		String valor = null;
		
		if(valor1 == -1 & valor2 == -1){
			valor = "-1";
		}else if(valor1 == -1 & valor2 == 0){
			valor = "-1";
		}else if(valor1 == -1 & valor2 == 1){
			valor = "1";
		}else if(valor1 == 0 & valor2 == -1){
			valor = "-1";
		}else if(valor1 == 0 & valor2 == 0){
			valor = "0";
		}else if(valor1 == 0 & valor2 == 1){
			valor = "1";
		}else if(valor1 == 1 & valor2 == -1){
			valor = "1";
		}else if(valor1 == 1 & valor2 == 0){
			valor = "1";
		}else if(valor1 == 1 & valor2 == 1){
			valor = "1";
		}
		
		return valor;
		/*if((valor1 == -1 & valor2 == -1) || ((valor1 == 0 & valor2 == -1) || (valor1 == -1 & valor2 == -0))){
			return "-1";
		}else if(valor1 == 0 & valor2 == 0){
			return "0";
		}else{
			return "1";
		}*/
	}

}
