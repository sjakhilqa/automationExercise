package testCases;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

@Listeners(utilities.ExtentReportManager.class)
public class TC_001_ValidLogin extends BaseClass{
	
	@Test
	public void login() 
	{
		LandingPage lap =  new LandingPage(driver);
		lap.clickLoginlink();
		
		LoginPage lop = new LoginPage(driver);
		lop.setLoginEmail("akhilqa@dummy.com");
		lop.setLoginPassword("Apple12#");
		lop.clickLogin();
		
		HomePage hop = new HomePage(driver);
		
		//getting current window handle
		
		String windowhandle = driver.getWindowHandle();
		System.out.println("Window handle: "+windowhandle);
		
		//Getting  all window handles
		
		Set<String> windowids = driver.getWindowHandles();
		System.out.println("All window handles :"+windowids);
		
		
		//Asserting if logged in correctly
		
	     String loggedInUserDtls = hop.loggedInUserName();
	     Assert.assertTrue(loggedInUserDtls.contains("AkhilQA"));
	     
				
	}

}
