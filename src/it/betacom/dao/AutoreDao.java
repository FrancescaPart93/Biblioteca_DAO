package it.betacom.dao;

import java.util.List;

import it.betacom.model.Autore;


public interface AutoreDao {

	List<Autore> getAllAutori();
	
	Autore getAutoreById(int codiceA);
	
	void insertAutore(Autore autore);
	
	void updateAutore(Autore autore);
	
	void deleteAutore(Autore autore);
}
