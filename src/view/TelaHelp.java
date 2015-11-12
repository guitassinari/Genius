package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;

import controller.EscAction;
import model.Constante;
/**
 * 
 * Tela estatica que auxilia o usuario com informações básicas sobre o jogo e seu funcionamento
 *
 */
public class TelaHelp extends Tela {

	private static final String ESC_PRESSIONADO = "esc pressionado";	
	
	public TelaHelp(JanelaDeJogo janelaDeJogo) {
		super();
		this.janelaDeJogo = janelaDeJogo;
		inicializar();
	}

	public void inicializar() {
		setLayout(null);
		
		JLabel lblMenuPrincipal = new JLabel("Menu Principal:");
		lblMenuPrincipal.setBounds(33, 25, 93, 14);
		add(lblMenuPrincipal);
		
		JLabel lblTelaDePartida = new JLabel("Tela De Partida:");
		lblTelaDePartida.setBounds(33, 84, 93, 14);
		add(lblTelaDePartida);
		
		JTextPane txtpnUtilizeAsSetas = new JTextPane();
		txtpnUtilizeAsSetas.setEditable(false);
		txtpnUtilizeAsSetas.setText("Utilize as setas direcionais do teclado, ou clique nas cores, para acessar a tela correspondente.");
		txtpnUtilizeAsSetas.setBounds(124, 25, 302, 54);
		add(txtpnUtilizeAsSetas);
		
		JTextPane txtpnCliqueNoBotao = new JTextPane();
		txtpnCliqueNoBotao.setEditable(false);
		txtpnCliqueNoBotao.setText("Clique no botao COME\u00C7AR para iniciar uma nova partida. Utilize as setas direcionais do teclado, ou clique nas cores para jogar.");
		txtpnCliqueNoBotao.setBounds(124, 84, 302, 54);
		add(txtpnCliqueNoBotao);
		
		JTextPane txtpnEmQualquerTela = new JTextPane();
		txtpnEmQualquerTela.setEditable(false);
		txtpnEmQualquerTela.setText("Em qualquer tela, pressione ESC no teclado para retornar ao menu principal.");
		txtpnEmQualquerTela.setBounds(33, 200, 393, 20);
		add(txtpnEmQualquerTela);
		
		JTextPane txtpnORankingS = new JTextPane();
		txtpnORankingS.setEditable(false);
		txtpnORankingS.setText("O ranking s\u00F3 leva em considera\u00E7\u00E3o as cinco melhores pontua\u00E7\u00F5es!");
		txtpnORankingS.setBounds(33, 232, 393, 20);
		add(txtpnORankingS);

	}
}
