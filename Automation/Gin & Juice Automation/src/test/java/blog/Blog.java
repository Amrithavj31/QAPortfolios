package blog;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import settings.Settings;

public class Blog extends Settings {
	 WebDriverWait wait;

	    @BeforeTest
	    @Parameters("browser")
	    public void setupBrowser(String browser) {
	    	 chooseBrowser(browser);
			  launchBrowser(browser);
	        driver.get("https://ginandjuice.shop/");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));    
	    }
	    @Test (priority=1)
	    public void blog() {
	    	WebElement blogLink=driver.findElement(By.xpath("//*[@id=\"scanMeHeader\"]/section[2]/div/div/nav/ul[1]/li[2]/a"));
			  blogLink.click();
			  String blog=driver.getTitle();
			  Assert.assertTrue(blog.contains("Blog"), "Successfully retrieved blog page");	 
			  System.out.println("Test case : Successfully redirected into blog page");
	    }
	    @Test (priority=2)
	    public void viewPost()  {
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	    	WebElement view= driver.findElement(By.xpath("//a[@class='button is-small']"));
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("window.scrollBy(0,100)");
	    	view.click();
	    	driver.navigate().back();
	    	
	    	System.out.println("Test case : View blog post");
	    }
	    @Test (priority=3)
	    public void search() {
	    	WebElement searchBlog=driver.findElement(By.xpath("//input[@placeholder='Search the blog...']"));
	    	searchBlog.clear();
	    	searchBlog.sendKeys("Training Day");
	    	System.out.println("Test case : Searching blog");
	    }
	  
	    @AfterTest
	    public void tearDown() {
		      if (driver != null) {
		          driver.quit();
		          System.out.println("Test case : Browser closed after blog test iteration");
		      }
		  }

}
