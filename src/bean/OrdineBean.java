package bean;


import java.time.LocalDate;


public class OrdineBean {
	private Integer IdOrdine;
	private String Descrizione;
	private String Destinazione;
	private Integer NumeroProdotti;
	private Float CostoSpedizione;
	private LocalDate Spedizione;
	private Float Costo;
	private Integer IdProdotto;
	private Integer Cliente_Ordine;
	
	@Override
	public String toString() {
		return "OrdineBean [IdOrdine=" + IdOrdine + ", Descrizione=" + Descrizione + ", Destinazione=" + Destinazione
				+ ", NumeroProdotti=" + NumeroProdotti + ", CostoSpedizione=" + CostoSpedizione + ", Spedizione="
				+ Spedizione + ", Costo=" + Costo + ", IdProdotto=" + IdProdotto + ", Cliente_Ordine=" + Cliente_Ordine
				+ "]";
	}
	public Integer getIdOrdine() {
		return IdOrdine;
	}
	public void setIdOrdine(Integer idOrdine) {
		IdOrdine = idOrdine;
	}
	public String getDescrizione() {
		return Descrizione;
	}
	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}
	public String getDestinazione() {
		return Destinazione;
	}
	public void setDestinazione(String destinazione) {
		Destinazione = destinazione;
	}
	public Integer getNumeroProdotti() {
		return NumeroProdotti;
	}
	public void setNumeroProdotti(Integer numeroProdotti) {
		NumeroProdotti = numeroProdotti;
	}
	public Float getCostoSpedizione() {
		return CostoSpedizione;
	}
	public void setCostoSpedizione(Float costoSpedizione) {
		CostoSpedizione = costoSpedizione;
	}
	public LocalDate getSpedizione() {
		return Spedizione;
	}
	public void setSpedizione(LocalDate localDate) {
		Spedizione = localDate;
	}

	public Float getCosto() {
		return Costo;
	}
	public void setCosto(Float costo) {
		Costo = costo;
	}
	public Integer getIdProdotto() {
		return IdProdotto;
	}
	public void setIdProdotto(Integer idProdotto) {
		IdProdotto = idProdotto;
	}
	public OrdineBean() {
		super();
	}
	public Integer getCliente_Ordine() {
		return Cliente_Ordine;
	}
	public void setCliente_Ordine(Integer cliente_Ordine) {
		Cliente_Ordine = cliente_Ordine;
	}
	
}
