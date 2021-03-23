package it.polito.tdp.spellchecker.model;

public class Parola {
	
	private String parola;
	private boolean giusta;

	public Parola(String parola) {
		this.parola = parola;
		giusta = false;
	}

	public boolean isGiusta() {
		return giusta;
	}

	public void setGiusta(boolean giusta) {
		this.giusta = giusta;
	}
	
	public String toString() {
		return this.parola;
	}

}
