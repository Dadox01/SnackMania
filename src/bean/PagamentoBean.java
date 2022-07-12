package bean;

import java.sql.Date;

public class PagamentoBean {
	private Integer IdPagamento;
	private String NumeroCarta;
	private String Intestatario;
	private Integer Cvv;
	private Date Scadenza;
	public Integer getIdPagamento() {
		return IdPagamento;
	}
	public void setIdPagamento(Integer idPagamento) {
		IdPagamento = idPagamento;
	}
	public String getNumeroCarta() {
		return NumeroCarta;
	}
	public void setNumeroCarta(String numeroCarta) {
		NumeroCarta = numeroCarta;
	}
	public String getIntestatario() {
		return Intestatario;
	}
	public void setIntestatario(String intestatario) {
		Intestatario = intestatario;
	}
	public Integer getCvv() {
		return Cvv;
	}
	public void setCvv(Integer cvv) {
		Cvv = cvv;
	}
	public Date getScadenza() {
		return Scadenza;
	}
	public void setScadenza(Date scadenza) {
		Scadenza = scadenza;
	}
	@Override
	public String toString() {
		return "PagamentoBean [IdPagamento=" + IdPagamento + ", NumeroCarta=" + NumeroCarta + ", Intestatario="
				+ Intestatario + ", Cvv=" + Cvv + ", Scadenza=" + Scadenza + "]";
	}
	public PagamentoBean() {
		super();
	}
	
}
