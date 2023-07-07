package it.betacom.model;

public class Libro {
	
	private int codiceR;
	private String titolo;
	private int numPag;
	private int anno;
	private int codiceA;	
	private String codiceE;
	private int codiceG;
	
	
	
	public Libro(int codiceR, String titolo, int numPag, int anno, int codiceA, String codiceE, int codiceG) {
		this.codiceR = codiceR;
		this.titolo = titolo;
		this.numPag = numPag;
		this.anno = anno;
		this.codiceA = codiceA;
		this.codiceE = codiceE;
		this.codiceG = codiceG;
	}

	

	public int getCodiceR() {
		return codiceR;
	}


	public void setCodiceR(int codiceR) {
		this.codiceR = codiceR;
	}


	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public int getNumPag() {
		return numPag;
	}


	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}


	public int getAnno() {
		return anno;
	}


	public void setAnno(int anno) {
		this.anno = anno;
	}


	public int getCodiceA() {
		return codiceA;
	}


	public void setCodiceA(int codiceA) {
		this.codiceA = codiceA;
	}


	public String getCodiceE() {
		return codiceE;
	}


	public void setCodiceE(String codiceE) {
		this.codiceE = codiceE;
	}


	public int getCodiceG() {
		return codiceG;
	}


	public void setCodiceG(int codiceG) {
		this.codiceG = codiceG;
	}



	@Override
	public String toString() {
		return "\n[codiceR=" + codiceR + ", titolo=" + titolo + ", numPag=" + numPag + ", anno=" + anno
				+ ", codiceA=" + codiceA + ", codiceE=" + codiceE + ", codiceG=" + codiceG + "]";
	}

	
	
	
	
	
	
	
}
