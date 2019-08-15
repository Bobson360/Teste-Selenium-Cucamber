package test.atomic.tAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import test.atomic.tAutomation.common.PageBase;

public class GoogleHomePage extends PageBase{
	public void googleHome() {
		driver.get("https://www.google.com/");
	}
	
	public void googleSearch(String busca) {
		System.out.println(busca);
		WebElement res = driver.findElement(By.name("q"));
		res.sendKeys(busca + Keys.ENTER);
	}
}
