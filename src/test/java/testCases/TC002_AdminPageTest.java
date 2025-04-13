package testCases;



import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageoObjects.AdminPage;
import utilities.ActionDriver;





public class TC002_AdminPageTest extends TestBase {
	

public AdminPage adminPage;
public ActionDriver actionDriver;

@BeforeMethod
	public void setup() {
		
	adminPage = new AdminPage(driver);
	actionDriver = new ActionDriver();

	    
	    }

	
        @Test(priority=1)
	    public void clickOnAdminButton() throws IOException, InterruptedException  {
	        WebElement adminButton = adminPage.adminMenuBtn;
	        actionDriver.clickElement(adminButton, "Clicked on Admin Button", 5);}
	         
	         
	         @Test(priority=2)
	 	    public void selectCheckBoxes() throws IOException, InterruptedException  {
	 	        List<WebElement> checkBox = adminPage.checkBox;
 	 	        actionDriver.validateCheckBox(checkBox, "Selected all check boxes", 5);  
 	 	        
             Thread.sleep(10000);
	        
        }}
	            
