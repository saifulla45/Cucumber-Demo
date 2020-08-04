package stepDefinations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddCustomerPage;
import pageObjects.BaseClass;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;


public class Login_StepDefination extends BaseClass {
	
	@Before
	public void setup() throws IOException {
		
		logger=Logger.getLogger("cucumberDemo");
		PropertyConfigurator.configure("log4j.properties");
		
		//Reading Data From the Properties File
		configProp=new Properties();
		FileInputStream fis=new FileInputStream("config.properties");
		configProp.load(fis);
		
		String br=configProp.getProperty("browser");
		
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromepath"));
		driver=new ChromeDriver();
		}
		
		if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",configProp.getProperty("firefoxpath"));
			driver=new FirefoxDriver();
		}
		
		if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver",configProp.getProperty("iepath"));
			driver=new InternetExplorerDriver();
		}
		
		logger.info("*********Launching Browser***********");
		driver.manage().window().maximize();
		
		
	}
	
	
	
	@Given("User Launch Chrome Browser")
	public void user_Launch_Chrome_Browser() {
		
		
		lp=new LoginPage(driver);
	    
	}

	@When("User Opens Url {string}")
	public void user_Opens_Url(String url) {
		logger.info("********Launching URL********");
		
		driver.get(url);
	    
	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) throws InterruptedException {
		logger.info("******** PROVIDING LOGIN DETAILS ********");
		lp.setUsername(email);
		lp.setPassword(password);
	    Thread.sleep(3000);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() throws InterruptedException {
		logger.info("******** Clicking on Login Button ********");
		lp.clickOnLogin();
		Thread.sleep(3000);
	   
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
		String pTitle=driver.getTitle();
		if(pTitle.equalsIgnoreCase(title))
		{
			logger.info("******** Login Passed *********");
			System.out.println("Home page is displayed");
		}
		else
		{
			logger.info("******** Login Failed *********");
			System.out.println("Home Page is not displayed");
		}
	    Thread.sleep(3000);
	}

	@When("user clicks on Logout")
	public void user_clicks_on_Logout() throws InterruptedException {
		logger.info("******** Click on Logout Link ********");
		lp.clickOnLogout();
		Thread.sleep(3000);
	    
	}

	@Then("Title of the page should be {string}")
	public void title_of_the_page_should_be(String title1) throws InterruptedException {
		if(driver.getTitle().equals(title1))
		{
			System.out.println("Test Case is passed");
		}
		else
		{
			System.out.println("Test case is failed");
		}
		
		Thread.sleep(3000);
		
	    
	}

	@Then("user close the browser")
	public void user_close_the_browser() {
		logger.info("******** Closing the Browser ********");
	    driver.quit();
	}
	
	//Adding new Customer
	
	@Then("user is able to see the dashboard")
	public void user_is_able_to_see_the_dashboard() {
		addCust=new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration",driver.getTitle() );
		
	   
	}

	@When("user clicks on Customer menu")
	public void user_clicks_on_Customer_menu() throws InterruptedException {
		Thread.sleep(3000);
		addCust.mainCustomerMenu();
	    
	}

	@When("user clicks on customer menu item")
	public void user_clicks_on_customer_menu_item() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickOnCustomer();
	   
	}

	@When("user clicks on Add new customer")
	public void user_clicks_on_Add_new_customer() throws InterruptedException {
		addCust.clickOnAddNew();
		Thread.sleep(3000);
	   
	}

	@Then("user can view the add new customer page")
	public void user_can_view_the_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", driver.getTitle());
	    
	}

	@When("user enters customer details")
	public void user_enters_customer_details() throws InterruptedException {
		logger.info("******** Adding New Customer ********");
		String emailId=randomString()+"@gmail.com";
		addCust.setEmail(emailId);
		addCust.setPassword("test123");
		
		addCust.SetGender("male");
		addCust.SetFirstName("saifulla");
		addCust.setLastName("Attar");
		addCust.setDateOfBirth("7/05/1985");
		addCust.setCompanyName("Testing World");
		
		addCust.setCustomerRole("Vendor");
		Thread.sleep(2000);
		
		addCust.selectVendor("Vendor 2");
		Thread.sleep(2000);
		
		addCust.addComments("This is the first Testing");
		
		
		
	   
	}

	@When("clicks on save button")
	public void clicks_on_save_button() throws InterruptedException {
		logger.info("********  Saving Customer Data ********");
	   addCust.clickonSave();
	   Thread.sleep(2000);
	}

	@Then("User view a conformation message {string}")
	public void user_view_a_conformation_message(String msg) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
	   
	}
	
	// STEPS FOR SEARCHING CUSTOMER USING E-MAIL ID
	
	@When("user enters email Id")
	public void user_enters_email_Id() {
		logger.info("******** Searching Customer by Email Id ********");
		searchCust=new SearchCustomerPage(driver);
		searchCust.setEmail("victoria_victoria@nopCommerce.com");
	    
	}

	@When("user clicks on search button")
	public void user_clicks_on_search_button() throws InterruptedException {
		searchCust.clickOnSearch();
		Thread.sleep(2000);
	    
	}

	@Then("user should found email in the search table")
	public void user_should_found_email_in_the_search_table() {
		boolean status=searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	    
	}
	
	// STEPS FOR SEARCHING CUSTOMER USING FIRST NAME AND LAST NAME
	
	@When("user enters first Name")
	public void user_enters_first_Name() {
		logger.info("******** Searching Customer by Name ********");
		searchCust=new SearchCustomerPage(driver);
		searchCust.setFirstName("Victoria");
	   
	}

	@When("user enters last name")
	public void user_enters_last_name() {
		searchCust.setLastName("Terces");
	   
	}

	@Then("user should found name in the search table")
	public void user_should_found_name_in_the_search_table() {
		boolean status=searchCust.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true, status);
		
	   
	}


}
