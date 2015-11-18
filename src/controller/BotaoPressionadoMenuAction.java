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
import view.TelaMenuPrincipal;

/**
 * 
 * Classe que define o comportamento de teclas do teclado ao serem pressionadas 
 * 
 */
public class BotaoPressionadoMenuAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private Color cor;
	private TelaMenuPrincipal telaMenuPrincipal;

	public BotaoPressionadoMenuAction(Color cor, TelaMenuPrincipal telaMenuPrincipal) {
		super();
		this.cor = cor;
		this.telaMenuPrincipal = telaMenuPrincipal;
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
		TocadorDeAudio tocadorDeAudio = new TocadorDeAudio();
		
		if(cor.equals(Cor.VERMELHO)){
			tocadorDeAudio.setCaminhoDoAudio(EfeitoSonoro.SOM_BOTAO_VERMELHO);
			executarThreadAudio(tocadorDeAudio);
			telaMenuPrincipal.fecharJogo();
		} else if (cor.equals(Cor.AMARELO)){
			tocadorDeAudio.setCaminhoDoAudio(EfeitoSonoro.SOM_BOTAO_AMARELO);
			executarThreadAudio(tocadorDeAudio);
			telaMenuPrincipal.mostrarHelp();
		} else if (cor.equals(Cor.AZUL)){
			tocadorDeAudio.setCaminhoDoAudio(EfeitoSonoro.SOM_BOTAO_AZUL);
			executarThreadAudio(tocadorDeAudio);
			telaMenuPrincipal.mostrarRanking();
		} else if (cor.equals(Cor.VERDE)){
			tocadorDeAudio.setCaminhoDoAudio(EfeitoSonoro.SOM_BOTAO_VERDE);
			executarThreadAudio(tocadorDeAudio);
			telaMenuPrincipal.mostrarInserirNome();
		}
	}
	
	private void executarThreadAudio(TocadorDeAudio tocadorDeAudio){
		Thread threadDeAudio = new Thread(tocadorDeAudio);
		threadDeAudio.run();
	}

	public Color getCor() {
		return cor;
	}

	public void setCor(Color cor) {
		this.cor = cor;
	}

	public TelaMenuPrincipal getTelaMenuPrincipal() {
		return telaMenuPrincipal;
	}

	public void setTelaMenuPrincipal(TelaMenuPrincipal telaMenuPrincipal) {
		this.telaMenuPrincipal = telaMenuPrincipal;
	}

}
