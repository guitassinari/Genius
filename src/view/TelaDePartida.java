package view;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingWorker;

import controller.BotaoPressionadoPartidaAction;
import controller.ControladorPartida;
import controller.TocadorDeAudio;
import model.Constante;
import model.Cor;
import model.EfeitoSonoro;
import model.Mensagem;
/**
 * 
 * Tela de execução de jogo. Aqui é feita a real interação com o jogador e a partida é realizada. Nenhuma real manipulação de objetos
 * ou operações complexas são realizadas aqui. O objetivo da classe é prover respostas e interações VISUAIS com o usuario. Outras operações
 * são realizadas no ControladorDePartida
 * 
 * @see ControladorDePartida
 *
 */
public class TelaDePartida extends Tela {

	
	/**
	 * Strings de mapeamento utilizadas para o controle das teclas do teclado
	 */
	private static final String BOTAO_VERMELHO_PRESSIONADO = "botao vermelho pressionado";
	private static final String BOTAO_AZUL_PRESSIONADO = "botao azulpressionado";
	private static final String BOTAO_AMARELO_PRESSIONADO = "botao amarelo pressionado";
	private static final String BOTAO_VERDE_PRESSIONADO = "botao verde pressionado";
	

	private ControladorPartida controladorPartida;
	private Canvas botaoAzul;
	private Canvas botaoAmarelo;
	private Canvas botaoVermelho;
	private Canvas botaoVerde;

	// ----------------------------------------------------------- CONSTRUTORES ---------------------------------------------------
	
	public TelaDePartida() {
		super();
		inicializar();
	}

	public TelaDePartida(JanelaDeJogo janelaDeJogo, String nomeJogador) {
		super();
		this.janelaDeJogo = janelaDeJogo;
		this.controladorPartida = new ControladorPartida(nomeJogador, this);
		inicializar();
	}
	


	// ----------------------------------------------------------- MÉTODOS GERAIS ------------------------------------------------

	private void inicializar() {
		
		if(controladorPartida == null){
			controladorPartida = new ControladorPartida(this);
		} else {
			controladorPartida.setConteudoJanelaNovaPartida(this);
		}
		
		setBackground(Cor.CINZA_ESCURO);
		setLayout(new BorderLayout(0, 0));
		criarBotoes();
		
		JButton botaoComecar = new JButton("COME\u00C7AR!");
		botaoComecar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					controladorPartida.comecarPartida();
			}
		});
		botaoComecar.setFont(new Font("Segoe UI", Font.PLAIN, 36));
		botaoComecar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(botaoComecar, BorderLayout.CENTER);
		
	}
	
	private void criarBotoes() {
		// --------------------------------------------------------------------------------------------------------------
		botaoVermelho = criarBotao(new Rectangle(0, 0, 200, 0), Cor.VERMELHO, Cor.VERMELHO_BRILHANTE, BorderLayout.WEST,
				Constante.SETA_ESQUERDA, BOTAO_VERMELHO_PRESSIONADO);
		// -------------------------------------------------------------------------------------------------------------------
		botaoAmarelo = criarBotao(new Rectangle(0, 0, 200, 0), Cor.AMARELO, Cor.AMARELO_BRILHANTE, BorderLayout.EAST,
				Constante.SETA_DIREITA, BOTAO_AMARELO_PRESSIONADO);
		// ----------------------------------------------------------------------------------------------------------------------
		botaoVerde = criarBotao(new Rectangle(0, 0, 0, 200), Cor.VERDE, Cor.VERDE_BRILHANTE, BorderLayout.SOUTH,
				Constante.SETA_BAIXO, BOTAO_VERDE_PRESSIONADO);
		// -------------------------------------------------------------------------------------------------------------------------------------------------
		botaoAzul = criarBotao(new Rectangle(0, 0, 0, 200), Cor.AZUL, Cor.AZUL_BRILHANTE, BorderLayout.NORTH,
				Constante.SETA_CIMA, BOTAO_AZUL_PRESSIONADO);
		// --------------------------------------------------------------------------------------------------------------------------
	}

	/**
	 * 
	 * cria e adiciona um botao à tela, com cor e comportamentos
	 * 
	 * @param dimensoes tamanho do botao, num objeto Rectangle respectivamente: deslocamento x, deslocamento y, comprimento, altura.
	 * @param corBotaoPadrao cor padrao que o botao deve apresentar quando ocioso
	 * @param corBotaoPressionado cor que o botao deve apresentar como resposta ao usuario quando for pressionada
	 * @param posicao Posicao do botao no layout BorderLayout : NORTE, SUL, LESTE, OESTE ou CENTRO
	 * @param teclaComportamento tecla a ser pressionada para executar a acao do botao
	 * @param stringMapeamento string de mapeamento com a Action
	 * @param action Classe que deve ser executada quando o botao for clicado
	 * @return Referencia ao botao criado
	 */
	private Canvas criarBotao(Rectangle dimensoes, Color corBotaoPadrao, Color corBotaoPressionado, String posicao,
			int teclaComportamento, String stringMapeamento) {
		Canvas botao = new Canvas();
		botao.setBounds(dimensoes);

		botao.addMouseListener(new MouseAdapter() {
			// Comportamento com mouse pressionado
			@Override
			public void mousePressed(MouseEvent arg0) {
				botao.setBackground(corBotaoPressionado);
				
			}

			// Comportamento quando mouse for solto
			@Override
			public void mouseReleased(MouseEvent e) {
				botao.setBackground(corBotaoPadrao);
				
				TocadorDeAudio tocadorDeAudio = new TocadorDeAudio();
				String caminhoDoAudio;
				
				if(corBotaoPadrao.equals(Cor.AMARELO)){
					janelaDeJogo.mostrarHelp();
					caminhoDoAudio = EfeitoSonoro.SOM_BOTAO_AMARELO;
				} else if(corBotaoPadrao.equals(Cor.AZUL)){
					janelaDeJogo.mostrarRanking();
					caminhoDoAudio = EfeitoSonoro.SOM_BOTAO_AZUL;
				} else if(corBotaoPadrao.equals(Cor.VERDE)){
					caminhoDoAudio = EfeitoSonoro.SOM_BOTAO_VERDE;
					janelaDeJogo.mostrarInserirNome();
				} else {
					caminhoDoAudio = EfeitoSonoro.SOM_BOTAO_VERMELHO;
					janelaDeJogo.fecharJogo();
				}
				
				
				tocadorDeAudio.setCaminhoDoAudio(caminhoDoAudio);
				Thread threadDeAudio = new Thread(tocadorDeAudio);
				threadDeAudio.run();
				
				controladorPartida.corPressionada(corBotaoPadrao);
			}
		});

		//Comportamento das teclas do teclado
		BotaoPressionadoPartidaAction action = new BotaoPressionadoPartidaAction(botao, controladorPartida, this);
		
		getInputMap(Constante.QUANDO_JANELA_FOCADA).put(KeyStroke.getKeyStroke(teclaComportamento, 0, false),
				stringMapeamento);
		getActionMap().put(stringMapeamento, action);

		botao.setBackground(corBotaoPadrao);
		add(botao, posicao);
		return botao;
	}

	public void inicializarCoresBotoes() {
		botaoAmarelo.setBackground(Cor.AMARELO);
		botaoVerde.setBackground(Cor.VERDE);
		botaoVermelho.setBackground(Cor.VERMELHO);
		botaoAzul.setBackground(Cor.AZUL);
	}
	
	/**
	 * Pisca o botao (Canvas) com a cor passada por parametro
	 * 
	 * @param botao botao a ser piscado
	 * @param cor cor para se piscar o botao
	 */
	public void piscarBotao(Canvas botao, Color cor) {

		SwingWorker worker = new SwingWorker() {

			@Override
			protected Void doInBackground() throws Exception {
				
				Color corAnterior = botao.getBackground();
				
				botao.setBackground(cor);
				try {
					Thread.sleep(200);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
				botao.setBackground(corAnterior);
				
				return null;
			}

		};
		worker.execute();
	}

	/**
	 * Recebe uma lista de cores e pisca os botoes que possuem estas respectivas cores na ordem da lista
	 * 
	 * @param coresBotoes lista com as cores a serem piscadas
	 */
	public void piscarSequenciaBotoes(List<Color> coresBotoes) {

		SwingWorker worker = new SwingWorker() {

			@Override
			protected Void doInBackground() throws Exception {
					
				for (Color corBotao : coresBotoes) {
					
					inicializarCoresBotoes();
					try {
						Thread.sleep(150);
					} catch (InterruptedException ex) {
						Thread.currentThread().interrupt();
					}
					
					TocadorDeAudio tocadorDeAudio = new TocadorDeAudio();
					String caminhoDoAudio;
					
					
					if (corBotao.equals(botaoAmarelo.getBackground())) {
						botaoAmarelo.setBackground(Cor.AMARELO_BRILHANTE);
						caminhoDoAudio = EfeitoSonoro.SOM_BOTAO_AMARELO;

					} else if (corBotao.equals(botaoVerde.getBackground())) {
						botaoVerde.setBackground(Cor.VERDE_BRILHANTE);
						caminhoDoAudio = EfeitoSonoro.SOM_BOTAO_VERDE;

					} else if (corBotao.equals(botaoAzul.getBackground())) {
						botaoAzul.setBackground(Cor.AZUL_BRILHANTE);
						caminhoDoAudio = EfeitoSonoro.SOM_BOTAO_AZUL;

					} else {
						botaoVermelho.setBackground(Cor.VERMELHO_BRILHANTE);
						caminhoDoAudio = EfeitoSonoro.SOM_BOTAO_VERMELHO;

					}
						
					tocadorDeAudio.setCaminhoDoAudio(caminhoDoAudio);
					Thread threadDeAudio = new Thread(tocadorDeAudio);
					threadDeAudio.run();
					
					try {
						Thread.sleep(700);
					} catch (InterruptedException ex) {
						Thread.currentThread().interrupt();
					}
				}
				
				inicializarCoresBotoes();
				
				return null;
			}

		};
		worker.execute();
	}

	// ----------------------------------------------------------- GETTERS E SETTERS ----------------------------------------------

	public JanelaDeJogo getJanelaDeJogo() {
		return janelaDeJogo;
	}

	public void setJanelaDeJogo(JanelaDeJogo janelaDeJogo) {
		this.janelaDeJogo = janelaDeJogo;
	}

	public ControladorPartida getControladorPartida() {
		return controladorPartida;
	}

	public void setControladorPartida(ControladorPartida controladorPartida) {
		this.controladorPartida = controladorPartida;
	}


}
