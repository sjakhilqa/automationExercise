package testCases;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_001_ValidLogin extends BaseClass{
	
	public void login() 
	{
		LandingPage lap =  new LandingPage(driver);
		lap.clickLoginlink();		
		LoginPage lop = new LoginPage(driver);
		lop.setLoginEmail("akhilqa@dummy.com");
		lop.setLoginPassword("Apple12#");
		lop.clickLogin();
		
		
	}

}
