package testSelenium.learning;


import java.io.IOException;

import org.testng.annotations.Test;

import Pages.Guru99HomePage;
import Pages.Guru99Page;
import Pages.LoginPage;
import commonPackage.BasePage;

public class Guru99HomePagetest extends BasePage{
	
	@Test (groups = {"test1","test2"})
	public void logwithValidDataTest() throws IOException {
		Guru99HomePage lp = new Guru99HomePage();
		lp.checkBGColor();
	}
	
}
