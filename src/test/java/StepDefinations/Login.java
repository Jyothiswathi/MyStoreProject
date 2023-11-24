package StepDefinations;

import java.util.Properties;

import com.pageobjects.LoginPage;
import com.utility.ConfigReader;
import com.utility.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Login {
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	public ConfigReader c = new ConfigReader();
	Properties prop;

	@Given("enter the url")
	public void enter_the_url() {
		prop = c.init_Properties("Config");
		DriverFactory.getDriver().get(prop.getProperty("url"));
	}

	@Then("Enter the userName and password")
	public void enter_the_user_name_and_password() {
		loginpage.facebookLogin();

	}

}
