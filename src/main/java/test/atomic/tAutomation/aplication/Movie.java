package test.atomic.tAutomation.aplication;

public class Movie {
	
	private String name;
	private String lancamento;
	private Director diretor;

	public Movie() {
		
	}

	public Movie(String name, String lancamento, Director diretor) {
		super();
		this.name = name;
		this.lancamento = lancamento;
		this.diretor = diretor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLancamento() {
		return lancamento;
	}

	public void setLancamento(String lancamento) {
		this.lancamento = lancamento;
	}

	public Director getDiretor() {
		return diretor;
	}

	public void setDiretor(Director diretor) {
		this.diretor = diretor;
	}
	
	
}
