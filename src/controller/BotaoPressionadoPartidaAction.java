package controller;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.AbstractAction;

import model.Cor;
import model.EfeitoSonoro;
import view.TelaDePartida;

/**
 *
 *	Classe que define o comportamento das teclas do teclado durante uma partida.
 * 
 */
 public class BotaoPressionadoPartidaAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private Canvas botao;
	private ControladorPartida controladorPartida;
	private TelaDePartida telaDePartida;

	public BotaoPressionadoPartidaAction(Canvas botao, ControladorPartida controladorPartida, TelaDePartida telaDePartida) {
		super();
		this.botao = botao;
		this.controladorPartida = controladorPartida;
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
		Color corPiscar = Color.white;
		TocadorDeAudio tocadorDeAudio = new TocadorDeAudio();
		String caminhoDoAudio;
		
		/*As cores *_BRILHANTE são testadas para os casos em que o usuário pressionou rapidamente os botões e 
		 * acaba trazendo a cor enquanto o mesmo está piscando
		 */
		if(corBotao.equals(Cor.AMARELO) || corBotao.equals(Cor.AMARELO_BRILHANTE)){
			corPiscar = Cor.AMARELO_BRILHANTE;
			corBotao = Cor.AMARELO;
			caminhoDoAudio = EfeitoSonoro.SOM_BOTAO_AMARELO;
		} else if(corBotao.equals(Cor.AZUL) || corBotao.equals(Cor.AZUL_BRILHANTE)){
			corPiscar = Cor.AZUL_BRILHANTE;
			corBotao = Cor.AZUL;
			caminhoDoAudio = EfeitoSonoro.SOM_BOTAO_AZUL;
		} else if(corBotao.equals(Cor.VERDE) || corBotao.equals(Cor.VERDE_BRILHANTE)){
			corPiscar = Cor.VERDE_BRILHANTE;
			corBotao = Cor.VERDE;
			caminhoDoAudio = EfeitoSonoro.SOM_BOTAO_VERDE;
		} else {
			corPiscar = Cor.VERMELHO_BRILHANTE;
			corBotao = Cor.VERMELHO;
			caminhoDoAudio = EfeitoSonoro.SOM_BOTAO_VERMELHO;
		}

		tocadorDeAudio.setCaminhoDoAudio(caminhoDoAudio);
		Thread threadDeAudio = new Thread(tocadorDeAudio);
		threadDeAudio.run();
		
		telaDePartida.piscarBotao(botao, corPiscar);
		
		controladorPartida.corPressionada(corBotao);
	}

	public Canvas getBotao() {
		return botao;
	}

	public void setBotao(Canvas botao) {
		this.botao = botao;
	}

	public ControladorPartida getControladorNovaPartida() {
		return controladorPartida;
	}

	public void setControladorNovaPartida(ControladorPartida controladorNovaPartida) {
		this.controladorPartida = controladorNovaPartida;
	}
}
