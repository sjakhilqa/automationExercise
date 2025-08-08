package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//a[normalize-space()='Signup / Login']")
	WebElement loginLink;
	
	public void clickLoginlink()
	{
		loginLink.click();
	}
	
	
}
