package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.Tela;

/**
 * 
 * Define o comportamento da tecla ESC em todas as telas! Sempre que for
 * pressionado, retorna ao menu principal.
 *
 */

public class EscAction extends AbstractAction {

	private Tela tela;

	public EscAction(Tela tela) {
		super();
		this.tela = tela;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		tela.mostrarMenuPrincipal();
	}

	public Tela getTela() {
		return tela;
	}

	public void setTela(Tela tela) {
		this.tela = tela;
	}

}
