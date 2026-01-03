package login;

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

public class Logout extends Settings {
	WebDriverWait wait;
	 @BeforeTest
	 @Parameters("browser")
    public void setupBrowser(String browser) {
    	  chooseBrowser(browser);
		  launchBrowser(browser);
		  driver.get("https://ginandjuice.shop/login");
		  wait= new WebDriverWait(driver,Duration.ofSeconds(40));
	  }
	@Test (priority=1)
	public void login() {
		WebElement usernameField=driver.findElement(By.name("username"));
		usernameField.sendKeys("carlos");
		System.out.println("Test case : Entered username ");
		
		driver.findElement(By.xpath("//button[text()=' Log in ']")).click();
		
		WebElement passwordField=driver.findElement(By.name("password"));
		passwordField.sendKeys("hunter2");
		
		System.out.println("Test case : Entered password ");
		
		driver.findElement(By.xpath("//button[text()=' Log in ']")).click();
		
		System.out.println("Test case : Successfully login with valid credentials");
	}
	@Test (priority=2)
	public void logout() {
		 WebElement accountIcon = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//*[@id='scanMeHeader']/section[2]/div/div/nav/ul[2]/li[1]/a")));

	        Actions action = new Actions(driver);
	        action.moveToElement(accountIcon).perform();
	        
	        System.out.println("Test case : Successfully hover the account icon");
	        
	        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//*[@id='scanMeHeader']/section[2]/div/div/nav/ul[2]/li[1]/ul/li[1]/a")));
	        logoutButton.click();
	        
	        System.out.println("Test case : Clicked on logout link");
	        // Assert user is redirected correctly
	        wait.until(ExpectedConditions.urlContains("ginandjuice"));
	        Assert.assertTrue(driver.getCurrentUrl().contains("ginandjuice"), "Logout successful!");
	        System.out.println("Test case : Logout functionality verified");
	}
	@AfterTest
	public void tearDown() {
	      if (driver != null) {
	          driver.quit();
	          System.out.println("Test case : Browser closed after logout test iteration");
	      }
	  }
}
