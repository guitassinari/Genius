package model;

import java.awt.event.KeyEvent;

import javax.swing.JComponent;

/**
 * 
 * Classe com diversas constantes int. Em grande maioria, numeros que correspondem à teclas do teclado
 *
 */

public final class Constante {
	public static final int SETA_CIMA = KeyEvent.VK_UP;
	public static final int SETA_DIREITA = KeyEvent.VK_RIGHT;
	public static final int SETA_ESQUERDA = KeyEvent.VK_LEFT;
	public static final int SETA_BAIXO = KeyEvent.VK_DOWN;
	public static final int QUANDO_JANELA_FOCADA = JComponent.WHEN_IN_FOCUSED_WINDOW;
	public static final int ENTER = KeyEvent.VK_ENTER;
	public static final int ESC = KeyEvent.VK_ESCAPE;
	public static final int MAX_RANKING = 5;
	public static final int MAX_CHAR_NOME = 15;
}
