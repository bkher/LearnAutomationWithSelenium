package commonPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public static WebDriver driver;
	public Properties prop;
	public Utility utils;

	public BasePage() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	@Parameters({ "browser" })
	@BeforeTest
	public void openBrowser(String browser) {

		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			utils = new Utility();
			//utils.responsiveWindow();
			 driver.manage().window().maximize();
			driver.get(prop.getProperty("naukariURL"));
			utils.implicitWait(5000, getDriver());
		}

		if (browser.equalsIgnoreCase("safari")) {
			// WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			utils = new Utility();
			utils.implicitWait(5000, getDriver());
		}

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			utils = new Utility();
			utils.implicitWait(5000, getDriver());
		}

	}

	@AfterTest
	public void exitBrowser() {
		driver.quit();
		;

	}
}
