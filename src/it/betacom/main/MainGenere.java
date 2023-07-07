package it.betacom.main;

import it.betacom.dao.GenereDao;
import it.betacom.dao.impl.GenereDaoImpl;
import it.betacom.model.Genere;

public class MainGenere {

	public static void main(String[] args) {

		// ----------------------GENERE----------------------------------------------------------------------
		
				Genere genere1 = new Genere(1, "Giallo");
				Genere genere2 = new Genere(2, "Horror");
				Genere genere3 = new Genere(3, "Storico");
				Genere genere4 = new Genere(4, "Romanzo");
				Genere genere5 = new Genere(5, "Saggio");
				Genere genere6 = new Genere(6, "Fumetto");
				
				GenereDao genereDao = new GenereDaoImpl();
				
//				genereDao.insertGenere(genere1);
//				genereDao.insertGenere(genere2);
//				genereDao.insertGenere(genere3);
//				genereDao.insertGenere(genere4);
//				genereDao.insertGenere(genere5);
//				genereDao.insertGenere(genere6);

//				System.out.println("Lista generi: " + genereDao.getAllGeneri());
				
//				System.out.println(genereDao.getGenereById(5));
				
//				genere1.setDescrizione("Fantasy");
//				genereDao.updateGenere(genere1);
//				System.out.println("Lista generi: " + genereDao.getAllGeneri());

//				genereDao.deleteGenere(genere6);
//				System.out.println("Lista generi: " + genereDao.getAllGeneri());
				
				
		
	}

}
