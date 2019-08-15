package test.atomic.tAutomation.pages;

import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import test.atomic.tAutomation.aplication.App;
import test.atomic.tAutomation.common.PageBase;

public class GoogleSearchResultsPage extends PageBase{
	
	GoogleHomePage googleHomePage = new GoogleHomePage();
	
	private String baseUrl = "https://www.google.com/search?q={director}+{movie}";
	
	public GoogleSearchResultsPage() {
		browserConfig();
	}
	
	public static void browserConfig() {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public String pesquisaAlternativa(String director, String movie) {
		String newUrl;
		newUrl = baseUrl.replace("{director}", director);
		newUrl = baseUrl.replace("{movie}", movie);
		
		return newUrl;
	}
	
		
	public LinkedHashMap<String, Boolean> pesquisa() throws InterruptedException {
		LinkedHashMap<String, Boolean> pesquisa = new LinkedHashMap<String, Boolean>();
		
		
		App app = new App();
		
		for(int i = 0; i < app.directors().size(); i++) {
			for(int j = 0; j < app.directors().get(i).getFilmes().size(); j ++) {
				String director = app.directors().get(i).getName();
				String movie = app.directors().get(i).getFilmes().get(j);
				
				googleHomePage.googleSearch(director + " " + movie);
				
				try {
					WebElement resultado = driver.findElement(By.id("resultStats"));
					String test = "Pesquisa: " + director + " " + movie + " " + resultado.getText();
					System.out.println(test);
					pesquisa.put(test, true);
					
				}catch (Exception e) {
					try{
						System.out.println("não existe resultStats para esta pesquisa, tentando metodo alternativo.");
						String pesqAltern = pesquisaAlternativa(director, movie);
						driver.get(pesqAltern);
						
						WebElement resultado = driver.findElement(By.id("resultStats"));
						System.out.println("Pesquisa: " + director + " " + movie + " " + resultado.getText());
					}catch (Exception err) {
						System.out.println("unexpected error");
						System.out.println(err);
					}
					
				}
				
				googleHomePage.googleHome();
			}
		}
		return pesquisa;
	}
}
