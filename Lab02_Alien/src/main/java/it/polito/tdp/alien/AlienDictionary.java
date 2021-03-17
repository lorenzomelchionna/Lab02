package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {
	
	List<WordEnhanced> Dizionario;

	public AlienDictionary() {
		Dizionario = new LinkedList<WordEnhanced>();
	}
	
	public void addWord(String alienWord, String translaction) {
		
		WordEnhanced tempWord = new WordEnhanced(alienWord, translaction);
		
		for(WordEnhanced w : Dizionario)
			if(w.equals(tempWord)) {
				
				w.addTranslation(translaction);
				return;
				
			}
		
		Dizionario.add(tempWord);
		
	}
	
	public List<String> translateWord(String alienWord) {
		
		for(WordEnhanced w : Dizionario)
			if(w.getAlienWord().equals(alienWord))
				return w.getTranslations();
		
		return null;
		
	}
	
}
