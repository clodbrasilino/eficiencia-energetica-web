package br.edu.ifpi.see.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Sala {
	
	@Id @GeneratedValue
	private long id;
	private String numero;
	private String descricao;
	private int pavimento;
	
	@Transient
	private Status status;
	
	@ManyToOne
	private Usuario usuario;
	
	@OneToMany(mappedBy="sala")
	private List<MicroControlador> listaMicroControlador;
	@OneToMany(mappedBy="sala")
	private List<HistoricoSala> listaHistorico;
	
	private boolean ativa;
	
	public Sala() {
		super();
	}

	public Sala(String numero, String descricao, int pavimento,
			Usuario usuario, List<MicroControlador> listaMicroControlador,
			List<HistoricoSala> listaHistorico) {
		super();
		this.numero = numero;
		this.descricao = descricao;
		this.pavimento = pavimento;
		this.usuario = usuario;
		this.listaMicroControlador = listaMicroControlador;
		this.listaHistorico = listaHistorico;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	public Status getStatus(){
		return status;
	}
	
	public void setStatus(Status status){
		this.status = status;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<MicroControlador> getListaMicroControlador() {
		return listaMicroControlador;
	}

	public void setListaMicroControlador(
			List<MicroControlador> listaMicroControlador) {
		this.listaMicroControlador = listaMicroControlador;
	}

	public List<HistoricoSala> getListaHistorico() {
		return listaHistorico;
	}

	public void setListaHistorico(List<HistoricoSala> listaHistorico) {
		this.listaHistorico = listaHistorico;
	}
	
	public boolean isAtiva(){
		return ativa;
	}
	
	public void setAtiva(boolean ativa){
		this.ativa = ativa;
	}
	
	public String getAtiva(){
		if(this.ativa){
			return "Sim";
		}else{
			return "Não";
		}
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
