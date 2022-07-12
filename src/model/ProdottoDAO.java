package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.ProdottoBean;


public class ProdottoDAO implements Model<ProdottoBean>{

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
	
	@Override
	public Collection<ProdottoBean> doRetrieveAll() throws SQLException  {
		Connection connection = null;
		ArrayList<ProdottoBean> prodotto = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		String selectSQL = "SELECT * FROM prodotto ";
		
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
			
			
			while (rs.next()) {
				ProdottoBean bean = new ProdottoBean();
				bean.setIdProdotto(rs.getInt("ID_prodotto"));
				bean.setNome(rs.getString("Nome"));
				bean.setQuantita(rs.getInt("Quantita"));
				bean.setDescrizione(rs.getString("Descrizione"));
				bean.setSconto(rs.getInt("Sconto"));
				bean.setPrezzo(rs.getFloat("Prezzo"));
				bean.setPeso(rs.getString("Peso"));
				bean.setMarca(rs.getString("Marca"));
				prodotto.add(bean);
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
		
		return prodotto;
	}

	@Override
	public void doSave(ProdottoBean bean) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;


		String saveSQL = "Insert INTO prodotto (ID_prodotto,Quantita, Descrizione, Nome, Prezzo, Peso, Marca) values (?,?,?,?,?,?,?)";
		String selectId = "SELECT MAX(ID_prodotto) as Id FROM prodotto";
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectId);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next())
			{
				bean.setIdProdotto(rs.getInt("Id")+1);
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
			preparedStatement = connection.prepareStatement(saveSQL);
			preparedStatement.setInt(1, bean.getIdProdotto());
			preparedStatement.setLong(2, bean.getQuantita());
			preparedStatement.setString(3, bean.getDescrizione());
			preparedStatement.setString(4, bean.getNome());
			preparedStatement.setFloat(5, bean.getPrezzo());
			preparedStatement.setString(6, bean.getPeso());
			preparedStatement.setString(7, bean.getMarca());
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
	
	public void doSave2(ProdottoBean bean) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;


		String saveSQL = "Insert INTO prodotto (ID_prodotto,Quantita, Descrizione, Nome, Prezzo, Peso, Marca) values (?,?,?,?,?,?,?)";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(saveSQL);
			preparedStatement.setInt(1, bean.getIdProdotto());
			preparedStatement.setLong(2, bean.getQuantita());
			preparedStatement.setString(3, bean.getDescrizione());
			preparedStatement.setString(4, bean.getNome());
			preparedStatement.setFloat(5, bean.getPrezzo());
			preparedStatement.setString(6, bean.getPeso());
			preparedStatement.setString(7, bean.getMarca());
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

	@Override
	public int doUpdate(ProdottoBean bean) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Integer id = bean.getIdProdotto();
		String saveSQL = "UPDATE prodotto SET Quantita=?, Descrizione=?, Nome=?, Prezzo=?, Peso=?, Marca=? WHERE ID_prodotto = " + id;
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(saveSQL);
			preparedStatement.setLong(1, bean.getQuantita());
			preparedStatement.setString(2, bean.getDescrizione());
			preparedStatement.setString(3, bean.getNome());
			preparedStatement.setFloat(4, bean.getPrezzo());
			preparedStatement.setString(5, bean.getPeso());
			preparedStatement.setString(6, bean.getMarca());
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
		
		return 0;
	}

	@Override
	public boolean doDelete(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM  prodotto  WHERE Id_Prodotto = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, code);

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

	@Override
	public ProdottoBean doRetrieveByKey(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ProdottoBean bean = new ProdottoBean();
		String selectSQL = "SELECT * FROM prodotto WHERE ID_prodotto=?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, code);
			ResultSet rs = preparedStatement.executeQuery();

			if(rs.next()) {
				bean.setIdProdotto(rs.getInt("ID_prodotto"));
				bean.setNome(rs.getString("Nome"));
				bean.setPrezzo(rs.getFloat("Prezzo"));
				bean.setDescrizione(rs.getString("Descrizione"));
				bean.setMarca(rs.getString("Marca"));
				bean.setQuantita(rs.getInt("Quantita"));
				bean.setPeso(rs.getString("Peso"));
				bean.setImmagine(String.valueOf(bean.getIdProdotto()));					
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