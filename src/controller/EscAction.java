package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.JanelaDeJogo;

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
