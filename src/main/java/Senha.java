
public class Senha {

	private boolean prioridade;
	private String numero;

	public Senha(String numero) {
		this.numero = numero;
		this.prioridade = false;
	}
	
	public Senha(String numero, boolean prioridade) {
		this.numero = numero;
		this.prioridade = prioridade;
	}

	public boolean isPrioridade() {
		return prioridade;
	}

	public void setPrioridade(boolean prioridade) {
		this.prioridade = prioridade;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
