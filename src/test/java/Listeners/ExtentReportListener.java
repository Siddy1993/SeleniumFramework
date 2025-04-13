
package Listeners;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import base.TestBase;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;



public class ExtentReportListener  implements ITestListener {
	
	public static ExtentSparkReporter sparkReporter;
	  public static ExtentReports extent;
	  public static ExtentTest test;
	    private static Map<String, ExtentTest> classTestMap = new HashMap<>(); // Stores class-level tests


	  String repName;
	  
	
	    public void setup() {
	        extent = new ExtentReports();
	        test = extent.createTest("Test Name");  // Ensure this is properly assigned
	    }

	 public void onStart(ITestContext context) {
		 
		
		 String timeStamp =new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());
		 String reportDir = System.getProperty("user.dir") + File.separator + "reports";
		 File dir = new File(reportDir);
		 if (!dir.exists()) {
		     dir.mkdirs(); // 🔹 Ensure the "reports" directory exists
		 }
		 repName = "Test-Report-" + timeStamp + ".html";
		 sparkReporter = new ExtentSparkReporter(reportDir + File.separator + repName);
		 extent = new ExtentReports();
		 extent.attachReporter(sparkReporter);
		  System.out.println("Extent Reports Initialized.");

		 
		    sparkReporter.config().setDocumentTitle("Automation Report"); // Title of report
		    sparkReporter.config().setReportName("Functional Testing"); // name of the report
		    sparkReporter.config().setTheme(Theme.STANDARD);	
		    
		    extent.attachReporter(sparkReporter);
		    extent.setSystemInfo("Computer Name", "localhost");
		    extent.setSystemInfo("Environment", "QA");
		    extent.setSystemInfo("Tester Name", System.getProperty("user.name"));
		   
		    String os = context.getCurrentXmlTest().getParameter("os");
		    extent.setSystemInfo("Operating System", os);

		    String browser = context.getCurrentXmlTest().getParameter("browser");
		    extent.setSystemInfo("Browser", browser);

		    List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
		    if (!includedGroups.isEmpty()) {
		        extent.setSystemInfo("Groups", includedGroups.toString());
		    }
	 
	 }
	 
	 
	 
	 @Override
	  public  void onTestStart(ITestResult result) {
		  String className = result.getTestClass().getName();

	        // Create test class node only once
	        if (!classTestMap.containsKey(className)) {
	            classTestMap.put(className, extent.createTest(className));
	        }

	        // Add method as a child test
	        test = extent.createTest(result.getMethod().getMethodName());
	    }	 

	  
	  
	  
	  
	  
	  public void onTestSuccess(ITestResult result) {
		  if (test != null) {  // 🔹 Ensure test is initialized
		        test.assignCategory(result.getMethod().getGroups());
		        test.log(Status.PASS, result.getName() + " got successfully executed");

		        try {
		            String imgPath = TestBase.captureScreen(result.getName());
		            if (imgPath != null && !imgPath.isEmpty()) {
		                test.addScreenCaptureFromPath(imgPath);
		            } else {
		                System.out.println("⚠️ Screenshot not captured. Path is null/empty.");
		            }
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
		    }
		}

	  
	  
	  
	  
		public void onTestFailure(ITestResult result) {
			  if (test != null) {  // 🔹 Ensure test is initialized
			test.assignCategory(result.getMethod().getGroups());
	        test.log(Status.INFO, result.getThrowable().getMessage());

	        try {
	            String imgPath = TestBase.captureScreen(result.getName());
	            if (imgPath != null && !imgPath.isEmpty()) {
	                test.addScreenCaptureFromPath(imgPath);
	            } else {
	                System.out.println("⚠️ Screenshot not captured. Path is null/empty.");
	            }
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
	    }
		}

		
		
		public void onTestSkipped(ITestResult result) {
			  if (test != null) {  // 🔹 Ensure test is initialized
					test.assignCategory(result.getMethod().getGroups());		        
					test.log(Status.INFO, result.getThrowable().getMessage());
		}}
		
		
		
		
		
		public void onFinish(ITestContext testContext) {
			 extent.flush();

//		        String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + repName;
//		        File extentReport = new File(pathOfExtentReport);
//
//		        try {
//		            Desktop.getDesktop().browse(extentReport.toURI());
//		        } catch (IOException e) {
//		            e.printStackTrace();
//		        }
		    }
	
	
	

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		
	}
	  }
	
