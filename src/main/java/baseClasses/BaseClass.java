package baseClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import configurations.AllPath;
import configurations.PathConfigure;


public class BaseClass {
      
    public WebDriver driverInit() throws IOException {
    	System.setProperty("webdriver.chrome.driver", AllPath.chromePath);
    	WebDriver driver=new ChromeDriver();
    	driver.get(UtilityClass.readPropertyFileData("URL"));
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	return driver;
    }
    
    
}
