package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ControladorNovaPartida;
import controller.Principal;
import model.Partida;

/**
 * 
 * Principal Classe do jogo. Representa a janela/viewport onde se encontra o jogo. 
 * Nela são mostradas todas as telas, como o menu, partida, ranking e help.
 *
 */

public class JanelaDeJogo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaDeJogo window = new JanelaDeJogo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaDeJogo() {
		inicializar();
	}

	public void inicializar() {
		frame = new JFrame();
		limparConteudoJanela();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		abrirJanela();
		mostrarMenuPrincipal();
	}

	public void abrirJanela() {
		frame.setVisible(true);
	}

	public void mostrarMenuPrincipal() {
		limparConteudoJanela();
		frame.setContentPane(new TelaMenuPrincipal(this));
		redesenharConteudoJanela();
	}

	/**
	 * Abre a tela de partida
	 * 
	 * @param nmJogador nome do jogador que está jogando atualmente. Recebe de TelaInserirNome e seta num objeto Partida dentro de um ControladorPartida
	 */
	public void mostrarNovaPartida(String nmJogador) {
		limparConteudoJanela();
		Partida partida = new Partida(nmJogador);
		ControladorNovaPartida controladorNovaPartida = new ControladorNovaPartida(partida);
		frame.setContentPane(new TelaDePartida(this, controladorNovaPartida));
		redesenharConteudoJanela();
	}
	
	public void mostrarHelp(){
		limparConteudoJanela();
		frame.setContentPane(new TelaHelp(this));
		redesenharConteudoJanela();
	}

	public void mostrarInserirNome() {
		limparConteudoJanela();
		frame.setContentPane(new TelaInserirNome(this));
		redesenharConteudoJanela();
	}

	public void mostrarRanking(){
		limparConteudoJanela();
		frame.setContentPane(new TelaRanking(this));
		redesenharConteudoJanela();
	}
	
	public void limparConteudoJanela() {
		frame.getContentPane().removeAll();
	}

	public void redesenharConteudoJanela() {
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
	}
	
	public void desbloquearJanela(){
		frame.getGlassPane().setVisible(false);
	}
	
	public void bloquearJanela(){
		frame.getGlassPane().setVisible(true);
	}
	
	public void fecharJogo() {
		frame.dispose();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
