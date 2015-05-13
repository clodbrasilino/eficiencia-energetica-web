package br.edu.ifpi.see.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class HistoricoMicroControlador {
	
	@Id @GeneratedValue
	private long id;
	private Date data;
	private String hora;
	private String sPorta;
	private String sPresenca;
	private String sAr;
	private String sLampadas;
	
	@ManyToOne
	private MicroControlador microControlador;
	
	public HistoricoMicroControlador() {
		super();
	}

	public HistoricoMicroControlador(long id, Date data, String hora,
			MicroControlador microControlador, String sPorta, String sPresenca,
			String sAr, String sLampadas) {
		super();
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.microControlador = microControlador;
		this.sPorta = sPorta;
		this.sPresenca = sPresenca;
		this.sAr = sAr;
		this.sLampadas = sLampadas;
	}

	public HistoricoMicroControlador(Date data, String hora,
			MicroControlador microControlador, String sPorta, String sPresenca,
			String sAr, String sLampadas) {
		super();
		this.data = data;
		this.hora = hora;
		this.microControlador = microControlador;
		this.sPorta = sPorta;
		this.sPresenca = sPresenca;
		this.sAr = sAr;
		this.sLampadas = sLampadas;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public MicroControlador getMicroControlador() {
		return microControlador;
	}

	public void setMicroControlador(MicroControlador microControlador) {
		this.microControlador = microControlador;
	}

	public String getsPorta() {
		return sPorta;
	}

	public void setsPorta(String sPorta) {
		this.sPorta = sPorta;
	}

	public String getsPresenca() {
		return sPresenca;
	}

	public void setsPresenca(String sPresenca) {
		this.sPresenca = sPresenca;
	}

	public String getsAr() {
		return sAr;
	}

	public void setsAr(String sAr) {
		this.sAr = sAr;
	}

	public String getsLampadas() {
		return sLampadas;
	}

	public void setsLampadas(String sLampadas) {
		this.sLampadas = sLampadas;
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
		HistoricoMicroControlador other = (HistoricoMicroControlador) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HistoricoMicroControlador [id=" + id + ", data=" + data
				+ ", hora=" + hora + ", microControlador=" + microControlador
				+ ", sPorta=" + sPorta + ", sPresenca=" + sPresenca + ", sAr="
				+ sAr + ", sLampadas=" + sLampadas + "]";
	}

}
