package Selenium_Scripts;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class verifytheCyclosLogin 
{
	WebDriver d;
	
	@Test
	public void verifytheCyclos() throws Exception
	{
        
		d.get("https://demo.cyclos.org/ui/login");
		
		Demo_Projectinput ex=new Demo_Projectinput("C:\\Automation\\input\\Requirement.xlsx", "Sheet1");
		
		for(int i=1; i<=ex.sheet.getLastRowNum();i++)
		{
		d.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
		
		
		d.findElement(By.xpath("//input[@placeholder='User']")).clear();
		d.findElement(By.xpath("//input[@placeholder='User']")).sendKeys(ex.getData(i, 0));
		String username=d.findElement(By.xpath("//input[@placeholder='User']")).getAttribute("value");
		
		d.findElement(By.xpath("//input[@placeholder='Password']")).clear();
		d.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(ex.getData(i, 1));
		String password=d.findElement(By.xpath("//input[@placeholder='Password']")).getAttribute("value");
		
		
		d.findElement(By.xpath("//span[text()='Submit']")).click();
		
		Thread.sleep(3000);
		//Blank User name and Blank Password
		if(username.equals("")&&password.equals(""))
		{
			assertEquals(d.findElement(By.xpath("(//div[@class='invalid-feedback'])[1]")).getText(), "This field is required");
			assertEquals(d.findElement(By.xpath("(//div[@class='invalid-feedback'])[2]")).getText(), "This field is required");
		    //ex.setData("C:\\Entri\\TestData\\Cyclos.xlsx", i, 2, "Fail");
		    ex.setdata("C:\\Automation\\input\\Requirement.xlsx", i, 2,"Fail");
		
		}
		
		//Blank Username and Valid or invalid password
		else if(username.equals("")&& !password.equals(""))
		{
			assertEquals(d.findElement(By.xpath("(//div[@class='invalid-feedback'])")).getText(), "This field is required");
			ex.setdata("C:\\Automation\\input\\Requirement.xlsx", i, 2,"Fail");
			//ex.setData("C:\\Entri\\TestData\\Cyclos.xlsx", i, 2, "Fail");
		
		}
		
		//Valid or invalid username and Blank Password
		else if(!username.equals("")&& password.equals(""))
		{
			assertEquals(d.findElement(By.xpath("(//div[@class='invalid-feedback'])")).getText(), "This field is required");
			ex.setdata("C:\\Automation\\input\\Requirement.xlsx", i, 2,"Fail");
			//ex.setData("C:\\Entri\\TestData\\Cyclos.xlsx", i, 2, "Fail");
		}
		//Both are valid
		else if(d.findElement(By.xpath("(//a[contains(@class,'nav-item')])[last()]")).isDisplayed())
		{	
			assertTrue(d.findElement(By.xpath("(//a[contains(@class,'nav-item')])[last()]")).isDisplayed());
			d.findElement(By.xpath("(//a[contains(@class,'nav-item')])[last()]")).click();
			ex.setdata("C:\\Automation\\input\\Requirement.xlsx", i, 2,"Pass");
			//ex.setData("C:\\Entri\\TestData\\Cyclos.xlsx", i, 2, "Pass");
		
		}
		
		//Both or invalid
		else
		{
		    assertEquals(d.findElement(By.xpath("//div[@class='notification-message']")).getText(), "The given name / password are incorrect. Please, try again.");
		    d.findElement(By.xpath("//span[text()='Close']")).click();
		    ex.setdata("C:\\Automation\\input\\Requirement.xlsx", i, 2,"Fail");
		    //ex.setData("C:\\Entri\\TestData\\Cyclos.xlsx", i, 2, "Fail");
		}
		
		}
	}

	@BeforeMethod
	public void launchBrowser() 
	{
		d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		d.manage().deleteAllCookies();
	}

	@AfterMethod
	public void closeBrowser() throws Exception 
	{
		Thread.sleep(3000);
		d.quit();
	}


}



