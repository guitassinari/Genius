package view;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import controller.EscAction;
import model.Constante;

public class Tela extends JPanel {

	private static final String ESC_PRESSIONADO = "esc pressionado";
	
	protected JanelaDeJogo janelaDeJogo;

	public Tela(){
		getInputMap(Constante.QUANDO_JANELA_FOCADA).put(KeyStroke.getKeyStroke(Constante.ESC, 0, false),
				ESC_PRESSIONADO);
		getActionMap().put(ESC_PRESSIONADO, new EscAction(this));
	}
	
	public void mostraMensagem(String mensagem){
		JOptionPane.showMessageDialog(this, mensagem);
	}
	
	public void fecharJogo(){
		janelaDeJogo.fecharJogo();
	}
	
	public void mostrarMenuPrincipal(){
		janelaDeJogo.mostrarMenuPrincipal();
	}
	
	public void mostrarNovaPartida(String nomeJogador){
		janelaDeJogo.mostrarNovaPartida(nomeJogador);
	}
	
	public void mostrarHelp(){
		janelaDeJogo.mostrarHelp();
	}
	
	public void mostrarRanking(){
		janelaDeJogo.mostrarRanking();
	}
	
	public void mostrarInserirNome(){
		janelaDeJogo.mostrarInserirNome();
	}
	
	public JanelaDeJogo getJanelaDeJogo() {
		return janelaDeJogo;
	}

	public void setJanelaDeJogo(JanelaDeJogo janelaDeJogo) {
		this.janelaDeJogo = janelaDeJogo;
	}
}
