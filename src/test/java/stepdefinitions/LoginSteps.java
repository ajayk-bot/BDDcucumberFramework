package stepdefinitions;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qaFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//https://www.techlistic.com/2019/08/automate-buy-product-using-selenium.html

public class LoginSteps {


	public static String title;
	LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
	    title = loginPage.getLoginPageTitle();
	    System.out.println("Title of the Page : "+title);
	    System.out.println("END");
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String ExpectedTitle) {
		 System.out.println("Title of the Page : "+title);
		Assert.assertTrue(title.equalsIgnoreCase(ExpectedTitle));
	}

	@Then("forget your password link should be displayed")
	public void forget_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.getForgotPasswordLink());
	}

	@When("user enters username  {string}")
	public void user_enters_username(String userName) {
			loginPage.enterUserName(userName);
	}

	@When("user enters password  {string}")
	public void user_enters_password(String passWord) {
		loginPage.enterpassWord(passWord);
	}

	@When("user click on Login button")
	public void user_click_on_login_button() {
		loginPage.clickOnSignIn();
	}


	@Then("user gets the AuthenticationFailedMsg {string}")
	public void user_gets_the_AuthenticationFailedMsg(String ExpectedMsg) {
		String ActualMsg = loginPage.verifyInvalidLogin();
		System.out.println("Actual msg"+ActualMsg);
		System.out.println("Expected msg"+ExpectedMsg);
		Assert.assertTrue(ActualMsg.equalsIgnoreCase(ExpectedMsg));
	}
	
	

}
