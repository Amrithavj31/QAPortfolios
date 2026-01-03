package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VideoPlayerPage {
	 private WebDriver driver;
	 private WebDriverWait wait;
	 private By videoElement = By.tagName("video");
	 private By playerContainer = By.cssSelector("div.plyr");
	  
	 public VideoPlayerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	 }

    public String clickVideoPlayerPage() {
    	driver.navigate().to("https://academybugs.com/latest-news/");
        return driver.getCurrentUrl();
    }
    public void clickPlayPauseButton() {
    	WebElement video = driver.findElement(videoElement);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].play();", video);
    	
    }
    public void clickUnMuteButton() {
    	WebElement video = driver.findElement(videoElement);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].muted = false;", video);
    }
    public void clickFullScreenMode() {
    	WebElement video = driver.findElement(videoElement);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].requestFullscreen();", video);
    }
    public void clickVolumeButton() {
    	WebElement video = driver.findElement(videoElement);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].volume = 0.5;", video); // 50%
    }
}
