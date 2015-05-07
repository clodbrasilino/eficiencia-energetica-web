package br.edu.ifpi.see.model;

import java.util.ArrayList;

public class Sala {
	
	private String numero;
	private String descricao;
	private int pavimento;
	private Usuario usuario;
	private ArrayList<MicroControlador> listaMicroControlador = new ArrayList<MicroControlador>();
	private ArrayList<HistoricoSala> listaHistorico = new ArrayList<HistoricoSala>();
	
	public Sala() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sala(String numero, String descricao, int pavimento,
			Usuario usuario, ArrayList<MicroControlador> listaMicroControlador,
			ArrayList<HistoricoSala> listaHistorico) {
		super();
		this.numero = numero;
		this.descricao = descricao;
		this.pavimento = pavimento;
		this.usuario = usuario;
		this.listaMicroControlador = listaMicroControlador;
		this.listaHistorico = listaHistorico;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPavimento() {
		return pavimento;
	}

	public void setPavimento(int pavimento) {
		this.pavimento = pavimento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ArrayList<MicroControlador> getListaMicroControlador() {
		return listaMicroControlador;
	}

	public void setListaMicroControlador(
			ArrayList<MicroControlador> listaMicroControlador) {
		this.listaMicroControlador = listaMicroControlador;
	}

	public ArrayList<HistoricoSala> getListaHistorico() {
		return listaHistorico;
	}

	public void setListaHistorico(ArrayList<HistoricoSala> listaHistorico) {
		this.listaHistorico = listaHistorico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Sala other = (Sala) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sala [numero=" + numero + ", descricao=" + descricao
				+ ", pavimento=" + pavimento + ", usuario=" + usuario
				+ ", listaMicroControlador=" + listaMicroControlador
				+ ", listaHistorico=" + listaHistorico + "]";
	}
	
}
