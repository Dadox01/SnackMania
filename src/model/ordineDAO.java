package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.OrdineBean;
import bean.ProdottoBean;
import bean.UtenteBean;

public class ordineDAO{

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
	


	public void doSaveCliente(UtenteBean bean, OrdineBean ord) throws SQLException {
		
		System.out.println("dosavecliente");
		OrdineBean ordine = new OrdineBean();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		LocalDate today = LocalDate.now();
		String selectSQL = "Insert INTO ordine (ID_Ordine, Descrizione,Destinazione,Numero_prodotti,Data_spedizione,Costo,Cliente_Ordine) values (?,?,?,?,?,?,?)";
		String selectId = "SELECT MAX(ID_Ordine) as Id FROM ordine";
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectId);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next())
			{
				ord.setIdOrdine(rs.getInt("Id")+1);
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
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, ord.getIdOrdine());
			preparedStatement.setString(2, ord.getDescrizione());
			preparedStatement.setString(3, ord.getDestinazione());
			preparedStatement.setInt(4, ord.getNumeroProdotti());
			preparedStatement.setString(5, today.toString());
			preparedStatement.setFloat(6, ord.getCosto());
			preparedStatement.setInt(7, ord.getCliente_Ordine());
			preparedStatement.executeUpdate();
		
		}
		
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
	}
	
	public void doSave(OrdineBean ord) throws SQLException {
		
		OrdineBean ordine = new OrdineBean();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		LocalDate today = LocalDate.now();
		String selectSQL = "Insert INTO ordine (ID_Ordine, Descrizione,Destinazione,Numero_prodotti,Data_spedizione,Costo) values (?,?,?,?,?,?)";
		String selectId = "SELECT MAX(ID_Ordine) as Id FROM ordine";
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectId);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next())
			{
				ord.setIdOrdine(rs.getInt("Id")+1);
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
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, ord.getIdOrdine());
			preparedStatement.setString(2, ord.getDescrizione());
			preparedStatement.setString(3, ord.getDestinazione());
			preparedStatement.setInt(4, ord.getNumeroProdotti());
			preparedStatement.setString(5, today.toString());
			preparedStatement.setFloat(6, ord.getCosto());
			preparedStatement.executeUpdate();
		
		}
		
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
	}
	
	public Collection<OrdineBean> doRetriveAll() throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<OrdineBean> ordini = new ArrayList<>();
		String selectSQL = "SELECT * FROM ordine";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				Date data = rs.getDate("Data_spedizione");
				OrdineBean bean = new OrdineBean();
				bean.setIdOrdine(rs.getInt("ID_ordine"));
				bean.setDescrizione(rs.getString("Descrizione"));
				bean.setDestinazione(rs.getString("Destinazione"));
				bean.setNumeroProdotti(rs.getInt("Numero_Prodotti"));
				bean.setCostoSpedizione(rs.getFloat("Costo_Spedizione"));
				bean.setSpedizione(data.toLocalDate());
				bean.setCosto(rs.getFloat("Costo"));
				bean.setCliente_Ordine(rs.getInt("Cliente_Ordine"));
				ordini.add(bean);
			}
			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return ordini;
	}

		
		
	public  Collection<OrdineBean>  doRetrieveByKeyAll(Integer code) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<OrdineBean> ordini = new ArrayList<>();
		String selectSQL = "SELECT * FROM ordine WHERE Cliente_Ordine = "+ code;
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				Date data = rs.getDate("Data_spedizione");
				OrdineBean bean = new OrdineBean();
				bean.setIdOrdine(rs.getInt("ID_ordine"));
				bean.setDescrizione(rs.getString("Descrizione"));
				bean.setDestinazione(rs.getString("Destinazione"));
				bean.setNumeroProdotti(rs.getInt("Numero_Prodotti"));
				bean.setCostoSpedizione(rs.getFloat("Costo_Spedizione"));
				bean.setSpedizione(data.toLocalDate());
				bean.setCosto(rs.getFloat("Costo"));
				bean.setCliente_Ordine(code);
				ordini.add(bean);
			}
			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return ordini;
	}
	
	public OrdineBean doRetrieveByKey(int code) throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		OrdineBean ordini = new OrdineBean();
		String selectSQL = "SELECT * FROM ordine WHERE Cliente_Ordine = "+ code;
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				Date data = rs.getDate("Data_spedizione");
				OrdineBean bean = new OrdineBean();
				bean.setIdOrdine(rs.getInt("ID_ordine"));
				bean.setDescrizione(rs.getString("Descrizione"));
				bean.setDestinazione(rs.getString("Destinazione"));
				bean.setNumeroProdotti(rs.getInt("Numero_Prodotti"));
				bean.setCostoSpedizione(rs.getFloat("Costo_Spedizione"));
				bean.setSpedizione(data.toLocalDate());
				bean.setCosto(rs.getFloat("Costo"));
				bean.setCliente_Ordine(code);
			}
			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		
		System.out.println(ordini.toString());
		
		return ordini;
		
	}
	
	
public OrdineBean doRetrieveByID(int code) throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		OrdineBean bean = new OrdineBean();
		String selectSQL = "SELECT * FROM ordine WHERE ID_ordine = "+ code;
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				Date data = rs.getDate("Data_spedizione");
				bean.setIdOrdine(rs.getInt("ID_ordine"));
				bean.setDescrizione(rs.getString("Descrizione"));
				bean.setDestinazione(rs.getString("Destinazione"));
				bean.setNumeroProdotti(rs.getInt("Numero_Prodotti"));
				bean.setCostoSpedizione(rs.getFloat("Costo_Spedizione"));
				bean.setSpedizione(data.toLocalDate());
				bean.setCosto(rs.getFloat("Costo"));
				bean.setCliente_Ordine(rs.getInt("Cliente_Ordine"));
			}
			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		
		
		return bean;
		
	}

}
