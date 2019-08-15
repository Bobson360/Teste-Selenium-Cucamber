package test.atomic.tAutomation.aplication;

/**
 * 
 * @author Robson Rodrigues da Silva
 * 		   Email: bobson278@gmail.com </br>
 * 		   GitHub: https://github.com/Bobson360</br>
 *
 *	Classe Movie monta um objeto do tipo Movie contendo nome, data de lançamento e diretor
 */
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
