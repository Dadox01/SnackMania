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

import bean.ProdottoBean;
import bean.RecensioneBean;


public class recensioniDAO{

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
	
	public RecensioneBean doRetriveById(Integer code) throws SQLException{
		
		RecensioneBean bean = new RecensioneBean();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "SELECT * FROM recensione WHERE ID_prodotto = " + code;
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				
				bean.setIdProdotto(code);
				bean.setData(rs.getDate("Data").toLocalDate());
				bean.setIdRecensione(rs.getInt("ID_recensione"));
				bean.setTesto(rs.getString("Testo"));
				bean.setNome(rs.getString("Nome"));
				bean.setPunteggio(rs.getString("Punteggio"));
			}
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
	
		
		return bean;
		
		
	}
	
	public boolean doDelete(Integer id) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM  recensione  WHERE Id_recensione = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);

			result = preparedStatement.executeUpdate();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return (result != 0);
	}
		
	public void doSave(RecensioneBean ord) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		LocalDate today = LocalDate.now();
		String selectSQL = "Insert INTO recensione (ID_recensione,Testo,Punteggio,ID_prodotto,Data,Nome) values (?,?,?,?,?,?)";
		String selectId = "SELECT MAX(ID_recensione) as Id FROM recensione";
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectId);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next())
			{
				ord.setIdRecensione(rs.getInt("Id")+1);
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
			preparedStatement.setInt(1, ord.getIdRecensione());
			preparedStatement.setString(2, ord.getTesto());
			preparedStatement.setString(3, ord.getPunteggio());
			preparedStatement.setInt(4, ord.getIdProdotto());
			preparedStatement.setString(5, today.toString());
			preparedStatement.setString(6, ord.getNome());
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
	
	public Collection<RecensioneBean> doRetriveAll() throws SQLException
	{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<RecensioneBean> recensioni = new ArrayList<>();
		String selectSQL = "SELECT * FROM recensione";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				Date data = rs.getDate("Data");
				RecensioneBean bean = new RecensioneBean();
				bean.setIdProdotto(rs.getInt("ID_prodotto"));
				bean.setIdRecensione(rs.getInt("ID_recensione"));
				bean.setNome(rs.getString("Nome"));
				bean.setPunteggio(rs.getString("Punteggio"));
				bean.setTesto(rs.getString("Testo"));	
				recensioni.add(bean);
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
		
		return recensioni;
	}
}