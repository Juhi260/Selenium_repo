package extentReports;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToaddScreenShotIntoReport {
	@Test
	public void addscreenshot()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com/");
		TakesScreenshot ts=(TakesScreenshot) driver;
		String ss = ts.getScreenshotAs(OutputType.BASE64);
		
		String time = LocalDateTime.now().toString().replace(":","_");
		//creating object for ExtentSparkReporter
		ExtentSparkReporter extSp=new ExtentSparkReporter("./HTML_reports/extentreport"+time+".html");
		//creating object for ExtentReports
		ExtentReports extRep=new ExtentReports();
		//Attaching ExtentSparkReports to ExtentReports
		extRep.attachReporter(extSp);
		//creating Extent Test object and storing into a variable that is ExtentTest Type
		ExtentTest test = extRep.createTest("addscreenshot");
		test.log(Status.PASS, "successfully navigated to demoWebShop and adding screenshot");
		test.addScreenCaptureFromBase64String(ss);
		extRep.flush();
				
	}

}
