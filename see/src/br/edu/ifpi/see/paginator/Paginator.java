package br.edu.ifpi.see.paginator;

import java.util.ArrayList;
import java.util.List;

public class Paginator {
	
	private Object lista;
	private List<Object> sublistas;
	private int posicao;
	private int linhas;
	private int quantidadeSublistas;
	
	public Object getLista() {
		return lista;
	}

	public void setLista(Object lista) {
		this.lista = lista;
	}

	public List<Object> getSublistas() {
		return sublistas;
	}

	public void setSublistas(List<Object> sublistas) {
		this.sublistas = sublistas;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public int getQuantidadeSublistas() {
		return quantidadeSublistas;
	}

	public void setQuantidadeSublistas(int quantidadeSublistas) {
		this.quantidadeSublistas = quantidadeSublistas;
	}
	
	@SuppressWarnings("unchecked")
	public Object getSublista() {
		this.createSublistas();
		
		if(sublistas.size() > 0) {
			return (List<Object>) sublistas.get(posicao);
		} else {
			return null;
		}
	}
	
	public int getSiseLista() {
		return quantidadeSublistas;
	}
	
	public boolean temProximaLista() {
		return posicao < sublistas.size()-1;
	}
	
	public boolean temListaAnterior() {
		return posicao > 0;
	}
	
	public void chamaProximaLista() {
		if(posicao < sublistas.size()-1) {
			posicao++;
		}
	}
	
	public void chamaListaAnterior() {
		if(posicao > 0) {
			posicao--;
		}
	}
	
	@SuppressWarnings("unchecked")
	private void createSublistas() {
		quantidadeSublistas = 0;
		if(((List<Object>) lista).size() % linhas == 0) {
			quantidadeSublistas = ((List<Object>) lista).size() / linhas;
		} else {
			quantidadeSublistas = ((List<Object>) lista).size() / linhas + 1;
		}
		
		sublistas = new ArrayList<Object>();
		
		int j = 0;
		for(int i=0; i<quantidadeSublistas; i++) {
			if(j + linhas < ((List<Object>) lista).size()) {
				sublistas.add(((List<Object>) lista).subList(j, j+linhas));
			} else {
				sublistas.add(((List<Object>) lista).subList(j, ((List<Object>) lista).size()));
			}
			j = j + linhas;
		}
	}

}
