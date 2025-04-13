package rough;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {
	
	
	
	
	
	static void FutureDate(WebDriver driver,String year,String month,String date) {
		
		
		//select month and year
		
		while(true) {
			
        String currentMonth=  driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
        String currentYear=  driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
        
        if (currentMonth.equals(month) && currentYear.equals(year)) {
        	
        break;	
        	
        	
        }
			
        driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); //next button

			
		}
		
		//select date
		
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		
		
		for (WebElement dt:dates) {
			
			if(dt.getText().equals(date));
			{
				
				dt.click();			
				break;
				}
		
	}
	
	
}

	
	
	static void PastDate(WebDriver driver,String month, String year,String date) {
		
		
		//select month and year
		
		while(true) {
			
        String currentMonth=  driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
        String currentYear=  driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
        
        if (currentMonth.equals(month) && currentYear.equals(year)) {
        	
        break;	
        	
        	
        }
			
        driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); // previous buttom

			
		}
		
		//select date
		
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		
		
		for (WebElement dt:dates) {
			
			if(dt.getText().equals(date));
			{
				
				dt.click();			
				break;
				}
		
	}
	
	
}

	
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
				
				driver.get("https://testautomationpractice.blogspot.com/");
				driver.manage().window().maximize();
				Thread.sleep(3000);
				
				
				
				
				//Method 1: using sendkeys
				//driver.findElement(By.id("datepicker")).sendKeys("01/01/2025");
				//Thread.sleep(3000);

               //Method 2:
				String year="2025";
				String month="November";
				String date ="10";
				
				
				driver.findElement(By.id("datepicker")).click(); //opesn date picker
				
				FutureDate(driver,year,month,date);
				
				Thread.sleep(2000);
				
				driver.quit();		
	

}}
