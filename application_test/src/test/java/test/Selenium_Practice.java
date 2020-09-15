package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium_Practice {
	
	//Test Case 1 - Automate first Menu link of amazon.in and print page title

	//Steps to Automate:
	//1. Launch browser of your choice say., firefox, chrome etc.
	//2. Open this URL -  www.amazon.in
	//3. Maximize or set size of browser window.
	//4. Get the page title and print it.
	//5. Now, click on first menu link say 'Amazon Pay' (or choose any other link from the menu list)
	//6. Get the page title and print it.
	//7. Navigate back to Home Page.
	//8. Get the page title and print it. Verify that value matches with output of point no. 4
	//9. Close the browser.
	
	@Test
//	public void UserWillBeAbleToOpenBrowser() throws InterruptedException                           {
//		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.get("https://www.amazon.in");
//		driver.manage().window().maximize();
//		
//		//Get title
//		driver.getTitle();
//		boolean pageTitle=driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
//		if(pageTitle==true)         {
//			System.out.println("The testing is passed");
//		}
//		else               {
//			System.out.println("The testing is failed");
//		}
//		WebElement element=driver.findElement(By.id("twotabsearchtextbox"));
//		element.sendKeys("Amazon Pay");
//		Thread.sleep(2000);
//		element.sendKeys(Keys.ENTER);
//		driver.navigate().back();
//		
//		driver.getTitle();
//		boolean pageTitle1=driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
//		if(pageTitle1==true)         {
//			System.out.println("The testing is passed");
//		}
//		else               {
//			System.out.println("The testing is failed");
//		}
	
	//Test Case 2 - Automate all the Menu links of techlistic.com

	//Steps to Automate:
	//1. Launch browser of your choice say., firefox, chrome etc.
	//2. Open this URL -  https://www.techlistic.com/
	//3. Maximize or set size of browser window.
	//4. Click on 'Java Tutorial' link and validate page title.
	//5. Navigate back to Home Page.
	//6. Click on 'Selenium Tutorial' link and validate page title.
	//7. Navigate back to Home Page.
	//8. Click on 'Selenium Blogs' link and validate page title.
	//9. Navigate back to Home Page.
	//10. Click on 'TestNG Blogs' link and validate page title.
	//11. Close the browser.
	
	public void UserWillBeAbleToOpenBrowser() throws InterruptedException                {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.techlistic.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Java")).click();
		driver.getTitle();
		
		String ExpectedTitle="validate page title";
		String ActualTitle=driver.getTitle();
		System.out.println("Your assert starts here");
		
		try           {
			Assert.assertEquals(ExpectedTitle, ActualTitle);
		}
		catch(Throwable e)             {
			System.out.println("You assert ends here");
		}
		driver.navigate().back();
		//Thread.sleep(2000);
		//driver.findElement(By.linkText("Selenium")).click();
		//driver.navigate().back();
		
		
		
		
	}

}
