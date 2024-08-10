package extentReports;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLearnExtentReport {
@Test
public void createReport()
{
	String time = LocalDateTime.now().toString().replace(":","_");
	//creating object for ExtentSparkReporter
	ExtentSparkReporter extSp=new ExtentSparkReporter("./HTML_reports/extentreport"+time+".html");
	//creating object for ExtentReports
	ExtentReports extRep=new ExtentReports();
	//Attaching ExtentSparkReports to ExtentReports
	extRep.attachReporter(extSp);
	//creating Extent Test object and storing into a variable that is ExtentTest Type
	ExtentTest test = extRep.createTest("createReport");
	//calling log method and passing the message and status
	test.log(Status.INFO, "open browser and navigate to url");
	test.log(Status.PASS, "Enter valid credentials");
	test.log(Status.WARNING, "click on login button");
	test.log(Status.PASS, "Successfully created extent report");
	//calling flush method which is present in the extentReports
	extRep.flush();
	
}

}
