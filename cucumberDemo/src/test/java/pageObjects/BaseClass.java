package pageObjects;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addCust;
	public SearchCustomerPage searchCust;
	public static Logger logger;
	public Properties configProp; 
	
	
	public static String randomString()
	{
		String generatedString1=RandomStringUtils.randomAlphabetic(5);
		return(generatedString1);
	}
	

}
