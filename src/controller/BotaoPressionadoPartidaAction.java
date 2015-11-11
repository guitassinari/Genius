package controller;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Cor;
import view.JanelaDeJogo;
import view.TelaDePartida;

/**
 *
 *	Classe que define o comportamento das teclas do teclado durante uma partida.
 * 
 */
 public class BotaoPressionadoPartidaAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private Canvas botao;
	private ControladorNovaPartida controladorNovaPartida;
	private TelaDePartida telaDePartida;

	public BotaoPressionadoPartidaAction(Canvas botao, ControladorNovaPartida controladorNovaPartida, TelaDePartida telaDePartida) {
		super();
		this.botao = botao;
		this.controladorNovaPartida = controladorNovaPartida;
		this.telaDePartida = telaDePartida;
	}

	/**
	 * 
	 * Testa as cores para saber qual botao foi clicado e, a partir disso, pisca o botao como resposta ao usuario e adiciona a cor à lista
	 * de cores pressionadas pelo usuario nesta jogada.
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Color corBotao = botao.getBackground();
		Color corPiscar = corBotao.equals(Cor.VERMELHO) ? Cor.VERMELHO_FOSCO : 
			corBotao.equals(Cor.VERDE) ? Cor.VERDE_FOSCO :
				corBotao.equals(Cor.AZUL) ? Cor.AZUL_FOSCO :
				Cor.AMARELO_FOSCO;
		
		telaDePartida.piscarBotao(botao, corPiscar);
		controladorNovaPartida.corPressionada(corBotao);
	}

	public Canvas getBotao() {
		return botao;
	}

	public void setBotao(Canvas botao) {
		this.botao = botao;
	}

	public ControladorNovaPartida getControladorNovaPartida() {
		return controladorNovaPartida;
	}

	public void setControladorNovaPartida(ControladorNovaPartida controladorNovaPartida) {
		this.controladorNovaPartida = controladorNovaPartida;
	}
}
