package bean;


import java.time.LocalDate;

public class RecensioneBean {
	private Integer IdRecensione;
	private String 	Testo;
	private String Punteggio;
	private String Nome;
	private Integer IdProdotto;
	private LocalDate data;
	public Integer getIdRecensione() {
		return IdRecensione;
	}
	public void setIdRecensione(Integer idRecensione) {
		IdRecensione = idRecensione;
	}
	public String getTesto() {
		return Testo;
	}
	public void setTesto(String testo) {
		Testo = testo;
	}
	public String getPunteggio() {
		return Punteggio;
	}
	public void setPunteggio(String punteggio) {
		Punteggio = punteggio;
	}

	public Integer getIdProdotto() {
		return IdProdotto;
	}
	public void setIdProdotto(Integer idProdotto) {
		IdProdotto = idProdotto;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "RecensioneBean [IdRecensione=" + IdRecensione + ", Testo=" + Testo + ", Punteggio=" + Punteggio
				+ ", Nome=" + Nome + ", IdProdotto=" + IdProdotto + ", data=" + data + "]";
	}
	public RecensioneBean() {
		super();
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	
}
