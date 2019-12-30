package ebay;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class automation_ebay {
	
	public void ebay_test() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\eclipse\\NavegadoresPaths\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.manage().window().maximize();
		
		//1. Ingresar a eBay
		driver.get("https://www.ebay.com/");
		
		//2. Buscar 'zapatos'
		WebElement search = driver.findElement(By.xpath("//input[@id='gh-ac']"));
		wait.until(ExpectedConditions.elementToBeClickable(search)).click();

		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Zapatos");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
		Thread.sleep(1000);
		
		//3. Buscar marca 'PUMA' 
		JavascriptExecutor jsScrollDownCassualDresses = (JavascriptExecutor) driver;
		jsScrollDownCassualDresses.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@id='x-refine__group_1__1']//li[7]//div[1]//a[1]//div[1]//input[1]")).click();
		Thread.sleep(1000);
		
		//4. Elegir tamaño 10
		driver.findElement(By.xpath("//div[@id='x-refine__group_1__0']//li[5]//div[1]//a[1]//div[1]//input[1]")).click();
		Thread.sleep(1000);

		//5. Imprimir el número de resultados        
        String results_shoes = driver.findElement
                (By.xpath("//h1[@class='srp-controls__count-heading']")).getText();
        System.out.println(results_shoes);
		
        //6. Ordenar el precio por ascendente
        Actions orderBy = new Actions(driver);
        orderBy.moveToElement(driver.findElement(By.xpath("//div[@id='w9']//div[contains(@class,'srp-controls__control--legacy')]")))
        .perform();
        
        driver.findElement(By.xpath("//div[contains(@class,'srp-controls__row-cells right clearfix')]//li[4]//a[1]")).click();
		Thread.sleep(1000);
		
		//7. Mantener el orden tomando los primeros 5 resultados
		//8. Elige los primeros 5 productos con sus precios e imprímelos en la consola
		
		List<WebElement> list_text = driver.findElements(By.className("s-item__title"));
		List<WebElement> list_price = driver.findElements(By.className("s-item__price"));
        
			for (int i = 0, j = 0; i < list_text.size() && j < 5; i++, j++) {
			WebElement desc_pro = list_text.get(j);
			WebElement prec_pro = list_price.get(j);
	
			System.out.println(desc_pro.getText() + ": " + prec_pro.getText());
			
			}
			
		}
	}


