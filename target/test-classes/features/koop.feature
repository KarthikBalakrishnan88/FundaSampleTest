Feature: Search houses that are on Sale [Koop]
         As a user of Funda.nl website
		 To search house that are on sale
		 I should be able to use the search option in the home page.

Scenario: Legal notification for usuage of cookies should be displayed
	Given I navigate to Funda home page
	Then I should see a legal warning for usuage of the cookies

Scenario: Verify that the last search item link is updated after a successful search
	Given I navigate to Funda home page
		And click on Koop link
		And I enter the search criteria as
		|Address	|Radius	|PriceVan	|PriceTot	|
		|Amsterdam	|+5 km	|€ 50.000	|€ 275.000	|
		And I click on Zoek button
 	When I go back to the home screen
 	Then I should see the last search item link with
 	|Address	|Radius	|PriceVan	|PriceTot	|
	|Amsterdam	|+5 km	|€ 50.000	|€ 275.000	|

@Regression
Scenario Outline: Verify that User should be able to search the house by providing valid inputs
	Given I navigate to Funda home page
		And click on Koop link
	When I enter the address as "<Address>"
		And I select the radius as "<Radius>"
		And I select the from price as "<PriceVan>"
		And I select the to price as "<PriceTot>"
		And I click on Zoek button
	Then I should see the search results
	Examples:
	|Address						|Radius	|PriceVan	|PriceTot		|
	|Amsterdam						|+0 km	|€ 0		|€ 275.000		|
	
	