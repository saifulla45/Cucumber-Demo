package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	public WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='#']//span[contains(text(),'Customers')]")
	WebElement lnkCustomermenu;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//span[contains(text(),'Customers')]")
	WebElement lnkCustomer;
	
	@FindBy(xpath="//a[@class='btn bg-blue']")
	WebElement btnAddNew;
	
	@FindBy(id="Email")
	WebElement txtEmail;
	
	@FindBy(id="Password")
	WebElement txtPassword;
	
	@FindBy(id="FirstName")
	WebElement txtFirstName;
	
	@FindBy(id="LastName")
	WebElement txtLastName;
	
	@FindBy(id="Gender_Male")
	WebElement rdBtnMale;
	
	@FindBy(id="Gender_Female")
	WebElement rdBtnFemale;
	
	@FindBy(id="DateOfBirth")
	WebElement dob;
	
	@FindBy(id="Company")
	WebElement txtCompany;
	
	@FindBy(id="IsTaxExempt")
	WebElement chckTaxExempt;
	
	@FindBy(xpath="//div[@class='k-multiselect-wrap k-floatwrap']")
	WebElement txtCustomerRoles;
	
	@FindBy(xpath="//li[contains(text(),'Administrators')]")
	WebElement lstitemAdministrators;
	
	@FindBy(xpath="//li[contains(text(),'Guests')]")
	WebElement lstitemGuests;
	
	@FindBy(xpath="//li[contains(text(),'Registered')]")
	WebElement lstitemRegistered;
	
	@FindBy(xpath="//li[contains(text(),'Vendors')]")
	WebElement lstitemVendors;
	
	@FindBy(id="VendorId")
	WebElement drpmgrOfVendor;
	
	@FindBy(id="AdminComment")
	WebElement txtAdminComment;
	
	@FindBy(xpath="//button[@name='save']")
	WebElement btnSave;
	
	public void mainCustomerMenu()
	{
		lnkCustomermenu.click();
	}
	
	public void clickOnCustomer()
	{
		lnkCustomer.click();
	}
	
	public void clickOnAddNew()
	{
		btnAddNew.click();
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void SetFirstName(String fName)
	{
		txtFirstName.sendKeys(fName);
	}
	
	public void setLastName(String lName)
	{
		txtLastName.sendKeys(lName);
	}
	
	public void SetGender(String gender)
	{
		if(gender.equalsIgnoreCase("male"))
		{
			rdBtnMale.click();
		}
		
		else
		{
			rdBtnFemale.click();
		}
	}
	
	public void setDateOfBirth(String birthDate)
	{
		dob.sendKeys(birthDate);
	}
	
	public void setCompanyName(String companyName)
	{
		txtCompany.sendKeys(companyName);
	}

	public void selectTaxExempted()
	{
		chckTaxExempt.click();
	}
	
	public void setCustomerRole(String role) throws InterruptedException
	{
		if(!role.equalsIgnoreCase("Vendor"))
		{
			driver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span[@calss='k-select']")).click();
		}
		txtCustomerRoles.click();
		Thread.sleep(2000);
		
		if(role.equalsIgnoreCase("Registered"))
		{
			lstitemRegistered.click();
		}
		else if(role.equalsIgnoreCase("Administrators"))
		{
			lstitemAdministrators.click();
		}
		else if (role.equalsIgnoreCase("Guests"))
		{
			lstitemGuests.click();
		}
		else
		{
			System.out.println("Invalid Locator");
		}
	}
	
	public void selectVendor(String value)
	{
		Select option=new Select(drpmgrOfVendor);
		option.selectByIndex(1);
	}
	
	public void addComments(String comment)
	{
		txtAdminComment.sendKeys(comment);
	}
	
	public void clickonSave()
	{
		btnSave.click();
	}
	
}
