package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.TelaInserirNome;
import view.JanelaDeJogo;

/**
 * 
 * Define o comportamento da tecla ENTER ao ser pressionada na TelaInserirNome, ocasionando o começo de uma nova partida
 *
 *
 */

public class EnterPressionadoInserirNomeAction extends AbstractAction {

	private JanelaDeJogo janelaDeJogo;
	private TelaInserirNome telaInserirNome;

	public EnterPressionadoInserirNomeAction(JanelaDeJogo janelaDeJogo, TelaInserirNome conteudoJanelaInserirNome) {
		super();
		this.janelaDeJogo = janelaDeJogo;
		this.telaInserirNome = conteudoJanelaInserirNome;
	}

	/**
	 * Trata o nome e, se for o caso, inicia uma nova partida. Evita que o nome esteja vazio
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (telaInserirNome.nomeVazio()) {
			telaInserirNome.mostraMensagemNomeVazio();
		} else {
			String nomeJogador = telaInserirNome.getNmJogador().getText();
			janelaDeJogo.mostrarNovaPartida(nomeJogador);
		}

	}

	public JanelaDeJogo getJanelaDeJogo() {
		return janelaDeJogo;
	}

	public void setJanelaDeJogo(JanelaDeJogo janelaDeJogo) {
		this.janelaDeJogo = janelaDeJogo;
	}

	public TelaInserirNome getConteudoJanelaInserirNome() {
		return telaInserirNome;
	}

	public void setConteudoJanelaInserirNome(TelaInserirNome conteudoJanelaInserirNome) {
		this.telaInserirNome = conteudoJanelaInserirNome;
	}

}
