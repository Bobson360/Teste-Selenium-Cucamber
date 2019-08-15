package test.atomic.tAutomation.utils;

import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map.Entry;


/**
 * 
 * @author Robson Rodrigues da Silva
 * 		   Email: bobson278@gmail.com </br>
 * 		   GitHub: https://github.com/Bobson360</br>
 *
 */
public class Utils {
	/**
	 * Recebe uma Mapa e faz a validação de acordo com o valor
	 * 
	 * @param pesquisa
	 */
	public void validations(LinkedHashMap<String, Boolean> pesquisa) {
		System.setProperty("log4j.configurationFile","log4j2-testConfig.xml");
		for (Entry<String, Boolean> x : pesquisa.entrySet()) {
			try {
				assertTrue("Pesquisa realisado com sucesso", x.getValue());
			} catch (Exception e) {
				assertTrue("falha ao fazer a pesquisa", x.getValue());
			}
			System.out.println(x.getKey() + " " + x.getValue());
		}
	}
}
