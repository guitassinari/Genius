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
		Color corPiscar = Color.white;
		String audio;
		
		
		if(corBotao.equals(Cor.AMARELO)){
			corPiscar = Cor.AMARELO_BRILHANTE;
			audio = EfeitoSonoro.SOM_BOTAO_AMARELO;
		} else if(corBotao.equals(Cor.AZUL)){
			corPiscar = Cor.AZUL_BRILHANTE;
			audio = EfeitoSonoro.SOM_BOTAO_AZUL;
		} else if(corBotao.equals(Cor.VERDE)){
			audio = EfeitoSonoro.SOM_BOTAO_VERDE;
			corPiscar = Cor.VERDE_BRILHANTE;
		} else {
			corPiscar = Cor.VERMELHO_BRILHANTE;
			audio = EfeitoSonoro.SOM_BOTAO_VERMELHO;
		}

		 try{
		        Clip clip = AudioSystem.getClip();
		        clip.open(AudioSystem.getAudioInputStream(new File(audio)));
		        clip.start();
		        Thread.sleep(300);
		        clip.close();
			 } catch (Exception exc) {
		        exc.printStackTrace(System.out);
			 }
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
