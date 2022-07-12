package bean;

public class CategoriaBean {
	private Integer IdCategoria;
	private String Descrizione;
	private String Nome;
	private Integer IdProdotto;
	public Integer getIdCategoria() {
		return IdCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		IdCategoria = idCategoria;
	}
	public String getDescrizione() {
		return Descrizione;
	}
	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public Integer getIdProdotto() {
		return IdProdotto;
	}
	public void setIdProdotto(Integer idProdotto) {
		IdProdotto = idProdotto;
	}
	@Override
	public String toString() {
		return "CategoriaBean [IdCategoria=" + IdCategoria + ", Descrizione=" + Descrizione + ", Nome=" + Nome
				+ ", IdProdotto=" + IdProdotto + "]";
	}
	
	public CategoriaBean() {
		super();
	}
	
	
}
