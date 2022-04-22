package pomClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KiteBuyModule {

	@FindBy(xpath="(//button[@type='button'])[2]")private WebElement buy;
	@FindBy(xpath="//input[@type='text']") private WebElement company;
	
}
