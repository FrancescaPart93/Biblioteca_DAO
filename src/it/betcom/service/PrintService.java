package it.betcom.service;


public interface PrintService {

	void saveListAsPdf();  
	void saveListAsCsv(); 
	void saveListAsTxt(); 
	void saveAsPdf(int codiceA); 
	void saveAsCsv(int codiceA); 
	void saveAsTxt(int codiceA); 
}
