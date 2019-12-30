package ebay;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println(results_shoes+"\n");
		
        //6. Ordenar el precio por ascendente
        Actions orderBy = new Actions(driver);
        orderBy.moveToElement(driver.findElement(By.xpath("//div[@id='w9']//div[contains(@class,'srp-controls__control--legacy')]")))
        .perform();
        
        driver.findElement(By.xpath("//div[contains(@class,'srp-controls__row-cells right clearfix')]//li[4]//a[1]")).click();
		Thread.sleep(1000);
		
		//7. Mantener el orden tomando los primeros 5 resultados
		//8. Elige los primeros 5 productos con sus precios e imprímelos en la consola
		
		System.out.println("5 primeros productos y sus precios:");
		
		List<WebElement> list_text = driver.findElements(By.className("s-item__title"));
		List<WebElement> list_price = driver.findElements(By.className("s-item__price"));
        
			for (int i = 0, j = 0; i < list_text.size() && j < 5; i++, j++) {
			WebElement desc_pro = list_text.get(j);
			WebElement prec_pro = list_price.get(j);
	
			System.out.println(desc_pro.getText() + ": " + prec_pro.getText());
			
			}

		//9. Elige los primeros 5 productos con sus precios e imprímelos en la consola
			
			System.out.println("Productos ordenado en orden alfabetico:");
			
			String result_desc_1 =
			driver.findElement(By.xpath("//li[@id='srp-river-results-listing1']//a[@class='s-item__link']")).getText();
			
			String result_desc_2 =
			driver.findElement(By.xpath("//li[@id='srp-river-results-listing2']//a[@class='s-item__link']")).getText();
					
			String result_desc_3 =
			driver.findElement(By.xpath("//li[@id='srp-river-results-listing3']//a[@class='s-item__link']")).getText();
					
			String result_desc_4 =
			driver.findElement(By.xpath("//li[@id='srp-river-results-listing4']//a[@class='s-item__link']")).getText();
					
			String result_desc_5 =
			driver.findElement(By.xpath("//li[@id='srp-river-results-listing5']//a[@class='s-item__link']")).getText();
					
			List<String> slist = Arrays.asList(result_desc_1, result_desc_2, result_desc_3, result_desc_4, result_desc_5); 
			List<String> sortedList = slist.stream().sorted().collect(Collectors.toList());
			sortedList.forEach(System.out::println);	
			
			
		//10. Ordena e imprime los productos por precio (descendente)
			String result_price_1 =
			driver.findElement(By.xpath("//li[@id='srp-river-results-listing1']//div[@class='s-item__details clearfix']//div[1]")).getText();
					
			String result_price_2 =
			driver.findElement(By.xpath("//li[@id='srp-river-results-listing2']//div[@class='s-item__details clearfix']//div[1]")).getText();
					
			String result_price_3 =
			driver.findElement(By.xpath("//li[@id='srp-river-results-listing3']//div[@class='s-item__details clearfix']//div[1]")).getText();
					
			String result_price_4 =
			driver.findElement(By.xpath("//li[@id='srp-river-results-listing4']//div[@class='s-item__details clearfix']//div[1]")).getText();
					
			String result_price_5 =
			driver.findElement(By.xpath("//li[@id='srp-river-results-listing5']//span[@class='s-item__price']")).getText();
					
			List<String> plist = Arrays.asList(result_price_1, result_price_2, result_price_3, result_price_4, result_price_5); 
			Collections.sort(plist, Collections.reverseOrder());

			for(String str: plist){
				System.out.println(str);
			}
		}
	}


