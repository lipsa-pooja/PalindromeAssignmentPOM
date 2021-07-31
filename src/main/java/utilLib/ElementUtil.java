package utilLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public void lunchBrowser(String url) {
		driver.get(url);
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public void doSendKey(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public String getRequiredText(By locator) {
		return getElement(locator).getText();
	}
	
	public WebElement waitTillElement(By locator, int timeout) {
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		return	wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public boolean getDisplayStatus(By locator) {
		return getElement(locator).isDisplayed();
	}
}
