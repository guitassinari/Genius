package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.Constante;
import model.Partida;

public class ControladorRanking {

	private List<Partida> ranking;
	private static String CAMINHO_ARQUIVO = "C:\\Users\\Guilherme\\OneDrive\\Conhecimentos\\workspace\\Genius\\bin\\ranking.ser";

	
	public ControladorRanking() {
		super();
		lerTopCincoDoArquivo();
	}
	
// ----------------------------------------------------	MÉTODOS GERAIS -----------------------------------
	

	private void escreverTopCincoNoArquivo(){
		
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
	
	private void lerTopCincoDoArquivo(){
		
		FileInputStream arquivoRanking;
		
		try {
			arquivoRanking = new FileInputStream(CAMINHO_ARQUIVO);
			
			if(arquivoRanking.read() != -1){		
				ObjectInputStream leitorDeObjetos = new ObjectInputStream(arquivoRanking);
				Object objeto = leitorDeObjetos.readObject();
				ranking = (ArrayList<Partida>)objeto;
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
	
	public void addPartidaTopCinco(Partida novaPartida){
		
		 
		 lerTopCincoDoArquivo();
		 
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
		 
		 escreverTopCincoNoArquivo();
	}
	
// ---------------------------------------------------- GETTERS E SETTERS --------------------------------
	
	public List<Partida> getTopCinco() {
		return ranking;
	}

	public void setTopCinco(List<Partida> topCinco) {
		this.ranking = topCinco;
	}
}
