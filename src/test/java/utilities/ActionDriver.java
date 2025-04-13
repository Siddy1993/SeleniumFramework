package utilities;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import Listeners.ExtentReportListener;

public class ActionDriver {

    public  WebDriver driver;
    public  Logger logger = LogManager.getLogger(ActionDriver.class);
    Properties p;

    
     
    
    public void waitForElementToBeClickable(WebElement element, int timeoutInSeconds) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            ExtentReportListener.test.log(Status.PASS, "Element is clickable.");
            logger.info("Element is clickable.");
        } catch (TimeoutException | NoSuchElementException | StaleElementReferenceException | ElementNotInteractableException e) {
            ExtentReportListener.test.log(Status.FAIL, "Error: " + e.getMessage());
            logger.error("Error waiting for element to be clickable: " + e.getMessage());
            throw e;
        }
    }

    public void sendKeys(WebElement element, String data, String message, int timeOut) throws IOException {
        waitForElementToBeClickable(element, timeOut);
        try {
            element.sendKeys(data);
            ExtentReportListener.test.log(Status.PASS, message);
            logger.info("Sent keys: " + data);
        } catch (WebDriverException e) {
            ExtentReportListener.test.log(Status.FAIL, "Error sending keys: " + e.getMessage());
            logger.error("Error sending keys: " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void clickElement(WebElement element, String message, int timeOut) throws IOException {
        waitForElementToBeClickable(element, timeOut);
        try {
            element.click();
            ExtentReportListener.test.log(Status.PASS, message);
            logger.info("Clicked element: " + message);
        } catch (WebDriverException e) {
            ExtentReportListener.test.log(Status.FAIL, "Error clicking element: " + e.getMessage());
            logger.error("Error clicking element: " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void waitForElementToBeVisible(WebElement element, int timeoutInSeconds, String message) throws IOException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));
            ExtentReportListener.test.log(Status.PASS, message);
            logger.info("Element is visible: " + message);
        } catch (WebDriverException e) {
            ExtentReportListener.test.log(Status.FAIL, "Error waiting for visibility: " + e.getMessage());
            logger.error("Error waiting for visibility: " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementPresent(List<WebElement> elements) {
        return !elements.isEmpty();
    }

    public void waitForFrameAndSwitchToIt(WebElement frameElement, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
            ExtentReportListener.test.log(Status.PASS, "Switched to frame successfully.");
            logger.info("Switched to frame successfully.");
        } catch (WebDriverException e) {
            ExtentReportListener.test.log(Status.FAIL, "Error switching to frame: " + e.getMessage());
            logger.error("Error switching to frame: " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void validateDropdownValues(WebElement dropdownBar, String propertyKey, int timeOut) throws IOException {
        waitForElementToBeVisible(dropdownBar, timeOut, "Dropdown visible");
        try {
            String expectedValue = p.getProperty(propertyKey);
            String actualValue = dropdownBar.getText().trim();

            if (actualValue.equals(expectedValue)) {
                ExtentReportListener.test.log(Status.PASS, "Dropdown contains expected value: " + expectedValue);
                logger.info("Dropdown contains expected value: " + expectedValue);
            } else {
                ExtentReportListener.test.log(Status.FAIL, "Expected: " + expectedValue + ", but found: " + actualValue);
                logger.error("Dropdown validation failed. Expected: " + expectedValue + " but found: " + actualValue);
                Assert.fail("Dropdown does not contain expected value");
            }
        } catch (WebDriverException e) {
            ExtentReportListener.test.log(Status.FAIL, "Error validating dropdown: " + e.getMessage());
            logger.error("Error validating dropdown: " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    public void validateText(WebElement element, String expectedText, String message, int timeOut) throws IOException {
        waitForElementToBeVisible(element, timeOut, message);
        try {
            String actualText = element.getText().trim();

            if (actualText.equals(expectedText)) {
                ExtentReportListener.test.log(Status.PASS, message);
                logger.info("Text validation passed: " + expectedText);
            } else {
                ExtentReportListener.test.log(Status.FAIL, "Expected: " + expectedText + ", but found: " + actualText);
                logger.error("Text validation failed. Expected: " + expectedText + " but found: " + actualText);
                Assert.fail("Text validation failed");
            }
        } catch (WebDriverException e) {
        	ExtentReportListener.test.log(Status.FAIL, "Error validating text: " + e.getMessage());
            logger.error("Error validating text: " + e.getMessage());
            Assert.fail(e.getMessage());
        }}
            
            public void validateCheckBox(List<WebElement> element, String message, int timeOut) throws IOException {
                try {

                    for (int i=1;i<element.size();i++) {
                    	element.get(i).click();
                    }
                        ExtentReportListener.test.log(Status.PASS, message);
                        logger.info("Selected all the checkboxes: " + message);
                    }
                
            catch (WebDriverException e) {
                	ExtentReportListener.test.log(Status.FAIL, "Error validating checkbox: " + e.getMessage());
                    logger.error("Error validating checkbox: " + e.getMessage());
                    Assert.fail(e.getMessage());    
            
            
            
        }
    }
}
