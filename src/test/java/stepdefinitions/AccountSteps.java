package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.qaFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountSteps {

	//private String username;
	//private String password;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountPage accPage;

	@Given("User already logged into the application")
	public void user_already_logged_into_the_application(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.

		List<Map<String, String>> userCrendentials = dataTable.asMaps();
		String username = userCrendentials.get(0).get("UserName");
		String password = userCrendentials.get(0).get("Password");

		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accPage = loginPage.doLogin(username, password);
	}

	@Given("user is on account page")
	public void user_is_on_account_page() {

		String title  = accPage.getAccountPageTitle();
		System.out.println(title);
		
	}

	@Then("user gets the account section")
	public void user_gets_the_account_section(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.

		List<String> expectedMenusList = dataTable.asList();

		int size = accPage.getSizeOfAccountSection();
		List<String> actualMenusList = accPage.namesOfmenus();
		System.out.println("Actual List return is" + actualMenusList);
		System.out.println("Expected List return is" + expectedMenusList);
		//Boolean value =  menusList.equals(reutrnList);
		Assert.assertTrue(actualMenusList.containsAll(expectedMenusList));
	}

}
