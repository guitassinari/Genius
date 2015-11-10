package view;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import model.Constante;
import model.Cor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.KeyStroke;

import java.awt.Component;
import javax.swing.SwingConstants;

import controller.BotaoPressionadoMenuAction;
import controller.EnterPressionadoInserirNomeAction;

public class TelaMenuPrincipal extends JPanel {

	private static final String BOTAO_VERMELHO_PRESSIONADO = "botao vermelho pressionado";
	private static final String BOTAO_VERMELHO_SOLTO = "botao vermelho solto";
	private static final String BOTAO_AZUL_PRESSIONADO = "botao azulpressionado";
	private static final String BOTAO_AZUL_SOLTO = "botao azul solto";
	private static final String BOTAO_AMARELO_PRESSIONADO = "botao amarelo pressionado";
	private static final String BOTAO_AMARELO_SOLTO = "botao amarelo solto";
	private static final String BOTAO_VERDE_PRESSIONADO = "botao verde pressionado";
	private static final String BOTAO_VERDE_SOLTO = "botao verde solto";
	
	private Canvas botaoAmarelo;
	private Canvas botaoVermelho;
	private Canvas botaoAzul;
	private Canvas botaoVerde;
	
	private JanelaDeJogo janelaDeJogo;
	
	public TelaMenuPrincipal(JanelaDeJogo janelaDeJogo) {
		super();
		this.janelaDeJogo = janelaDeJogo;
		inicializar();
	}

	/**
	 * Create the panel.
	 */
	public TelaMenuPrincipal() {
		inicializar();
	}

	private void inicializar(){
		setBackground(Cor.CINZA_ESCURO);
		setLayout(new BorderLayout(0,0));
		criarBotoes();

		JPanel panel = new JPanel();
		panel.setBackground(Cor.CINZA_ESCURO);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		Label titulo = new Label("GENIUS");
		titulo.setForeground(Cor.BRANCO);
		panel.add(titulo, BorderLayout.CENTER);
		titulo.setAlignment(Label.CENTER);
		titulo.setFont(new Font("Segoe UI", Font.PLAIN, 99));
		
		JLabel lblSair = new JLabel("Sair");
		lblSair.setHorizontalAlignment(SwingConstants.LEFT);
		lblSair.setFont(new Font("Segoe UI", Font.PLAIN, 61));
		lblSair.setForeground(Color.RED);
		panel.add(lblSair, BorderLayout.WEST);
		
		JLabel lblNovaPartida = new JLabel("Nova Partida");
		lblNovaPartida.setForeground(Color.GREEN);
		lblNovaPartida.setFont(new Font("Segoe UI", Font.PLAIN, 61));
		lblNovaPartida.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNovaPartida.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNovaPartida, BorderLayout.SOUTH);
		
		JLabel lblHelp = new JLabel("HELP!");
		lblHelp.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblHelp.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblHelp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHelp.setFont(new Font("Segoe UI", Font.PLAIN, 61));
		lblHelp.setForeground(Cor.AMARELO);
		panel.add(lblHelp, BorderLayout.EAST);
		
		JLabel lblRanking = new JLabel("Ranking");
		lblRanking.setVerticalAlignment(SwingConstants.TOP);
		lblRanking.setHorizontalAlignment(SwingConstants.CENTER);
		lblRanking.setForeground(Cor.AZUL);
		lblRanking.setFont(new Font("Segoe UI", Font.PLAIN, 61));
		panel.add(lblRanking, BorderLayout.NORTH);
	}
	
	private void criarBotoes(){
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
		botaoVermelho = criarBotao(new Rectangle(0, 0, 200, 0), Cor.VERMELHO, Cor.VERMELHO_FOSCO, BorderLayout.WEST, Constante.SETA_ESQUERDA, BOTAO_VERMELHO_PRESSIONADO);	
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
		botaoAmarelo = criarBotao(new Rectangle(0, 0, 200, 0), Cor.AMARELO, Cor.AMARELO_FOSCO, BorderLayout.EAST, Constante.SETA_DIREITA, BOTAO_AMARELO_PRESSIONADO);	
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
		botaoAzul = criarBotao(new Rectangle(0, 0, 0, 200), Cor.VERDE, Cor.VERDE_FOSCO, BorderLayout.SOUTH, Constante.SETA_BAIXO, BOTAO_VERDE_PRESSIONADO);	
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
		botaoAzul = criarBotao(new Rectangle(0, 0, 0, 200), Cor.AZUL, Cor.AZUL_FOSCO, BorderLayout.NORTH, Constante.SETA_CIMA, BOTAO_AZUL_PRESSIONADO);
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	}

	private Canvas criarBotao(Rectangle dimensoes, Color corBotaoPadrao, Color corBotaoPressionado, String posicao, int teclaComportamento, String stringMapeamento){
		Canvas botao = new Canvas();
		botao.setBounds(dimensoes);

		botao.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				botao.setBackground(corBotaoPressionado);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				botao.setBackground(corBotaoPadrao);
			}
		});
		
		botao.setBackground(corBotaoPadrao);
		add(botao, posicao);
		
		defineComportamentoTecla(Constante.QUANDO_JANELA_FOCADA, stringMapeamento, janelaDeJogo, teclaComportamento, false, botao.getBackground());	
		return botao;
	}
	
	public JanelaDeJogo getJanelaDeJogo() {
		return janelaDeJogo;
	}

	public void setJanelaDeJogo(JanelaDeJogo janelaDeJogo) {
		this.janelaDeJogo = janelaDeJogo;
	}
	
	private void defineComportamentoTecla(int tipoDeFoco ,String stringDeMapeamento, JanelaDeJogo janelaDeJogo, int tecla, boolean quandoBotaoSolto, Color cor) {
		getInputMap(tipoDeFoco).put(KeyStroke.getKeyStroke(tecla, 0, quandoBotaoSolto),
				stringDeMapeamento);
		getActionMap().put(stringDeMapeamento, new BotaoPressionadoMenuAction(cor, janelaDeJogo));
	}

}