package controller;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.SwingWorker;

/**
 * 
 * Classe responsável por tocar qualquer tipo de audio através de uma nova thread
 *
 */
public class TocadorDeAudio implements Runnable {

	private String caminhoDoAudio;

	@Override
	public void run() {
		
		SwingWorker worker = new SwingWorker() {

			@Override
			protected Void doInBackground() throws Exception {
				
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(new File(caminhoDoAudio)));
					clip.start();
					Thread.sleep(300);
					clip.close();
				} catch (Exception exc) {
					exc.printStackTrace(System.out);
				}
				
				return null;
			}

		};
		worker.execute();
		
	}

	public String getCaminhoDoAudio() {
		return caminhoDoAudio;
	}

	public void setCaminhoDoAudio(String caminhoDoAudio) {
		this.caminhoDoAudio = caminhoDoAudio;
	}

}
