package testCases;

// Credentials are valid -Login Pass - Test Pass -Then logout
// Credentials are valid - Login failed - Test fail

//Credentials are invalid - Login failed - Test Pass
//Credentials are invalid - Login Passed - Test fail - Then logout



import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Verify;

import pageObjects.HomePage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

@Listeners(utilities.ExtentReportManager.class)

public class TC_002_LoginDDTValidations extends BaseClass {


	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void loginDDT(String email,String pwd, String valdtns) 
	{
		try {

			LandingPage lap =  new LandingPage(driver);
			lap.clickLoginlink();

			LoginPage lop = new LoginPage(driver);
			lop.setLoginEmail(email);
			lop.setLoginPassword(pwd);
			lop.clickLogin();

			HomePage hop = new HomePage(driver);

			//getting current window handle

			String windowhandle = driver.getWindowHandle();
			System.out.println("Window handle: "+windowhandle);

			//Getting  all window handles

			Set<String> windowids = driver.getWindowHandles();
			System.out.println("All window handles :"+windowids);


			//Asserting/verifying  if logged in correctly

/*			String loggedInUserDtls = hop.loggedInUserName();
			SoftAssert softAssert= new SoftAssert();
			softAssert.assertTrue(loggedInUserDtls.contains("AkhilQA"));
			softAssert.assertAll();

*/
			// 1.Credentials are valid -Login Pass - Test Pass -Then logout 
			// 2.Credentials are valid -Login fail - Test fail

			if (valdtns.equalsIgnoreCase("valid")) {     
			    if (hop.loggedInUserNamelinkDisplayed() == true) {
			        hop.logoutUser(); // Assertion after logout
			        Assert.assertTrue(true, "Login successful as expected for valid credentials.");
			    } else {
			        Assert.fail("Login failed unexpectedly for valid credentials.");
			    }
			}

			// 1. Invalid credentials - Login passed → Test should fail
			// 2. Invalid credentials - Login failed → Test should pass

			if (valdtns.equalsIgnoreCase("invalid")) {
			    if (hop.loggedInUserNamelinkDisplayed() == true) {
			        hop.logoutUser(); // Assertion after logout
			        Assert.fail("Login succeeded unexpectedly for invalid credentials.");
			    } else {
			        Assert.assertTrue(true, "Login failed as expected for invalid credentials.");
			    }
			}		
			
		}
		catch (Exception e)
		{
			e.printStackTrace(); // Show what went wrong
		    Assert.fail("Test failed due to unexpected exception: " + e.getMessage());
		}
	}
}

