package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportBugsPage {
	 private WebDriver driver;
	 private WebDriverWait wait;

	 private By issueTitle = By.xpath("//select[@name='bug-title-1']");
	 private By issueType = By.xpath("//select[@name='bug-type-1']");
	 private By freequencyField = By.xpath("//*[@id=\"frequency-form-group-1\"]/div/div/label[1]/div/span");
	 private By priorityField = By.xpath("//header[@id='sq-masthead']");
	 private By dragOpenLink = By.xpath("//*[@id=\"bug-1-step-1\"]");
	 private By dragOpenProduct=By.xpath("//*[@id=\"bug-1-sortable-2\"]/li[3]");
	 private By dragImage =By.xpath("//*[@id=\"bug-1-step-4\"]");
	 private By dropField =By.xpath("//*[@id=\"bug-1-sortable-1\"]");
	 private By expectedResult=By.xpath("//*[@id=\"expected-result-form-group-1\"]/div/select");
	 private By actualResult=By.xpath("//*[@id=\"actual-result-form-group-1\"]/div/select");
	 private By errorMessage=By.xpath("//*[@id=\"error-message-form-group-1\"]/div/select");
	 private By screenshotField =By.xpath("//*[@id=\"reportBugImage2\"]");
	 private By screenRecordField=By.xpath("//*[@id=\"reportBugVideo2\"]");
	 private By logField=By.xpath("//*[@id=\"reportBugLog3\"]");
	 private By submitButton=By.xpath("//*[@id=\"submit-bug-report-1\"]/span[2]");
	 
	 
	 public ReportBugsPage(WebDriver driver) {
		 this.driver = driver;
	     this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	 }
	 public void clickIssueTitleLink() {
		 driver.navigate().to("https://academybugs.com/report-bugs/");
		 Select option=new Select(driver.findElement(issueTitle));
		 option.selectByIndex(3);
	 }
	 public void clickIssueTypeField() {
		 Select option= new Select(driver.findElement(issueType));
		 option.selectByIndex(2);
	 }
	 public void clickFreequencyField() {
		 driver.findElement(freequencyField).click();
	 }
	 public void clickPriorityField() {
		 driver.findElement(priorityField).click();
	 }
	 public void clickDragAndDropField() {
		 WebElement sourceDropOpen = driver.findElement(dragOpenLink);
		 WebElement sourceDragOpenProduct=driver.findElement(dragOpenProduct);
		 WebElement sourceDropImage=driver.findElement(dragImage);
		 WebElement targetLink = driver.findElement(dropField);
		 Actions actions = new Actions(driver);
		 actions.dragAndDrop(sourceDropOpen, targetLink).perform();
		 actions.dragAndDrop(sourceDragOpenProduct, targetLink).perform();
		 actions.dragAndDrop(sourceDropImage, targetLink).perform();
	 }
	
	 public void clickExpectedResultField() {
		 Select option= new Select(driver.findElement(expectedResult));
		 option.selectByIndex(3);
	 }
	 public void clickActualResultField() {
		 Select option= new Select(driver.findElement(actualResult));
		 option.selectByIndex(2);
	 }
	 public void clickErrorMessageField() {
		 Select option= new Select(driver.findElement(errorMessage));
		 option.selectByIndex(0);
	 }
	 public void clickScreenshotField() {
		 driver.findElement(screenshotField).click();
	 }
	 public void clickScreenRecordField() {
		 driver.findElement(screenRecordField).click();
	 }
	 public void clickLogField() {
		 driver.findElement(logField).click();
	 }
	 public void clickSubmitButtonField() {
		 driver.findElement(submitButton).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
	 } 
}
