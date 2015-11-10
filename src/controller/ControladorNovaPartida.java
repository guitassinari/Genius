package controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Cor;
import model.Partida;
import view.TelaDePartida;

public class ControladorNovaPartida {

	// ------------------------------------------ ATRIBUTOS ---------------------------------------------------------
	
	private List<Color> sequenciaCoresPartida;
	private List<Color> sequenciaCoresPressionadas;
	private Partida partida;
	private TelaDePartida telaDePartida;

	
	// ------------------------------------------ MÉTODOS CONSTRUTORES ---------------------------------------------
	
	
	public ControladorNovaPartida(TelaDePartida conteudoJanelaNovaPartida) {
		super();
		this.telaDePartida = conteudoJanelaNovaPartida;
		this.sequenciaCoresPartida = new ArrayList<Color>();
		this.sequenciaCoresPressionadas = new ArrayList<Color>();
		this.partida = new Partida();
	}

	public ControladorNovaPartida(List<Color> sequenciaCoresPartida, List<Color> sequenciaCoresPressionadas,
			Partida partida, TelaDePartida conteudoJanelaNovaPartida) {
		super();
		this.sequenciaCoresPartida = sequenciaCoresPartida;
		this.sequenciaCoresPressionadas = sequenciaCoresPressionadas;
		this.partida = partida;
		this.telaDePartida = conteudoJanelaNovaPartida;
	}

	public ControladorNovaPartida(Partida partida) {
		super();
		this.partida = partida;
		sequenciaCoresPartida = new ArrayList<Color>();
		sequenciaCoresPressionadas = new ArrayList<Color>();
	}
	
	
	// ------------------------------------------- MÉTODOS GERAIS --------------------------------------------------
	
	
	public void comecarPartida(){
		sequenciaCoresPartida = new ArrayList<Color>();
		comecarNovaJogada();
	}
	
	public void comecarNovaJogada(){
		sequenciaCoresPressionadas = new ArrayList<Color>();
		addCorSequenciaPartida();
		piscarSequenciaCores(sequenciaCoresPartida);
	}
	
	public void piscarSequenciaCores(List<Color> sequencia) {
		telaDePartida.piscarSequenciaBotoes(sequencia);
	}
	
	public void corPressionada(Color corPressionada) {
		sequenciaCoresPressionadas.add(corPressionada);
		
		int tamanhoSequenciaCoresPressionadas = sequenciaCoresPressionadas.size();
		Color corCorrespondenteSequenciaPartida = sequenciaCoresPartida.get(tamanhoSequenciaCoresPressionadas-1);
		
		if(corPressionada.equals(corCorrespondenteSequenciaPartida)){
			if(tamanhoSequenciaCoresPressionadas == sequenciaCoresPartida.size()){
				partida.incrementarNrPontos();
				telaDePartida.mostrarMensagemSequenciaCorreta();
				comecarNovaJogada();
			}
		} else {
			//Se errou, termina a partida
			fimDePartida();
		}
		
	}
	
	public void fimDePartida(){
		ControladorRanking controladorRanking = new ControladorRanking();
		controladorRanking.addPartidaTopCinco(this.partida);
	}
	
	public void addCorSequenciaPartida() {
		Color[] cores = new Color[] { Cor.VERDE, Cor.AZUL, Cor.AMARELO, Cor.VERMELHO };
		Random geradorRandomico = new Random();
		int index = geradorRandomico.nextInt(cores.length);
		sequenciaCoresPartida.add(cores[index]);
	}

	
	// ------------------------------------------ GETTERS E SETTERS --------------------------------------------
	
	
	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public List<Color> getSequenciaCoresPartida() {
		return sequenciaCoresPartida;
	}

	public void setSequenciaCoresPartida(List<Color> sequenciaCoresPartida) {
		this.sequenciaCoresPartida = sequenciaCoresPartida;
	}

	public List<Color> getSequenciaCoresJogador() {
		return sequenciaCoresPressionadas;
	}

	public void setSequenciaCoresJogador(List<Color> sequenciaCoresJogador) {
		this.sequenciaCoresPressionadas = sequenciaCoresJogador;
	}

	public TelaDePartida getConteudoJanelaNovaPartida() {
		return telaDePartida;
	}

	public void setConteudoJanelaNovaPartida(TelaDePartida conteudoJanelaNovaPartida) {
		this.telaDePartida = conteudoJanelaNovaPartida;
	}

}
