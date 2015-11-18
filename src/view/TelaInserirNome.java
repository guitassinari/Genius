package view;

import javax.swing.JPanel;

import model.Constante;
import model.Mensagem;
import controller.EnterPressionadoInserirNomeAction;
import controller.LimiteCharCampoTexto;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * Tela que l� o nome do jogador que quer jogar uma partida. Este nome ser� repassado � JanelaDeJogo e, caso n�o esteja vazio, ser� ent�o
 * repassado ao objeto Partida dentro do ControladorDePartida para posterior escrita no ranking atrav�s do ControladorRanking
 *
 */

public class TelaInserirNome extends Tela {

	private static final String ENTER_PRESSIONADO = "enter pressionado";
		private JTextField nomeJogador;

	public TelaInserirNome(JanelaDeJogo janelaDeJogo,
			JTextField nmJogador) {
		super();
		this.janelaDeJogo = janelaDeJogo;
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

		//Titulo da tela
		JLabel labelInsiraSeuNome = new JLabel(Mensagem.MSG_INSIRA_NOME);
		labelInsiraSeuNome.setForeground(Color.WHITE);
		labelInsiraSeuNome.setHorizontalAlignment(SwingConstants.CENTER);
		labelInsiraSeuNome.setFont(new Font("Segoe UI", Font.PLAIN, 50));
		add(labelInsiraSeuNome, BorderLayout.NORTH);

		//Campo para inser��o do nome do jogador
		nomeJogador = new JTextField();
		labelInsiraSeuNome.setLabelFor(nomeJogador);
		nomeJogador.setBorder(new LineBorder(Color.BLACK, 100));
		nomeJogador.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		nomeJogador.setBackground(Color.LIGHT_GRAY);
		nomeJogador.setToolTipText("");
		nomeJogador.setHorizontalAlignment(SwingConstants.CENTER);
		add(nomeJogador, BorderLayout.CENTER);
		nomeJogador.setColumns(10);
		//Define o limite de characteres do campo de nome
		nomeJogador.setDocument(new LimiteCharCampoTexto(Constante.MAX_CHAR_NOME));

		//Botao inferior para come�ar nova partida.
		JButton botaoIniciarPartida = new JButton(Mensagem.MSG_INICIAR_PARTIDA);
		botaoIniciarPartida.setBounds(new Rectangle(0, 0, 200, 0));
		botaoIniciarPartida.setFont(new Font("Segoe UI", Font.BOLD, 20));
		botaoIniciarPartida.setBackground(Color.RED);
		botaoIniciarPartida.setForeground(Color.WHITE);
		add(botaoIniciarPartida, BorderLayout.SOUTH);
		//Comportamento do mouse
		botaoIniciarPartida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!nomeVazio()) {
					janelaDeJogo.mostrarNovaPartida(nomeJogador.getText());
				} else {
					mostraMensagem(Mensagem.MSG_NOME_VAZIO);
				}
			}
		});
		
		//Comportamento da tecla Enter
		defineComportamentoTecla(Constante.QUANDO_JANELA_FOCADA, ENTER_PRESSIONADO, janelaDeJogo, Constante.ENTER, false);
	}

	public boolean nomeVazio() {
		return nomeJogador.getText().trim().isEmpty();
	}


	public JanelaDeJogo getJanelaDeJogo() {
		return janelaDeJogo;
	}

	public void setJanelaDeJogo(JanelaDeJogo janelaDeJogo) {
		this.janelaDeJogo = janelaDeJogo;
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
		getActionMap().put(stringDeMapeamento, new EnterPressionadoInserirNomeAction(this));
	}
}
