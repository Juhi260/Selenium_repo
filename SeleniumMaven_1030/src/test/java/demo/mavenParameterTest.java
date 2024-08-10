package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
@Test
public class mavenParameterTest {
	public void recieveData() {
		String URL = System.getProperty("url");
		String Email = System.getProperty("email");
		String Paasword = System.getProperty("pwd");
		Reporter.log(URL,true);
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(Email);
		driver.findElement(By.id("Password")).sendKeys(Paasword);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
	}

}
