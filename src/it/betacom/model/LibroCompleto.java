package it.betacom.model;

public class LibroCompleto extends Libro{

	
	private String nomeA;
	private String cognomeA;
	private String nomeE;
	private String descrizioneG;
	

	public LibroCompleto(int codiceR, String titolo, int numPag, int anno, int codiceA, String nomeA, String cognomeA, String codiceE, String nomeE, int codiceG, String descrizioneG) {
		super(codiceR, titolo, numPag, anno, codiceA, codiceE, codiceG);
		this.nomeA = nomeA;
		this.cognomeA = cognomeA;
		this.nomeE = nomeE;
		this.descrizioneG = descrizioneG;
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

	public String getNomeE() {
		return nomeE;
	}

	public void setNomeE(String nomeE) {
		this.nomeE = nomeE;
	}

	public String getDescrizioneG() {
		return descrizioneG;
	}

	public void setDescrizioneG(String descrizioneG) {
		this.descrizioneG = descrizioneG;
	}

	@Override
	public String toString() {
		return "LibroCompleto [CodiceR = " + getCodiceR() + ", Titolo = " + getTitolo() + ", Numero pagine = " + getNumPag() 
		+ ", Anno = " + getAnno() + ", CodiceA = " + getCodiceA() + ", NomeA = " + nomeA + ", CognomeA = " + cognomeA 
		+ ", CodiceE = " + getCodiceE() + ", NomeE = " + nomeE + ", CodiceG = " + getCodiceG() + ", Descrizione = " + descrizioneG + "]";
				
	}

	
	
	


	
}
