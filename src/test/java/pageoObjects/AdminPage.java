package pageoObjects;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

	
	  
	public AdminPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
	}

	

@FindBy(xpath="//span[normalize-space()='Admin']")
public WebElement adminMenuBtn;
	
@FindBy(xpath="//i[contains(@class,'oxd-icon bi-check')]")
public List<WebElement> checkBox;





}


	
	



