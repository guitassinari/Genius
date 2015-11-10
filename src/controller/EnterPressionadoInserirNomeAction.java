package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.TelaInserirNome;
import view.JanelaDeJogo;

public class EnterPressionadoInserirNomeAction extends AbstractAction {

	private JanelaDeJogo janelaDeJogo;
	private TelaInserirNome conteudoJanelaInserirNome;

	public EnterPressionadoInserirNomeAction(JanelaDeJogo janelaDeJogo, TelaInserirNome conteudoJanelaInserirNome) {
		super();
		this.janelaDeJogo = janelaDeJogo;
		this.conteudoJanelaInserirNome = conteudoJanelaInserirNome;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (!conteudoJanelaInserirNome.nomeVazio()) {
			String nomeJogador = conteudoJanelaInserirNome.getNmJogador().getText();
			janelaDeJogo.mostrarNovaPartida(nomeJogador);
		} else {
			conteudoJanelaInserirNome.mostraMensagemNomeVazio();
		}

	}

	public JanelaDeJogo getJanelaDeJogo() {
		return janelaDeJogo;
	}

	public void setJanelaDeJogo(JanelaDeJogo janelaDeJogo) {
		this.janelaDeJogo = janelaDeJogo;
	}

	public TelaInserirNome getConteudoJanelaInserirNome() {
		return conteudoJanelaInserirNome;
	}

	public void setConteudoJanelaInserirNome(TelaInserirNome conteudoJanelaInserirNome) {
		this.conteudoJanelaInserirNome = conteudoJanelaInserirNome;
	}

}
