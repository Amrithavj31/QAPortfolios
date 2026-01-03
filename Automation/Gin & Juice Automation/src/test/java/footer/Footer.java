package footer;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import homepage.Homepage;
import settings.Settings;

public class Footer extends Settings {
    WebDriverWait wait;
    Homepage links;
  
    @BeforeTest
    @Parameters("browser")
    public void setupBrowser(String browser) {
    	chooseBrowser(browser);
		launchBrowser(browser);
        driver.get("https://ginandjuice.shop/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        links = new Homepage();
        links.driver = driver;
    }

    @Test
    public void subscription() throws IOException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        System.out.println("Test case : Scroll down to the footer ");
       
        WebElement subscription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='subscribe']/input[1]")));
        subscription.sendKeys("test@test.com");
        System.out.println("Test case : Entered subscription Email");
       
        WebElement subscribeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='subscribe']/button")));
        subscribeButton.click();
        System.out.println("Test case : Click on submit subscription button");
        // Ensure folder exists
        File destDir = new File("C:\\Users\\amrit\\eclipse-workspace\\AutomationMiniProject\\screenshots");
        if (!destDir.exists()) {
            destDir.mkdirs();
        }

        // Take screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(destDir, "screenshot_subscription"+ ".png"));
        
        System.out.println("Test case : Takes subscription page screenshot successfully");
       
    }
    @Test
    public void footerLinks() {
    	links.productLink();
    	System.out.println("Test case : Product footer link verified");
    	links.blogLink();
    	System.out.println("Test case : Blog footer link verified");
    	links.ourStoryLink();
    	System.out.println("Test case : Our story footer link verified");
    }

    @AfterTest
    public void shutDown() {
    	 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"coupon-dialog\"]/div/div/div")));
        exit();
    }
}
