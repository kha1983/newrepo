package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Automation_Testing {
	
	@Test
	public void UserWillAbleToOpenTheBrowser() throws InterruptedException                      {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		//driver.findElement(By.linkText("Add/Remove Elements")).click();
		
		//Add element multiple time
		//int a;
		//for(a=0;a<=5;a++)             {
			//driver.findElement(By.xpath("//*[contains(text(),'Add Element')]")).click();
		//}
		//Thread.sleep(3000);
		
		
		//Remove element multiple time
		//int b;
		//for(b=5;b>=0;b--)               {
			//driver.findElement(By.xpath("//*[contains(text(),'Delete')]")).click();
		//}
		//Thread.sleep(2000);
		
		//Challenging DOM
		driver.findElement(By.linkText("Challenging DOM")).click();
	}

}
