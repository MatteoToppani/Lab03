package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Dictionary {

	LinkedList<Parola> Italiano = new LinkedList<Parola>();
	LinkedList<Parola> Inglese = new LinkedList<Parola>();
	
	boolean scelta;

	public void LoadDictionary(String language) {
		if (language.equals("English")) {
			try {
				FileReader fr = new FileReader("src/main/resources/English.txt");
				BufferedReader br = new BufferedReader(fr);
				String word;
				while ((word = br.readLine()) != null) {
					Parola p = new Parola(word);
					Inglese.add(p);
				}
				//fr.close();
				br.close();
			} catch (IOException e) {
				System.out.println("Errore lettura file");
			}

		} else {
			try {
				FileReader fr = new FileReader("src/main/resources/Italian.txt");
				BufferedReader br = new BufferedReader(fr);
				String word;
				while ((word = br.readLine()) != null) {
					Parola m = new Parola(word);
					Italiano.add(m);
				}
				//fr.close();
				br.close();
			} catch (IOException e) {
				System.out.println("Errore lettura file");
			}

		}
	}
	
	public List<Parola> Controlla(String frase) {
		boolean controllo;
		frase.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
		List<Parola> sbagliate = new LinkedList<Parola>();
		String campi[];
		campi = frase.split(" ");
		if(scelta == true) {
			for(String s : campi) {
				controllo = false;
				Parola p = new Parola(s);
				for(Parola o : Inglese)
					if(o.getParola().equals(s))
						controllo = true;
				if(controllo == false)
					sbagliate.add(p);
			}
		}
		else {
			for(String s : campi) {
				controllo = false;
				Parola p = new Parola(s);
				for(Parola o : Italiano)
					if(o.getParola().equals(s))
						controllo = true;
				if(controllo == false)
					sbagliate.add(p);
			}
			
		}
		return sbagliate;
	}

	public boolean isScelta() {
		return scelta;
	}

	public void setScelta(boolean scelta) {
		this.scelta = scelta;
	}

	public LinkedList<Parola> getItaliano() {
		return Italiano;
	}

	public void setItaliano(LinkedList<Parola> italiano) {
		Italiano = italiano;
	}

	public LinkedList<Parola> getInglese() {
		return Inglese;
	}

	public void setInglese(LinkedList<Parola> inglese) {
		Inglese = inglese;
	}

}
