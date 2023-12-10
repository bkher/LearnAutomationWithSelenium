package testSelenium.learning;


import java.io.IOException;

import org.testng.annotations.Test;

import Pages.Guru99Page;
import Pages.LoginPage;
import commonPackage.BasePage;

public class Guru99PageTest extends BasePage{
	
	@Test(groups = {"test2"})
	public void logwithValidDataTest() throws IOException {
		Guru99Page lp = new Guru99Page();
		lp.getThetextOfXapath();
	}
	
}
