package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Session_4 {
	
	WebDriver driver;
	@Test
	public void UserWillAbleTOHandleAlertandPopup() throws InterruptedException                   {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		Alert/Popup
//		https://mail.rediff.com/cgi-bin/login.cgi
//		http://demo.guru99.com/test/delete_customer.php
		
//		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
//		driver.manage().window().maximize();
//		WebElement element=driver.findElement(By.xpath("//*[@type='text']"));
//		element.sendKeys("Go");
//		element.sendKeys(Keys.ENTER);
//		
//		driver.switchTo().alert().accept();
//		
//	}

	
//	iFrame
//	HTML document. https://docs.oracle.com/javase/8/docs/api/
//		driver.get("https://docs.oracle.com/javase/8/docs/api/");
//		driver.manage().window().maximize();
//		
//		//First frame
//		driver.switchTo().frame(0);
//		driver.findElement(By.linkText("java.awt.color")).click();
//		Thread.sleep(2000);
//		
//		
//		//Second frame
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(1);
//		driver.findElement(By.linkText("ColorSpace")).click();
//		
//		
//		//Original frame
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(2);
//		driver.findElement(By.linkText("Serializable")).click();

	
	
//	Mouse Over
//	Example,  https://www.dell.com/en-us
//		driver.get("https://www.dell.com/en-us");
//		driver.manage().window().maximize();
//		
//		Actions action=new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'Deals')]"))).build().perform();
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("//*[contains(text(),'Workstation Deals')]")).click();
		
//	Scroll Up/Down
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("scroll(0,4000)");
//		
//		driver.findElement(By.linkText("Careers")).click();
//		
	
		
//	Handling New Tab/Window: 
//	Go to google
//	type xpath 
//	select link to navigate to w3school site 
//	and click on SQL.
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		WebElement element=driver.findElement(By.cssSelector("input[title='Search']"));
		element.sendKeys("xpath");
		element.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//*[contains(text(),'XPath Tutorial - W3Schools')]")).click();
		
		driver.findElement(By.linkText("SQL")).click();
		
		//Validation if the sql page is displayed
		boolean status=driver.findElement(By.xpath("//*[contains(text(),'SQL Tutorial')]")).isDisplayed();
		if(status==true)         {
			System.out.println("The testing passed");
		}
		else         {
			System.out.println("Please try again");
		}
	
	}

}
