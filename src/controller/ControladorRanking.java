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
 * Classe responsavel por manipular o ranking e sua leitura e escrita em arquivo externo.
 * 
 * @param ranking lista com os atuais melhores. Limite de partidas listadas é definido pela constante MAX_RANKING : {@link Constante#MAX_RANKING} 
 * @param CAMINHO_ARQUIVO caminho do arquivo a ser editado, lido e escrito.
 */

public class ControladorRanking {

	private List<Partida> ranking;
	private static String CAMINHO_ARQUIVO = "C:\\Users\\Guilherme\\OneDrive\\Conhecimentos\\workspace\\Genius\\bin\\ranking.ser";

	
	public ControladorRanking() {
		super();
		lerRankingDoArquivo();
	}
	
// ----------------------------------------------------	MÉTODOS GERAIS -----------------------------------
	

	/**
	 * Escreve o ranking atual no arquivo.
	 */
	private void escreverRankingNoArquivo(){
		
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
	 * Le o ranking atual do arquivo e ordena por pontuação
	 */
	private void lerRankingDoArquivo(){
		
		FileInputStream arquivoRanking;
		
		try {
			arquivoRanking = new FileInputStream(CAMINHO_ARQUIVO);
			
				ObjectInputStream leitorDeObjetos = new ObjectInputStream(arquivoRanking);
				Object objeto = leitorDeObjetos.readObject();
				Object[] arrayObjetos = (Object[])objeto;
				
				ranking = new ArrayList<Partida>();
				for(Object obj : arrayObjetos){
					Partida novaPartida = (Partida)obj;
					ranking.add(novaPartida);
				}
				leitorDeObjetos.close();
			
			arquivoRanking.close();
			
			Collections.sort(ranking);
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
	 * Método que testa se uma partida esta entre os tops e, se estiver, adiciona ao ranking, já escrevendo no arquivo
	 * 
	 * @param novaPartida partida a ser inserida no ranking, se for o caso
	 *
	 */
	public void addPartidaRanking(Partida novaPartida){
		
		 lerRankingDoArquivo();
		 
		 if(ranking != null){
			 boolean novaPartidaEhTopCinco = false;
			 Partida partidaMenorPontuacao = novaPartida;
			 
			 for(Partida partidaTopCinco : ranking){
				 if(partidaTopCinco.getNrPontos() < novaPartida.getNrPontos()){
					 novaPartidaEhTopCinco = true;
					 if(partidaMenorPontuacao.getNrPontos() < partidaTopCinco.getNrPontos()){
						 partidaMenorPontuacao = partidaTopCinco;
					 }
				 }
			 }
			 if(novaPartidaEhTopCinco){
				if(ranking.size() >= Constante.MAX_RANKING){
					ranking.remove(partidaMenorPontuacao);
			 	}
				 ranking.add(novaPartida);
			 }
		 } else {
			 ranking = new ArrayList<Partida>();
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
