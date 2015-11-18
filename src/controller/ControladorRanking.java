package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Constante;
import model.Partida;

/**
 * 
 * Classe responsavel por manipular o ranking e sua leitura e escrita em arquivo
 * externo.
 * 
 * @param ranking
 *            lista com os atuais melhores. Limite de partidas listadas é
 *            definido pela constante MAX_RANKING :
 *            {@link Constante#MAX_RANKING}
 * @param CAMINHO_ARQUIVO
 *            caminho do arquivo a ser editado, lido e escrito.
 */

public class ControladorRanking {

	private List<Partida> ranking;
	private static String CAMINHO_ARQUIVO = "C:\\Users\\Guilherme\\OneDrive\\Conhecimentos\\workspace\\Genius\\bin\\ranking.ser";

	public ControladorRanking() {
		super();
		lerRankingDoArquivo();
	}

	// ---------------------------------------------------- MÉTODOS GERAIS

	/**
	 * Escreve o ranking atual no arquivo.
	 */
	private void escreverRankingNoArquivo() {

		FileOutputStream arquivoRanking;

		try {

			arquivoRanking = new FileOutputStream(CAMINHO_ARQUIVO);

			ObjectOutputStream escritorDeObjetos = new ObjectOutputStream(arquivoRanking);

			escritorDeObjetos.writeObject(ranking.toArray());

			escritorDeObjetos.close();

			arquivoRanking.close();

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Le o ranking atual do arquivo e ordena por pontuação, da maior para a menor
	 */
	private void lerRankingDoArquivo() {

		FileInputStream arquivoRanking;

		try {
			arquivoRanking = new FileInputStream(CAMINHO_ARQUIVO);

			if (arquivoRanking.available() > 1) {
				
				ObjectInputStream leitorDeObjetos = new ObjectInputStream(arquivoRanking);
				
				Object objeto = leitorDeObjetos.readObject();
				
				Object[] arrayObjetos = (Object[]) objeto;

				ranking = new ArrayList<Partida>();
				
				for (Object obj : arrayObjetos) {
					
					Partida novaPartida = (Partida) obj;
					ranking.add(novaPartida);
				
				}
				
				Collections.sort(ranking);
				
				leitorDeObjetos.close();
			}

			arquivoRanking.close();

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Método que testa se uma partida esta entre as melhores e, se estiver,
	 * adiciona ao ranking, já escrevendo no arquivo
	 * 
	 * @param novaPartida
	 *            partida a ser inserida no ranking, se for o caso
	 *
	 */
	public void addPartidaRanking(Partida novaPartida) {

		//Recebe o ranking ordenado por pontuação, da maior para a menor
		lerRankingDoArquivo();

		//Realiza testes para saber se a novaPartida deve estar no ranking
		boolean partidaEstaEntreMelhores = false;		
		if (ranking != null) {	
			
			if(ranking.size() >= Constante.MAX_RANKING){
				
				Partida partidaMenorPontuacao = ranking.get(ranking.size()-1);
				
				if (novaPartida.getNrPontos() > partidaMenorPontuacao.getNrPontos()) {
					ranking.remove(partidaMenorPontuacao);
					partidaEstaEntreMelhores = true;
				}
				
			} else {
				partidaEstaEntreMelhores = true;
			}
			
		} else {
			ranking = new ArrayList<Partida>();
			partidaEstaEntreMelhores = true;
		}
		
		if(partidaEstaEntreMelhores){
			ranking.add(novaPartida);
		}

		escreverRankingNoArquivo();
	}

	// ---------------------------------------------------- GETTERS E SETTERS --------------------------------

	public List<Partida> getRanking() {
		return ranking;
	}

	public void setRanking(List<Partida> topCinco) {
		this.ranking = topCinco;
	}
}
