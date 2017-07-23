package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Koop")
	WebElement link_Koop;

	@FindBy(id = "autocomplete-input")
	WebElement inputAddress;

	@FindBy(id = "Straal")
	WebElement selectRadius;

	@FindBy(id = "range-filter-selector-select-filter_koopprijsvan")
	WebElement selectPriceFrom;

	@FindBy(id = "range-filter-selector-select-filter_koopprijstot")
	WebElement selectPriceTo;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement buttonSearch;

	@FindBy(css = "a.link-alternative")
	WebElement link_lastSearch;

	public void clickKoopLink() {
		link_Koop.click();
	}

	public void enterAddres(String address) {
		inputAddress.clear();
		inputAddress.sendKeys(address);
	}

	public void selectRadiusValue(String val) {
		Select _selectRadius = new Select(selectRadius);
		_selectRadius.selectByVisibleText(val);
	}

	public void selectPriceFromValue(String val) {
		Select _selectPriceFrom = new Select(selectPriceFrom);
		_selectPriceFrom.selectByVisibleText(val);
	}

	public void selectPriceToValue(String val) {
		Select _selectPriceTo = new Select(selectPriceTo);
		_selectPriceTo.selectByVisibleText(val);
	}

	public void clickSearchButton() {
		buttonSearch.click();
	}

	public String getLastSearchResultLink() {
		return link_lastSearch.getText();
	}

}
