package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SocialSharePage {
	private WebDriver driver;
    private By socialTabField=By.xpath("//*[@id=\"sq-content\"]/div/section/div/a[1]/div/div/p[2]");
    private By popUpField= By.xpath("//*[@id=\"popmake-4434\"]");
    private By articlesListLink=By.xpath("//*[@id='low_s']/b");
    private By closeButtonField = By.xpath("//*[@id=\"popmake-4434\"]/button");
    private By readmoreLink = By.xpath("//div[@class='entry-readmore']/a[normalize-space()='Read More']");
    private By brochureLink = By.xpath("//article[@id='post-86']//a[text()='Brochure']");
    private By visitingCardLink = By.xpath("//*[@id=\"post-86\"]/div/footer/span[1]/a[2]");
    private By websiteLink =  By.xpath("//*[@id=\"post-86\"]/div/footer/span[1]/a[3]");
    private By blogLink = By.xpath("//*[@id=\"post-86\"]/div/footer/span[2]/a[1]");
    private By holidayLink = By.xpath("//*[@id=\"post-86\"]/div/footer/span[2]/a[2]");
    private By houseLink = By.xpath("//*[@id=\"post-86\"]/div/footer/span[2]/a[3]");
    private By maintenanceLink = By.xpath("//*[@id=\"post-86\"]/div/footer/span[2]/a[4]");
    private By travelLink = By.xpath("//*[@id=\"post-86\"]/div/footer/span[2]/a[5]");
    private By facebookLink = By.xpath("//*[@id=\"square-share-a1\"]/i");
    private By twitterLink = By.xpath("//*[@id=\"square-share-a2\"]/i");
    private By pinterestLink = By.xpath("//*[@id=\"square-share-a3\"]/i");
    private By emailLink = By.xpath("//*[@id=\"square-share-a4\"]/i");
    private By dateLink = By.xpath("//*[@id=\"post-86\"]/div/header/div/span[1]/a/time");
    private By graphicsLink = By.xpath("//*[@id=\"post-84\"]/div/footer/span/a[2]");
    private By pensionLink = By.xpath("//*[@id=\"post-59\"]/figure/a/img");
    private By logoLink =By.xpath("//*[@id=\"post-78\"]/div/footer/span/a[3]");
    
    public SocialSharePage(WebDriver driver) {
        this.driver = driver;
    }
    public String clickSocialTab() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement socialTab = wait.until(
                ExpectedConditions.visibilityOfElementLocated(socialTabField)
        );

        // Scroll into view
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", socialTab);

        // JS click to bypass overlay
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", socialTab);

        return driver.getCurrentUrl();
    }

    public String clickArticlesListLinkAndGetURL() {
    	driver.findElement(socialTabField);
        driver.findElement(articlesListLink).click();
        return driver.getTitle();
    }
    
    public boolean isPopupDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(popUpField)
        ).isDisplayed();
    }
    public String clickReadMoreLink() {
    	driver.findElement(readmoreLink).click();
    	return driver.getTitle();
    }
    
    public String clickBrochureLink() {
    	driver.findElement(brochureLink).click();
    	return driver.getTitle();
    }
    
    public String clickVisitingCardLink() {
    	driver.findElement(visitingCardLink).click();
    	return driver.getTitle();
    }
    
    public String clickWebsiteLink() {
    	driver.findElement(websiteLink).click();
    	return driver.getTitle();
    }
    
    public String clickBlogLink() {
    	driver.findElement(blogLink).click();
    	return driver.getTitle();
    }
    
    public String clickHolidayLink() {
    	driver.findElement(holidayLink).click();
    	return driver.getTitle();
    }
    
    public String clickHouseLink() {
    	driver.findElement(houseLink).click();
    	return driver.getTitle();
    }
    
    public String clickMaintenanceLink() {
    	driver.findElement(maintenanceLink).click();
    	return driver.getTitle();
    }
    
    public String clickTravelLink() {
    	driver.findElement(travelLink).click();
    	return driver.getTitle();
    }
    
    public String clickFacebookLink() {
    	driver.findElement(facebookLink).click();
    	return driver.getTitle();
    }
    
    public String clickTwitterLink() {
    	driver.findElement(twitterLink).click();
    	return driver.getTitle();
    }
    
    public String clickPinterestLink() {
    	driver.findElement(pinterestLink).click();
    	return driver.getTitle();
    }
    
    public String clickEmailLink() {
    	driver.findElement(emailLink).click();
    	return driver.getTitle();
    }
    
    public String clickDateLink() {
    	driver.findElement(dateLink).click();
    	return driver.getCurrentUrl();
    }
    
    public String clickGraphicsLink() {
    	driver.findElement(graphicsLink).click();
    	return driver.getTitle();
    }
    
    public String clickLogoLink() {
    	driver.findElement(logoLink).click();
    	return driver.getTitle();
    }
    
    public String clickPensionLink() {
    	driver.findElement(pensionLink).click();
    	return driver.getTitle();
    }
    public String clickCloseButtonLink() {
    	driver.findElement(closeButtonField).click();
    	return driver.getCurrentUrl();
    }
 
}
