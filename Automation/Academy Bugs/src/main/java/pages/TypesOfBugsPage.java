package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TypesOfBugsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By typeOfBugsLink = By.xpath("//*[@id=\"menu-item-1024\"]/a");
    private By closeButton =By.xpath("//div[@id='popmake-4454']//button[@aria-label='Close']");
    private By tourOverlay = By.id("TourTipDisabledArea");
    private By functionalLink= By.xpath("//*[@id=\"post-1081\"]/div/section/div/a[1]/div/div/p[2]");
    private By opportunitiesLink=By.xpath("//*[@id=\"fn_bug\"]/b");
    private By applyNowButton=By.xpath("//*[@id=\"post-41\"]/div/div/a");
    private By visualTab=By.xpath("//p[contains(text(),'Visual issues affect the layout and cause user int')]");
    private By contentTab=By.xpath("//a[3]//div[1]//div[1]");
    private By performanceTab = By.xpath("//h5[@class='types-of-bugs-tile-heading'][normalize-space()='Performance']");
    private By crashTab=By.xpath("//a[@class='types-of-bugs-tile-div']//h5[@class='types-of-bugs-tile-heading'][normalize-space()='Crash']");
    private By homePageTab= By.xpath("//*[@id=\"post-133\"]/div/div[2]/a[1]/div[1]/img");
	private By typeOfBugsTab= By.xpath("//*[@id=\"post-133\"]/div/div[2]/a[2]/div[1]/img");
	private By findBugsTab= By.xpath("//*[@id=\"post-133\"]/div/div[2]/a[3]/div[1]/img");
	private By reportBugsTab= By.xpath("//*[@id=\"post-133\"]/div/div[2]/a[4]/div[1]/img");

    public TypesOfBugsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public void clickFunctionalLink() {
    	driver.navigate().to("https://academybugs.com/types/#");
    	driver.findElement(functionalLink).click();
    }
    // 🔹 Close popup if present
    private void handlePopupIfPresent() {
        // Close popup if close button appears
		wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(tourOverlay));
    }

    // 🔹 Business action
    public String clickTypesOfBugs() {
        handlePopupIfPresent();
        wait.until(ExpectedConditions.elementToBeClickable(typeOfBugsLink)).click();
        return driver.getCurrentUrl();
    }
    public String clickOpportunitiesWeProvide() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeButton));
        wait.until(ExpectedConditions.elementToBeClickable(opportunitiesLink)).click();
        return driver.getCurrentUrl();
    }
    public String clickApplyNowButton() {
    	driver.navigate().to("https://academybugs.com/opportunities-we-provide/");
        driver.findElement(applyNowButton).click();
        return driver.getCurrentUrl();
    }
    public String clickVisualTab() {
    	driver.navigate().to("https://academybugs.com/types/#");
    	driver.findElement(visualTab).click();
        return driver.getCurrentUrl();
    }
    public String clickContentTab() {
    	driver.navigate().to("https://academybugs.com/types/#");
    	handlePopupIfPresent();
    	driver.findElement(contentTab).click();
        return driver.getCurrentUrl();
    }
    public String clickPerformanceTab() {
    	driver.navigate().to("https://academybugs.com/types/#");
    	handlePopupIfPresent();
    	driver.findElement(performanceTab).click();
        return driver.getCurrentUrl();
    }
    public String clickCrashTab() {
    	driver.navigate().to("https://academybugs.com/types/#");
    	handlePopupIfPresent();
    	driver.findElement(crashTab).click();
        return driver.getCurrentUrl();
    }
    public void clickReportQuote() {
    	driver.navigate().to("https://academybugs.com/request-a-quote/");
    	handlePopupIfPresent();
    	driver.findElement(performanceTab).click();
    	driver.navigate().refresh();
    	waitForPageToLoad(driver);
    }
    public void waitForPageToLoad(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(
            webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")
                .equals("complete")
        );
    }
    public String clickHomePageTab() {
		driver.navigate().to("https://academybugs.com/what-we-offer/");
		driver.findElement(homePageTab).click();
		return driver.getTitle();
	}
	public String clickTypeOfBugsTab() {
		driver.navigate().to("https://academybugs.com/what-we-offer/");
		driver.findElement(typeOfBugsTab).click();
		return driver.getTitle();
	}
	public String clickFindBugsTab() {
		driver.navigate().to("https://academybugs.com/what-we-offer/");
		driver.findElement(findBugsTab).click();
		return driver.getTitle();
	}
	public String clickReportBugsTab() {
		driver.navigate().to("https://academybugs.com/what-we-offer/");
		driver.findElement(reportBugsTab).click();
		return driver.getTitle();
	}
}
