package rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='PIM']")).click();
		
		Thread.sleep(3000);

		
		WebElement cb = driver.findElement(By.xpath("//label[text()='Employment Status']/ancestor::div[@class='oxd-grid-item oxd-grid-item--gutters']/descendant::div[@class='oxd-select-text--after']"));
		cb.click();
		
		
		
		
		System.out.println(cb.getText());
		
		Thread.sleep(3000);


		
	}

}
