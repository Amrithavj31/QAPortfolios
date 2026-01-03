package settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Settings {
    public WebDriver driver;
   
    public void launchBrowser(String browser) {
    	if (browser.equals("chrome")) {
    		 driver = new ChromeDriver();
    		 System.out.println("Test case : Successfully opened chrome browser");
    	}
    	else if (browser.equals("firefox")) {
    		driver=new FirefoxDriver();
    		System.out.println("Test case : Successfully opened firefox browser");
    	}
    	else if (browser.equals("edge")) {
    		driver=new EdgeDriver();
    		System.out.println("Test case : Successfully opened edge browser");
    	}
    	else {
    		System.out.println("Invalid browser");
    	}
       
        driver.manage().window().maximize();
        
    }

    public void exit() {
        if (driver != null) {
            driver.quit();
            
        }
    }
    public void chooseBrowser(String browser) {
		if (browser.equals("chrome")) {
			driver =new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new EdgeDriver();
		}
	}
}
