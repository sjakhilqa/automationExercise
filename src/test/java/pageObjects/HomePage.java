package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//a[contains(. ,'AkhilQA')]")
	WebElement loggedinuserNamelink;
	
	@FindBy(xpath="//a[contains(. ,'Logout')]")
	WebElement logoutlink;
	
	
	
	public String loggedInUserName() 
	{
		return loggedinuserNamelink.getText();
		
	}
	
	//light assertions like isDisplayed can be done here in page object

	public boolean loggedInUserNamelinkDisplayed()
	{
		try {
			return loggedinuserNamelink.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void logoutUser()
	{
		logoutlink.click();
	}
	
}
