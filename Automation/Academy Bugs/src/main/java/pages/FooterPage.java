package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By termsAndConditionLink = By.xpath("//a[normalize-space()='Terms & Conditions']");
    private By privacyPolicyLink = By.xpath("//a[normalize-space()='Privacy Policy']");
    private By iconLink = By.cssSelector("#sq-top-footer ul li a");
    private By xcomLink=By.xpath("//a[img[@alt='X']]");
    private By instagramLink=By.xpath("//a[@title='Follow on Instagram']");
    private By facebookLink=By.xpath("//img[@alt='Facebook']");
    private By linkedInLink=By.xpath("//img[@alt='LinkedIn']");
    private By redditLink=By.xpath("//img[@alt='Reddit']");

    
//    private By tourOverlay = By.id("TourTipDisabledArea"); // canvas overlay

    public FooterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private void openHomePage() {
        driver.navigate().to("https://academybugs.com/");
    }

    private void clickUsingJS(By locator) {
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(locator));

        // Scroll into view
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);

        // JS click to bypass overlay
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

    public String clickTermsAndConditionLink() {
        openHomePage();
        clickUsingJS(termsAndConditionLink);
        return driver.getCurrentUrl();
    }

    public String clickPrivacyPolicyLink() {
        openHomePage();
        clickUsingJS(privacyPolicyLink);
        return driver.getCurrentUrl();
    }
    public String clickIconLink() {
    	 openHomePage();
    	 clickUsingJS(iconLink);
    	return driver.getCurrentUrl();
    }
    public String clickSocialMediaRedirection(By iconLocator) {
    	driver.navigate().to("https://www.utest.com/terms-and-conditions");

        // 2️⃣ Wait for footer icon
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(iconLocator));

        // 3️⃣ Scroll
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);

        // 4️⃣ Click via JS (overlay-safe)
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);

        String url="";
        // 5️⃣ Switch to new tab
        String parentWindow = driver.getWindowHandle();
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                url=driver.getCurrentUrl();
                break;
            }
        }

		return url;
    }
    public String clickXcomIcon() {
        return clickSocialMediaRedirection(xcomLink);
    }

    public String clickInstagramIcon() {
    	return clickSocialMediaRedirection(instagramLink);
    }
    public String clickFacebookIcon() {
    	return clickSocialMediaRedirection(facebookLink);
    }
    public String clickLinkedInIcon() {
    	return clickSocialMediaRedirection(linkedInLink);
    }
    public String clickRedditIcon() {
    	return clickSocialMediaRedirection(redditLink);
    }
}
