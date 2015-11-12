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
			tocarSom(EfeitoSonoro.SOM_BOTAO_VERMELHO);
			janelaDeJogo.fecharJogo();
		} else if (cor.equals(Cor.AMARELO)){
			tocarSom(EfeitoSonoro.SOM_BOTAO_AMARELO);
			janelaDeJogo.mostrarHelp();
		} else if (cor.equals(Cor.AZUL)){
			tocarSom(EfeitoSonoro.SOM_BOTAO_AZUL);
			janelaDeJogo.mostrarRanking();
		} else if (cor.equals(Cor.VERDE)){
			tocarSom(EfeitoSonoro.SOM_BOTAO_VERDE);
			janelaDeJogo.mostrarInserirNome();
		}
	}
	
	private void tocarSom(String audio){
		try{
	        Clip clip = AudioSystem.getClip();
	        clip.open(AudioSystem.getAudioInputStream(new File(audio)));
	        clip.start();
	        Thread.sleep(300);
	        clip.close();
		 } catch (Exception exc) {
	        exc.printStackTrace(System.out);
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
