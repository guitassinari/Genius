package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Mensagem;
import view.TelaInserirNome;
import view.JanelaDeJogo;

/**
 * 
 * Define o comportamento da tecla ENTER ao ser pressionada na TelaInserirNome, ocasionando o começo de uma nova partida
 *
 *
 */

public class EnterPressionadoInserirNomeAction extends AbstractAction {

	private TelaInserirNome telaInserirNome;

	public EnterPressionadoInserirNomeAction(TelaInserirNome conteudoJanelaInserirNome) {
		super();
		this.telaInserirNome = conteudoJanelaInserirNome;
	}

	/**
	 * Trata o nome e, se for o caso, inicia uma nova partida. Evita que o nome esteja vazio
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (telaInserirNome.nomeVazio()) {
			telaInserirNome.mostraMensagem(Mensagem.MSG_NOME_VAZIO);
		} else {
			String nomeJogador = telaInserirNome.getNmJogador().getText();
			telaInserirNome.mostrarNovaPartida(nomeJogador);
		}

	}

	public TelaInserirNome getConteudoJanelaInserirNome() {
		return telaInserirNome;
	}

	public void setConteudoJanelaInserirNome(TelaInserirNome conteudoJanelaInserirNome) {
		this.telaInserirNome = conteudoJanelaInserirNome;
	}

}
