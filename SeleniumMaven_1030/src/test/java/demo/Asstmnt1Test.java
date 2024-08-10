package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Asstmnt1Test {
	@Test
	public void login() {
		String Url = System.getProperty("url");
		String Email = System.getProperty("email");
		String Password = System.getProperty("pwd");
		Reporter.log(Url,true);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(Url);
		driver.findElement(By.linkText("LOGIN")).click();
		driver.findElement(By.id("email")).sendKeys(Email);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		Assert.assertEquals(driver.getTitle(), "SkillRary Ecommerce","Home page not displayed");
		Reporter.log("Home page displayed",true);
	}
	
	

}
