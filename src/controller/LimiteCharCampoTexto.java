package controller;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimiteCharCampoTexto extends PlainDocument {

	private static final long serialVersionUID = 1L;
	private int limite;

	public LimiteCharCampoTexto(int limite) {
		super();
		this.limite = limite;
	}

	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		if (str == null)
			return;

		if ((getLength() + str.length()) <= limite) {
			super.insertString(offset, str, attr);
		}
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

}
