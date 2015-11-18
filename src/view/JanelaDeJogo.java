package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.ControladorPartida;
import controller.Principal;
import model.Mensagem;
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

	private void inicializar() {
		frame = new JFrame();
		limparConteudoJanela();
		frame.setTitle(Mensagem.MSG_TITULO);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		abrirJanela();
		mostrarMenuPrincipal();
	}

	private void abrirJanela() {
		frame.setVisible(true);
	}

	public void mostrarMenuPrincipal() {
		limparConteudoJanela();
		frame.setContentPane(new TelaMenuPrincipal(this));
		redesenharConteudoJanela();
		JOptionPane.showMessageDialog(frame.getContentPane(), Mensagem.MSG_MENU_INICIAL);
	}

	/**
	 * Abre a tela de partida
	 * 
	 * @param nmJogador nome do jogador que está jogando atualmente. Recebe de TelaInserirNome e seta num objeto Partida dentro de um ControladorPartida
	 */
	public void mostrarNovaPartida(String nomeJogador) {
		limparConteudoJanela();
		frame.setContentPane(new TelaDePartida(this, nomeJogador));
		redesenharConteudoJanela();
		JOptionPane.showMessageDialog(frame.getContentPane(), Mensagem.MSG_INSTRUCOES_PARTIDA);
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
		JOptionPane.showMessageDialog(frame.getContentPane(), Mensagem.MSG_TELA_INSERIR_NOME);
	}

	public void mostrarRanking(){
		limparConteudoJanela();
		frame.setContentPane(new TelaRanking(this));
		redesenharConteudoJanela();
	}
	
	private void limparConteudoJanela() {
		frame.getContentPane().removeAll();
		frame.validate();
	}

	private void redesenharConteudoJanela() {
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
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
