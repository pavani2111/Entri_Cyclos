package Demo_cyclosproject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Cyclos_class {
	
	public WebDriver d;
	
	public String browser="Edge";
	
	public String url="https://demo.cyclos.org/ui/login";
	
	@BeforeMethod
	public void Launchbrowser()
	{
		switch (browser) {
		case "GC":
			
			d=new ChromeDriver();
			break;
			
		case "FF":
			
			d=new FirefoxDriver();
			break;
			
		case "Edge":
	
			d=new EdgeDriver();
			break;

		}
		
		   d.manage().window().maximize();
		   d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		   d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		   d.manage().deleteAllCookies();
	}
	@AfterMethod
	  public void afterMethod() throws Exception {
		  Thread.sleep(3000);
		  d.quit();
	  }

}
