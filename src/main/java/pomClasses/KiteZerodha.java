package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteZerodha {

	@FindBy(xpath = "//button[@type='submit']") private WebElement loginButton;	
	
	@FindBy(xpath= "//input[@type='text']") private WebElement userName;
	
	@FindBy(xpath= "//input[@type='password']") private WebElement passWord;
	
	@FindBy(xpath = "//span[contains(text(),'User ID')]") private WebElement errorText1;
	
	@FindBy(xpath = "//span[contains(text(),'Password should be')]") private WebElement errorText2;
	
	public KiteZerodha(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public void enterUserName(String username) {
		userName.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passWord.sendKeys(password);
	}
	
	public void kiteLoginBtn() {
		loginButton.click();
	}
	
	public String getErrorMessageOfUN() {
		String text1 = errorText1.getText();
		return text1;
	}
	
	public String getErrorMessageOfPass() {
		String text2 = errorText2.getText();
		return text2;
	}
	
	
}
