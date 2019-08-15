package test.atomic.tAutomation.pages;

import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import test.atomic.tAutomation.aplication.App;
import test.atomic.tAutomation.common.PageBase;

/**
 * 
 * @author Robson Rodrigues da Silva
 * 		   Email: bobson278@gmail.com </br>
 * 		   GitHub: https://github.com/Bobson360</br>
 *
 */
public class GoogleSearchResultsPage extends PageBase{
	
	GoogleHomePage googleHomePage = new GoogleHomePage();
	
	private String baseUrl = "https://www.google.com/search?q={director}+{movie}";
	
	/**
	 * Metodo contrutor
	 */
	public GoogleSearchResultsPage() {
		browserConfig();
	}
	
	/**
	 * Configura o navegador
	 */
	public static void browserConfig() {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
	
	/**
	 * monta a url para pesquisa
	 * 
	 * @param director
	 * @param movie
	 * @return newUrl
	 */
	public String pesquisaAlternativa(String director, String movie) {
		String newUrl;
		newUrl = baseUrl.replace("{director}", director);
		newUrl = newUrl.replace("{movie}", movie);
		
		return newUrl;
	}
	
	/**
	 * faz as pesquisa no google com base nos dados da matriz
	 * @return LinkedHashMap<String, Boolean>
	 * @throws InterruptedException
	 */
	public LinkedHashMap<String, Boolean> pesquisa() throws InterruptedException {
		LinkedHashMap<String, Boolean> pesquisa = new LinkedHashMap<String, Boolean>();
		
		/*
		 *  Intancia da classe App()
		 */
		App app = new App();
		
		for(int i = 0; i < app.directors().size(); i++) {
			for(int j = 0; j < app.directors().get(i).getFilmes().size(); j ++) {
				
				/*
				 * Configa as Strings para pesquisa
				 */
				String director = app.directors().get(i).getName();
				String movie = app.directors().get(i).getFilmes().get(j);
				
				googleHomePage.googleSearch(director + " " + movie);
				
				/*
				 * Tenta fazer a pesquisa pela pagina inicial do google
				 */
				try {
					
					/*
					 * Cria uma nova instancia do elemnto
					 */
					WebElement resultado = driver.findElement(By.id("resultStats"));
					String test = "Pesquisa: " + director + " " + movie + " " + resultado.getText();
					pesquisa.put(test, true);
					
				}catch (Exception e) {
					
					/*
					 * Tenta fazer a pesquisa pela url
					 */
					try{
						System.out.println("não existe resultStats para esta pesquisa, tentando metodo alternativo.");
						
						/*
						 * Recebe a nova url para pesquisa
						 */
						String pesqAltern = pesquisaAlternativa(director, movie);
						driver.get(pesqAltern);
						
						/*
						 * Cria uma nova instancia do elemnto
						 */
						WebElement resultado = driver.findElement(By.id("resultStats"));
						String test = "Pesquisa feita por link direto: " + director + " " + movie + " " + resultado.getText();
						pesquisa.put(test, true);
					
						/*
						 * Dispara um erro e falha o teste
						 */
					}catch (Exception err) {
						System.out.println("unexpected error");
						System.out.println(err);
						assertTrue(false);
					}
					
				}
				
				/*
				 * Volta para a home do google
				 */
				googleHomePage.googleHome();
			}
		}
		
		/*
		 * fecha o navegador
		 */
		driver.quit();
		
		return pesquisa;
	}
}
