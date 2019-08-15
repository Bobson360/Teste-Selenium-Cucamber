package test.atomic.tAutomation.aplication;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Robson Rodrigues da Silva
 * 		   Email: bobson278@gmail.com </br>
 * 		   GitHub: https://github.com/Bobson360</br>
 *
 */
public class App {
	

	/**
	 * monta instancias do tipo Director e Movie
	 * 
	 * @return ArrayList
	 */
    public List<Director> directors(){
    	Director jamesCameron = new Director("James Cameron", "16/08/1954");
    	Director michaelBay = new Director("Michael Bay", "17/02/1965");
    	
    	Movie terminator = new Movie("Terminator", "março de 1985", jamesCameron);
    	Movie titanic = new Movie("Titanic", "julho de 1997", jamesCameron);
    	Movie avatar = new Movie("Avatar", "Dezembro de 2009", jamesCameron);
    	
    	Movie armagedon = new Movie("Armagedon", "agosto de 1998", michaelBay);
    	Movie pearlHarbor = new Movie("Pearl Harbor", "junho de 2001", michaelBay);
    	Movie transformers = new Movie("Transformers", "julho de 2007", michaelBay);

    	jamesCameron.setFilmes(Arrays.asList(terminator.getName(), titanic.getName(), avatar.getName()));
    	
    	michaelBay.setFilmes(Arrays.asList(armagedon.getName(), pearlHarbor.getName(), transformers.getName()));
    	
    	return Arrays.asList(jamesCameron, michaelBay);
    }
}
