package testSelenium.learning;

import org.testng.annotations.Test;

import Pages.NaukariPage;
import commonPackage.BasePage;

public class NaukariTest extends BasePage{

	@Test
	public void NaukariPageTest() {

		NaukariPage np = new NaukariPage();
		np.mouseHoverAndClick();
	}
}
