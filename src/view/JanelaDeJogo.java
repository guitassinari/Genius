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
		criarPainelDeVidro();
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

	public void mostrarNovaPartida(String nmJogador) {
		limparConteudoJanela();
		Partida partida = new Partida(nmJogador);
		ControladorNovaPartida controladorNovaPartida = new ControladorNovaPartida(partida);
		frame.setContentPane(new TelaDePartida(this));
		redesenharConteudoJanela();
	}

	public void mostrarInserirNome() {
		limparConteudoJanela();
		frame.setContentPane(new TelaInserirNome(this));
		redesenharConteudoJanela();
	}

	public void limparConteudoJanela() {
		frame.getContentPane().removeAll();
	}

	public void redesenharConteudoJanela() {
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
	}
	
	private void criarPainelDeVidro(){
		JPanel glass = new JPanel(new GridLayout(0, 1));
		JLabel padding = new JLabel();
		glass.setBackground(new Color(0,0,0,0));
	    glass.add(padding);
	    glass.addMouseListener(new MouseAdapter() {});
	    glass.addMouseMotionListener(new MouseMotionAdapter() {});
	    glass.addKeyListener(new KeyAdapter() {});
	    glass.setFocusCycleRoot(true);  // 1.4
	   // padding.setNextFocusableComponent(padding); 
	    frame.setGlassPane(glass);
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
