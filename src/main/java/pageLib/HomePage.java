package pageLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilLib.ElementUtil;

public class HomePage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	private By titleHeader = By.xpath("//header[@class='entry-header']");
	private By palindromText = By.id("originalWord");
	private By palindromeSubmitBtn = By.id("button1");
	private By palindromeResult = By.id("palindromeResult");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public void launchBrowser(String url) {
		elementUtil.lunchBrowser(url);
	}
	
	public String validatePageTitleMessage() {
		return elementUtil.getRequiredText(titleHeader);
	}
	
	public boolean validateSubmitBtnEnableState() {
		return elementUtil.getDisplayStatus(palindromeSubmitBtn);
	}
	
	public void enterInputParam(String inputVal) {
		elementUtil.doSendKey(palindromText, inputVal);
	}
	
	public void clickOnSubmit() {
		elementUtil.doClick(palindromeSubmitBtn);
	}
	
	public String getResultMessage() {
		return elementUtil.getRequiredText(palindromeResult);
	}
}
