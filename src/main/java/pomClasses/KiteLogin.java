package pomClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClasses.UtilityClass;

public class KiteLogin {

	@FindBy(xpath ="//input[@type='text']") private WebElement username;
	@FindBy(xpath ="//input[@type='password']") private WebElement password;
	@FindBy(xpath ="//button[@type='submit']") private WebElement loginbutton;
	@FindBy(xpath ="//input[@id='pin']") private WebElement passcode;
	@FindBy(xpath ="//button[@type='submit']") private WebElement button;
	@FindBy(xpath ="//span[text()='AL0737']") private WebElement getuserid;
	
	public KiteLogin (WebDriver driver){
    PageFactory.initElements(driver, this);	
}
	
	public void enterUsername(String uname) throws IOException {
		username.sendKeys(uname);
	}
	
	public void enterPassword(String pword) throws IOException {
		password.sendKeys(pword);
	}
	
	public void loginButton() {
		loginbutton.click();
	}
	
	public void passCode(String pcode) {
		passcode.sendKeys(pcode);
	}
	
	public void clickbutton() {
		button.click();
	}
	public String getUserID() {
		String text = getuserid.getText();
		return text;
	}
	
	
	
}
