package it.betacom.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.betacom.configuration.Configuration;
import it.betacom.dao.LibroDao;
import it.betacom.model.Autore;
import it.betacom.model.Libro;
import it.betacom.model.LibroCompleto;

public class LibroDaoImpl implements LibroDao{
	
	Connection conn;

	
	@Override
	public List<LibroCompleto> getAllLibri() {
		
		List<LibroCompleto> libri = new ArrayList<LibroCompleto>();

		
		try {
			conn = Configuration.getInstance().getConnection();

			Statement stmt = conn.createStatement(); 
		
			ResultSet rs = stmt.executeQuery("SELECT l.CodiceR, l.Titolo, l.NumPag, l.Anno, a.CodiceA, a.NomeA, a.CognomeA, e.CodiceE, e.Nome, g.CodiceG, g.Descrizione\n"
					+ "FROM libro AS l \n"
					+ "JOIN autore AS a ON l.CodiceA = a.CodiceA\n"
					+ "JOIN editore AS e ON l.CodiceE = e.CodiceE\n"
					+ "JOIN genere AS g ON l.CodiceG = g.CodiceG\n"
					+ "ORDER BY l.CodiceR ASC;");
				
				while(rs.next()) {
					
					int codiceR = rs.getInt("CodiceR");
					String titolo = rs.getString("Titolo");
					int numPag = rs.getInt("NumPag");
					int anno = rs.getInt("Anno");
					int codiceA = rs.getInt("CodiceA");
					String nomeA = rs.getString("NomeA");
					String cognomeA = rs.getString("CognomeA");
					String codiceE = rs.getString("CodiceE");
					String nomeE = rs.getString("Nome");
					int codiceG = rs.getInt("CodiceG");
					String descrizione = rs.getString("Descrizione");
					
					LibroCompleto libroCompleto = new LibroCompleto(codiceR, titolo, numPag, anno, codiceA, nomeA, cognomeA, codiceE, nomeE, codiceG, descrizione);
		            		            
		            libri.add(libroCompleto);
		            
				}
				
				for(LibroCompleto libro: libri) {
					System.out.println("\n" + libro);
				}
				
			} catch (SQLException e) {	
				e.printStackTrace();
			}finally {
				if (null != conn) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		
		return libri;
	}



	@Override
	public Libro getLibroById(int codiceR) {
		
		LibroCompleto libro = null;
		
		try {
			conn = Configuration.getInstance().getConnection();

	        PreparedStatement stmt = conn.prepareStatement("SELECT l.CodiceR, l.Titolo, l.NumPag, l.Anno, a.CodiceA, a.NomeA, a.CognomeA, e.CodiceE, e.Nome, g.CodiceG, g.Descrizione\n"
	        		+ "FROM libro AS l \n"
	        		+ "JOIN autore AS a ON l.CodiceA = a.CodiceA\n"
	        		+ "JOIN editore AS e ON l.CodiceE = e.CodiceE\n"
	        		+ "JOIN genere AS g ON l.CodiceG = g.CodiceG\n"
	        		+ "WHERE CodiceR = ?;");
	        
	        stmt.setInt(1, codiceR);
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	        	
	        	int codice = rs.getInt("CodiceR");
				String titolo = rs.getString("Titolo");
				int numPag = rs.getInt("NumPag");
				int anno = rs.getInt("Anno");
				int codiceA = rs.getInt("CodiceA");
				String nomeA = rs.getString("NomeA");
				String cognomeA = rs.getString("CognomeA");
				String codiceE = rs.getString("CodiceE");
				String nomeE = rs.getString("Nome");
				int codiceG = rs.getInt("CodiceG");
				String descrizione = rs.getString("Descrizione");
				
				libro = new LibroCompleto(codice, titolo, numPag, anno, codiceA, nomeA, cognomeA, codiceE, nomeE, codiceG, descrizione);
	           
	         
	        }
		
		} catch (SQLException e) {	
			System.out.println("Impossibile trovare il libro");
			e.printStackTrace();
		}finally {
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return libro;
		

	}

	
	
	
	@Override
	public void insertLibro(String nomeA, String cognomeA, String titolo, String editore, String genere, int numPag, int anno) {
		
		conn = Configuration.getInstance().getConnection();
		
		int codiceA = 0;
		String codiceE = null;
		int codiceG = 0;
		int codR = 0;

		try {
			
			String query4 = "SELECT MAX(CodiceR) FROM libro ";
			
			Statement stmt4 = conn.createStatement();
			ResultSet rs4 = stmt4.executeQuery(query4);

			while(rs4.next()) {
				codR = rs4.getInt("MAX(CodiceR)")+1;
			}
			
			
			String query = "SELECT CodiceA FROM autore WHERE NomeA ='" + nomeA + "' AND CognomeA = '" + cognomeA + "'";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			
			while(rs.next()) {
				codiceA = rs.getInt("codiceA");
			}
			
			if(codiceA == 0) {
				throw new Exception("Impossibile recuperare codice autore per " + nomeA + " " + cognomeA);
			}
			
			String query2 = "SELECT CodiceE FROM editore WHERE Nome = '" + editore + "'";
			
			Statement stmt2 = conn.createStatement();
			ResultSet rs2 = stmt2.executeQuery(query2);

			while(rs2.next()) {
				codiceE = rs2.getString("codiceE");
			}
			
			if(null == codiceE) {
				throw new Exception("Impossibile recuperare codice editore");
			}
			
			String query3 = "SELECT CodiceG FROM genere WHERE Descrizione = '" + genere + "'";
			
			Statement stmt3 = conn.createStatement();
			ResultSet rs3 = stmt3.executeQuery(query3);

			while(rs3.next()) {
				codiceG = rs3.getInt("codiceG");
			}
			
			if(codiceG == 0) {
				throw new Exception("Impossibile recuperare codice genere");
			}
			
			Libro libro = new Libro(codR, titolo, numPag, anno, codiceA, codiceE, codiceG);
			insertLibro(libro);

		} catch (Exception e) {
			System.out.println("Impossibile inserire il libro");
			e.printStackTrace();
		}
		
		
	
	}
	
	
	public void insertLibro(Libro libro) {
		
		try {
			conn = Configuration.getInstance().getConnection();

			PreparedStatement stmt = conn.prepareStatement("INSERT INTO libro VALUES(?, ?, ?, ?, ?, ?, ?)");
			
			stmt.setInt(1, libro.getCodiceR());
			stmt.setString(2, libro.getTitolo());
			stmt.setInt(3, libro.getNumPag());
			stmt.setInt(4, libro.getAnno());
			stmt.setInt(5, libro.getCodiceA());
			stmt.setString(6, libro.getCodiceE());
			stmt.setInt(7, libro.getCodiceG());
		
			stmt.execute();
			
			System.out.println("Inserimento effettuato!");
	
			
		} catch (SQLException e) {
			System.out.println("Impossibile effettuare l'inserimento");
			e.printStackTrace();
		}finally {
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public void updateLibroCampiInt(int codiceR, String campo, int nuovoValoreCampo) {

		try {
			conn = Configuration.getInstance().getConnection();
			
			String query1 = "UPDATE libro SET " + campo + " = ? WHERE CodiceR = ?";

			PreparedStatement stmt = conn.prepareStatement(query1);
			
			stmt.setInt(1, nuovoValoreCampo);
			stmt.setInt(2, codiceR);
			
			stmt.execute();
			
			System.out.println("Aggiornamento effettuato!");
			

		} catch (Exception e) {
			System.out.println("Impossibile effettuare l'aggiornamento");
			e.printStackTrace();
		}finally {
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	@Override
	public void updateLibroCampiString(int codiceR, String campo, String nuovoValoreCampo) {

		try {
			conn = Configuration.getInstance().getConnection();
			
			String query1 = "UPDATE libro SET " + campo + " = ? WHERE CodiceR = ?";

			PreparedStatement stmt = conn.prepareStatement(query1);
			
			stmt.setString(1, nuovoValoreCampo);
			stmt.setInt(2, codiceR);
			
			stmt.execute();
			
			System.out.println("Aggiornamento effettuato!");

		} catch (Exception e) {
			System.out.println("Impossibile effettuare l'aggiornamento");
			e.printStackTrace();
		}finally {
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public void deleteLibro(int codiceR) {

		try{
			conn = Configuration.getInstance().getConnection();

			PreparedStatement stmt = conn.prepareStatement("DELETE FROM libro WHERE CodiceR = ?");
		
			stmt.setInt(1, codiceR);
			
			stmt.execute();
			
			System.out.println("Eliminazione effettuata!");
			
		} catch (SQLException e) {
			System.out.println("Impossibile effettuare l'eliminazione");
			e.printStackTrace();
		}finally {
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
