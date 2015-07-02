package br.edu.ifpi.see.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.persistence.Transient;

@Entity
public class MicroControlador {
	
	@Id @GeneratedValue
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Calendar dtInstalacao;
	
	private String ip;
	private boolean sensorPorta;
	private boolean sensorPresenca;
	private boolean sensorLampada;
	private boolean sensorAr;
	
	@ManyToOne
	private Sala sala;
	
	@OneToMany(mappedBy="microControlador")
	private List<HistoricoMicroControlador> listaHistorico;
	
	public MicroControlador() {
		super();
	}
	
	public MicroControlador(Calendar dtInstalacao, String ip, boolean sensorPorta,
			boolean sensorPresenca, boolean sensorLampada, boolean sensorAr, Sala sala,
			List<HistoricoMicroControlador> listaHistorico) {
		super();
		this.dtInstalacao = dtInstalacao;
		this.ip = ip;
		this.sensorPorta = sensorPorta;
		this.sensorPresenca = sensorPresenca;
		this.sensorLampada = sensorLampada;
		this.sensorAr = sensorAr;
		this.sala = sala;
		this.listaHistorico = listaHistorico;
	}

	public MicroControlador(Calendar dtInstalacao, String ip, boolean sensorPorta,
			boolean sensorPresenca, boolean sensorLampada, boolean sensorAr) {
		super();
		this.dtInstalacao = dtInstalacao;
		this.ip = ip;
		this.sensorPorta = sensorPorta;
		this.sensorPresenca = sensorPresenca;
		this.sensorLampada = sensorLampada;
		this.sensorAr = sensorAr;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Calendar getDtInstalacao() {
		return dtInstalacao;
	}

	public void setDtInstalacao(Calendar dtInstalacao) {
		this.dtInstalacao = dtInstalacao;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public List<HistoricoMicroControlador> getListaHistorico() {
		return listaHistorico;
	}

	public void setListaHistorico(
			List<HistoricoMicroControlador> listaHistorico) {
		this.listaHistorico = listaHistorico;
	}

	public boolean isSensorPorta() {
		return sensorPorta;
	}

	public void setSensorPorta(boolean sensorPorta) {
		this.sensorPorta = sensorPorta;
	}
	
	public String getSensorPorta(){
		if(this.sensorPorta){
			return "Sim";
		}else{
			return "Não";
		}
	}

	public boolean isSensorPresenca() {
		return sensorPresenca;
	}

	public void setSensorPresenca(boolean sensorPresenca) {
		this.sensorPresenca = sensorPresenca;
	}
	
	public String getSensorPresenca(){
		if(this.sensorPresenca){
			return "Sim";
		}else{
			return "Não";
		}
	}
	
	public boolean isSensorLampada() {
		return sensorLampada;
	}

	public void setSensorLampada(boolean sensorLampada) {
		this.sensorLampada = sensorLampada;
	}
	
	public String getSensorLampada(){
		if(this.sensorLampada){
			return "Sim";
		}else{
			return "Não";
		}
	}
	
	public boolean isSensorAr() {
		return sensorAr;
	}

	public void setSensorAr(boolean sensorAr) {
		this.sensorAr = sensorAr;
	}
	
	public String getSensorAr(){
		if(this.sensorAr){
			return "Sim";
		}else{
			return "Não";
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MicroControlador other = (MicroControlador) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "M" + this.id;
	}
	
	public boolean temSensor(String sensor){
		boolean valor = false;
		
		if(sensor.equals("porta")){
			valor = this.isSensorPorta();
		}else if(sensor.equals("presenca")){
			valor = this.isSensorPresenca();
		}else if(sensor.equals("luz")){
			valor = this.isSensorLampada();
		}else if(sensor.equals("ar")){
			valor = this.isSensorAr();
		}
		
		return valor;
	}
	
}
