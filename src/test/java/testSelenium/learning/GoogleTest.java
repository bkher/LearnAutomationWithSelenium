package testSelenium.learning;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.GooglePage;
import commonPackage.BasePage;

public class GoogleTest extends BasePage{

	
	@Test
	public void searchKeyWordAndStoreScreenShot() throws IOException {
		GooglePage gp = new GooglePage();
		gp.solutionOfStaleElement("Van Heusen India");
	}
}
