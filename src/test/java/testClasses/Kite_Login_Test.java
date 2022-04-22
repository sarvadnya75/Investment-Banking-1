package testClasses;

import java.io.IOException;

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
import pomClasses.KiteLogin;

public class Kite_Login_Test {
    
	BaseClass base;
	WebDriver driver;
	KiteLogin kite;
	String tcID;
	
	@BeforeClass
	public void launchBrowser() throws IOException {
		 base=new BaseClass();
		 driver = base.driverInit();
	     kite=new KiteLogin(driver);
	}
	
	@BeforeMethod
	public void refresh() {
		driver.navigate().refresh();
	}
	
	@Test
	public void validCredentialLogIn() throws IOException, InterruptedException {
		tcID="201";
		kite.enterUsername(UtilityClass.readPropertyFileData("UNAME"));
		kite.enterPassword(UtilityClass.readPropertyFileData("PWORD"));
        kite.loginButton(); 
        kite.passCode(UtilityClass.readPropertyFileData("PCODE"));
        kite.clickbutton();
        String UserID = kite.getUserID();
	    Assert.assertEquals(UserID, UtilityClass.readPropertyFileData("UNAME"));
	}
	
	@AfterMethod
	public void takesScreenshot(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus()) {
			UtilityClass.captureScreenshot(driver, tcID);
		}
	}
		@AfterClass
		public void closeBrowser() {
			driver.close();
		}	
	
}
