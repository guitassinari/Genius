package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.JanelaDeJogo;

/**
 * 
 * Define o comportamento da tecla ESC em todas as telas! Sempre que for pressionado, retorna ao menu principal.
 *
 */

public class EscAction extends AbstractAction {

	private JanelaDeJogo janelaDeJogo;

	public EscAction(JanelaDeJogo janelaDeJogo) {
		super();
		this.janelaDeJogo = janelaDeJogo;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		janelaDeJogo.mostrarMenuPrincipal();
	}

	public JanelaDeJogo getJanelaDeJogo() {
		return janelaDeJogo;
	}

	public void setJanelaDeJogo(JanelaDeJogo janelaDeJogo) {
		this.janelaDeJogo = janelaDeJogo;
	}

}
