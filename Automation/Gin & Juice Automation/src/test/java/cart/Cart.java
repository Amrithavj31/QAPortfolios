package cart;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import login.Login;
import products.Products;
import settings.Settings;

public class Cart extends Settings {
	 Products products;
	    Login login;
	    WebDriverWait wait;

	    @BeforeTest
	    @Parameters("browser")
	    public void setupBrowser(String browser) {
	    	 chooseBrowser(browser);
			  launchBrowser(browser);
	        driver.get("https://ginandjuice.shop/");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        // Initialize Products instance and share same WebDriver
	        products = new Products();
	        products.driver = driver;
	        login=new Login();
	        login.driver=driver;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    }

	    @Test(priority = 1)
	    public void login() {
	    	login.wait = wait;
	       login.login("carlos", "hunter2","valid");
	       System.out.println("Test case : Successfully login to the system");
	    }
	    
	    @Test (priority=2)
	    public void listProducts() {
	    	driver.findElement(By.xpath("//*[@id=\"scanMeHeader\"]/section[2]/div/div/nav/ul[1]/li[1]/a")).click();
	    	System.out.println("Test case: List products");
	    }
	    @Test (priority=3)
	    public void searchProduct() throws IOException {
	    	products.productSearch();
	    	System.out.println("Test case : Search products successfully");
	    }
	    
	    @Test (priority=4)
	    public void viewProduct() {
	    	products.viewDetails();
	    	System.out.println("Test case : Successfully Viewed the product details");
	    }
	    
	    @Test (priority=5)
	    public void stockCheck() {
	    	products.checkStock();
	    	System.out.println("Test case : Successfully check the stock");
	    }
	    @Test (priority=6)
	    public void addToCart() {
	    	products.addToCart();
	    	System.out.println("Test case : Sucessfully added product to the cart");
	    }
	    @Test (priority=7)
	    public void viewCartDetails() {
	    	products.viewCartButton();
	    	System.out.println("Test case : View cart details");
	    }
	    @Test(priority=8)
	    public void validAddCoupon() throws IOException {
	    	  // Ensure folder exists
	        File destDir = new File("C:\\Users\\amrit\\eclipse-workspace\\AutomationMiniProject\\screenshots");
	        if (!destDir.exists()) {
	            destDir.mkdirs();
	        }

	        // Take screenshot
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(src, new File(destDir, "screenshot_cart"+ ".png"));
	        
	        System.out.println("Test case : Takes subscription page screenshot successfully");
	    	driver.findElement(By.xpath("//*[@id=\"coupon-form\"]/input[2]")).sendKeys("9In&JUICE5H0P");
	    	driver.findElement(By.xpath("//*[@id=\"coupon-form\"]/button")).click();
	    	System.out.println("Test case : Added a valid coupon");
	    }
	    @Test (priority=9)
	    public void removeValidCoupon() {
	    	driver.findElement(By.xpath("//*[@id=\"coupon-form\"]/div/button")).click();
	    	System.out.println("Test case : Removed an invalid coupon");
	    }
	    @Test (priority=10)
	    public void invalidCoupon() {
	    	driver.findElement(By.xpath("//*[@id=\"coupon-form\"]/input[2]")).sendKeys("TESSTCOUPON");
	    	System.out.println("Test case : Added an invalid coupon");
	    }
	    @Test (priority=11)
	    public void placeOrder() {
	    	driver.findElement(By.xpath("//button[normalize-space()='Place order']")).click();
	    	System.out.println("Test case : Successfully place order");
	    }
	    @Test (priority=12, dependsOnMethods="validAddCoupon")
	    public void calculateAmount() throws InterruptedException {
	    	// Step 1: Get the original price
	    	WebElement originalPriceElement = driver.findElement(By.xpath("//span[contains(@class, 'item-price')]"));
	    	String originalPriceText = originalPriceElement.getText(); // "$30.50"

	    	// Remove $ and convert to double
	    	originalPriceText = originalPriceText.replace("$", "");
	    	double originalPrice = Double.parseDouble(originalPriceText);

	    	// Step 2: Apply coupon (example)
	    	WebElement couponInput = driver.findElement(By.xpath("//input[@type='text' or @placeholder='Enter coupon']"));
	    	couponInput.sendKeys("9In&JUICE5H0P");

	    	WebElement applyButton = driver.findElement(By.xpath("//button[contains(text(), 'APPLY')]"));
	    	applyButton.click();

	    	// Wait for the total to update
	    	Thread.sleep(2000); // or use WebDriverWait for better handling

	    	// Step 3: Get the discounted total
	    	WebElement totalElement = driver.findElement(By.xpath("//strong[contains(text(), '$')]"));
	    	String totalText = totalElement.getText(); // "$24.40"
	    	totalText = totalText.replace("$", "");
	    	double totalValue = Double.parseDouble(totalText);

	    	// Step 4: Calculate expected discount (20%)
	    	double expectedValue = originalPrice * 0.8;

	    	// Step 5: Format to 2 decimals
	    	String formattedExpected = String.format("%.2f", expectedValue);
	    	String formattedActual = String.format("%.2f", totalValue);

	    	// Step 6: Compare values
	    	if (formattedExpected.equals(formattedActual)) {
	    	    System.out.println("✅ Coupon applied successfully! Expected Total: $" + formattedExpected);
	    	}
	    	else {
	    	    System.out.println("invalid coupon aapplied!!");
	    	}
	    }

	    @AfterTest
	    public void tearDown() {
		      if (driver != null) {
		          driver.quit();
		          System.out.println("Test case : Browser closed after cart test iteration");
		      }
		  }
}
