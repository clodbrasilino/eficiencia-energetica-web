package br.edu.ifpi.see.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class HistoricoSala {
	
	@Id @GeneratedValue
	private long id;
	private Date data;
	private String hora;
	private String status;
	
	@ManyToOne
	private Sala sala;
	
	public HistoricoSala() {
		super();
	}

	public HistoricoSala(long id, Date data, String hora, String status,
			Sala sala) {
		super();
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.status = status;
		this.sala = sala;
	}

	public HistoricoSala(Date data, String hora, String status, Sala sala) {
		super();
		this.data = data;
		this.hora = hora;
		this.status = status;
		this.sala = sala;
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
		HistoricoSala other = (HistoricoSala) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HistoricoSala [id=" + id + ", data=" + data + ", hora=" + hora
				+ ", status=" + status + ", sala=" + sala + "]";
	}

}
