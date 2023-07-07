package it.betacom.main;

import it.betacom.dao.EditoreDao;
import it.betacom.dao.impl.EditoreDaoImpl;
import it.betacom.model.Editore;

public class MainEditore {

	public static void main(String[] args) {
	
	// ----------------------EDITORE----------------------------------------------------------------------
		

		Editore editore1 = new Editore("CE1", "Laterza");
		Editore editore2 = new Editore("CE2", "De Agostini");
		Editore editore3 = new Editore("CE3", "Bompiani");
		Editore editore4 = new Editore("CE4", "Adelphi");

		EditoreDao editoreDao = new EditoreDaoImpl();
		
//		editoreDao.insertEditore(editore1);
//		editoreDao.insertEditore(editore2);
//		editoreDao.insertEditore(editore3);
//		editoreDao.insertEditore(editore4);
//		
//		System.out.println("Lista editori: " + editoreDao.getAllEditori());

//		System.out.println(editoreDao.getEditoreById("CE3"));
		
//		editore2.setNome("Mondadori");
//		editoreDao.updateEditore(editore2);
//		System.out.println("Lista editori: " + editoreDao.getAllEditori());

		
//		editoreDao.deleteEditore(editore4);
//		System.out.println("Lista editori: " + editoreDao.getAllEditori());


		

	}

}
