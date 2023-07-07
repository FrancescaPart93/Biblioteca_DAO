package it.betacom.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.betacom.configuration.Configuration;
import it.betacom.dao.AutoreDao;
import it.betacom.model.Autore;


public class AutoreDaoImpl implements AutoreDao{

	Connection conn;
	
	@Override
	public List<Autore> getAllAutori() {
		
		List<Autore> autori = new ArrayList<Autore>();

		
		try {
			conn = Configuration.getInstance().getConnection();

			Statement stmt = conn.createStatement(); 
		
			ResultSet rs = stmt.executeQuery("SELECT * FROM autore");
				
				while(rs.next()) {
					
					int codiceA = rs.getInt("CodiceA");
					String nomeA = rs.getString("NomeA");
					String cognomeA = rs.getString("CognomeA");
					int annoN = rs.getInt("AnnoN");
					int annoM = rs.getInt("AnnoM");
					String sesso = rs.getString("Sesso");
					String nazione = rs.getString("Nazione");

					
					Autore autore = new Autore(codiceA, nomeA, cognomeA, annoN, annoM, sesso, nazione);
		            		            
		            autori.add(autore);
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
		
		return autori;
	}

	@Override
	public Autore getAutoreById(int codiceA) {
		try {
			conn = Configuration.getInstance().getConnection();

	        PreparedStatement stmt = conn.prepareStatement("SELECT CodiceA, NomeA, CognomeA, AnnoN, AnnoM, Sesso, Nazione FROM autore WHERE CodiceA = ?");
	        stmt.setInt(1, codiceA);
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	        	
	            Autore autore = new Autore();
	           
	            autore.setCodiceA(codiceA);
	            autore.setNomeA(rs.getString("NomeA"));
	            autore.setCognomeA(rs.getString("CognomeA"));
	            autore.setAnnoN(rs.getInt("AnnoN"));
	            autore.setAnnoM(rs.getInt("AnnoM"));
	            autore.setSesso(rs.getString("Sesso"));
	            autore.setNazione(rs.getString("Nazione"));

	            return autore;
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
		return null;

	}

	
	@Override
	public void insertAutore(Autore autore) {
		
		try {
			conn = Configuration.getInstance().getConnection();

			PreparedStatement stmt = conn.prepareStatement("INSERT INTO autore(CodiceA, NomeA, CognomeA, AnnoN, AnnoM, Sesso, Nazione) VALUES(?, ?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, autore.getCodiceA());
			stmt.setString(2, autore.getNomeA());
			stmt.setString(3, autore.getCognomeA());
			stmt.setInt(4, autore.getAnnoN());
			stmt.setInt(5, autore.getAnnoM());
			stmt.setString(6, autore.getSesso());
			stmt.setString(7, autore.getNazione());
			
			stmt.execute();
			
			System.out.println("Inserimento effettuato!");
	
			
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
		
	}

	@Override
	public void updateAutore(Autore autore) {
		
		try {
			conn = Configuration.getInstance().getConnection();

			PreparedStatement stmt = conn.prepareStatement("UPDATE autore SET Nazione = ? WHERE CodiceA = ?");
			
			stmt.setInt(2, autore.getCodiceA());
			stmt.setString(1, autore.getNazione());
			
			stmt.execute();
			
		 

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
		
	}

	@Override
	public void deleteAutore(Autore autore) {
		
		try{
			conn = Configuration.getInstance().getConnection();

			PreparedStatement stmt = conn.prepareStatement("DELETE FROM autore WHERE CodiceA = ?");
		
			stmt.setInt(1, autore.getCodiceA());
			
			stmt.execute();
			
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
		
	}

}
