package com.fourstay.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {
	private static WebDriver driver;
	// dot . means project home folder path
	// everything follows the dot will be added to project home folder path
	public static final String CHROME_DRIVER = "webdriver.chrome.driver";
	public static final String CHROME_DRIVER_PATH = "./src/test/resources/com/fourstay/Browsers/chromedriver.exe";
	public static final String FIREFOX_DRIVER = "webdriver.gecko.driver";
	public static final String FIREFOX_DRIVER_PATH = "./src/test/resources/com/fourstay/Browsers/geckodriver.exe";
	public static final String IE_DRIVER = "webdriver.ie.driver";
	public static final String IE_DRIVER_PATH = "./src/test/resources/com/fourstay/Browsers/IEDriverServer_1.exe";
	public static final String PHANTOMJS_DRIVER = "phantomjs.binary.path";
	public static final String PHANTOMJS_DRIVER_DRIVER_PATH = "./src/test/resources/Browsers/phantomjs.exe";
	public static final String EDGE_DRIVER = "webdriver.edge.driver";
	public static final String EDGE_DRIVER_DRIVER_PATH = "./src/test/resources/com/fourstay/Browsers/MicrosoftWebDriver.exe";

	@Before
	public void setUp() {
		//This line is to check if there is already a browser running on the system.
		String browser = System.getProperty("browser");
		
		if (browser==null) {
			browser = "chrome";
		}
		
		if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
			// String browser = "edge";
			switch (browser) {
			case "firefox":
				System.setProperty(FIREFOX_DRIVER, FIREFOX_DRIVER_PATH);
				driver = new FirefoxDriver();
				break;
			case "ie":
				System.setProperty(IE_DRIVER, IE_DRIVER_PATH);
				driver = new InternetExplorerDriver();
				break;
			case "phantomjs":
				System.setProperty(PHANTOMJS_DRIVER, PHANTOMJS_DRIVER_DRIVER_PATH);
				driver = new PhantomJSDriver();
				break;
			case "edge":
				System.setProperty(EDGE_DRIVER, EDGE_DRIVER_DRIVER_PATH);
				driver = new EdgeDriver();
				break;
			case "chrome":
			default:
				System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
				driver = new ChromeDriver();
				break;
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		}
		Base.driver = driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");

		}
		if (driver != null) {
			driver.quit();
		}
	}

}
