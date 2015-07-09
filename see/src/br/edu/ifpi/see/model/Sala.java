package br.edu.ifpi.see.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private Status statusAnterior;
	
	@Transient
	private Status status;
	
	@ManyToOne
	private Usuario usuario;
	
	@OneToMany(mappedBy="sala")
	private List<MicroControlador> listaMicroControlador;
	@OneToMany(mappedBy="sala")
	private List<HistoricoSala> listaHistorico;
	
	private boolean ativa;
	
	@Transient
	private List<TempoStatus> temposStatus;
	
	@Transient
	private HashMap<String, TempoStatus> tempoStatus;
	
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
		this.statusAnterior = this.status;
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
	
	public boolean hasStatusAtual(){
		if(this.status != null && this.statusAnterior != null){
			return !status.equals(this.statusAnterior);
		}else{
			return false;
		}
	}
	
	public void carregaStatusTempo(){
		
		/*this.tempoStatus = new HashMap<>();
		
		for(HistoricoSala hs : this.listaHistorico){
			if(this.tempoStatus.containsKey(hs.getStatus())){
				TempoStatus ts = this.tempoStatus.get(hs.getStatus());
				ts.setHora(hs.getHora().getTimeInMillis());
				this.tempoStatus.put(hs.getStatus(), ts);
			}else{
				this.tempoStatus.put(hs.getStatus(), new TempoStatus(hs.getHora().getTimeInMillis()));
			}
		}*/
		
		temposStatus = new ArrayList<TempoStatus>();
		
		Calendar data = Calendar.getInstance();
		data.setTime(new Date());
		
		//this.listaHistorico.add(new HistoricoSala(data, this));
		
		long tempo = 0;
		for (int i = 0; i < this.listaHistorico.size()-1; i++) {
			tempo = listaHistorico.get(i+1).getHora().getTimeInMillis() - listaHistorico.get(i).getHora().getTimeInMillis();
			this.temposStatus.add(new TempoStatus(this.listaHistorico.get(i).getStatus(), tempo));
		}
		tempo = System.currentTimeMillis() - listaHistorico.get(this.listaHistorico.size()-1).getHora().getTimeInMillis();
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		System.out.println(df.format(System.currentTimeMillis()));
		this.temposStatus.add(new TempoStatus(this.listaHistorico.get(this.listaHistorico.size()-1).getStatus(), tempo));
		
		this.tempoStatus = new HashMap<>();
		for(TempoStatus ts : this.temposStatus){
			System.out.println(ts.getDescicao() + " - " + ts.getTempoMilisegundos());
			
			if(this.tempoStatus.containsKey(ts.getDescicao())){
				TempoStatus tempoStatus = this.tempoStatus.get(ts.getDescicao());
				//tempoStatus.setHora(hs.getHora().getTimeInMillis());
				tempoStatus.setTempo(tempoStatus.getTempoMilisegundos() + ts.getTempoMilisegundos());
				this.tempoStatus.put(ts.getDescicao(), tempoStatus);
			}else{
				this.tempoStatus.put(ts.getDescicao(), new TempoStatus(ts.getDescicao(), (long) ts.getTempoMilisegundos()));
			}
			
		}
		
		for(Map.Entry<String, TempoStatus> times : this.tempoStatus.entrySet()){
			System.out.println(times.getKey() + " - " + times.getValue().getTempoMilisegundos());
		}
		
		System.out.println(this.status.getDescricao());
		
	}
	
	public HashMap<String, TempoStatus> getTempoStatus() {
		
		/*for(Map.Entry<String, TempoStatus> times : this.tempoStatus.entrySet()){
			times.getValue().analizaTempo();
		}*/
		return tempoStatus;
	}
	
}
