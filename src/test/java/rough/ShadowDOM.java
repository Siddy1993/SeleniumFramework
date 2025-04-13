package rough;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOM {
	
	
		public static void main(String[] args) throws InterruptedException {
	ChromeDriver driver = new ChromeDriver();
			
			driver.get("https://books-pwakit.appspot.com/");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			
			
			// Directly accessing the input field using only level of shadow host because of how the component was built with slotting.
			
			SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
			
			Thread.sleep(1000);
			shadow.findElement(By.cssSelector("#input")).sendKeys("Siddhartha");		
			
			Thread.sleep(3000);

			
			
			// Second approach using nested shadow doms to nterratc with element by navigating one by one 
			
			SearchContext shadow1 = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
			SearchContext shadow2 = shadow1.findElement(By.cssSelector("app-header")).getShadowRoot();
			SearchContext shadow3 = shadow2.findElement(By.cssSelector("app-toolbar[class='toolbar-bottom']")).getShadowRoot();
			SearchContext shadow4 = shadow3.findElement(By.cssSelector("book-input-decorator")).getShadowRoot();

			shadow4.findElement(By.cssSelector("#input")).sendKeys("Siddhartha");
			
			
			
			
}
}


