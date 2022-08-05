package TestLoginAP;

import java.awt.Dimension;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
		
        System.setProperty("webdriver.chrome.driver", 
                "C:\\Users\\LONG\\Documents\\OneDrive\\Máy tính\\KiemThuNangCao\\chromedriver.exe");
		 ChromeOptions options = new ChromeOptions();

		 webDriver =  new ChromeDriver(options);
//		 webDriver.get("https://lms.poly.edu.vn/");
		 webDriver.get("https://www.facebook.com/");
		 Thread.sleep(500);
	}
	@Parameters({"username","password"})
	@Test
	public void LoginAp(String u, String p) throws InterruptedException {
		WebElement username = webDriver.findElement(By.xpath("//*[@id=\"email\"]"));
		username.sendKeys(u);
		WebElement password = webDriver.findElement(By.xpath("//*[@id=\"pass\"]"));
		password.sendKeys(p);
		Thread.sleep(1000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).click();
	
	
		System.out.println(webDriver.getTitle());
		if(webDriver.getTitle().equals("Facebook")) {
			System.out.println("PASS");
        }else{
            Assert.fail("FAIL ");
        }
       
        
		}
		
		
//		webDriver.findElement(By.linkText("SINH VIÊN")).click();
//		Thread.sleep(500);
//		Select se = new Select(webDriver.findElement(By.xpath("//*[@id='campus_id']")));
//		se.selectByValue("ps");
//		
//		Thread.sleep(500);
//		String framename=webDriver.findElement(By.tagName("iframe")).getAttribute("name");
//		webDriver.switchTo().frame(framename);
//		webDriver.findElement(By.xpath("//span[@id='recaptcha-anchor']")).click();
	
	 
}