package bean;

public class IndirizzoBean {
	private Integer IdIndirizzo;
	private String Via;
	private String Cap;
	private String Citta;
	private String Provincia;
	private String Telefono;
	private Integer Cliente;
	public Integer getIdIndirizzo() {
		return IdIndirizzo;
	}
	public void setIdIndirizzo(Integer idIndirizzo) {
		IdIndirizzo = idIndirizzo;
	}
	public String getVia() {
		return Via;
	}
	public void setVia(String via) {
		Via = via;
	}
	public String getCap() {
		return Cap;
	}
	public void setCap(String cap) {
		Cap = cap;
	}
	public String getCitta() {
		return Citta;
	}
	public void setCitta(String citta) {
		Citta = citta;
	}
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String provincia) {
		Provincia = provincia;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public Integer getCliente() {
		return Cliente;
	}
	public void setCliente(Integer cliente) {
		Cliente = cliente;
	}
	@Override
	public String toString() {
		return "IndirizzoBean [IdIndirizzo=" + IdIndirizzo + ", Via=" + Via + ", Cap=" + Cap + ", Citta=" + Citta
				+ ", Provincia=" + Provincia + ", Telefono=" + Telefono + ", Cliente=" + Cliente + "]";
	}
	public IndirizzoBean() {
		super();
	}
	
}
