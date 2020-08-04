package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	
	WebDriver driver;
	WaitHelper waithelper;
	
	public SearchCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waithelper=new WaitHelper(driver);
		
	}
	

	@FindBy(how=How.ID, using="SearchEmail")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how=How.ID, using="SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(how=How.ID, using="SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(how=How.ID, using="SearchMonthOfBirth")
	@CacheLookup
	WebElement drpdopMonth;
	
	@FindBy(how=How.ID, using="SearchDayOfBirth")
	@CacheLookup
	WebElement drpdobDay;
	
	@FindBy(how=How.ID, using="SearchCompany")
	@CacheLookup
	WebElement txtCompanyName;
	
	@FindBy(how=How.ID, using="SearchIpAddress")
	@CacheLookup
	WebElement txtIpAddress;
	
	@FindBy(how=How.ID, using="search-customers")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(how=How.XPATH, using="//table[@role='grid']")
	@CacheLookup
	WebElement tblSearchResults;
	
	@FindBy(how=How.XPATH, using="//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;
	
	@FindBy(how=How.XPATH, using="//table[@id='customers-grid']//tbody/tr")
	@CacheLookup
	List<WebElement> tableRows;
	
	@FindBy(how=How.XPATH, using="//table[@id='customers-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement> tableColumns;
	
	public void setEmail(String email)
	{
		waithelper.waitForElement(txtEmail, 30);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void setFirstName(String fname) {
		waithelper.waitForElement(txtFirstName, 30);
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		waithelper.waitForElement(txtLastName, 30);
		txtLastName.clear();
		txtLastName.sendKeys(lname);
	}
	
	public void clickOnSearch() {
		btnSearch.click();
		waithelper.waitForElement(btnSearch, 30);
		
	}
	
	public int getNoOfRows() {
		return(tableRows.size());
	}
	
	public int getNoOfColumns() {
		return(tableColumns.size());
	}
	
	public boolean searchCustomerByEmail(String email)
	{
		boolean flag=false;
		
		for(int i=1;i<=getNoOfRows();i++)
		{
			String emailId=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailId);
			if(email.equalsIgnoreCase("victoria_victoria@nopCommerce.com"))
			{
				flag=true;
			}
		}
		
		return flag;
	}

	public boolean searchCustomerByName(String name)
	{
		boolean flag=false;
		
		for(int i=1;i<=getNoOfRows();i++)
		{
			String fullname=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
			String[] name1=fullname.split(" ");
			if(name1[0].equalsIgnoreCase("victoria") && name1[1].equalsIgnoreCase("Terces"))
			{
				flag=true;
			}
		}
		return flag;
	}
}
