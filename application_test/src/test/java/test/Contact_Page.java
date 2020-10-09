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

public class Contact_Page {
	
	//Automate the following test case:
		//Scenario: CRM -> Add Contact - Add contact and validate contact added in List Contacts
		//1: Open Browser and go to site http://techfios.com/test/billing/?ng=admin/
		//2. Enter username: techfiosdemo@gmail.com
		//3. Enter password: abc123
		//4. Click login button
		//5. Click on CRM in the Side Navigation
		//6. Click on Add Contact
		//7. Fill in the Add Contact Form,
		//8. Click submit,
		//9. Go to CRM -> List Contact Page
		//10. Search for the new contact in the search field,
		//12. Validate contact created
	WebDriver driver;
	@Test
	public void UserWillAbleToOpenTheBrowser() throws InterruptedException                           {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("//*[@placeholder='Email Address']")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.xpath("//*[contains(text(),'Sign in')]")).click();
		Thread.sleep(2000);
		
		//Verification of Dashboard Page
		String ExpectedTitle="Dashboard ";
		String ActualTitle=driver.getTitle();
		System.out.println("You asserts starts here");
		
		try             {
			Assert.assertEquals(ActualTitle, ExpectedTitle);
		}
		catch(Throwable E)                  {
			System.out.println("Your assert ends here");
		}
		
		driver.findElement(By.linkText("CRM")).click();
		driver.findElement(By.linkText("Add Contact")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Full Name')]")).click();
		Thread.sleep(1000);
		
		//Fill up the form
		driver.findElement(By.id("account")).sendKeys("Prince Khadak Kathayat");
		Thread.sleep(1000);
		driver.findElement(By.name("company")).sendKeys("Techfios LLC");
		driver.findElement(By.id("email")).sendKeys("prince@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("9722158094");
		driver.findElement(By.id("address")).sendKeys("Irving, Texas");
		driver.findElement(By.name("city")).sendKeys("Kathmandu");
		driver.findElement(By.id("state")).sendKeys("Texas");
		driver.findElement(By.id("zip")).sendKeys("75038");
		Thread.sleep(1000);
		driver.findElement(By.className("select2-search__field")).sendKeys("Its weekend guys");
		driver.findElement(By.id("submit")).click();
		
		String ExpectedTitle1="Account Created Sucessfully ";
		String ActualTitle1=driver.getTitle();
		System.out.println("You asserts starts here");
		
		try             {
			Assert.assertEquals(ActualTitle1, ExpectedTitle1);
		}
		catch(Throwable E)                  {
			System.out.println("Your assert ends here");
		}
		
	
	}
}
