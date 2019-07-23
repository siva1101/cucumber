package cucucasestudy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import browser.browser.UtilityClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	
	WebDriver driver;
	@Given("^the user is in the registration page of the browser application$")
	public void the_user_is_in_the_registration_page_of_the_browser_application() throws Throwable {
		driver=UtilityClass.browser("http://10.232.237.143:443/TestMeApp/RegisterUser.htm");
 	
	
	}

	@When("^username \"([^\"]*)\" ,firstname \"([^\"]*)\" ,lastname \"([^\"]*)\" ,password \"([^\"]*)\" ,confirm password \"([^\"]*)\" ,email \"([^\"]*)\" ,mobilenumber \"([^\"]*)\" ,DOB \"([^\"]*)\" ,Address \"([^\"]*)\" ,SecurityQuestion \"([^\"]*)\"$")
	public void username_firstname_lastname_password_confirm_password_email_mobilenumber_DOB_Address_SecurityQuestion(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10) throws Throwable {
		
		 	  driver.findElement(By.name("userName")).sendKeys(arg1);
			  driver.findElement(By.name("firstName")).sendKeys(arg2);
			  driver.findElement(By.name("lastName")).sendKeys(arg3);
			  driver.findElement(By.name("password")).sendKeys(arg4);
			  driver.findElement(By.name("confirmPassword")).sendKeys(arg5);
			  driver.findElement(By.xpath("//input[@value='Female']")).click();
			  driver.findElement(By.name("emailAddress")).sendKeys(arg6);
			  driver.findElement(By.name("mobileNumber")).sendKeys(arg7);
			  driver.findElement(By.name("dob")).sendKeys(arg8);
			  driver.findElement(By.name("address")).sendKeys(arg9);
			  Select a=new Select(driver.findElement(By.id("securityQuestion")));
			  a.selectByIndex(2);
			  driver.findElement(By.id("answer")).sendKeys(arg10);
			  driver.findElement(By.name("Submit")).click();
		}
 

	@Then("^user must be redirected to the login page$")
	public void user_must_be_redirected_to_the_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverWait wait= new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Login")));
		System.out.println("Registered Successfully");
		driver.close();
	   
	}
	@Given("^User must be in the Login Page$")
	public void user_must_be_in_the_Login_Page() throws Throwable {
		driver=UtilityClass.browser("http://10.232.237.143:443/TestMeApp/login.htm");
    	}

	@When("^User must provide registered username credentials \"([^\"]*)\" and \"([^\"]*)\" and click Login$")
	public void user_must_provide_registered_username_credentials_and_and_click_Login(String arg1, String arg2) throws Throwable {
	    //System.out.println(arg1+ " "+arg2);
		driver.findElement(By.name("userName")).sendKeys(arg1);
	    driver.findElement(By.name("password")).sendKeys(arg2);
	    driver.findElement(By.name("Login")).click();
		}
	
	@Then("^Login is done successfully and user is directed to the Home page$")
	public void login_is_done_successfully_and_user_is_directed_to_the_Home_page() throws Throwable {
		WebDriverWait wait= new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("val")));
		System.out.println("Logged in successfully");
		driver.close(); 
	    }
	
	@Given("^User must be in the Home Page$")
	public void user_must_be_in_the_Home_Page() throws Throwable {
		driver=UtilityClass.browser("http://10.232.237.143:443/TestMeApp/login.htm");
		driver.findElement(By.name("userName")).sendKeys("lalitha");
	    driver.findElement(By.name("password")).sendKeys("password123");
	    driver.findElement(By.name("Login")).click();
		Assert.assertEquals(driver.getTitle(), "Home");
		
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^User searches for a product in search engine$")
	public void user_searches_for_a_product_in_search_engine() throws Throwable {
		driver.findElement(By.name("products")).sendKeys("Head");
		driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^the user should be in the search result page$")
	public void the_user_should_be_in_the_search_result_page() throws Throwable {
		Assert.assertEquals(driver.getTitle(), "Search");
		System.out.println("search results are displayed");
		// Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}
	@Given("^User must be in the search page$")
	public void user_must_be_in_the_search_page() throws Throwable {
		driver=UtilityClass.browser("http://10.232.237.143:443/TestMeApp/login.htm");
		driver.findElement(By.name("userName")).sendKeys("lalitha");
	    driver.findElement(By.name("password")).sendKeys("password123");
	    driver.findElement(By.name("Login")).click();
	    driver.findElement(By.name("products")).sendKeys("Head");
		driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
	}

	@When("^try to proceed to payment without adding any item$")
	public void try_to_proceed_to_payment_without_adding_any_item() throws Throwable {
		Assert.assertEquals(driver.getTitle(), "Search");
		String a=driver.findElement(By.partialLinkText("Cart")).getText();
		
	}

	@Then("^Testme app doesn't show the cart icon$")
	public void testme_app_doesn_t_show_the_cart_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}


}
