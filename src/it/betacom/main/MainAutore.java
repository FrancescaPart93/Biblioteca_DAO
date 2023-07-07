package it.betacom.main;

import it.betacom.dao.AutoreDao;
import it.betacom.dao.impl.AutoreDaoImpl;
import it.betacom.model.Autore;

public class MainAutore {

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

				AutoreDao autoreDao = new AutoreDaoImpl();
				
//				autoreDao.insertAutore(autore1);
//				autoreDao.insertAutore(autore2);
//				autoreDao.insertAutore(autore3);
//				autoreDao.insertAutore(autore4);
//				autoreDao.insertAutore(autore5);
//				autoreDao.insertAutore(autore6);
//				autoreDao.insertAutore(autore7);
//				autoreDao.insertAutore(autore8);
//				autoreDao.insertAutore(autore9);
		
//			System.out.println("Lista autori: " + autoreDao.getAllAutori());
				
//			System.out.println(autoreDao.getAutoreById(1));
				
//				autore1.setNazione("Francia");
//				autoreDao.updateAutore(autore1);
//				System.out.println("Lista autori: " + autoreDao.getAllAutori());
		
//				
//				autoreDao.deleteAutore(autore1);
//				System.out.println("Lista autori: " + autoreDao.getAllAutori());

				
				
		
		
		
	}

}
