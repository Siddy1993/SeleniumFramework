package pageoObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
    public WebDriver driver;

	
	
	public LoginPage(WebDriver driver) {
	    this.driver = driver; // <-- important line!

	PageFactory.initElements(driver,this);
	}
	
	


@FindBy(xpath="//img[@alt='company-branding']")
public WebElement brandLogo;

@FindBy(xpath="//h5[normalize-space()='Login']")
public WebElement loginHeaderText;

@FindBy(xpath="//i[contains(@class,'oxd-icon bi-person')]")
public WebElement userNameIcon;

@FindBy(xpath="//label[text()='Username']")
public WebElement usernameHeaderText;

@FindBy(xpath="//input[@name='username']")
public WebElement usernameField;

@FindBy(xpath="//i[contains(@class,'oxd-icon bi-key')]")
public WebElement passwordIcon;

@FindBy(xpath="//label[text()='Password']")
public  WebElement passwordHeadertext;

@FindBy(xpath="//p[normalize-space()='Forgot your password?']")
public WebElement forgotPasswordLink;

@FindBy(xpath="//input[@name='password']")
public WebElement passwordField;

@FindBy(xpath="//button[@type='submit']")
public WebElement loginBtn;


}





