package it.betacom.model;

public class Autore {
	
	private int codiceA;
	private String nomeA, cognomeA;
	private int annoN, annoM;
	private String sesso;
	private String nazione;
	
	
	public Autore(int codiceA, String nomeA, String cognomeA, int annoN, int annoM, String sesso, String nazione) {
		this.codiceA = codiceA;
		this.nomeA = nomeA;
		this.cognomeA = cognomeA;
		this.annoN = annoN;
		this.annoM = annoM;
		this.sesso = sesso;
		this.nazione = nazione;
	}
	public Autore () {}


	public int getCodiceA() {
		return codiceA;
	}


	public void setCodiceA(int codiceA) {
		this.codiceA = codiceA;
	}


	public String getNomeA() {
		return nomeA;
	}


	public void setNomeA(String nomeA) {
		this.nomeA = nomeA;
	}


	public String getCognomeA() {
		return cognomeA;
	}


	public void setCognomeA(String cognomeA) {
		this.cognomeA = cognomeA;
	}


	public int getAnnoN() {
		return annoN;
	}


	public void setAnnoN(int annoN) {
		this.annoN = annoN;
	}


	public int getAnnoM() {
		return annoM;
	}


	public void setAnnoM(int annoM) {
		this.annoM = annoM;
	}


	public String getSesso() {
		return sesso;
	}


	public void setSesso(String sesso) {
		this.sesso = sesso;
	}


	public String getNazione() {
		return nazione;
	}


	public void setNazione(String nazione) {
		this.nazione = nazione;
	}
	
	
	@Override
	public String toString() {
		return "\n[codiceA = " + codiceA + ", nomeA = " + nomeA + ", cognomeA = " + cognomeA + ", annoN = " + annoN
				+ ", annoM = " + annoM + ", sesso = " + sesso + ", nazione = " + nazione + "]";
	}
	
	
	

}
