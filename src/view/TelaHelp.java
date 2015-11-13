package view;

import javax.swing.JLabel;
import javax.swing.JTextPane;

import model.Cor;
import java.awt.Font;
import java.awt.Color;

/**
 * 
 * Tela estatica que auxilia o usuario com informações básicas sobre o jogo e seu funcionamento
 *
 */
public class TelaHelp extends Tela {

	
	public TelaHelp(JanelaDeJogo janelaDeJogo) {
		super();
		this.janelaDeJogo = janelaDeJogo;
		inicializar();
	}

	public void inicializar() {
		setLayout(null);
		setBackground(Cor.CINZA_ESCURO);
		
		JLabel lblMenuPrincipal = new JLabel("Menu Principal:");
		lblMenuPrincipal.setForeground(Color.WHITE);
		lblMenuPrincipal.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblMenuPrincipal.setBounds(33, 25, 228, 33);
		add(lblMenuPrincipal);
		
		JLabel lblTelaDePartida = new JLabel("Tela De Partida:");
		lblTelaDePartida.setForeground(Color.WHITE);
		lblTelaDePartida.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		lblTelaDePartida.setBounds(33, 123, 228, 33);
		add(lblTelaDePartida);
		
		JTextPane txtpnUtilizeAsSetas = new JTextPane();
		txtpnUtilizeAsSetas.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 17));
		txtpnUtilizeAsSetas.setEditable(false);
		txtpnUtilizeAsSetas.setText("Utilize as setas direcionais do teclado, ou clique nas cores, para acessar a tela correspondente.");
		txtpnUtilizeAsSetas.setBounds(278, 25, 340, 63);
		add(txtpnUtilizeAsSetas);
		
		JTextPane txtpnCliqueNoBotao = new JTextPane();
		txtpnCliqueNoBotao.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 17));
		txtpnCliqueNoBotao.setEditable(false);
		txtpnCliqueNoBotao.setText("Clique no botao COME\u00C7AR para iniciar uma nova partida. Utilize as setas direcionais do teclado, ou clique nas cores para jogar.");
		txtpnCliqueNoBotao.setBounds(278, 123, 340, 94);
		add(txtpnCliqueNoBotao);
		
		JTextPane txtpnEmQualquerTela = new JTextPane();
		txtpnEmQualquerTela.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 17));
		txtpnEmQualquerTela.setEditable(false);
		txtpnEmQualquerTela.setText("Em qualquer tela, pressione ESC no teclado para retornar ao menu principal.");
		txtpnEmQualquerTela.setBounds(33, 265, 585, 57);
		add(txtpnEmQualquerTela);
		
		JTextPane txtpnORankingS = new JTextPane();
		txtpnORankingS.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 17));
		txtpnORankingS.setEditable(false);
		txtpnORankingS.setText("O ranking s\u00F3 leva em considera\u00E7\u00E3o as cinco melhores pontua\u00E7\u00F5es!");
		txtpnORankingS.setBounds(33, 333, 585, 63);
		add(txtpnORankingS);

	}
}
