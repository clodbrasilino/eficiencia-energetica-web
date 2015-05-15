package br.edu.ifpi.see.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.Transient;

@Entity
public class MicroControlador {
	
	@Id @GeneratedValue
	private long id;
	private Date dtInstalacao;
	private String ip;
	private int sensorPorta;
	private int sensorPresenca;
	private int sensorAr;
	private int sensorLampada;
	
	@ManyToOne
	private Sala sala;
	
	@OneToMany(mappedBy="microControlador")
	private List<HistoricoMicroControlador> listaHistorico;
	
	public MicroControlador() {
		super();
	}
	
	public MicroControlador(Date dtInstalacao, String ip, int sensorPorta,
			int sensorPresenca, int sensorAr, int sensorLampada, Sala sala,
			List<HistoricoMicroControlador> listaHistorico) {
		super();
		this.dtInstalacao = dtInstalacao;
		this.ip = ip;
		this.sensorPorta = sensorPorta;
		this.sensorPresenca = sensorPresenca;
		this.sensorAr = sensorAr;
		this.sensorLampada = sensorLampada;
		this.sala = sala;
		this.listaHistorico = listaHistorico;
	}

	public MicroControlador(Date dtInstalacao, String ip, int sensorPorta,
			int sensorPresenca, int sensorAr, int sensorLampada) {
		super();
		this.dtInstalacao = dtInstalacao;
		this.ip = ip;
		this.sensorPorta = sensorPorta;
		this.sensorPresenca = sensorPresenca;
		this.sensorAr = sensorAr;
		this.sensorLampada = sensorLampada;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDtInstalacao() {
		return dtInstalacao;
	}

	public void setDtInstalacao(Date dtInstalacao) {
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

	public int getSensorPorta() {
		return sensorPorta;
	}

	public void setSensorPorta(int sensorPorta) {
		this.sensorPorta = sensorPorta;
	}

	public int getSensorPresenca() {
		return sensorPresenca;
	}

	public void setSensorPresenca(int sensorPresenca) {
		this.sensorPresenca = sensorPresenca;
	}

	public int getSensorAr() {
		return sensorAr;
	}

	public void setSensorAr(int sensorAr) {
		this.sensorAr = sensorAr;
	}

	public int getSensorLampada() {
		return sensorLampada;
	}

	public void setSensorLampada(int sensorLampada) {
		this.sensorLampada = sensorLampada;
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
	
}
