Feature: Search houses that are on Sale [Koop]
         As a user of Funda.nl website
		 To search house that are on sale
		 I should be able to use the search option in the home page.

Scenario: Legal notification for usuage of cookies should be displayed
	Given I navigate to Funda home page
	Then I should see a legal warning for usuage of the cookies

@Regression
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
	|Address							|Radius	|PriceVan	|PriceTot		|
	|Amsterdam							|+0 km	|€ 0		|€ 275.000		|
	|Peter Calandlaan					|+5 km	|€ 0		|Geen maximum	|
	|1060TT								|+10 km	|€ 2.000.000|Geen maximum	|
	|Pieter Calandlaan 422, Amsterdam	|+15 km	|€ 0		|Geen maximum	|

Scenario: Verify that the input box for address should autofill with suggesstions
	Given I navigate to Funda home page
		And click on Koop link
	When I enter the address as "AMS"
	Then I should see autofil suggestions

Scenario: Verify that Van price should accept only numeric values
	Given I navigate to Funda home page
		And click on Koop link
	When I enter the address as "Amsterdam"
		And I select the from price as "anders" 
	Then I should not be able to enter alphabets
	
Scenario: Verify that Tot price should accept ony numeric values
	Given I navigate to Funda home page
		And click on Koop link
	When I enter the address as "Amsterdam"
		And I select the to price as "<PriceTot>" 
	Then I should not be able to enter alphabets

Scenario: Verify that when Tot price is less the Van Price then it should be highlight in red color
	Given I navigate to Funda home page
		And click on Koop link
	When I enter the address as "Amsterdam"
		And I select the from price as "€ 200.000" 
		And I select the to price as "€ 75.000" 
		And I click on Zoek button
	Then I should see the tot Price field is highlighed with red color	
	