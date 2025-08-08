package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@data-qa='login-email']")
     WebElement loginEmail;
	
	@FindBy(xpath="//input[@data-qa='login-password']")
    WebElement loginPassword;
	
	@FindBy(xpath="//button[@data-qa='login-button']")
	WebElement loginButton;
	
	
	public void setLoginEmail(String email)
	{
		loginEmail.sendKeys(email);
	}
	
	public void setLoginPassword(String pwd)
	{
		loginPassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		loginButton.click();
	}
}
