package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Partida implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7805659738830161851L;
	private String nmJogador;
	private Date dtPartida;
	private Long nrPontos;

	public Partida(String nmJogador) {
		super();
		this.nmJogador = nmJogador;
		this.dtPartida = new Date();
		this.nrPontos = 0l;
	}

	public Partida() {
		super();
		this.nmJogador = "";
		this.dtPartida = new Date();
		this.nrPontos = 0l;
	}
// ------------------------------------------ MÉTODOS GERAIS ------------------------------------------------------
	
	public void incrementarNrPontos(){
		if(nrPontos == null){
			nrPontos = 0l;
		}
		nrPontos += 1;
	}
	
// ------------------------------------------ GETTERS E SETTERS ---------------------------------------------------
	
	public String getNmJogador() {
		return nmJogador;
	}

	public void setNmJogador(String nmJogador) {
		this.nmJogador = nmJogador;
	}

	public Date getDtPartida() {
		return dtPartida;
	}

	public void setDtPartida(Date dtPartida) {
		this.dtPartida = dtPartida;
	}

	public Long getNrPontos() {
		return nrPontos;
	}

	public void setNrPontos(Long nrPontos) {
		this.nrPontos = nrPontos;
	}

}
