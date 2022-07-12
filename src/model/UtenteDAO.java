package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.UtenteBean;

public class UtenteDAO implements Model<UtenteBean>{

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
	
	
	public synchronized UtenteBean doRetrieveByKey(String email, String password) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		UtenteBean bean = new UtenteBean();
		String selectSQL = "SELECT * FROM cliente WHERE Email=? AND Password=? ";
		
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			
			
			if (rs.next()) {
				bean.setId(rs.getInt("ID_cliente"));
				bean.setNome(rs.getString("Nome"));
				bean.setCognome(rs.getString("Cognome"));
				bean.setEmail(email);
				bean.setPassword(password);
				bean.setData_Nascita(rs.getString("Data_Nascita"));
				bean.setStato_account(rs.getString("Stato_Account"));
				bean.setTelefono(rs.getString("Telefono"));
				bean.setAdmin(rs.getBoolean("Admin"));
			}
			
			System.out.println(bean.toString());

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
	
	public synchronized UtenteBean doRetrieveByEmail(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		UtenteBean bean = new UtenteBean();
		String selectSQL = "SELECT * FROM cliente WHERE Email=?";
		
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();
	
			if (rs.next()) {
				bean.setId(rs.getInt("ID_cliente"));
				bean.setNome(rs.getString("Nome"));
				bean.setCognome(rs.getString("Cognome"));
				bean.setEmail(rs.getString("Email"));
				bean.setData_Nascita(rs.getString("Data_Nascita"));
				bean.setStato_account(rs.getString("Stato_Account"));
				bean.setAdmin(rs.getBoolean("Admin"));
				bean.setTelefono(rs.getString("Telefono"));
				bean.setPassword(rs.getString("Password"));
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


	@Override
	public void doSave(UtenteBean bean) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "Insert INTO cliente (Id_Cliente,Nome, Cognome, Email, Password, Data_Nascita, Sesso) values (?,?,?,?,?,?,?)";
		String selectId = "SELECT MAX(ID_Cliente) as Id FROM cliente";
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectId);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next())
			{
				bean.setId(rs.getInt("Id")+1);
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
			preparedStatement.setInt(1, bean.getId());
			preparedStatement.setString(2, bean.getNome());
			preparedStatement.setString(3, bean.getCognome());
			preparedStatement.setString(4, bean.getEmail());
			preparedStatement.setString(5, bean.getPassword());
			preparedStatement.setString(6, bean.getData_Nascita());
			preparedStatement.setString(7, bean.getSesso());
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
	public int doUpdate(UtenteBean bean) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Integer id = bean.getId();
		String selectSQL = "Update cliente SET Nome=?, Cognome=?, Email=?, Telefono=? WHERE ID_cliente = " + id;
		
	
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);;
			preparedStatement.setString(1, bean.getNome());
			preparedStatement.setString(2, bean.getCognome());
			preparedStatement.setString(3, bean.getEmail());
			preparedStatement.setString(4, bean.getTelefono());
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
		return 1;
	}
	
	public int doUpdatePass(UtenteBean bean) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Integer id = bean.getId();
		String selectSQL = "Update cliente SET Password=? WHERE ID_cliente = " + id;
		
	
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);;
			preparedStatement.setString(1, bean.getPassword());
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
		return 1;
	}


	@Override
	public boolean doDelete(int code) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public UtenteBean doRetrieveByKey(int code) throws SQLException{
	    Connection connection = null;
		PreparedStatement preparedStatement = null;
		UtenteBean bean = new UtenteBean();
		String selectSQL = "SELECT * FROM cliente WHERE ID_cliente = " + code;
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
	
			if (rs.next()) {
				bean.setId(rs.getInt("ID_cliente"));
				bean.setNome(rs.getString("Nome"));
				bean.setCognome(rs.getString("Cognome"));
				bean.setEmail(rs.getString("Email"));
				bean.setData_Nascita(rs.getString("Data_Nascita"));
				bean.setStato_account(rs.getString("Stato_Account"));
				bean.setAdmin(rs.getBoolean("Admin"));
				bean.setTelefono(rs.getString("Telefono"));
				bean.setPassword(rs.getString("Password"));
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


	@Override
	public Collection<UtenteBean> doRetrieveAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	


}
