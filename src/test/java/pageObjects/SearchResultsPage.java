package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class SearchResultsPage {

	WebDriver driver;

	public SearchResultsPage(WebDriver driver) {
		driver = this.driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.search-output-result-count > span")
	WebElement searchResultCount;

	@SuppressWarnings("deprecation")
	public void isResultsDisplyed() {
		Assert.assertTrue("Error in search", searchResultCount.isDisplayed());
		System.out.println(searchResultCount.getText());
	}

}
