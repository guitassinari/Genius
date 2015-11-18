package controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Cor;
import model.Mensagem;
import model.Partida;
import view.TelaDePartida;

/**
 * 
 * Esta classe executará toda e qualquer operação que não envolva DIRETAMENTE alguma resposta visual ao usuário.
 * Toda e qualquer manipulação de objetos, modelos e funcionamento da partida será tratado aqui.
 * Respostas visuais serão tratadas pela classe TelaDePartida e poderão ser chamadas indiretamente por esta classe.
 *
 *
 * @see TelaDePartida
 * 
 * @param sequenciaCoresPartida	sequencia de cores que o usuario deve seguir para continuar a partida. Gerada randomicamente.
 * @param sequenciaCoresPressionadas sequencia de cores pressionadas pelo usuário na rodada atual
 * @param partida objeto que guardará os dados desta partida para serem salvos no ranking (nome, data e pontuação)
 */
public class ControladorPartida {

	// ------------------------------------------ ATRIBUTOS ---------------------------------------------------------
	
	private List<Color> sequenciaCoresPartida;
	private List<Color> sequenciaCoresPressionadas;
	private Partida partida;
	private TelaDePartida telaDePartida;

	
	// ------------------------------------------ MÉTODOS CONSTRUTORES ---------------------------------------------
	
	
	public ControladorPartida(TelaDePartida telaDePartida) {
		super();
		this.telaDePartida = telaDePartida;
		this.sequenciaCoresPartida = new ArrayList<Color>();
		this.sequenciaCoresPressionadas = new ArrayList<Color>();
		this.partida = new Partida();
	}
	
	public ControladorPartida(String nomeJogador, TelaDePartida telaDePartida){
		super();
		this.partida = new Partida(nomeJogador);
		sequenciaCoresPartida = new ArrayList<Color>();
		sequenciaCoresPressionadas = new ArrayList<Color>();
		this.telaDePartida = telaDePartida;
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
		
		if(tamanhoSequenciaCoresPressionadas <= sequenciaCoresPartida.size()){
			Color corCorrespondenteSequenciaPartida = sequenciaCoresPartida.get(tamanhoSequenciaCoresPressionadas-1);
			
			if(corPressionada.equals(corCorrespondenteSequenciaPartida)){
				if(tamanhoSequenciaCoresPressionadas == sequenciaCoresPartida.size()){
					partida.incrementarNrPontos();
					telaDePartida.mostraMensagem(Mensagem.MSG_SEQUENCIA_CORRETA);
					comecarNovaJogada();
				}
			} else {
				//Se errou, termina a partida
				telaDePartida.mostraMensagem(Mensagem.MSG_SEQUENCIA_INCORRETA);
				fimDePartida();
			}
		}
		
	}
	
	public void fimDePartida(){
		ControladorRanking controladorRanking = new ControladorRanking();
		controladorRanking.addPartidaRanking(this.partida);
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
