package TestLoginAP;

import java.awt.Dimension;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestLoginAP {
	WebDriver webDriver;
	@BeforeClass
	public void suiteSetup() throws InterruptedException {
		
		System.setProperty("webdriver.edge.driver","D:\\JavaLibs\\msedgedriver.exe" );
		webDriver  = new EdgeDriver();
//		 webDriver.get("https://lms.poly.edu.vn/");
		 webDriver.get("https://www.saucedemo.com/");
		 Thread.sleep(500);
	}
	@Parameters({"username","password"})
	@Test
	public void LoginAp(String u, String p) throws InterruptedException {
		WebElement username = webDriver.findElement(By.name("user-name"));
		username.sendKeys(u);
		WebElement password = webDriver.findElement(By.name("password"));
		password.sendKeys(p);
		Thread.sleep(1000);
		
		webDriver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	
	
		System.out.println(webDriver.getTitle());
		if(webDriver.getTitle().equals("Swag Labs")) {
			System.out.println("PASS");
        }else{
            Assert.fail("FAIL ");
        }
       
        
		}
		
		

	
	 
}