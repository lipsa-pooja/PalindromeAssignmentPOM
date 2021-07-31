package stepDefination;

import org.junit.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageLib.HomePage;

public class StepDefination {
	
	HomePage homepage = new HomePage(DriverFactory.getDriver());
	
	@Given("URL {string}")
	public void url(String reqURL) {
		homepage.launchBrowser(reqURL);
	}

	@Then("validate {string} title appeared on the page")
	public void validate_the_palindrome_exercise_title_appeared_on_the_page(String reqHeader) {
		Assert.assertEquals("Required Header is not matching on Home Page", reqHeader, homepage.validatePageTitleMessage());
	   
	}

	@Then("validate submit button is appeared")
	public void validate_submit_button_is_appeared() {
	    Assert.assertTrue("Required Submit button is not appearing on the Home Page", homepage.validateSubmitBtnEnableState());
	}

	@When("user enters {string} on Palindrome TextField")
	public void user_enters_on_palindrome_text_field(String inputVal) {
	    homepage.enterInputParam(inputVal);
	}

	@When("click on submit button")
	public void click_on_submit_button() {
	    homepage.clickOnSubmit();
	}

	@Then("validate {string} appeared on the page")
	public void validate_appeared_on_the_page(String expResult) {
	    Assert.assertEquals("Required Result message is not appearing", expResult, homepage.getResultMessage());
	}

}
