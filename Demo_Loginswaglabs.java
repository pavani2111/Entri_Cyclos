package Selenium_Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Demo_Loginswaglabs {
	
	WebDriver driver;
	
	public static void main(String[] args) throws Exception
	{
		Demo_Loginswaglabs obj = new Demo_Loginswaglabs();
		obj.OpenBrowser();
		obj.Urlset();
		obj.Closebrowser();
	}
	public void OpenBrowser()

	{
		driver = new ChromeDriver();
	}
	public void Urlset()
	{
		driver.get("https://www.facebook.com/login.php/");
		WebElement username =driver.findElement(By.id("email"));
		username.sendKeys("standard_user");
		
		WebElement password =driver.findElement(By.name("pass"));
		password.sendKeys("standard_user");
		
		WebElement login= driver.findElement(By.id("loginbutton"));
	
		if(login.isDisplayed())
		{
			login.click();
		}
		else
		{
			System.out.println("...........Error message..............");
		}	
	}
	public void Closebrowser() throws Exception
	{
		Thread.sleep(3000);
		driver.close();
	}
}
