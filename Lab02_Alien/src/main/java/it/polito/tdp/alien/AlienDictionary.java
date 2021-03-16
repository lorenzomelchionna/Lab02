package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {
	
	List<Word> Dizionario;

	public AlienDictionary() {
		Dizionario = new LinkedList<Word>();
	}
	
	public void addWord(String alienWord, String translaction) {
		
		Word tempWord = new Word(alienWord, translaction);
		
		for(Word w : Dizionario)
			if(w.equals(tempWord)) {
				
				w.setTranslation(translaction);
				return;
				
			}
		
		Dizionario.add(tempWord);
		
	}
	
	public String translateWord(String alienWord) {
		
		for(Word w : Dizionario)
			if(w.getAlienWord().equals(alienWord))
				return w.getTranslation();
		
		return null;
		
	}
	
}
