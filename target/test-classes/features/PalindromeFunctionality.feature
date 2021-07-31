Feature: validate palindrome functionality of excelon


Scenario Outline: Validating palindrome functionality with
	Given URL "https://xndev.com/palindrome"
	Then validate "The Palindrome Exercise" title appeared on the page
	And validate submit button is appeared
	When user enters "<input>" on Palindrome TextField
	And click on submit button
	Then validate "<Expected Message>" appeared on the page

Examples:
	|ScenarioName											|input		|Expected Message											|
	|Valid Alpha-Numeric							|121aba121|Yes! 121aba121 reversed is 121aba121	|

