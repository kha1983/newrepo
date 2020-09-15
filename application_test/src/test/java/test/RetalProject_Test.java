package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RetalProject_Test {
	
//	Scenario: Add new account on Techfios Site 
//	​
//	Beginner:
//	1: Open Browser and go to site http://techfios.com/test/billing/?ng=admin/
//	2. Enter username: techfiosdemo@gmail.com
//	3. Enter password: abc123
//	4. Click login button
//	5. Click on Bank & Cash
//	6. Click on New Account
//	7. Fill in the Add New Account Form (Randomize Account Title and Balance)
//	8. Click submit,
//
//	​Intermediate:
//	9. Validate the presence of "Account Created Successfully" message
//
//	Advance: 
//	10. Scroll Down,
//	11. Validate new account showed up in the bottom of the table
//	12. ​Delete that account
//	13. Validate account deleted from the bottom of the table

	
	WebDriver driver;
	@Test
	public void UserWillAbleToOpenTheBrowser() throws InterruptedException                 {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Bank & Cash")).click();
		driver.findElement(By.xpath("//*[contains(text(),'New Account')]")).click();
		
		driver.findElement(By.id("account")).sendKeys("Nepal is Beautiful Country");
		Thread.sleep(2000);
		driver.findElement(By.id("description")).sendKeys("Enough is enough");
		driver.findElement(By.id("balance")).sendKeys("99000");
		driver.findElement(By.xpath("//*[contains(text(),' Submit')]")).click();
		
		//Validate the presence of "Account Created Successfully" message
		//boolean status=driver.findElement(By.xpath("//*[contains(text(),'Account Created Successfully')]")).isDisplayed();
		//if(status==true)               {
		//	System.out.println("Your validation is sucessfull");
		//}
		//else       {
			//System.out.println("Please try it with an another element");
		//}
		String ExpectedTitle="Account Created Successfully";
		String ActualTitle=driver.getTitle();
		System.out.println("Your assert starts here");
		
		try      {
			Assert.assertEquals(ExpectedTitle, ActualTitle);
		}
		catch(Throwable e)            {
			System.out.println("Try it with an another element please");
		}
		
		
		//Scroll Down
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 1000)");
		
		//Mouse hover over
		//Actions action=new Actions(driver);
		//WebElement element="Main menu";
		//action.moveToElement("Main menu").moveToElement("Sub menu").click().build().perform();
		
		
		//Handling new window
		//for(String handle:driver.getWindowHandles())            {
		//	driver.switchTo().window(handle);
		//}
		
		
		//Manage alert pop up
		//driver.switchTo().alert().accept();
		//driver.switchTo().alert().dismiss();
		//driver.switchTo().alert().getText();
		//driver.switchTo().alert().sendKeys("Khadak");
		
		
		//implicit wait
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Explicit wait
		//WebDriverWait wait=new WebDriverWait(driver,Timeout);
		
		//Explicit wait
		//wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		//wait.until(ExpectedConditions.elementToBeClickable(element));
		
		//import from excel reader
		//ExcelReader reader=new ExcelReader(path of that excel sheet);
		//String username=reader.getCellData("sheet1","user",2);
		
		//Handling multiple frame
//		driver.switchTo().frame(2);
//		driver.switchTo().frame(name or id);
//		driver.switchTo().frame(webelement);
//		driver.switchTo().parentFrame();
//		driver.switchTo().defaultContent();
		
		
		//Testing challenges
		//Frequently changing and understanding of the requirements
		//company rules and regulations
//		time constraints
//		budget constraints
//		co ordination with developers
//		regression testing
//		team keep working in multiple projects
		
		//Takes Screen shot
		//TakesScreenshot scrShot=(TakesScrennShot)driver;
		
		//Diffrent TestNg annotation
//		@BeforeMethod
//		@AfterMethod
//		@Test
//		@assert
//		@Data Provider
//		@Factory
//		@parameters
		
		//How would you make your hybrid framework
		//It is hybrid framework by POM using page factory, TestNg for assert reporting, Maven project for jar management, excel ,xml or
		//any data provider for data storage, integration with github and jenkins.
//		Create maven project for jar management
//		implement POM by using page factory
//		implment classes, folder and util class for different pages
//		create test base class
//		create property file
//		add excel, xml or any data provider for data storage
//		TestNg for assert reporting
//		Takes screen shot when test cases failing
//		integration with github
//		integration with jenkins
		
		//How would you integrate xml or excel to your framework
//		Add apache POI dependencies
//		create an excel util class for data driven testing
//		set data excel file in test base class
//		set test data in test class
//		create test excel file
//		modify oage and page class
		
		
		
		
		
	}

}
