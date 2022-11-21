import static org.junit.jupiter.api.Assertions.assertEquals;

import org.asynchttpclient.util.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Driver {

		
		WebDriver webDriver;
		
		
		@BeforeAll
		public void setupAll () {
		System.setProperty("webdriver.chromer.driver", 
				"src\\test\\resources\\ChromeDriver\\chromedriver.exe" );
		}
		
		
		@BeforeEach
		public void setup() {
			webDriver = new ChromeDriver();
			webDriver.manage().window().maximize();
		}
		
		@AfterEach
		public void close() {
			webDriver.close();
		}
		
		
		@Test
		public void openMercadoLivrePage() {
			webDriver.get("https://www.mercadolivre.com.br/");
			Assertions.assertEquals("https://www.mercadolivre.com.br/",
	                webDriver.getCurrentUrl());
		}
		
		@Test
		public void fidBotaoTest() {
			webDriver.get("https://www.mercadolivre.com.br/");
			WebElement botaoML = webDriver.findElement(
					By.xpath("//*[@id=\"cb1-edit\"]/div[1]/div[4]/div[2]/a[3]\""));
			botaoML.click();
	        Assertions.assertEquals("https://www.mercadolivre.com.br/c/calcados-roupas-e-bolsas#nav-header",
	                webDriver.getCurrentUrl());
			
		}
		
		
		@Test
	    public void searchTelevisaoTest(){
	        webDriver.get("https://www.mercadolivre.com.br/");
	        WebElement search = webDriver.findElement(By.id("nav-icon-search"));
	        search.sendKeys("televisão");
	        search.submit();
	        Assertions.assertTrue(webDriver.getCurrentUrl().contains("televisão"));
	    }
		
		
		@Test
	    public void tooltipTitleTest(){
	        webDriver.get("https://www.mercadolivre.com.br/");
	        Actions actions = new Actions(webDriver);

	        WebElement botaoGe = webDriver.findElement(By.xpath("//*[@id=\"cb1-edit\\\"]/div[1]/div[4]/div[2]/a[3]\\"));
	        actions.moveToElement(botaoGe).perform();
	        Assertions.assertEquals("sapato", botaoGe.getAttribute("olympikus masculino"));
	    }

		
    

}