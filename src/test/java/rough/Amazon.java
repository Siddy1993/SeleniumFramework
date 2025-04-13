package rough;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[]args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		
		//Clicking on all navigation button
		//WebElement All = driver.findElement(By.id("nav-hamburger-menu"));
        //All.click()	;	
		
		
		//Printing all item of top menu bar
//		List<WebElement> nav_menu = driver.findElements(By.xpath("//*[@id='nav-xshop-container']//li"));
//		
//		for (WebElement items: nav_menu ) {
//			
//			System.out.println(items.getText());
//		}
		

		
		WebElement mobiles = driver.findElement(By.xpath("//div[normalize-space()='Mobiles']"));
		mobiles.click();	
		
		Thread.sleep(3000);	
		
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//span[text()='Brands']/ancestor::div[@class='a-section a-spacing-none']/descendant::i[@class='a-icon a-icon-checkbox']"));
        for(int i=0;i<checkBoxes.size();i++)
        {
        	
       checkBoxes.get(i).click();	
        	
        }
		

		
			
      Thread.sleep(5000);
		driver.close();
		

	}

}