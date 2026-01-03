package products;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import settings.Settings;

public class Products extends Settings {
	@BeforeTest
	@Parameters("browser")
	  public void setupBrowser(String browser) {
		  chooseBrowser(browser);
		  launchBrowser(browser);
		  driver.navigate().to("https://ginandjuice.shop/");
		  WebElement productLink=driver.findElement(By.xpath("//*[@id=\"scanMeHeader\"]/section[2]/div/div/nav/ul[1]/li[1]/a"));
		  productLink.click();
	  }
	
	 @Test (priority=1)
	  public void allcatalog() {
		  WebElement allLink=driver.findElement(By.xpath("//a[text()='All']"));
		  allLink.click();
		  String catalog=driver.getCurrentUrl();
		  Assert.assertTrue(catalog.contains("catalog"), "The our story pages is invalid");	  
		  System.out.println("Test case : Verified all catalog");
	 }
	  @Test (priority=2)
	  public void accessories() {
		  WebElement accessoriesLink=driver.findElement(By.xpath("//a[text()='Accessories']"));
		  accessoriesLink.click();
		  String accessories=driver.getCurrentUrl();
		  Assert.assertTrue(accessories.contains("Accessories"), "The Accessories is invalid");	  
		  System.out.println("Test case : Verified accessories link");
	  }
	  @Test (priority=3)
	  public void accompaniments() {
		  WebElement accompanimentsLink=driver.findElement(By.xpath("//a[text()='Accompaniments']"));
		  accompanimentsLink.click();
		  String accompaniments=driver.getCurrentUrl();
		  Assert.assertTrue(accompaniments.contains("Accompaniments"), "The Accompaniments pages is invalid");	  
		  System.out.println("Test case : Verified accompaniments link");
	  }
	  @Test (priority=4)
	  public void books() {
		  WebElement booksLink=driver.findElement(By.xpath("//a[text()='Books']"));
		  booksLink.click();
		  String books=driver.getCurrentUrl();
		  Assert.assertTrue(books.contains("Books"), "The Accompaniments pages is invalid");	  
		  System.out.println("Test case : Verified books link");
	  }
	  @Test (priority=5)
	  public void gin() {
		  WebElement ginLink=driver.findElement(By.xpath("//a[text()='Gin']"));
		  ginLink.click();
		  String gin=driver.getCurrentUrl();
		  Assert.assertTrue(gin.contains("Gin"), "The Gin page is invalid");	 
		  System.out.println("Test case : Verified gin link");
	  }
	  @Test (priority=6)
	  public void juice() {
		  WebElement juiceLink=driver.findElement(By.xpath("//a[text()='Juice']"));
		  juiceLink.click();
		  String juice=driver.getCurrentUrl();
		  Assert.assertTrue(juice.contains("Juice"), "The Juice page is invalid");	 
		  System.out.println("Test case : Verified juice link");
	  }
	  @Test (priority=7)
	  public void productSearch() throws IOException {
		  // Ensure folder exists
	        File destDir = new File("C:\\Users\\amrit\\eclipse-workspace\\AutomationMiniProject\\screenshots");
	        if (!destDir.exists()) {
	            destDir.mkdirs();
	        }

	        // Take screenshot
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(src, new File(destDir, "screenshot_search"+ ".png"));
	        
	        System.out.println("Test case : Takes subscription page screenshot successfully");
		  driver.navigate().to("https://ginandjuice.shop/catalog");
		  driver.findElement(By.id("searchBar")).sendKeys("fruit");
		  System.out.println("Test case : Sucessfully search the product");
	  }
	  @Test (priority=8)
	  public void viewDetails() {
		  driver.findElement(By.xpath("//div[@theme='ecommerce']//a[1]//span[2]")).click();
		  Assert.assertTrue(driver.getCurrentUrl().contains("/catalog/product?"),"Sucessfully retrieved");
		  System.out.println("Test case : Retrieved view product details");
	  }
	  @Test (priority=9)
	  public void checkStock() {
		  WebElement location = driver.findElement(By.name("storeId"));
		  Select loc = new Select(location);
		  loc.selectByVisibleText("Paris");
		  driver.findElement(By.xpath("//button[normalize-space()='Check stock']")).click();
		  System.out.println("Test case : Check product stock");
	  }
	  @Test (priority=10)
	  public void addToCart() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,160)");
		 WebElement quantity= driver.findElement(By.xpath("//select[@name='quantity']"));
		 Select qty=new Select(quantity);
		 qty.selectByIndex(0);
		 driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();
		 System.out.println("Test case : Add to cart functionality");
	  }
	  @Test(priority = 11)
	  public void viewCartButton() {
	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	      // Re-locate and click the View Cart button once it’s refreshed in the DOM
	      WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(
	          By.xpath("/html/body/div[2]/section/div/section/div[2]/span[5]/a")
	      ));
	      viewCart.click();
	      System.out.println("Test case : Verified view cart button");
	  }
	  @AfterTest
	  public void tearDown() {
	      if (driver != null) {
	          driver.quit();
	          System.out.println("Test case : Browser closed after test iteration");
	      }
	  }
}
