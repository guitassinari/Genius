package controller;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * 
 * Classe respons�vel por tocar qualquer tipo de audio atrav�s de uma nova thread
 *
 */
public class TocadorDeAudio implements Runnable {

	private String caminhoDoAudio;

	@Override
	public void run() {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(new File(caminhoDoAudio)));
			clip.start();
			Thread.sleep(300);
			clip.close();
		} catch (Exception exc) {
			exc.printStackTrace(System.out);
		}
	}

	public String getCaminhoDoAudio() {
		return caminhoDoAudio;
	}

	public void setCaminhoDoAudio(String caminhoDoAudio) {
		this.caminhoDoAudio = caminhoDoAudio;
	}

}
