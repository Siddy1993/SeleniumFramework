package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URI;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class TestBase {

	public static WebDriver driver;
	public static Properties p;
	
	
	
	@Parameters({"browser","os"})
    @BeforeSuite
    public void setup(String browser, String os) throws IOException {
		System.out.println("========== Inside setup ==========");
	    System.out.println("Browser: " + browser + " | OS: " + os);

		// Loading config.properties file
		FileReader file = new FileReader(".//src//test//resources//properties//Config.properties");
		p = new Properties();
		p.load(file);
		
	    boolean isHeadless = Boolean.parseBoolean(p.getProperty("headless"));

		
		
		//Grid Execution
		
		// Remote execution     
	
		// Browser
	    if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
	        try {
	            URL remoteUrl = URI.create("http://192.168.0.22:4444").toURL();

	            switch (browser.toLowerCase()) {
	            
	                case "chrome":
	                    ChromeOptions chromeOptions = new ChromeOptions();
	                    //if (isHeadless) chromeOptions.addArguments("--headless=new"); ///headless browser
	                    chromeOptions.setPlatformName(os);
	                        driver = new RemoteWebDriver(remoteUrl, chromeOptions);
		                    break;
	                                                      

	                case "firefox":
	                    FirefoxOptions firefoxOptions = new FirefoxOptions();
	                   // if (isHeadless) firefoxOptions.addArguments("--headless");
	                    firefoxOptions.setPlatformName(os);
	                    driver = new RemoteWebDriver(remoteUrl, firefoxOptions);
	                    break;

	                default:
	                    System.out.println("No matching browser");
	                    return;
	            }

	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        }

	
		
		
		// LocalExecution
	      
		     if (p.getProperty("execution_env").equalsIgnoreCase("local")) {

	        switch (browser.toLowerCase()) {
	            case "chrome":
	                ChromeOptions chromeOptions = new ChromeOptions();
                    //chromeOptions.setExperimentalOption("excludeSwitches", new String[] {"enableautomation"}); // to remove chrome is being controlled message
	                if (isHeadless) chromeOptions.addArguments("--headless=new");
	                driver = new ChromeDriver(chromeOptions);
	                break;

	            case "firefox":
	                FirefoxOptions firefoxOptions = new FirefoxOptions();
	                if (isHeadless) firefoxOptions.addArguments("--headless");
	                driver = new FirefoxDriver(firefoxOptions);
	                break;

	            case "edge":
	                driver = new EdgeDriver(); // Edge headless can be added similarly
	                break;

	            default:
	                System.out.println("Invalid browser name..");
	                return;
	        }}
	    
	    
	    driver.manage().deleteAllCookies();
	    driver.get(p.getProperty("appURL"));
	    driver.manage().window().maximize();
	
	
	    }  
	}
	
	
	
	

	@AfterTest(alwaysRun = true)
	public void tearDown() {
	    
	    if (driver != null) {
	        driver.quit(); // Only close at the end
	        driver = null;
	    }
	}	
	
	
	

	public static String captureScreen(String tname) throws IOException {
		
		 if (driver == null) {
		        System.out.println("⚠️ WebDriver is null in captureScreen()!");
		        return null;
		    }

		 File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String screenshotDir = System.getProperty("user.dir") + "/reports/screenshots";
	        new File(screenshotDir).mkdirs(); // Make sure folder exists

	        String destPath = screenshotDir + "/" + tname + ".png";
	        File destFile = new File(destPath);
	        FileUtils.copyFile(src, destFile);
	    return "./screenshots/" + tname + ".png";
	}

}
