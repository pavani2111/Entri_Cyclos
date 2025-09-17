package Cyclos_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cyclose_loginpage {
	@FindBy(xpath = "//div[contains(text(),'Login')]")	
	private WebElement loginlink;
	
	@FindBy(xpath ="//input[@placeholder='User']")
	private WebElement Usernametext;
	
	@FindBy(xpath ="//input[@placeholder='Password']")
	private WebElement Passwordtext;
	
	@FindBy(xpath ="//input[@placeholder='Password']")
	private WebElement Submitbutton;
	
	public Cyclose_loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Clickonloginlin()
	{
		loginlink.click();
	}
	public void EnterUsername()
	{
		Usernametext.click();
	}
	public void EnterPasswordname()
	{
		Passwordtext.click();
	}
	public void clickonsubmitbutton()
	{
		Submitbutton.click();
	}
}


