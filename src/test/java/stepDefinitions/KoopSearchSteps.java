package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.SearchResultsPage;

public class KoopSearchSteps {

	SeleniumDriver webDriver = new SeleniumDriver();
	WebDriver driver = webDriver.getDriver();
	HomePage homePage = new HomePage(driver);
	SearchResultsPage searchResultPage = new SearchResultsPage(driver);

	@Given("^I navigate to Funda home page$")
	public void i_navigate_to_Funda_home_page() {
		driver.navigate().to("http://www.funda.nl/");
	}

	@Given("^click on Koop link$")
	public void click_on_Koop_link() {
		homePage.clickKoopLink();
	}

	@Given("^I enter the search criteria as$")
	public void i_enter_the_search_criteria_as(DataTable table) {
		List<List<String>> data = table.raw();
		homePage.enterAddres(data.get(1).get(0));
		homePage.selectRadiusValue(data.get(1).get(1));
		homePage.selectPriceFromValue(data.get(1).get(2));
		homePage.selectPriceToValue(data.get(1).get(3));
	}

	@Given("^I click on Zoek button$")
	public void i_click_on_Zoek_button() {
		homePage.clickSearchButton();
	}

	@When("^I go back to the home screen$")
	public void i_go_back_to_the_home_screen() {
		driver.navigate().to("http://www.funda.nl/");
	}

	@Then("^I should see the last search item link with$")
	public void i_should_see_the_last_search_item_link_with(DataTable table) {
		List<List<String>> data = table.raw();
		String expectedResult = String.format("{0}, {1}, {2}, {3}+", data.get(1).get(0), data.get(1).get(1),
				data.get(1).get(2), data.get(1).get(3));
		Assert.assertTrue("The last result is not updated", expectedResult == homePage.getLastSearchResultLink());
	}

	@When("^I enter the address as \"([^\"]*)\"$")
	public void i_enter_the_address_as(String arg1) {

		homePage.enterAddres(arg1);
	}

	@When("^I select the radius as \"([^\"]*)\"$")
	public void i_select_the_radius_as(String arg1) {
		homePage.selectRadiusValue(arg1);
	}

	@When("^I select the from price as \"([^\"]*)\"$")
	public void i_select_the_from_price_as(String arg1) {
		homePage.selectPriceFromValue(arg1);
	}

	@When("^I select the to price as \"([^\"]*)\"$")
	public void i_select_the_to_price_as(String arg1) {
		homePage.selectPriceToValue(arg1);
	}

	@Then("^I should see the search results$")
	public void i_should_see_the_search_results() {
		searchResultPage.isResultsDisplyed();
	}
}
