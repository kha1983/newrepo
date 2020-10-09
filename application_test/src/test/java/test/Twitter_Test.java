package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Twitter_Test {

	private static final int priority = 0;
	WebDriver driver;

	@BeforeMethod
	public void UserWillAbleToOpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https:\\www.twitter.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	@Test(priority = 1)
	public void UserWillBeToAbleToLoginAccount() throws InterruptedException {
		driver.findElement(By.name("session[username_or_email]")).sendKeys("khadak.kathayat100@gmail.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("KK071520!!");
		driver.findElement(By.xpath("//*[contains(text(),'Log in')]")).click();
		Thread.sleep(2000);

		// Validation of the IF twitter page is logged in
		boolean status = driver.findElement(By.linkText("Tweet")).isDisplayed();
		if (status == true) {
			System.out.println("Testing is sucessfull");
		} else {
			System.out.println("Testing is failed");
		}

	}

	// Search the people in search box
	@Test(priority = 2)
	public void UserWillAbleToSearchFriendInTwitter() {
		driver.findElement(By.name("session[username_or_email]")).sendKeys("khadak.kathayat100@gmail.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("KK071520!!");
		driver.findElement(By.xpath("//*[contains(text(),'Log in')]")).click();
		WebElement element = driver.findElement(By.xpath("//*[@type='text']"));
		element.sendKeys("Mukunda Ghimire");
		element.sendKeys(Keys.ENTER);

		// Validation of if that name appears
		String expextedTitle = "Mukunda Ghimire";
		String actualTitle = driver.getTitle();
		System.out.println("Your asserts starts here");
		
		try            {
			Assert.assertEquals(actualTitle, expextedTitle);
		}
		catch(Throwable T)               {
			System.out.println("My asserts ends here");
		}
	}		
	@AfterMethod
	public void UserWillAbleToCloseTheBrowser()                 {
		driver.close();
		driver.quit();
	
	}

}
