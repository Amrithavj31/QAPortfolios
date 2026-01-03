package login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import settings.Settings;

public class Login extends Settings {
	public WebDriverWait wait;
	 @BeforeMethod
	 @Parameters("browser")
	  public void setupBrowser(String browser) {
		  chooseBrowser(browser);
		  launchBrowser(browser);
		   wait= new WebDriverWait(driver,Duration.ofSeconds(80));
	  }
	  @Test (priority=1)
	  public void openWebSite() {
		  driver.get("https://ginandjuice.shop");
		  String title = driver.getTitle();
		  Assert.assertTrue(title.contains("Gin"), "The page title does not contain 'Gin'. Actual title: " + title);
		  
		  System.out.println("Test case : Open website - Gin and Juice ");
		  System.out.println("Test case : Verify current title");
	  }
	  
	  @DataProvider(name = "loginData")
	  public Object[][] loginData() {
	      return new Object[][]{
	          {"carlos", "hunter2","valid"}, //valid password
	          {"carlos", "wrongpass","invalid"},  // invalid password
	          {"wronguser", "hunter2","invalid"}, // invalid username
	          {"@#as", "098","invalid"}, // invalid username with special sym
	          {"carlos", "","invalid"},//blank password
	          {"", "hunter2","invalid"},// blank username
	          {"", "","invalid"} // both blank
	      };
	  }
	  @Test (priority=2,dataProvider="loginData")
	  public void login (String username, String password, String expectedResult) {
		  driver.get("https://ginandjuice.shop");
	      WebElement profileIcon = wait.until(ExpectedConditions.presenceOfElementLocated(
	              By.xpath("//a[@class='account-icon']//*[name()='svg']")
	      ));

	      Actions actions = new Actions(driver);
	      actions.moveToElement(profileIcon).perform();
	      System.out.println("Test case : Hovered over profile icon");

	      WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(
	              By.cssSelector("body div[id='scanMeHeader'] li li:nth-child(1) a:nth-child(1)")
	      ));
	      loginLink.click();
	      
	      System.out.println("Test case : Clicked on login link");
	      // username field
	      WebElement userNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
	      userNameField.clear();
	      userNameField.sendKeys(username);
	      System.out.println("Test case : Entered username");

	      // check if username empty BEFORE clicking login
	      String usernameValue = userNameField.getAttribute("value");
	      if (usernameValue == null || usernameValue.trim().isEmpty()) {
	          System.out.println("Test case : Username field empty, returning to home");
	          driver.navigate().to("https://ginandjuice.shop/");
	          return;
	      }

	      driver.findElement(By.xpath("//button[text()=' Log in ']")).click();
	      System.out.println("Test case : Clicked the Login button after entering the username");

	      // password field
	      WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
	      passwordField.clear();
	      passwordField.sendKeys(password);
	      System.out.println("Test case : Entered password");

	      driver.findElement(By.xpath("//button[text()=' Log in ']")).click();
	      System.out.println("Test case : Clicked the Login button after entering the password");

	      if (expectedResult.equals("valid")) {
	          wait.until(ExpectedConditions.urlContains("my-account"));
	          Assert.assertTrue(driver.getCurrentUrl().contains("my-account"), "Login failed for valid credentials");
	      } else {
	          wait.until(ExpectedConditions.urlContains("login"));
	          Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Login did not stay on login page for invalid credentials");
	      }
	      System.out.println("Test case : username :" + username +" password :" +password);
	  }
	  @AfterMethod
	  public void tearDown() {
	      if (driver != null) {
	          driver.quit();
	          System.out.println("Test case : Browser closed after login test iteration");
	      }
	  }
	
	

}

