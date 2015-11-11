package view;

import javax.swing.JPanel;

import model.Constante;
import model.Mensagem;
import controller.ControladorNovaPartida;
import controller.EnterPressionadoInserirNomeAction;
import controller.EscAction;
import controller.LimiteCharCampoTexto;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;
import javax.swing.InputMap;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * Tela que lê o nome do jogador que quer jogar uma partida. Este nome será repassado à JanelaDeJogo e, caso não esteja vazio, será então
 * repassado ao objeto Partida dentro do ControladorDePartida para posterior escrita no ranking através do ControladorRanking
 *
 */

public class TelaInserirNome extends JPanel {

	private static final String ENTER_PRESSIONADO = "enter pressionado";
	private static final String ESC_PRESSIONADO = "esc pressionado";

	private JanelaDeJogo janelaDeJogo;
	private ControladorNovaPartida controladorPartida;
	private JTextField nomeJogador;

	public TelaInserirNome(JanelaDeJogo janelaDeJogo, ControladorNovaPartida controladorPartida,
			JTextField nmJogador) {
		super();
		this.janelaDeJogo = janelaDeJogo;
		this.controladorPartida = controladorPartida;
		this.nomeJogador = nmJogador;
		inicializar();
	}

	public TelaInserirNome(JanelaDeJogo janelaDeJogo) {
		super();
		this.janelaDeJogo = janelaDeJogo;
		inicializar();
	}

	public TelaInserirNome() {
		super();
		inicializar();

	}

	private void inicializar() {
		setBackground(Color.DARK_GRAY);
		setLayout(new BorderLayout(0, 0));

		JLabel labelInsiraSeuNome = new JLabel(Mensagem.MSG_INSIRA_NOME);
		labelInsiraSeuNome.setForeground(Color.WHITE);
		labelInsiraSeuNome.setHorizontalAlignment(SwingConstants.CENTER);
		labelInsiraSeuNome.setFont(new Font("Segoe UI", Font.PLAIN, 50));
		add(labelInsiraSeuNome, BorderLayout.NORTH);

		nomeJogador = new JTextField();
		labelInsiraSeuNome.setLabelFor(nomeJogador);
		nomeJogador.setBorder(new LineBorder(Color.BLACK, 100));
		nomeJogador.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		nomeJogador.setBackground(Color.LIGHT_GRAY);
		nomeJogador.setToolTipText("");
		nomeJogador.setHorizontalAlignment(SwingConstants.CENTER);
		add(nomeJogador, BorderLayout.CENTER);
		nomeJogador.setColumns(10);
		nomeJogador.setDocument(new LimiteCharCampoTexto(15));

		JButton botaoIniciarPartida = new JButton(Mensagem.MSG_INICIAR_PARTIDA);
		botaoIniciarPartida.setBounds(new Rectangle(0, 0, 200, 0));
		botaoIniciarPartida.setFont(new Font("Segoe UI", Font.BOLD, 20));
		botaoIniciarPartida.setBackground(Color.RED);
		botaoIniciarPartida.setForeground(Color.WHITE);
		add(botaoIniciarPartida, BorderLayout.SOUTH);
		botaoIniciarPartida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!nomeVazio()) {
					janelaDeJogo.mostrarNovaPartida(nomeJogador.getText());
				} else {
					mostraMensagemNomeVazio();
				}
			}
		});
		
		getInputMap(Constante.QUANDO_JANELA_FOCADA).put(KeyStroke.getKeyStroke(Constante.ESC, 0, false),
				ESC_PRESSIONADO);
		getActionMap().put(ESC_PRESSIONADO, new EscAction(janelaDeJogo));
	
		defineComportamentoTecla(Constante.QUANDO_JANELA_FOCADA, ENTER_PRESSIONADO, janelaDeJogo, Constante.ENTER, false);
	}

	public boolean nomeVazio() {
		return nomeJogador.getText().length() < 1;
	}

	public void mostraMensagemNomeVazio() {
		JOptionPane.showMessageDialog(nomeJogador, Mensagem.MSG_NOME_VAZIO);
	}

	public JanelaDeJogo getJanelaDeJogo() {
		return janelaDeJogo;
	}

	public void setJanelaDeJogo(JanelaDeJogo janelaDeJogo) {
		this.janelaDeJogo = janelaDeJogo;
	}

	public ControladorNovaPartida getControladorPartida() {
		return controladorPartida;
	}

	public void setControladorPartida(ControladorNovaPartida controladorPartida) {
		this.controladorPartida = controladorPartida;
	}

	public JTextField getNmJogador() {
		return nomeJogador;
	}

	public void setNmJogador(JTextField nmJogador) {
		this.nomeJogador = nmJogador;
	}

	private void defineComportamentoTecla(int tipoDeFoco ,String stringDeMapeamento, JanelaDeJogo janelaDeJogo, int tecla, boolean quandoTeclaSolto) {
		getInputMap(tipoDeFoco).put(KeyStroke.getKeyStroke(tecla, 0, quandoTeclaSolto),
				stringDeMapeamento);
		getActionMap().put(stringDeMapeamento, new EnterPressionadoInserirNomeAction(janelaDeJogo, this));
	}
}
