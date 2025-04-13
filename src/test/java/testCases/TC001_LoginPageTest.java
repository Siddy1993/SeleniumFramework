package testCases;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.TestBase;
import pageoObjects.LoginPage;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import utilities.ActionDriver;



public class TC001_LoginPageTest extends TestBase {
	
public LoginPage loginPage;
public ActionDriver actionDriver;
	
	@BeforeMethod
	public void initObjects() {
        System.out.println("Driver in BeforeMethod: " + driver);
        if (driver == null) {
            throw new RuntimeException("❌ WebDriver is not initialized.");
        }

        loginPage = new LoginPage(driver);
        actionDriver = new ActionDriver();
    }

   
     
     @Test(priority=1, groups = {"login"})
     public void enterUsername() throws IOException {
         WebElement usernameInput = loginPage.usernameField;
         actionDriver.sendKeys(usernameInput, p.getProperty("username"), "Username entered successfully", 10);}
    
     
     @Test(priority=2 , groups = {"login"})
     public void enterPassword() throws IOException {
         WebElement passwordInput = loginPage.passwordField;
         actionDriver.sendKeys(passwordInput, p.getProperty("password"), "Password entered successfully", 10);}
     
     
     @Test(priority=3, groups = {"smoke"})

     public void clickOnLoginButton() throws IOException, InterruptedException {
    	 actionDriver.clickElement(loginPage.loginBtn, "Clicked on Login button", 10);
     }
     
    
      
    }
    
	
	
	



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

