package br.edu.ifpi.see.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class HistoricoSala {
	
	@Id @GeneratedValue
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	private Calendar hora;
	private String status;
	
	@ManyToOne
	private Sala sala;
	
	public HistoricoSala() {
		super();
	}

	public HistoricoSala(long id, Calendar data, Calendar hora, String status,
			Sala sala) {
		super();
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.status = status;
		this.sala = sala;
	}

	public HistoricoSala(Calendar data, Sala sala) {
		super();
		this.data = data;
		this.hora = sala.getStatus().getTime();
		this.status = sala.getStatus().getDescricao();
		this.sala = sala;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Calendar getHora() {
		return hora;
	}

	public void setHora(Calendar hora) {
		this.hora = hora;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((sala == null) ? 0 : sala.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		HistoricoSala other = (HistoricoSala) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (id != other.id)
			return false;
		if (sala == null) {
			if (other.sala != null)
				return false;
		} else if (!sala.equals(other.sala))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HistoricoSala [id=" + id + ", data=" + data + ", hora=" + hora
				+ ", status=" + status + ", sala=" + sala + "]";
	}
	
}
