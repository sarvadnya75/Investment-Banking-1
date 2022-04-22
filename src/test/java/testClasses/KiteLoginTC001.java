package testClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import baseClasses.UtilityClass;
import configurations.PathConfigure;
import pomClasses.KiteZerodha;

public class KiteLoginTC001 {

	BaseClass base;
	WebDriver driver;
	KiteZerodha zerodha;
	UtilityClass util;
	String tcID;

	@BeforeClass
	public void launchBrowser() throws IOException {
		base = new BaseClass();
		driver = base.driverInit();
		zerodha = new KiteZerodha(driver);
		util = new UtilityClass();
	}

	@BeforeMethod
	public void enterUrl() {
		driver.navigate().refresh();
	}

	@Test
	public void logInScenario1_BlankUserBlankPass() {
		tcID = "101";
		zerodha.kiteLoginBtn();

		Assert.assertEquals(zerodha.getErrorMessageOfUN(), "User IDshould be minimum 6 characters.");
		Assert.assertEquals(zerodha.getErrorMessageOfPass(), "Password should be minimum 6 characters.");

	}

	@Test
	public void logInScenario2_EnterOnlyUserName() throws EncryptedDocumentException, IOException, InterruptedException {
		tcID = "102";
		zerodha.enterUserName(util.getTestData(0, 0));
		
		zerodha.kiteLoginBtn();

		Assert.assertEquals(zerodha.getErrorMessageOfPass(), "Password should be minimum 6 characters.");
	}

	@Test
	public void logInScenario3_EnterOnlyPassword() throws EncryptedDocumentException, IOException, InterruptedException {
		tcID = "103";
		zerodha.enterPassword(util.getTestData(0, 1));
		Thread.sleep(2000);
		zerodha.kiteLoginBtn();

		Assert.assertEquals(zerodha.getErrorMessageOfUN(), "User ID should be minimum 6 characters.");
	}

	@AfterMethod
	public void takesScreenshot(ITestResult result) throws IOException {
		
		if (ITestResult.FAILURE == result.getStatus()) {
			util.captureScreenshot(driver,tcID);
		}
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
