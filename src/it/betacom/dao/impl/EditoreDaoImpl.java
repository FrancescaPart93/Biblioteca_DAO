package it.betacom.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.betacom.configuration.Configuration;
import it.betacom.dao.EditoreDao;
import it.betacom.model.Editore;


public class EditoreDaoImpl implements EditoreDao{
	
	Connection conn;


	@Override
	public List<Editore> getAllEditori() {
		
		List<Editore> editori = new ArrayList<Editore>();

		
		try {
			conn = Configuration.getInstance().getConnection();

			Statement stmt = conn.createStatement(); 
		
			ResultSet rs = stmt.executeQuery("SELECT CodiceE, Nome FROM editore");
				
				while(rs.next()) {
					
					String codiceE = rs.getString("CodiceE");
					String nome = rs.getString("Nome");
					
					Editore editore = new Editore(codiceE, nome);
		            		            
		            editori.add(editore);
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
		
		return editori;
	}

	@Override
	public Editore getEditoreById(String codiceE) {
		try {
			conn = Configuration.getInstance().getConnection();

	        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM editore WHERE CodiceE = ?");
	        stmt.setString(1, codiceE);
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            Editore editore = new Editore(codiceE, null);
	            editore.setCodiceE(rs.getString("CodiceE"));
	            editore.setNome(rs.getString("Nome"));
	            
	            return editore;
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
	public void insertEditore(Editore editore) {
		try {
			conn = Configuration.getInstance().getConnection();

			PreparedStatement stmt = conn.prepareStatement("INSERT INTO editore(CodiceE, Nome) VALUES(?, ?)");
			stmt.setString(1, editore.getCodiceE());
			stmt.setString(2, editore.getNome());
			
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
	public void updateEditore(Editore editore) {
		try {
			conn = Configuration.getInstance().getConnection();

			PreparedStatement stmt = conn.prepareStatement("UPDATE editore SET Nome = ? WHERE CodiceE = ?");
			
			stmt.setString(2, editore.getCodiceE());
			stmt.setString(1, editore.getNome());
			
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

	@Override
	public void deleteEditore(Editore editore) {
		
		try{
			conn = Configuration.getInstance().getConnection();

			PreparedStatement stmt = conn.prepareStatement("DELETE FROM editore WHERE CodiceE = ?");
		
			stmt.setString(1, editore.getCodiceE());
			
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
