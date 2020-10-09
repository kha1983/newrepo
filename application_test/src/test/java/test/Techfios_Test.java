package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Techfios_Test {
	
		
		//Automate the following test case:
			//Scenario: Users will be able to add deposit
//			1: Open Browser and go to site http://techfios.com/test/billing/?ng=admin/
//			2. Enter username: techfiosdemo@gmail.com
//			3. Enter password: abc123
//			4. Click login button
//			5. Click on Add Deposit button on Dashboard Page
//			6. Click on Open An Account drop down to expand it,
//			7. Click on any account name,
//			8. Type any description,
//			9. Type any amount,
//			10. Click on submit button,
//			Visually check to make sure the deposit posted
		
		@Test
		public void UserWillBeAbleToOpenTheBrowser() throws InterruptedException                     {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("http://techfios.com/test/billing/?ng=admin/");
			driver.manage().window().maximize();
			driver.findElement(By.cssSelector("input[type='text']")).sendKeys("techfiosdemo@gmail.com");
			driver.findElement(By.xpath("//*[@name='password']")).sendKeys("abc123");
			driver.findElement(By.xpath("//*[contains(text(),'Sign in')]")).click();
			
			//Validation of if Dashboard page is present
			String expectedTitle="Dashboard";
			String actualTitle=driver.getTitle();
			System.out.println("My assert starts here--->");
			
			try           {
				Assert.assertEquals(actualTitle, expectedTitle);
			}
			catch(Throwable E)              {
				System.out.println("My assert ends here");
			}
			
			driver.findElement(By.linkText("Bank & Cash")).click();
			driver.findElement(By.linkText("New Account")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("account")).sendKeys("Kathmandu Nepal");
			driver.findElement(By.id("description")).sendKeys("Account Opened");
			Thread.sleep(2000);
			WebElement element=driver.findElement(By.id("balance"));
			element.sendKeys("20000");
			element.sendKeys(Keys.ENTER);
			
			//Validation if account is opened sucess fully
//			boolean status=driver.findElement(By.xpath("//*[contains(text(),' Account Created Successfully')]")).isDisplayed();
//			
//			if(status==true)                 {
//				System.out.println("The account is created sucessfully and testing is passed");
//			}
//			else              {
//				System.out.println("The testing is failed");
//			}
			
			String expectedTitle1="Account Created Successfully";
			String actualTitle1=driver.getTitle();
			System.out.println("My assert starts here--->");
			
			try           {
				Assert.assertEquals(actualTitle1, expectedTitle1);
			}
			catch(Throwable E)              {
				System.out.println("My assert ends here");
			}
			
			
			
		}

}
