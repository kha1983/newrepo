package test;

import static org.testng.Assert.assertEquals;

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
	static WebDriver driver;

	@BeforeMethod
	public static void UserWillBeAbleToOpenTheBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https:\\www.twitter.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	@Test(priority = 1)
	public static void UserWillBeAbleToLoginTheTwitter() {
		driver.findElement(By.name("session[username_or_email]")).sendKeys("khadak.kathayat100@gmail.com");
		WebElement element = driver.findElement(By.cssSelector("input[type='password']"));
		element.sendKeys("KK071520!!");
		element.sendKeys(Keys.ENTER);

		// Validation If Twitter page is displayed
		boolean status = driver.findElement(By.linkText("Home")).isDisplayed();

		if (status == true) {
			System.out.println("The testing is passed");
		} else {
			System.out.println("The testing is failed");
		}

	}

	@Test(priority = 2)
	public static void UserWillAbleToPerformAllTheFunctionInTwitterPage() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https:\\www.twitter.com");
		driver.findElement(By.name("session[username_or_email]")).sendKeys("khadak.kathayat100@gmail.com");
		WebElement element = driver.findElement(By.cssSelector("input[type='password']"));
		element.sendKeys("KK071520!!");
		element.sendKeys(Keys.ENTER);

		WebElement element1 = driver.findElement(By.xpath("//*[@placeholder='Search Twitter']"));
		element1.sendKeys("Mukunda Ghimire");
		element1.sendKeys(Keys.ENTER);

		// Validation if driver search specific name
		String ExpectedResult = "Mukunda Ghimire";
		String ActualResult = driver.getTitle();
		System.out.println("Assert starts here");

		try {
			Assert.assertEquals(ActualResult, ExpectedResult);
		} catch (Throwable T) {
			System.out.println("Assert ends here");
		}

	}

	@AfterMethod
	public static void UserWillBeAbleToCloseAllPagesOpen() {
		driver.close();
		driver.quit();

	}

}
