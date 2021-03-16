package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private AlienDictionary model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtAlienText;

    @FXML
    private TextArea txtDictionary;

    @FXML
    void doTraslate(ActionEvent event) {
    	
    	String pattern = "[a-zA-Z ]*";
    	
    	if(txtAlienText.getText().matches(pattern) == false) {
    		txtDictionary.appendText("Le parole possono contenere solo lettere!\n");
    		return;
    	}	
    		
    	String paroleInserite[] = txtAlienText.getText().split(" ");
    	String alienWord;
    	String translaction;
    	
    	if(paroleInserite.length == 1) {
    		
    		alienWord = paroleInserite[0].toLowerCase();
    		
    		if(model.translateWord(alienWord) != null)
    			txtDictionary.appendText("La traduzione di "+alienWord+" è "+model.translateWord(alienWord)+".\n");
    		else if(alienWord.equals("")) 
    			txtDictionary.appendText("Non hai inserito nessuna parola!\n");
    		else
    			txtDictionary.appendText("La parola "+alienWord+" non è presente nel dizionario.\n");
    		
    	} else if (paroleInserite.length == 2){
    		
    		alienWord = paroleInserite[0].toLowerCase();
    		translaction = paroleInserite[1].toLowerCase();
    		
    		model.addWord(alienWord, translaction);
    		txtDictionary.appendText("Aggiunto: "+alienWord+" --> "+translaction+"\n");
    		
    	} else 
    		txtDictionary.appendText("Devi inserire 1 o 2 parole!\n");
    	
    	txtAlienText.clear();
    	
    }
    
    @FXML
    void doClear(ActionEvent event) {
    	
    	model.Dizionario.clear();
    	txtAlienText.clear();
    	txtDictionary.clear();
    	
    }
    
    public void setModel(AlienDictionary model) {
    	this.model = model;
    }
    
    @FXML
    void initialize() {
    	
        assert txtAlienText != null : "fx:id=\"txtAlienText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtDictionary != null : "fx:id=\"txtDictionary\" was not injected: check your FXML file 'Scene.fxml'.";
        
    }
    
}
