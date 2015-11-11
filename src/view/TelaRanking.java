package view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;

import controller.ControladorRanking;
import controller.EscAction;
import model.Constante;
import model.Partida;

public class TelaRanking extends JPanel {

	private static final String ESC_PRESSIONADO = "esc pressionado";
	private JanelaDeJogo janelaDeJogo;
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
		panel.setLayout(null);

		JLabel label = new JLabel("1\u00BA");
		label.setBounds(112, 67, 46, 14);
		panel.add(label);

		JLabel label_1 = new JLabel("2\u00BA");
		label_1.setBounds(112, 92, 46, 14);
		panel.add(label_1);

		JLabel label_2 = new JLabel("3\u00BA");
		label_2.setBounds(112, 119, 46, 14);
		panel.add(label_2);

		JLabel label_3 = new JLabel("4\u00BA");
		label_3.setBounds(112, 144, 46, 14);
		panel.add(label_3);

		JLabel label_4 = new JLabel("5\u00BA");
		label_4.setBounds(112, 169, 46, 14);
		panel.add(label_4);

		if(!ranking.isEmpty()){
			int deslocamentoVertical = 67;
			for(Partida partida : ranking){
				JTextPane textPane = new JTextPane();
				textPane.setBounds(140, deslocamentoVertical, 204, 20);
				textPane.setText(partida.getNmJogador() + " : " + partida.getNrPontos() + " pontos " + partida.getDtPartida().toString());
				panel.add(textPane);
				
				deslocamentoVertical += 25;
			}
		}
		
		getInputMap(Constante.QUANDO_JANELA_FOCADA).put(KeyStroke.getKeyStroke(Constante.ESC, 0, false),
				ESC_PRESSIONADO);
		getActionMap().put(ESC_PRESSIONADO, new EscAction(janelaDeJogo));

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
