package it.betacom.model;

public class Editore {

	private String codiceE;
	private String nome;
	
	public Editore(String codiceE, String nome) {
		super();
		this.codiceE = codiceE;
		this.nome = nome;
	}

	public String getCodiceE() {
		return codiceE;
	}

	public void setCodiceE(String codiceE) {
		this.codiceE = codiceE;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	@Override
	public String toString() {
		return " \n[codiceE=" + codiceE + ", nome=" + nome + "]";
	}
}
