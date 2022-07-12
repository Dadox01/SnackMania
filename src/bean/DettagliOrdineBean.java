package bean;

public class DettagliOrdineBean {
	private Integer IdDettagliOrdine;
	private Integer Iva;
	private Integer IdOrdine;
	private Float Prezzo;
	private Integer Quantita;
	
	public Integer getIdDettagliOrdine() {
		return IdDettagliOrdine;
	}
	public void setIdDettagliOrdine(Integer idDettagliOrdine) {
		IdDettagliOrdine = idDettagliOrdine;
	}
	public Integer getIva() {
		return Iva;
	}
	public void setIva(Integer iva) {
		Iva = iva;
	}
	public Integer getIdOrdine() {
		return IdOrdine;
	}
	public void setIdOrdine(Integer idOrdine) {
		IdOrdine = idOrdine;
	}
	public Float getPrezzo() {
		return Prezzo;
	}
	public void setPrezzo(float f) {
		Prezzo = f;
	}
	public Integer getQuantita() {
		return Quantita;
	}
	public void setQuantita(Integer quantita) {
		Quantita = quantita;
	}
	
	
	public void setPrezzo(Float prezzo) {
		Prezzo = prezzo;
	}
	
	
	@Override
	public String toString() {
		return "DettagliOrdineBean [IdDettagliOrdine=" + IdDettagliOrdine + ", Iva=" + Iva + ", IdOrdine=" + IdOrdine
				+ ", Prezzo=" + Prezzo + ", Quantita=" + Quantita + "]";
	}
	public DettagliOrdineBean() {
		super();
	}
	
	
}
