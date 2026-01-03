package ourStory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import settings.Settings;

public class OurStory extends Settings {
	 WebDriverWait wait;

	    @BeforeTest
	    @Parameters("browser")
	    public void setupBrowser(String browser) {
	    	chooseBrowser(browser);
			launchBrowser(browser);
	        driver.get("https://ginandjuice.shop/");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));    
	    }
	    @Test
	    public void ourStory() {
	    	WebElement about =driver.findElement(By.xpath("//*[@id=\"scanMeHeader\"]/section[2]/div/div/nav/ul[1]/li[3]/a"));
	    	about.click();
	    	Assert.assertTrue(driver.getCurrentUrl().contains("about"));
	    	
	    	System.out.println("Test case : Successfully redirected into our story page");
	    	
	    }
	    @AfterTest
	    public void tearDown() {
		      if (driver != null) {
		          driver.quit();
		          System.out.println("Test case : Browser closed after our story test iteration");
		      }
		  }

}
