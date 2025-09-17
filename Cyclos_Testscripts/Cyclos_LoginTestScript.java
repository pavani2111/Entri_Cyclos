package Cyclos_Testscripts;

import org.openqa.selenium.WebDriver;

import Cyclos_Pages.Cyclose_loginpage;

public class Cyclos_LoginTestScript extends Cyclose_loginpage
{

	public Cyclos_LoginTestScript(WebDriver driver) {
		super(driver);
	}
	
	public void fillinglogindata(String Username,String Password)
	{
		Clickonloginlin();
		EnterUsername();
		EnterPasswordname();
		clickonsubmitbutton();
	}

}
