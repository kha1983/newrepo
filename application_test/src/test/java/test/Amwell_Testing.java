package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Amwell_Testing {
	
	WebDriver driver;
	@Test
	public void UserWillAbleToFullyOperateSite () throws InterruptedException                    {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.findElement(By.id("navbtn_tutorials")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Learn Java")).click();
		
		//Validation of Java Tutorial Page
		boolean status=driver.findElement(By.linkText("Start learning Java now »")).isDisplayed();
		
		if(status==true)                     {
			System.out.println("The page is displayed with title and testing is passed");
		}
		else                {
			System.out.println("The testing is failed due to not finding element");
		}
		
		//Scroll up and down
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scroll(0,3000)");
		
		driver.findElement(By.linkText("SQL")).click();
		Thread.sleep(2000);
		
		//Mouse hover over
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("MORE"))).click().build().perform();
		
		driver.findElement(By.linkText("Learn XPath")).click();
		
		//Validation of XPath page is displayed
		String ExpectedTitle ="XPath Tutorial";
		String ActualTitle=driver.getTitle();
		System.out.println("Your assert starts here");
		
		try              {
			Assert.assertEquals(ActualTitle, ExpectedTitle);
		}
		catch(Throwable E)             {
			System.out.println("Testing is failed");
		}
	}

}
