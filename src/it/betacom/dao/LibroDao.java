package it.betacom.dao;

import java.util.List;


import it.betacom.model.Libro;
import it.betacom.model.LibroCompleto;

public interface LibroDao {
	
	List<LibroCompleto> getAllLibri();
	
	Libro getLibroById(int codiceR);
	
	void insertLibro(String nomeA, String cognomeA, String titolo, String editore, String genere, int numPag, int anno);
	
	void insertLibro(Libro libro);
	
	void updateLibroCampiInt(int codiceR,  String campo, int nuovoValoreCampo);
	
	void updateLibroCampiString(int codiceR,  String campo, String nuovoValoreCampo);
	
	void deleteLibro(int codiceR);

}
