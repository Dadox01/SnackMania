package bean;

public class ProdottoBean {
	private Integer IdProdotto;
	private Integer Quantita;
	private String 	Descrizione;
	private Integer Sconto;
	private String  Nome;
	private Float 	Prezzo;
	private String	Peso;
	private String Marca;
	private String immagine;
	
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public Integer getIdProdotto() {
		return IdProdotto;
	}
	public void setIdProdotto(Integer idProdotto) {
		IdProdotto = idProdotto;
	}
	public Integer getQuantita() {
		return Quantita;
	}
	public void setQuantita(Integer quantita) {
		Quantita = quantita;
	}
	public String getDescrizione() {
		return Descrizione;
	}
	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}
	public Integer getSconto() {
		return Sconto;
	}
	public void setSconto(Integer sconto) {
		Sconto = sconto;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public Float getPrezzo() {
		return Prezzo;
	}
	public void setPrezzo(Float prezzo) {
		Prezzo = prezzo;
	}
	public String getPeso() {
		return Peso;
	}
	public void setPeso(String i) {
		Peso = i;
	}
	@Override
	public String toString() {
		return "ProdottoBean [IdProdotto=" + IdProdotto + ", Quantita=" + Quantita + ", Descrizione=" + Descrizione
				+ ", Sconto=" + Sconto + ", Nome=" + Nome + ", Prezzo=" + Prezzo + ", Peso=" + Peso + "]";
	}
	public ProdottoBean() {
		super();
	}
	public String getImmagine() {
		return immagine;
	}
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	
	
}
