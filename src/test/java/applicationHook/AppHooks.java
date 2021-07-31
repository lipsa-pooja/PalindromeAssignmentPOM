package applicationHook;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilLib.ConfigPropertyReader;

public class AppHooks {
	ConfigPropertyReader config;
	Properties prop;
	DriverFactory driverfactory;
	WebDriver driver;

	@Before(order = 0)
	public void setUpConfig() {
		config = new ConfigPropertyReader();
		prop = config.getProperty();
	}

	@Before(order = 1)
	public void setUpWebDriver() {
		driverfactory = new DriverFactory();
		driver = driverfactory.init_Driver(prop);
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void captureScreenshot(Scenario sc) throws IOException {
		if (sc.isFailed()) {
			String screenshotName = sc.getName().replace(" ", "_");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(screenshot, "image/png", screenshotName);
		}

	}



}
