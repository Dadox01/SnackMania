package bean;

public class PossiedeBean {
	private Integer IdCliente;
	private Integer IdPagamento;
	public Integer getIdCliente() {
		return IdCliente;
	}
	public void setIdCliente(Integer idCliente) {
		IdCliente = idCliente;
	}
	public Integer getIdPagamento() {
		return IdPagamento;
	}
	public void setIdPagamento(Integer idPagamento) {
		IdPagamento = idPagamento;
	}
	@Override
	public String toString() {
		return "PossiedeBean [IdCliente=" + IdCliente + ", IdPagamento=" + IdPagamento + "]";
	}
	public PossiedeBean() {
		super();
	}
	
}
