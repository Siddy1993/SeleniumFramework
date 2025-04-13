
package rough;


import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePicker {

    // user defined method for converting month from string--->Month
    static Month convertMonth(String month) {
        HashMap<String, Month> monthMap = new HashMap<String, Month>();

        monthMap.put("January", Month.JANUARY);
        monthMap.put("February", Month.FEBRUARY);
        monthMap.put("March", Month.MARCH);
        monthMap.put("April", Month.APRIL);
        monthMap.put("May", Month.MAY);
        monthMap.put("June", Month.JUNE);
        monthMap.put("July", Month.JULY);
        monthMap.put("August", Month.AUGUST);
        monthMap.put("September", Month.SEPTEMBER);
        monthMap.put("October", Month.OCTOBER);
        monthMap.put("November", Month.NOVEMBER);
        monthMap.put("December", Month.DECEMBER);

        Month vmonth = monthMap.get(month);

        if (vmonth == null) {
            System.out.println("Invalid Month...");
        }

        return vmonth;
    }
    
    
    
    
    static void selectDate(WebDriver driver, String requiredYear, String requiredMonth, String requiredDate ) {
    	
    	            // Select year
    				WebElement yearDropDown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
    				Select selectYear = new Select(yearDropDown);
    				selectYear.selectByVisibleText(requiredYear);

    				
    				// Select month
    				while (true) {
    				    String displayMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

    				    // Convert requiredMonth & displayMonth to Month objects
    				    Month expectedMonth = convertMonth(requiredMonth);
    				    Month currentMonth = convertMonth(displayMonth);

    				    // Compare
    				    int result = expectedMonth.compareTo(currentMonth);

    				    // 0 -> months are equal
    				    // >0 -> future month (click next)
    				    // <0 -> past month (click previous)

    				    if (result == 0) {
    				        break;
    				    } else if (result > 0) {
    				        // Click next button
    				        driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
    				    } else {
    				        // Click previous button
    				        driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
    				    }
    				}
    				
    				
    				//select date
    				List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
    				
    				
    				for (WebElement dt:dates) {
    					
    					if(dt.getText().equals(requiredDate));
    					{
    						
    						dt.click();			
    						break;
    						}
    				
    				}}


public static void main(String[] args) throws InterruptedException {
	
	ChromeDriver driver = new ChromeDriver();
			
			driver.get("https://testautomationpractice.blogspot.com/");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			
			// Input Data
			String requiredYear = "2021";
			String requiredMonth = "June";
			String requiredDate = "15";

			driver.switchTo().frame("frame-one796456169");
			driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();
			selectDate(driver,requiredYear,requiredMonth,requiredDate);
			 
			

}}

