package rough;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaicWebTable {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		
	
		ChromeDriver driver = new ChromeDriver();
				
				driver.get("https://testautomationpractice.blogspot.com/");
				driver.manage().window().maximize();
				Thread.sleep(3000);
				
				
				
				
				int rows= driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
				System.out.println(rows);
				
				
				
                int cols = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
				System.out.println(cols);

				
                //reading all values
				
//				for(int r=2;r<=rows;r++)
//				{
//				
//				for(int c=1;c<=cols;c++)
//				
//				{
//				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
//				System.out.println(value);
//				
//				}
				
				
				for(int r=2;r<=rows;r++) {

				
				String author= driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
				System.out.println(author);

				}
				
				
	
				
				}	
				}
	
					
				
				
	
