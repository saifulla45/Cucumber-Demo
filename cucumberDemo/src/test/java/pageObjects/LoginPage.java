package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='Email']")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Log in']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//a[text()='Logout']")
	@CacheLookup
	WebElement btnLogout;
	
	public void setUsername(String uname)
	{
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	public void clickOnLogin()
	{
		btnLogin.click();
	}
	
	public void clickOnLogout()
	{
		btnLogout.click();
	}

}
