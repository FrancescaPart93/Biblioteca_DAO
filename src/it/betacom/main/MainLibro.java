package it.betacom.main;

import it.betacom.dao.LibroDao;
import it.betacom.dao.impl.LibroDaoImpl;
import it.betacom.model.Autore;
import it.betacom.model.Editore;
import it.betacom.model.Genere;
import it.betacom.model.Libro;
import it.betacom.model.LibroCompleto;

public class MainLibro {

	public static void main(String[] args) {
		
		// ----------------------AUTORE----------------------------------------------------------------------
		
		Autore autore1 = new Autore(1, "Alessandro", "Manzoni", 1785, 1873, "M", "Italia");
		Autore autore2 = new Autore(2, "Lev", "Tolstoi", 1828, 1910, "M", "Russia");
		Autore autore3 = new Autore(3, "Bruno", "Vespa", 1785, 1873, "M", "Italia");
		Autore autore4 = new Autore(4, "Stephen", "King", 1947, 0, "M", "America");
		Autore autore5 = new Autore(5, "Ernest", "Hemingway", 1899, 1899, "M", "America");
		Autore autore6 = new Autore(6, "Umberto", "Eco", 1785, 1873, "M", "Italia");
		Autore autore7 = new Autore(7, "Susanna", "Tamaro", 1957, 0, "F", "Italia");
		Autore autore8 = new Autore(8, "Virginia", "Woolf", 1882, 1941, "F", "Inghilterra");
		Autore autore9 = new Autore(9, "Agatha", "Christie", 1890, 1976, "F", "Inghilterra");

		
		// ----------------------EDITORE----------------------------------------------------------------------
		

		Editore editore1 = new Editore("CE1", "Laterza");
		Editore editore2 = new Editore("CE2", "De Agostini");
		Editore editore3 = new Editore("CE3", "Bompiani");
		Editore editore4 = new Editore("CE4", "Adelphi");

		
		
	// -------------------------GENERE----------------------------------------------------------------------
		
		Genere genere1 = new Genere(1, "Giallo");
		Genere genere2 = new Genere(2, "Horror");
		Genere genere3 = new Genere(3, "Storico");
		Genere genere4 = new Genere(4, "Romanzo");
		Genere genere5 = new Genere(5, "Saggio");
		Genere genere6 = new Genere(6, "Fumetto");
		
		
// -------------------------------LIBRO----------------------------------------------------------------------
			
		
		String titolo = "Il vecchio e il mare";
		String nomeA = "Ernest";
		String cognomeA = "Hemingway";
		String editore = "Adelphi";
		String genere = "Romanzo";
	
		LibroDao libroDao = new LibroDaoImpl();

		
//	    ------------------------ INSERIMENTO --------------------------------------
		
//		libroDao.insertLibro(nomeA, cognomeA, titolo, editore, genere, 820, 1952);
		
		

//		---------------------- STAMPA TUTTI I LIBRI -------------------------------
		
//		libroDao.getAllLibri();
		
		

//		---------------------- SELEZIONE LIBRO BY ID --------------------------------
		
//		System.out.println("Libro selezionato: " + libroDao.getLibroById(3));
		
		

		
//		----------------------- UPDATE LIBRO --------------------------------------
	
		
//		libroDao.updateLibroCampiInt(2, "NumPag", 800);
//		libroDao.updateLibroCampiString(2, "Titolo", "Avventure nel bosco");
//		libroDao.getAllLibri();

		
//		------------------------ DELETE LIBRO ------------------------------------
		

//		libroDao.deleteLibro(2);
//		libroDao.deleteLibro();

	}	

}
