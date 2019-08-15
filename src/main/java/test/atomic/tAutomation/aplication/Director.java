package test.atomic.tAutomation.aplication;

import java.util.ArrayList;
import java.util.List;

public class Director {
	
	private String name;
	private String birth;
	
	private List<String> filmes = new ArrayList<String>();
	
	public Director() {
		
	}

	public Director(String name, String birth) {
		super();
		this.name = name;
		this.birth = birth;
	}

	public String getName() {
		return name;
	}

	public void setDiretor(String name) {
		this.name = name;
	}

	public List<String> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<String> filmes) {
		this.filmes = filmes;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "Director [name=" + name + ", birth=" + birth + ", filmes=" + filmes + "]";
	}
	
	

}
