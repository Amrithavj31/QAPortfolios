package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {
	private WebDriver driver;
	private WebDriverWait wait;
    private By searchTabLink=By.xpath("//*[@id=\"sq-content\"]/div/section/div/a[5]/div/div");
    private By productDetailsLink= By.cssSelector("a[class='example-5-search-bug'] b");
    private By popupLink= By.xpath("//*[@id=\"popmake-4434\"]");
    private By signUpLink= By.xpath("//*[@id=\"login-from-side-menu\"]/div[5]/a");
    private By firstNameField= By.xpath("//input[@id=\'ec_account_register_first_name\']");
    private By lastNameField= By.xpath("//*[@id=\"ec_account_register_last_name\"]");
    private By emailField= By.xpath("//*[@id=\"ec_account_register_email\"]");
    private By retypeEmailField= By.xpath("//*[@id=\"ec_account_register_retype_email\"]");
    private By passwordField= By.xpath("//*[@id=\"ec_account_register_password\"]");
    private By retypePasswordField= By.xpath("//*[@id=\"ec_account_register_password_retype\"]");
    private By sendButtonField=By.xpath("//*[@id=\"ec_account_register\"]/div[1]/form/div[8]/input[2]");
    private By checkboxField=By.xpath("//*[@id=\"ec_account_register_is_subscriber\"]");
    private By signOutField=By.xpath("//*[@id=\"ec_account_dashboard\"]/div[3]/div[6]/a");
    
      public SignupPage(WebDriver driver) {
		  this.driver = driver;
		  this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  }
	  
	  public int clickSearchTabLink() {
	   	 	List<WebElement> elements = driver.findElements(searchTabLink);
	        return elements.size();
	  }
	  public String clickProductDetailsLink() {
	   	 	driver.findElement(productDetailsLink).click();
	        return driver.getCurrentUrl();
	  }
	  public int clickPopUpLink() {
	   	 	List<WebElement> elements = driver.findElements(popupLink);
	        return elements.size();
	  }
	  public String fillSignUpForm(String firstName,String lastName,String email,String retypeEmail,String password,String retypePassword) {
			driver.navigate().to("https://academybugs.com/account/?ec_page=register");
			WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
			
			firstNameInput.clear();
			firstNameInput.sendKeys(firstName);
			
			driver.findElement(lastNameField).clear();
			driver.findElement(lastNameField).sendKeys(lastName);
			
			driver.findElement(emailField).clear();
			driver.findElement(emailField).sendKeys(email);
			
			driver.findElement(retypeEmailField).clear();
			driver.findElement(retypeEmailField).sendKeys(retypeEmail);
			
			driver.findElement(passwordField).clear();
			driver.findElement(passwordField).sendKeys(password);
			
			driver.findElement(retypePasswordField).clear();
			driver.findElement(retypePasswordField).sendKeys(retypePassword);
			
			String url=driver.getCurrentUrl();
			return url;
		}
	    public void clickSend() {
	        driver.findElement(sendButtonField).click();
	    }
	    public void clickCheckbox() {
	        driver.findElement(checkboxField).click();
	    }
	    public boolean isOnSignUpForm() {
	        return driver.getCurrentUrl().contains("ec_page=register");
	    }
	    public int clickSignOutLink() {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(signOutField));
	   	 	List<WebElement> elements = driver.findElements(signOutField);
	        return elements.size();
	    }
}
