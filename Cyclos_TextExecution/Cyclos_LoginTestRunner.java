package Cyclos_TextExecution;

import org.testng.annotations.Test;

import Cyclos_Testscripts.Cyclos_LoginTestScript;
import Demo_cyclosproject.Cyclos_class;

public class Cyclos_LoginTestRunner extends Cyclos_class
{
	@Test
	public void verifycycloslogin()
	{
		d.get(url);
		
		Cyclos_LoginTestScript ex=new Cyclos_LoginTestScript(d);
		ex.fillinglogindata("demo","1234");
		
	}

}
