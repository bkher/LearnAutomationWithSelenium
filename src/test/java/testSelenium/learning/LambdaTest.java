package testSelenium.learning;

import org.testng.annotations.Test;

import Pages.LambdatestPage;
import commonPackage.BasePage;

public class LambdaTest extends BasePage{

	@Test
	public void staleElementTest() {
		LambdatestPage ltp = new LambdatestPage();
		ltp.ClickTableSearchLink();
		ltp.EnterFilterKeyword("in progress");
		ltp.nevogationBack();
		ltp.ClickTableSearchLink();
		ltp.EnterFilterKeyword("completed");
	}
}
