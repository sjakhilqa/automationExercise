package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	WebDriverWait wait;
	
	
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
