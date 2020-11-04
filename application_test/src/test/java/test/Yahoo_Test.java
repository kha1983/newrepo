package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Yahoo_Test {

	// Test Case: Search "xpath" in Yahoo
	// a. Go to Yahoo.com,
	// b. Type "xpath" in the search field,
	// c. Click on the search icon,
	// d. click on the link that says, "XPath Tutorial - W3Schools",
	// e. W3Schools page should open (Validation: if else)

	WebDriver driver;

//	@BeforeMethod
//	public void UserWillBeAbleToOpenW3Schools() {
//		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.get("https://docs.oracle.com/javase/8/docs/api/");
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//
//	}
//
//	@Test
//	public void UserWillValidateIfW3SchoolPageIsOpen() {
//		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("xpath");
//		driver.findElement(By.xpath("//*[@type='submit']")).click();
//		driver.findElement(By.linkText("XPath Tutorial - W3Schools")).click();
//
//		// Validation of W3 School page is open
//
//		String ExpectedTitle = "w3schools";
//		String ActualTitle = driver.getTitle();
//		System.out.println("Your assert starts here");
//
//		try {
//			Assert.assertEquals(ActualTitle, ExpectedTitle);
//		} catch (Throwable E) {
//			System.out.println("Your assert ends here");
//		}
	
	
	//Managing iFrame
	@Test
	public void UserWillBeAbleToOpenW3Schools() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Switch Frame
		driver.switchTo().frame(0);
		//driver.switchTo().frame("packageListFrame");
		driver.findElement(By.linkText("java.awt.color")).click();
		
		//Return to parentFrame
		driver.switchTo().defaultContent();
		
		//Switch To frame 1
		driver.switchTo().frame(1);
		driver.findElement(By.linkText("ColorSpace")).click();
		
		//Switch To frame 2
		driver.switchTo().frame(2);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Serializable")).click();
		
		driver.close();
		driver.quit();

	}

}
