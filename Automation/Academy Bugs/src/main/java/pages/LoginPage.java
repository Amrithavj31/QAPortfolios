package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;
    private By emailField=By.xpath("//*[@id=\"ec_account_login_email\"]");
    private By passwordField=By.xpath("//*[@id=\"ec_account_login_password\"]");
    private By forgotField=By.cssSelector("#sq-masthead");
    private By signInField=By.xpath("//*[@id=\"ec_account_register\"]/div[2]/form/div[5]/input");
    private By emailredirectionLinkField=By.cssSelector("#ec_account_forgot_password_email");
    private By forgotSubmitButton=By.xpath("//header[@id='sq-masthead']");
//    private By logoutField =By.xpath("");
    
    public LoginPage(WebDriver driver) {
		 this.driver = driver;
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public String fillLoginForm(String email,String password) {
		driver.navigate().to("https://academybugs.com/account/?ec_page=register");
		WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
		
		emailInput.clear();
		emailInput.sendKeys(email);
		
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(password);
		
		String url=driver.getCurrentUrl();
		return url;
	}
    public void clickSend() {
        driver.findElement(signInField).click();
    }
    public String clickForgotPasswordLink() {
    	driver.navigate().to("https://academybugs.com/account/?ec_page=login");
        driver.findElement(forgotField).click();
        System.out.println("current title     ="+driver.getCurrentUrl());
        return driver.getTitle();
    }
    public boolean isOnLoginForm() {
        return driver.getCurrentUrl().contains("ec_page=register");
    }
    public String clickRedirectionMailField(String email) {
    	driver.navigate().to("https://academybugs.com/account/?ec_page=forgot_password");
    	System.out.println("im hereeeeee");
    	driver.findElement(emailredirectionLinkField).sendKeys(email);
		return driver.getCurrentUrl();
    }
    public void clickForgotSubmitButton() {
    	driver.findElement(forgotSubmitButton);
    }

}
