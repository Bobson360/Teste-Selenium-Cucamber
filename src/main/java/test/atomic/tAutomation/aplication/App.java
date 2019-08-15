package test.atomic.tAutomation.aplication;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	
	
    public static void main( String[] args ) throws ParseException{
    	
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
    	System.out.println(jamesCameron);
    	System.out.println(michaelBay);

    }
    
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
