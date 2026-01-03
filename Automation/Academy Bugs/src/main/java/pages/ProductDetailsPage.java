package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Social icons
    private By facebookIcon  = By.xpath("//img[@alt='Facebook']");
    private By twitterIcon   = By.xpath("//img[@alt='X']");
    private By pinterestIcon = By.xpath("//img[@alt='Pinterest']");
    private By linkedInIcon  = By.xpath("//img[@alt='LinkedIn']");
    private By emailIcon     = By.xpath("//img[@alt='Email']");
    private By myspaceIcon   = By.xpath("//img[@alt='MySpace']");
    // Page elements
    private By currencyDropdwon = By.xpath("//*[@id=\"ec_currency_conversion\"]");
    private By productSearch = By.xpath("//*[@id=\"secondary\"]/div[1]/form/input[1]");
    private By searchButton = By.xpath("//*[@id=\"secondary\"]/div[1]");
    private By incrementPlusButton=By.xpath("//*[@id=\"post-1675\"]/div/section/div[1]/div[3]/form/div[9]/div[1]/input[3]");
    private By decrementPlusButton=By.xpath("//*[@id=\"post-1675\"]/div/section/div[1]/div[3]/form/div[9]/div[1]/input[1]");
    private By addToCartButton=By.xpath("//*[@id=\"post-1675\"]/div/section/div[1]/div[3]/form/div[9]/div[2]/input");
    private By dnkLink=By.cssSelector("a[href='https://academybugs.com/stored/extra/dnk/']");
    private By allItemLink=By.xpath("//*[@id=\"menu3\"]");
    private By accessoriesLink = By.xpath("//*[@id=\"menu2\"]");
    private By handBagLink=By.xpath("//a[@id='submenu1']");
    private By braceletLink=By.xpath("//a[@id='submenu2']");
    private By fashionTypeLink = By.xpath("//*[@id=\"menu4\"]");
    private By womenWearLink = By.xpath("//*[@id=\"menu5\"]");
    private By signUpLink = By.xpath("//*[@id=\"login-from-side-menu\"]/div[5]/a");
    private By signInLink = By.xpath("//*[@id=\"login-from-side-menu\"]/div[6]/button");
    private By filterByPriceLink = By.xpath("//*[@id=\"secondary\"]/div[6]/div/a");
    private By productDetailsLink = By.xpath("//a[@class='ec_product_title_link']");
    private By cartCountData =By.xpath("//*[@id=\"ec_quantity_5_1\"]");
    // Leave a reply
    private By commentField = By.xpath("//*[@id=\"comment\"]");
    private By nameField = By.xpath("//*[@id=\"author\"]");
    private By emailField = By.xpath("//*[@id=\"email\"]");
    private By websiteField = By.xpath("//*[@id=\"url\"]");
    private By postCommentButton =By.xpath("//*[@id=\"url\"]");
    private By cartValue=By.xpath("//*[@id=\"ec_final_price_5_1\"]");
    private By productValue=By.xpath("//*[@id=\"ec_cartitem_price_2136917\"]");
    private By countValue = By.xpath("//*[@id=\"ec_quantity_2136917\"]");
    private By invalidCoupon=By.xpath("//*[@id=\"ec_coupon_code\"]");
    private By invalidGiftCard=By.xpath("//*[@id=\"ec_gift_card\"]");
    

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public String clickFacebookIcon() {
        return clickSocialIcon(facebookIcon);
    }

    public String clickTwitterIcon() {
        return clickSocialIcon(twitterIcon);
    }

    public String clickPinterestIcon() {
        return clickSocialIcon(pinterestIcon);
    }

    public String clickLinkedInIcon() {
        return clickSocialIcon(linkedInIcon);
    }

    public String clickMySpaceIcon() {
        driver.navigate().to("https://academybugs.com/store/dnk-yellow-shoes/");
        driver.findElement(myspaceIcon).click();
        return driver.getTitle();
    }

    public String clickEmailIcon() {
    	 driver.navigate().to("https://academybugs.com/store/dnk-yellow-shoes/");
        driver.findElement(emailIcon).click();
        return "email_clicked";
    }

    private String clickSocialIcon(By icon) {

    	driver.navigate().to("https://academybugs.com/store/dnk-yellow-shoes/");

        String parentWindow = driver.getWindowHandle();
        int windowsBefore = driver.getWindowHandles().size();

        driver.findElement(icon).click();

        // Wait only if a new tab opens
        wait.until(d -> d.getWindowHandles().size() > windowsBefore);

        // Switch to new tab
        for (String win : driver.getWindowHandles()) {
            if (!win.equals(parentWindow)) {
                driver.switchTo().window(win);
                break;
            }
        }

        String url = driver.getCurrentUrl();

        // Close child tab and return to parent
        driver.close();
        driver.switchTo().window(parentWindow);

        return url;
    }
    
    public void clickProductSearchField() {
    	driver.findElement(productSearch).sendKeys("shoes");
    }
    public void clickSearchButton() {
    	driver.findElement(searchButton).click();
    }
    public void clickIncrementPlusButton() {
    	driver.findElement(incrementPlusButton).click();
    }
    public void clickDecrementPlusButton() {
    	driver.findElement(decrementPlusButton).click();
    }
    public String clickAddToCartButton() {
    	driver.findElement(addToCartButton).click();
    	return driver.getCurrentUrl();
    }
    public String clickAllItemLink() {
    	 wait.until(ExpectedConditions.elementToBeClickable(allItemLink)).click();
    	 return driver.getCurrentUrl();
    }
    public String clickHandBagLink() {
    	 driver.navigate().to("https://academybugs.com/store/dnk-yellow-shoes/");
    	 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    // Expand Accessories
		    WebElement accessories = wait.until(
		        ExpectedConditions.elementToBeClickable(accessoriesLink)
		    );
		    accessories.click();

		    // Click Handbags
		    WebElement handbags = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(handBagLink)
		    );
		    handbags.click();

    	return driver.getCurrentUrl();
    }
    public String clickBraceletLink() {
    	 driver.navigate().to("https://academybugs.com/store/dnk-yellow-shoes/");
    	 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		  WebElement accessories = wait.until(ExpectedConditions.elementToBeClickable(accessoriesLink));
		        accessories.click();

		        // Click Bracelets
		        WebElement bracelets = wait.until(
		            ExpectedConditions.visibilityOfElementLocated(braceletLink)
		        );
		        bracelets.click();

    	return driver.getCurrentUrl();
    }
    public String clickAccessoriesLink() {
    	driver.findElement(accessoriesLink).click();
    	return driver.getCurrentUrl();
    }
    public String clickWomenWearLink() {
    	driver.findElement(womenWearLink).click();
    	return driver.getCurrentUrl();
    }
    public String clickDNKLink() {
    	driver.findElement(dnkLink).click();
    	return driver.getCurrentUrl();
    }
    public String clickSignUpLink() {
    	driver.findElement(signUpLink).click();
    	return driver.getCurrentUrl();
    }
    public String clickSignInLink() {
    	driver.findElement(signInLink).click();
    	return driver.getCurrentUrl();
    }
    public String clickFashionTypeLink() {
    	driver.findElement(fashionTypeLink).click();
    	return driver.getCurrentUrl();
    }
    public String clickFilterByValue() {
    	driver.findElement(filterByPriceLink).click();
    	return driver.getCurrentUrl();
    }
    public String clickProductDetailLink() {
    	driver.findElement(productDetailsLink).click();
    	return driver.getCurrentUrl();
    }
    public void clickCurrencyDropDown() {
    	Select dropdown=new Select(driver.findElement(currencyDropdwon));
    	dropdown.selectByIndex(0);
    }
    public String fillLeaveReplyForm(String comment,String name,String email,String website) {
		WebElement commentInput = wait.until(ExpectedConditions.visibilityOfElementLocated(commentField));
		
		commentInput.clear();
		commentInput.sendKeys(comment);
		
		driver.findElement(nameField).clear();
		driver.findElement(nameField).sendKeys(name);
		
		driver.findElement(emailField).clear();
		driver.findElement(emailField).sendKeys(email);
		
		driver.findElement(websiteField).clear();
		driver.findElement(websiteField).sendKeys(website);
		
		String url=driver.getCurrentUrl();
		return url;
	}
    public void clickSend() {
        driver.findElement(postCommentButton).click();
    }
    public int clickCartCountValue() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(cartCountData));
    	String data= driver.findElement(cartCountData).getText();
    	int count= Integer.parseInt(data);
    	return count;
    }
    public int clickCartValue() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(cartValue));
    	String val=driver.findElement(cartValue).getText();
    	int value = Integer.parseInt(val);
    	return value;
    }
    public String clickProductAmount() {
    	String prod=driver.findElement(productValue).getText();
    	System.out.println("valueeeee"+prod);
    	return prod;
    }
    public String clickCountValue() {
    	WebElement qty = wait.until(
    	        ExpectedConditions.visibilityOfElementLocated(countValue)
    	    );
    	    return qty.getAttribute("value"); // IMPORTANT for input fields
    }
    public void clickInvalidCoupon() {
    	driver.navigate().to("https://academybugs.com/store/dnk-yellow-shoes/");
    	driver.findElement(invalidCoupon).sendKeys("TESTCOUPON");
    }
    public void clickInvalidGiftCard() {
    	driver.navigate().to("https://academybugs.com/store/dnk-yellow-shoes/");
    	driver.findElement(invalidGiftCard).sendKeys("TESTGIFT");
    }
}