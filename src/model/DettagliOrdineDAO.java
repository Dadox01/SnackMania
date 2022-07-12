package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.DettagliOrdineBean;


public class DettagliOrdineDAO {
		
	private static DataSource ds;

	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/snackmania");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

		private static final String TABLE_NAME = "dettagli_ordine";

		
		public synchronized void doSave(DettagliOrdineBean composizione) throws SQLException {
			
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			String insertSQL = "INSERT INTO " +DettagliOrdineDAO.TABLE_NAME
					+ " ( ID_dettagli_ordine,ID_ordine,Quantita,Prezzo,Iva) VALUES (?,?,?,?,?)";
			
			String selectId = "SELECT MAX(ID_dettagli_ordine) as Id FROM dettagli_ordine";
			

			try {
				connection = ds.getConnection();
				preparedStatement = connection.prepareStatement(selectId);
				ResultSet rs = preparedStatement.executeQuery();
				if(rs.next())
				{
					composizione.setIdDettagliOrdine(rs.getInt("Id")+1);
				}
				
			}finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} finally {
					if (connection != null)
						connection.close();
				}
			}

			try {
				connection =ds.getConnection();
				preparedStatement = connection.prepareStatement(insertSQL);
				
				preparedStatement.setInt(1, composizione.getIdDettagliOrdine());
				preparedStatement.setInt(2,composizione.getIdOrdine());
				preparedStatement.setInt(3, composizione.getQuantita());
				preparedStatement.setDouble(4, composizione.getPrezzo());
				preparedStatement.setDouble(5, composizione.getIva());
				preparedStatement.executeUpdate();
			} finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} finally {
					connection.close();
				}
			}
		}

		
		public synchronized DettagliOrdineBean doRetrieveByKey(int identificativo_prodotto,int identificativo_ordine) throws SQLException {
			
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			DettagliOrdineBean bean = new DettagliOrdineBean();

			String selectSQL = "SELECT * FROM " + DettagliOrdineDAO.TABLE_NAME + " WHERE ID_dettagli_ordine = ? AND ID_Ordine=?";

			try {
				connection = ds.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);

				preparedStatement.setInt(1, identificativo_prodotto);
				preparedStatement.setInt(2, identificativo_ordine);
				
				
				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					
					bean.setIdDettagliOrdine(rs.getInt("ID_dettagli_ordine"));
					bean.setIdOrdine(rs.getInt("ID_Ordine"));
					bean.setQuantita(rs.getInt("Quantita"));
					bean.setPrezzo(rs.getFloat("Prezzo"));
					bean.setIva(rs.getInt("Iva"));
						
				}

			} finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} finally {
					connection.close();
				}
			}
			return bean;
		}

		
		public synchronized DettagliOrdineBean doRetrieveById(int id) throws SQLException{
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			DettagliOrdineBean bean = new DettagliOrdineBean();

			String selectSQL = "SELECT * FROM " + DettagliOrdineDAO.TABLE_NAME+ " WHERE ID_ordine = ?";


			try {
				connection = ds.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);

				preparedStatement.setInt(1, id);
				
				ResultSet rs = preparedStatement.executeQuery();

				if (rs.next()) {
				
					
					bean.setIdDettagliOrdine(rs.getInt("ID_dettagli_ordine"));
					bean.setIdOrdine(rs.getInt("ID_ordine"));
					bean.setQuantita(rs.getInt("Quantita"));
					bean.setPrezzo(rs.getFloat("Prezzo"));
					bean.setIva(rs.getInt("Iva"));
					
					
					System.out.println("Id Ordine: "+bean.getIdDettagliOrdine());
					System.out.println("Id Prodotto: "+bean.getIdOrdine());
					System.out.println("IVA: "+bean.getIva());
					System.out.println("Prezzo senza IVA: "+bean.getPrezzo());
					System.out.println("Quantita'�: "+bean.getQuantita());
					
					
				}

			} finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} finally {
					connection.close();
				}
			}
			return bean;
		}

			
		public synchronized Collection<DettagliOrdineBean> doRetrieveByOrder(int id) throws SQLException {

			Connection connection = null;
			PreparedStatement preparedStatement = null;

			Collection<DettagliOrdineBean> compositions = new LinkedList<DettagliOrdineBean>();

			String selectSQL = "SELECT * FROM " + DettagliOrdineDAO.TABLE_NAME+ " WHERE ID_dettagli_ordine = ?";


			try {
				connection = ds.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);

				preparedStatement.setInt(1, id);
				
				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					DettagliOrdineBean bean = new DettagliOrdineBean();

					
					bean.setIdDettagliOrdine(rs.getInt("ID_dettagli_ordine"));
					bean.setIdOrdine(rs.getInt("ID_ordine"));
					bean.setQuantita(rs.getInt("Quantita"));
					bean.setPrezzo(rs.getFloat("Prezzo"));
					bean.setIva(rs.getInt("Iva"));
					
					
					System.out.println("Id Ordine: "+bean.getIdDettagliOrdine());
					System.out.println("Id Prodotto: "+bean.getIdOrdine());
					System.out.println("IVA: "+bean.getIva());
					System.out.println("Prezzo senza IVA: "+bean.getPrezzo());
					System.out.println("Quantita'�: "+bean.getQuantita());
					
					compositions.add(bean);
					
				}

			} finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} finally {
					connection.close();
				}
			}
			return compositions;
		}


	}

