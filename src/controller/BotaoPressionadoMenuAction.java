package controller;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Cor;
import view.JanelaDeJogo;

/**
 * 
 * Classe que define o comportamento de teclas do teclado ao serem pressionadas 
 * 
 */
public class BotaoPressionadoMenuAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private Color cor;
	private JanelaDeJogo janelaDeJogo;

	public BotaoPressionadoMenuAction(Color cor, JanelaDeJogo janelaDeJogo) {
		super();
		this.cor = cor;
		this.janelaDeJogo = janelaDeJogo;
	}

	/**
	 * Ação a ser tomada quando uma tecla for pressionada. Testará qual cor foi pressionada e abrirá a tela correspondente:
	 * 
	 * 	AMARELO	:	Help
	 * 	AZUL 	: 	Ranking
	 * 	VERMELHO:	Fecha Janela
	 * 	VERDE	:	Inserir Nome(Começa fluxo de nova partida)
	 * 	
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(cor.equals(Cor.VERMELHO)){	
			janelaDeJogo.fecharJogo();
		} else if (cor.equals(Cor.AMARELO)){
			janelaDeJogo.mostrarHelp();
		} else if (cor.equals(Cor.AZUL)){
			janelaDeJogo.mostrarRanking();
		} else if (cor.equals(Cor.VERDE)){
			janelaDeJogo.mostrarInserirNome();
		}
	}

	public Color getCor() {
		return cor;
	}

	public void setCor(Color cor) {
		this.cor = cor;
	}

	public JanelaDeJogo getJanelaDeJogo() {
		return janelaDeJogo;
	}

	public void setJanelaDeJogo(JanelaDeJogo janelaDeJogo) {
		this.janelaDeJogo = janelaDeJogo;
	}

}
