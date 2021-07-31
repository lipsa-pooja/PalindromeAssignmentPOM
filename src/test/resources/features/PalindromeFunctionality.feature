Feature: validate palindrome functionality of excelon


Scenario Outline: Validating palindrome functionality with <ScenarioName>
	Given URL "https://xndev.com/palindrome"
	Then validate "The Palindrome Exercise" title appeared on the page
	And validate submit button is appeared
	When user enters "<input>" on Palindrome TextField
	And click on submit button
	Then validate "<Expected Message>" appeared on the page

Examples:
	|ScenarioName													|input			|Expected Message													|
	|Valid Alpha-Numeric									|121aba121	|Yes! 121aba121 reversed is 121aba121			|
	|Valid Numeric Value									|12121			|Yes! 12121 reversed is 12121							|
	|Invalid Numeric Value								|1234521		|No! 1234521 reserved is 1254321					|
	|Invalid Alpha-Numeric								|123abc345	|No! 123abc345 reserved is 543cba321			|
	|String Value with Single Space				|abc cba		|Yes! abc cba reversed is abc cba					|
	|String Value with Multiple Space 		|xyz     zyx|Yes! xyz     zyx reversed is xyz     zyx	|
	|String Value Starts/Ends With Space	|  abcba  |Yes!   abcba   reversed is   abcba  |
	|With Special Character								|%^&**&^%		|Yes! %^&**&^% reversed is %^&**&^%				|
	|With different language characters		|是的不				|No! 是的不 reserved is 不的是								|
	|Validation with empty space					|						|Yes! reversed is													|
