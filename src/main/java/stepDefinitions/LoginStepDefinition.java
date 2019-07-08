package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition {
	WebDriver driver;
	
	@Given("^user is on login page$")
	public void user_is_on_login_page(){
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://www.crmpro.com/index.html");
		
	}

	@When("^title of login page is Free CRM$")
	public void title_of_login_page_is_Free_CRM(){
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.",title);
	    
	}

	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_and(String username, String password){
		driver.findElement(By.name("username")).sendKeys(username);
 	    driver.findElement(By.name("password")).sendKeys(password);   
	}

	@Then("^user clicks on Login button$")
	public void user_clicks_on_Login_button(){
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginBtn);
	    
	}

	@Then("^user is on Home Page$")
	public void user_is_on_Home_Page(){
		 String title = driver.getTitle();
		 System.out.println("Home page title is: "+title);
		 Assert.assertEquals("CRMPRO", title);
	    
	}

	@Then("^close the browser$")
	public void close_the_browser() {
		driver.quit();
	   
	}

}
