package it.betacom.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.betacom.configuration.Configuration;
import it.betacom.dao.GenereDao;
import it.betacom.model.Genere;

public class GenereDaoImpl implements GenereDao{

	Connection conn;


	@Override
	public List<Genere> getAllGeneri() {
		
		List<Genere> generi = new ArrayList<Genere>();

		
		try {
			conn = Configuration.getInstance().getConnection();

			Statement stmt = conn.createStatement(); 
		
			ResultSet rs = stmt.executeQuery("SELECT CodiceG, Descrizione FROM genere");
				
				while(rs.next()) {
					
					int codiceG = rs.getInt("CodiceG");
					String descrizione = rs.getString("Descrizione");
					
					Genere genere = new Genere(codiceG, descrizione);
		            		            
		            generi.add(genere);
				}
				
			} catch (SQLException e) {	
				e.printStackTrace();
			}finally {
				if (null != conn) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		
		return generi;
	}
	

	@Override
	public Genere getGenereById(int codiceG) {
				
			try {
					conn = Configuration.getInstance().getConnection();

			        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM genere WHERE CodiceG = ?");
			        stmt.setInt(1, codiceG);
			        ResultSet rs = stmt.executeQuery();

			        if (rs.next()) {
			            Genere genere = new Genere(codiceG, null);
			            genere.setCodiceG(rs.getInt("CodiceG"));
			            genere.setDescrizione(rs.getString("Descrizione"));
			            
			            return genere;
			        }
				
			} catch (SQLException e) {	
				e.printStackTrace();
			}finally {
				if (null != conn) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		return null;
	
		
	}

	@Override
	public void insertGenere(Genere genere) {
		try {
			conn = Configuration.getInstance().getConnection();

			PreparedStatement stmt = conn.prepareStatement("INSERT INTO genere(CodiceG, Descrizione) VALUES(?, ?)");
			stmt.setInt(1, genere.getCodiceG());
			stmt.setString(2, genere.getDescrizione());
			
			stmt.execute();
			
			System.out.println("Inserimento effettuato!");
	
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
	}

	@Override
	public void updateGenere(Genere genere) {
		
		try {
			conn = Configuration.getInstance().getConnection();

			PreparedStatement stmt = conn.prepareStatement("UPDATE genere SET Descrizione = ? WHERE CodiceG = ?");
			
			stmt.setInt(2, genere.getCodiceG());
			stmt.setString(1, genere.getDescrizione());
			
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
	public void deleteGenere(Genere genere) {
		
		try{
			conn = Configuration.getInstance().getConnection();

			PreparedStatement stmt = conn.prepareStatement("DELETE FROM genere WHERE CodiceG = ?");
		
			stmt.setInt(1, genere.getCodiceG());
			
			stmt.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
