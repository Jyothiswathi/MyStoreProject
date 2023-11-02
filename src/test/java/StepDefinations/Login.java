package StepDefinations;

import com.pageobjects.LoginPage;
import com.utility.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Login {
	private LoginPage loginpage=new LoginPage(DriverFactory.getDriver());

	@Given("enter the url")
	public void enter_the_url() {
		DriverFactory.getDriver().get("https://www.facebook.com/login.php");
	}

	@Then("Enter the userName and password")
	public void enter_the_user_name_and_password() {
		loginpage.facebookLogin();
	
	}

}
