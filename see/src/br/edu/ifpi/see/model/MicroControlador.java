package br.edu.ifpi.see.model;

import java.sql.Date;
import java.util.ArrayList;

public class MicroControlador {
	
	private long id;
	private Date dtInstalacao;
	private String ip;
	private Sala sala;
	private SensorPorta sPorta;
	private SensorPresenca sPresenca;
	private SensorAr sAr;
	private SensorLampada sLampada;
	private ArrayList<HistoricoMicroControlador> listaHistorico = new ArrayList<HistoricoMicroControlador>();
	
	public MicroControlador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MicroControlador(long id, Date dtInstalacao, String ip, Sala sala,
			SensorPorta sPorta, SensorPresenca sPresenca, SensorAr sAr,
			SensorLampada sLampada,
			ArrayList<HistoricoMicroControlador> listaHistorico) {
		super();
		this.id = id;
		this.dtInstalacao = dtInstalacao;
		this.ip = ip;
		this.sala = sala;
		this.sPorta = sPorta;
		this.sPresenca = sPresenca;
		this.sAr = sAr;
		this.sLampada = sLampada;
		this.listaHistorico = listaHistorico;
	}

	public MicroControlador(Date dtInstalacao, String ip, Sala sala,
			SensorPorta sPorta, SensorPresenca sPresenca, SensorAr sAr,
			SensorLampada sLampada,
			ArrayList<HistoricoMicroControlador> listaHistorico) {
		super();
		this.dtInstalacao = dtInstalacao;
		this.ip = ip;
		this.sala = sala;
		this.sPorta = sPorta;
		this.sPresenca = sPresenca;
		this.sAr = sAr;
		this.sLampada = sLampada;
		this.listaHistorico = listaHistorico;
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

	public SensorPorta getsPorta() {
		return sPorta;
	}

	public void setsPorta(SensorPorta sPorta) {
		this.sPorta = sPorta;
	}

	public SensorPresenca getsPresenca() {
		return sPresenca;
	}

	public void setsPresenca(SensorPresenca sPresenca) {
		this.sPresenca = sPresenca;
	}

	public SensorAr getsAr() {
		return sAr;
	}

	public void setsAr(SensorAr sAr) {
		this.sAr = sAr;
	}

	public SensorLampada getsLampada() {
		return sLampada;
	}

	public void setsLampada(SensorLampada sLampada) {
		this.sLampada = sLampada;
	}

	public ArrayList<HistoricoMicroControlador> getListaHistorico() {
		return listaHistorico;
	}

	public void setListaHistorico(
			ArrayList<HistoricoMicroControlador> listaHistorico) {
		this.listaHistorico = listaHistorico;
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
