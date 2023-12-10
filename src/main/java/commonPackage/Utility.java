package commonPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class Utility extends BasePage {
	
	
	public void implicitWait(int timeCount, WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(timeCount, TimeUnit.MILLISECONDS);
	}

	public void takeAScreenshot(WebDriver driver, String fileWithPath, String nameOfScreen) throws IOException {

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);

		File destFile = new File(System.getProperty("user.dir") + fileWithPath + nameOfScreen);

		FileUtils.copyFile(scrFile, destFile);

	}

	public void dropDownSelection(WebElement selectionEle, String selectBy, String valueOfDropDown) {
		Select sel = new Select(selectionEle);

		if (selectBy.equals("value")) {
			sel.selectByValue(valueOfDropDown);
		}

		if (selectBy.equals("text")) {
			sel.selectByVisibleText(valueOfDropDown);
		}
	}

	public void clickRadioButton(WebElement elemnt) {
		try {
			elemnt.isDisplayed();
			elemnt.click();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
	}

	public void explicitWaitOnElement(int tm, String TypeOfExpectedCond, WebElement ele) {

		if (TypeOfExpectedCond.equals("alertPresent")) {

			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(tm));
			wait.until(ExpectedConditions.alertIsPresent());
		}

		if (TypeOfExpectedCond.equals("elementClickable")) {
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(tm));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		}

		if (TypeOfExpectedCond.equals("elementSelected")) {
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(tm));
			wait.until(ExpectedConditions.elementToBeSelected(ele));
		}

		if (TypeOfExpectedCond.equals("invisibilityOfElement")) {
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(tm));
			wait.until(ExpectedConditions.invisibilityOf(ele));
		}

	}

	public void fluentWaitOnElement(WebElement ele) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5000))
				.pollingEvery(Duration.ofMillis(500)).ignoring(ElementNotInteractableException.class);
	}

	public Object readDateFromExcel(String sheetName, int rowNumber, int column)
			throws InvalidFormatException, IOException {

		File fs = new File(System.getProperty("user.dir") + prop.getProperty("excelFile"));
		FileInputStream fis = new FileInputStream(fs);
		Workbook workbook = new XSSFWorkbook(fs);

		Sheet sh = workbook.getSheet(sheetName);

		int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();
		String data = "";

		if (rowCount > 0) {
			Row rw = sh.getRow(rowNumber);
			data = rw.getCell(column).getStringCellValue().trim();
		}

		Object object = data;
		return object;
	}

	public void hardAssertionValidation(String typeOfAssertion) {
		Assertion hardAssert = new Assertion();
		if (typeOfAssertion.equals("Equals")) {
			hardAssert.assertEquals("Test", "Test");
		}
	}

	public void seleniumNevigation(String typeOfNavigation) {
		if (typeOfNavigation.equals("back")) {
			driver.navigate().back();
		}

		if (typeOfNavigation.equals("forward")) {
			driver.navigate().forward();
		}

		if (typeOfNavigation.equals("refresh")) {
			driver.navigate().refresh();
		}

	}

	public String getTextOfElement(WebElement ele, String usingAttribute) {

		if (usingAttribute.equals("innerhtml")) {
			return ele.getAttribute("innerHTML");
		}

		if (usingAttribute.equals("value")) {
			return ele.getAttribute("value");
		}

		return ele.getText();
	}

	public void applyAssetVerification(String method, String actual, String expected) {

		if (method.equals("euals")) {
			Assert.assertEquals(actual, expected);
		}

		if (method.equals("true")) {
			Assert.assertTrue(false, expected);
		}

		if (method.equals("false")) {
			Assert.assertFalse(false, expected);
		}

	}

	public void applyVerifyVerification(String method, String actual, String expected) {

		SoftAssert softAssert = new SoftAssert();

		if (method.equals("euals")) {
			softAssert.assertEquals(actual, expected);
		}

		if (method.equals("true")) {
			softAssert.assertTrue(false, expected);
		}

		if (method.equals("false")) {
			softAssert.assertFalse(false, expected);
		}
	}

	public void testWithActionClass(String actionsPerform, WebElement ele) {
		Actions act = new Actions(driver);

		if (actionsPerform.equals("click")) {
			act.click(ele).build().perform();
		}

		if (actionsPerform.equals("doubleclick")) {
			act.doubleClick(ele).build().perform();
		}

		if (actionsPerform.equals("moveToElement")) {
			act.moveToElement(ele).build().perform();
		}

		if (actionsPerform.equals("clickAndHold")) {
			act.clickAndHold(ele).build().perform();
		}

		if (actionsPerform.equals("rightClick")) {
			act.contextClick(ele).build().perform();
		}

		if (actionsPerform.equals("upKey")) {
			act.sendKeys(Keys.ARROW_UP).build().perform();
		}

		if (actionsPerform.equals("escKey")) {
			act.sendKeys(Keys.ESCAPE).build().perform();
		}

		if (actionsPerform.equals("enterKey")) {
			act.sendKeys(Keys.ENTER).build().perform();
		}

	}

	public void swtichingBetweenWindoes(WebDriver driver) {

		String parent = driver.getWindowHandle();
		System.out.println(parent);

		Set<String> s = driver.getWindowHandles();

		Iterator<String> it = s.iterator();

		while (it.hasNext()) {
			String childWindow = it.next();

			if (parent != childWindow) {
				driver.switchTo().window(childWindow);
				System.out.println(driver.getTitle());
			}

		}
		driver.switchTo().window(parent);

		// driver.switchTo().defaultContent();

	}

	public void workWithAlert(String actionOnAlert) {

		Alert ale = driver.switchTo().alert();

		if (actionOnAlert.equals("accept")) {
			ale.accept();
		}

		if (actionOnAlert.equals("dismiss")) {
			ale.dismiss();
		}

		if (actionOnAlert.equals("gettext")) {
			System.out.println(ale.getText());
		}

		if (actionOnAlert.equals("typeText")) {
			ale.sendKeys("SomeTExt");
		}
	}
	
	
	public void WorkWithJavaScriptExecutor(String ActWithJS,String ele) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		if (ActWithJS.equals("click")) {
			js.executeScript(ele+"click();");
		}
	}
	
	public void workWithFrames() {
		driver.switchTo().frame(0);
		
		driver.switchTo().frame("ifram1");
		WebElement iframe = driver.findElement(By.id("Frame1"));

		driver.switchTo().frame(iframe);
		
		
		driver.switchTo().defaultContent();
		
	}
	
	
	public void responsiveWindow() {
		int hight = 450;
		int width = 1200;
		Dimension dm = new Dimension(hight,width);
		driver.manage().window().setSize(dm);
	}

}
