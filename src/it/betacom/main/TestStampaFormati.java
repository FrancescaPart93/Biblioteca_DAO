package it.betacom.main;

import it.betacom.service.impl.AutorePrintService;
import it.betcom.service.PrintService;

public class TestStampaFormati {

	public static void main(String[] args) {
		
		//--------------------- STAMPA AUTORI ---------------------------
		
		PrintService print = new AutorePrintService();
				
		print.saveListAsPdf();
		print.saveAsPdf(1);
				
		print.saveListAsTxt();
		print.saveAsTxt(2);
				
		print.saveListAsCsv();
		print.saveAsCsv(3);

	


	
	
	}
	
}
