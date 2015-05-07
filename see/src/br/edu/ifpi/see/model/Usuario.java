package br.edu.ifpi.see.model;

import java.util.ArrayList;

public class Usuario {
	
	private long id;
	private String nome;
	private String endereco;
	private String email;
	private String telefone;
	private String senha;
	private int tipo;
	private ArrayList<Sala> listaSala = new ArrayList<Sala>();
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(long id, String nome, String endereco, String email,
			String telefone, String senha, int tipo, ArrayList<Sala> listaSala) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.tipo = tipo;
		this.listaSala = listaSala;
	}

	public Usuario(String nome, String endereco, String email, String telefone,
			String senha, int tipo, ArrayList<Sala> listaSala) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.tipo = tipo;
		this.listaSala = listaSala;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public ArrayList<Sala> getListaSala() {
		return listaSala;
	}

	public void setListaSala(ArrayList<Sala> listaSala) {
		this.listaSala = listaSala;
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
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", endereco="
				+ endereco + ", email=" + email + ", telefone=" + telefone
				+ ", senha=" + senha + ", tipo=" + tipo + ", listaSala="
				+ listaSala + "]";
	}
	
}
