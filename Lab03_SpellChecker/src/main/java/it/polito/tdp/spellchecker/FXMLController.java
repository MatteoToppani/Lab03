/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.Parola;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea Testo;

    @FXML
    private TextArea Correzione;

    @FXML
    private TextField errori;

    @FXML
    private TextField tempo;
    
    Dictionary model;

    @FXML
    void Clear(ActionEvent event) {
    	Testo.clear();
    	Correzione.clear();
    }

    @FXML
    void Controlla(ActionEvent event) {
    	long start = System.currentTimeMillis();
    	String s = Testo.getText();
    	List<Parola> list = model.Controlla(s);
    	for(Parola p : list) {
    		Correzione.appendText(p.toString()+"\n");
    	}
    	errori.setText("Numero errori: "+list.size());
    	long end = System.currentTimeMillis();
    	long time = end-start;
    	tempo.setText("Tempo impegato: "+time);
    }

    @FXML
    void Inglese(ActionEvent event) {
    	//if(model.getInglese().size()==0)
    		model.LoadDictionary("English");
    	model.setScelta(true);
    }

    @FXML
    void Italiano(ActionEvent event) {
    	if(model.getItaliano().size()==0)
    		model.LoadDictionary("Italiano");
    	model.setScelta(false);
    }

    @FXML
    void initialize() {
        assert Testo != null : "fx:id=\"Testo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Correzione != null : "fx:id=\"Correzione\" was not injected: check your FXML file 'Scene.fxml'.";
        assert errori != null : "fx:id=\"errori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tempo != null : "fx:id=\"tempo\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Dictionary model) {
		// TODO Auto-generated method stub
		this.model = model;
	}
}


