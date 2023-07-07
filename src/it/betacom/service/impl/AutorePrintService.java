package it.betacom.service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.opencsv.CSVWriter;

import it.betacom.dao.AutoreDao;
import it.betacom.dao.impl.AutoreDaoImpl;
import it.betacom.model.Autore;
import it.betcom.service.PrintService;

public class AutorePrintService implements PrintService{
	
	private AutoreDao autoreDao;
	

	@Override
	public void saveListAsPdf() {
		
		String fileName = "./Archivio_file/lista_autori.pdf";

		autoreDao = new AutoreDaoImpl();
		
		autoreDao.getAllAutori();
		
		Document document = new Document ();
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
			document.open();
			document.add(new Paragraph("LISTA AUTORI: \n" + autoreDao.getAllAutori()));
			document.close();
			writer.close();
			
			System.out.println("Stampa pdf effettuata!");
			
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void saveListAsCsv() {
		
		List<Autore> autori = new ArrayList<Autore>();
		
		String fileName = "./Archivio_file/lista_autori.csv";

		autoreDao = new AutoreDaoImpl();
		
		autoreDao.getAllAutori();
		
		try {
			
			autori = autoreDao.getAllAutori();
			
			CSVWriter csvw = new CSVWriter(new FileWriter(fileName));			
			
			String [] campi = {"CodiceA", "NomeA", "CognomeA", "AnnoN", "AnnoM", "Sesso", "Nazione"};
			csvw.writeNext(campi);
		
			for(Autore autore: autori) {
				String[]campi2 = {String.valueOf(autore.getCodiceA()), autore.getNomeA(), autore.getCognomeA(), String.valueOf(autore.getAnnoN()), String.valueOf(autore.getAnnoM()), autore.getSesso(), autore.getNazione()};
				csvw.writeNext(campi2);
			}
			csvw.close();
			
			System.out.println("Stampa csv effettuata!");
			
		} catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void saveListAsTxt() {
		
		String fileName = "./Archivio_file/lista_autori.txt";

		autoreDao = new AutoreDaoImpl();
		
		autoreDao.getAllAutori();
		
		try {
			FileWriter writer = new FileWriter(fileName);
			
			writer.write("LISTA AUTORI: " + autoreDao.getAllAutori());
			writer.close();
			
			System.out.println("Stampa txt effettuata!");
			
		} catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void saveAsPdf(int codiceA) {
		
		String fileName = "./Archivio_file/autore.pdf";

		autoreDao = new AutoreDaoImpl();
		
		autoreDao.getAutoreById(codiceA);
		
		Document document = new Document ();
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
			document.open();
			document.add(new Paragraph("AUTORE SELEZIONATO: \n" + autoreDao.getAutoreById(codiceA)));
			document.close();
			writer.close();
			
			System.out.println("Stampa pdf effettuata!");
			
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void saveAsCsv(int codiceA) {

		
		String fileName = "./Archivio_file/autore.csv";

		autoreDao = new AutoreDaoImpl();
		
		autoreDao.getAutoreById(codiceA);		
		
		try {
			
			CSVWriter csvw = new CSVWriter(new FileWriter(fileName));	
			
			String [] campi = {"CodiceA", "NomeA", "CognomeA", "AnnoN", "AnnoM", "Sesso", "Nazione"};
			csvw.writeNext(campi);
					
			String[]campi2 = {String.valueOf(autoreDao.getAutoreById(codiceA).getCodiceA()), autoreDao.getAutoreById(codiceA).getNomeA(),
					autoreDao.getAutoreById(codiceA).getCognomeA(), String.valueOf(autoreDao.getAutoreById(codiceA).getAnnoN()),
					String.valueOf(autoreDao.getAutoreById(codiceA).getAnnoM()), autoreDao.getAutoreById(codiceA).getSesso(),
					autoreDao.getAutoreById(codiceA).getNazione()};
			csvw.writeNext(campi2);

			csvw.close();
			
			System.out.println("Stampa csv effettuata!");
			
		} catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	


	@Override
	public void saveAsTxt(int codiceA) {
		
		String fileName = "./Archivio_file/autore.txt";

		autoreDao = new AutoreDaoImpl();
		
		autoreDao.getAutoreById(codiceA);
		
		try {
			FileWriter writer = new FileWriter(fileName);
			
			writer.write("AUTORE SELEZIONATO: \n" + autoreDao.getAutoreById(codiceA));
			writer.close();
			
			System.out.println("Stampa txt effettuata!");
			
		} catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	
	
	
}
