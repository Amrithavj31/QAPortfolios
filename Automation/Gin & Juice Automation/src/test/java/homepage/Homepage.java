package homepage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import settings.Settings;

public class Homepage extends Settings{
	WebDriverWait wait;
	  @BeforeTest
	  @Parameters("browser")
	  public void setupBrowser(String browser) {
		  chooseBrowser(browser);
		  launchBrowser(browser);
		  wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		 
	  }
	  
	  @Test (priority=1)
	  public void openWebSite() {
		  driver.get("https://ginandjuice.shop/");
		  String title = driver.getTitle();
		  Assert.assertTrue(title.contains("Gin"), "The page title does not contain 'Gin'. Actual title: " + title);
		  System.out.println("Test case : Successfully open website");
	  }
	  
	  @Test (priority=2)
	  public void productLink() {
		  WebElement productLink=driver.findElement(By.xpath("//*[@id=\"scanMeHeader\"]/section[2]/div/div/nav/ul[1]/li[1]/a"));
		  productLink.click();
		  String product=driver.getTitle();
		  Assert.assertTrue(product.contains("Products"), "The product pages is incorrect");	  
		  System.out.println("Test case : Redirected into product link");
	  }
	
	  @Test (priority=3)
	  public void blogLink() {
		  WebElement blogLink=driver.findElement(By.xpath("//*[@id=\"scanMeHeader\"]/section[2]/div/div/nav/ul[1]/li[2]/a"));
		  blogLink.click();
		  String blog=driver.getTitle();
		  Assert.assertTrue(blog.contains("Blog"), "The blog pages is incorrect");	 
		  System.out.println("Test case : Redirected into blog link");
	  }
	  
	  @Test (priority=4)
	  public void ourStoryLink() {
		  WebElement storyLink=driver.findElement(By.xpath("//*[@id=\"scanMeHeader\"]/section[2]/div/div/nav/ul[1]/li[3]/a"));
		  storyLink.click();
		  String story=driver.getTitle();
		  Assert.assertTrue(story.contains("Our story"), "The our story pages is invalid");	  
		  driver.navigate().to("https://ginandjuice.shop/");
		  System.out.println("Test case : Redirected into our story link");
	  }
	  @Test (priority=5)
	  public void loginLink() {
		  driver.navigate().to("https://ginandjuice.shop/");
	      
	      // Wait for account icon
	      WebElement myAccountIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(
	              By.xpath("//*[@id='scanMeHeader']/section[2]/div/div/nav/ul[2]/li[1]/a")
	      ));
	      // Hover on the icon to reveal dropdown
	      Actions actions = new Actions(driver);
	      actions.moveToElement(myAccountIcon).perform();
	      
	      
	      // Wait for "Login" option to appear after hover
		  WebElement accountLink = driver.findElement(By.xpath("//*[@id='scanMeHeader']/section[2]/div/div/nav/ul[2]/li[1]/a"));
		  accountLink.click();
		  
		  Assert.assertTrue(driver.getCurrentUrl().contains("login"));
		  System.out.println("Test case : Redirected into account link");
	  }
	  @Test (priority=6)
	  public void myAccount() {
	      driver.navigate().to("https://ginandjuice.shop/");
	      
	      // Wait for account icon
	      WebElement myAccountIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(
	              By.xpath("//*[@id='scanMeHeader']/section[2]/div/div/nav/ul[2]/li[1]/a")
	      ));

	      // Hover on the icon to reveal dropdown
	      Actions actions = new Actions(driver);
	      actions.moveToElement(myAccountIcon).perform();

	      // Wait for "My Account" option to appear after hover
	      WebElement myAccount = wait.until(ExpectedConditions.elementToBeClickable(
	              By.xpath("//a[normalize-space()='My account']")
	      ));

	      myAccount.click();
	      Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	      
	      System.out.println("Test case : Hovered over account icon and navigated to 'My Account'");
	  }

	  @Test (priority=7)
	  public void cart() {
		  driver.navigate().to("https://ginandjuice.shop/");
		  WebElement cartLink =  driver.findElement(By.xpath("//*[@id=\"scanMeHeader\"]/section[2]/div/div/nav/ul[2]/li[2]/a"));
		  cartLink.click();
		  Assert.assertTrue(driver.getTitle().contains("Cart"));
		  System.out.println("Test case : Redirected into cart link");
	  }
	  @Test (priority=8)
	  public void viewAllProducts() {
		  driver.findElement(By.xpath("//a[@href='/catalog']")).click();
		  Assert.assertTrue(driver.getTitle().contains("Products"));
		  System.out.println("Test case : Sucessfully retrieved products page");
	  }
	  
	  @AfterTest
	  public void tearDown() {
	      if (driver != null) {
	          driver.quit();
	          System.out.println("Test case : Browser closed after homepage test iteration");
	      }
	  }
}
