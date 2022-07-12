package bean;

import java.io.Serializable;

public class UtenteBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String Nome;
	private String Cognome;
	private String Data_Nascita;
	private String Email;
	private String Password;
	private String Stato_Account;
	private Boolean Admin;
	private String Sesso;
	private String Telefono;
	
	public String getSesso() {
		return Sesso;
	}

	public void setSesso(String sesso) {
		Sesso = sesso;
	}

	public Boolean getAdmin() {
		return Admin;
	}

	public void setAdmin(Boolean admin) {
		Admin = admin;
	}

	public UtenteBean() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	public String getData_Nascita() {
		return Data_Nascita;
	}
	public void setData_Nascita(String Data_Nascita) {
		this.Data_Nascita = Data_Nascita;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getStato_account() {
		return Stato_Account;
	}
	public void setStato_account(String stato_account) {
		Stato_Account = stato_account;
	}

	@Override
	public String toString() {
		return "UtenteBean [id=" + id + ", Nome=" + Nome + ", Cognome=" + Cognome + ", Data_Nascita=" + Data_Nascita
				+ ", Email=" + Email + ", Password=" + Password + ", Stato_Account=" + Stato_Account + ", Admin="
				+ Admin + "]";
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	

	
}
