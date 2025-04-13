 package testCases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import base.TestBase;
import pageoObjects.BasePage;
import pageoObjects.LoginPage;
import utilities.DataProviders;

public class TC003_Login_DataDrivenTest extends TestBase {
	
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_login(String email, String pwd, String exp) throws InterruptedException, IOException
	{
	
	LoginPage hp = new LoginPage(driver);
	
	

}
}