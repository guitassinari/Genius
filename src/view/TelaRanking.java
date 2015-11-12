package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;

import controller.ControladorRanking;
import controller.EscAction;
import model.Constante;
import model.Cor;
import model.Mensagem;
import model.Partida;

public class TelaRanking extends Tela {

	private static final String ESC_PRESSIONADO = "esc pressionado";
	private ControladorRanking controladorRanking;

	public TelaRanking(JanelaDeJogo janelaDeJogo) {
		super();
		this.janelaDeJogo = janelaDeJogo;
		this.controladorRanking = new ControladorRanking();
		inicializar();
	}

	public void inicializar() {
		setLayout(new BorderLayout(0, 0));
		
		List<Partida> ranking = controladorRanking.getRanking();
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setBackground(Cor.CINZA_ESCURO);
		panel.setLayout(null);
		
		
		if(ranking != null && !ranking.isEmpty()){
			int deslocamentoVertical = 67;
			int contadorLimite = 0;
			for(Partida partida : ranking){
				if(contadorLimite >= Constante.MAX_RANKING){
					break;
				} else {
					contadorLimite++;
				}
				
				JLabel label = new JLabel( (contadorLimite+1) + "\u00BA");
				label.setBounds(112, deslocamentoVertical, 46, 50);
				label.setFont(new Font("Segoe UI", Font.PLAIN, 25));
				label.setForeground(Color.WHITE);
				panel.add(label);
				
				JTextPane textPane = new JTextPane();
				textPane.setBounds(140, deslocamentoVertical,800, 50);
				textPane.setText(partida.getNmJogador() + " : " + partida.getNrPontos() + " pontos " + partida.getDtPartida().toString());
				textPane.setFont(new Font("Segoe UI", Font.PLAIN, 25));
				textPane.setEditable(false);
				panel.add(textPane);
				
				deslocamentoVertical += 60;
			} 
		} else {
			mostraMensagem(Mensagem.MSG_RANKING_VAZIO);
		}
		

	}

	public JanelaDeJogo getJanelaDeJogo() {
		return janelaDeJogo;
	}

	public void setJanelaDeJogo(JanelaDeJogo janelaDeJogo) {
		this.janelaDeJogo = janelaDeJogo;
	}

	public ControladorRanking getControladorRanking() {
		return controladorRanking;
	}

	public void setControladorRanking(ControladorRanking controladorRanking) {
		this.controladorRanking = controladorRanking;
	}

}
