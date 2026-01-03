package tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;

public class ProductDetailsTest extends BaseTest {
	private ProductDetailsPage product;
	 @BeforeMethod
	    public void initPage() {
		 	product = new ProductDetailsPage(driver);
	    }
	 @Test(priority=1)
	 public void verifyFacebookIconRedirection() {
		 String title = product.clickFacebookIcon();
		 Assert.assertTrue(title.contains("https://www.facebook.com/"));
		 System.out.println("Test case : Facebook page retrieved successfully");
	 }
	 @Test(priority=2)
	 public void verifyTwitterIconRedirection() {
		 String title = product.clickTwitterIcon();
		 Assert.assertTrue(title.contains("https://twitter.cointent/"));
		 System.out.println("Test case : Twitter page retrieved successfully");
	 }
	
	 @Test(priority=3)
	 public void verifyPinterestIconRedirection() {
		 String title = product.clickPinterestIcon();
		 Assert.assertTrue(title.contains("https://www.pinterest.com/"));
		 System.out.println("Test case : Pinterest page retrieved successfully");
	 }
	 @Test(priority=4)
	 public void verifyLinkedInIconRedirection() {
		 String url = product.clickLinkedInIcon();
		 Assert.assertTrue(url.contains("https://www.linkedin.com/"));
		 System.out.println("Test case : LinkedIn page retrieved successfully");
	 }
	 @Test(priority=5)
	 public void verifyMySpaceIconRedirection() {
		 String title = product.clickMySpaceIcon();
		 Assert.assertTrue(title.contains("MySpace"));
		 System.out.println("Test case : My space page retrieved successfully");
	 }
	 @Test(priority=6)
	 public void verifyEmailIconRedirection() {
		 String title = product.clickEmailIcon();
		 Assert.assertTrue(title.contains("email"));
		 System.out.println("Test case : Email page retrieved successfully");
	 }
	 @Test(priority=7)
	 public void verifyProductSearchRedirection() {
		 product.clickProductSearchField();
		 System.out.println("Test case : Product search page retrieved successfully");
	 }
	 @Test(priority=8)
	 public void verifySearchButtonRedirection() {
		 product.clickSearchButton();
		 System.out.println("Test case : Product search button works properly");
	 }
	 @Test(priority=9)
	 public void verifyAllItemsLinkRedirection() {
		 String url=product.clickAllItemLink();
		 Assert.assertTrue(url.contains("all-items"));
		 System.out.println("Test case : All items page retrieved successfully");
	 }
	 @Test(priority=10)
	 public void verifyFashionTypeRedirection() {
		 String url = product.clickWomenWearLink();
		 Assert.assertTrue(url.contains("womens-pants"));
		 System.out.println("Test case : Women's page retrieved successfully");
	 }
	 @Test(priority=11)
	 public void verifyHandBagRedirection() {
		 
		 String url = product.clickHandBagLink();
		 Assert.assertTrue(url.contains("handbags-purses"));
		 System.out.println("Test case : Handbag page retrieved successfully");
	 }
	 @Test(priority=12)
	 public void verifyBraceletsRedirection() {
		 
		 String url=product.clickBraceletLink();
		 Assert.assertTrue(url.contains("bracelets"));
		 System.out.println("Test case : Bracelets page retrieved successfully");
	 }
	 @Test(priority=13)
	 public void verifyWomensPageRedirection() {
		 product.clickWomenWearLink();
		 System.out.println("Test case : Women page  retrieved successfully");
	 }
	 @Test(priority=14)
	 public void verifyDNKRedirection() {
		 product.clickDNKLink();
		 System.out.println("Test case : DNK manufacturer link retrieved successfully");
	 }
	 @Test(priority=15)
	 public void verifySignUpLinkRedirection() {
		 product.clickSignUpLink();
		 System.out.println("Test case : Sign up link retrieved successfully");
	 }
	 @Test(priority=16)
	 public void verifySignInLinkRedirection() {
		 product.clickSignInLink();
		 System.out.println("Test case : Sign In page retrieved successfully");
	 }
	 @Test(priority=17)
	 public void verifyProductDetailsPageRedirection() {
		 product.clickProductDetailLink();
		 System.out.println("Test case : Product detail link page retrieved successfully");
	 }
	 @Test(priority=18)
	 public void verifyCurrencyDropdownRedirection() {
		 product.clickCurrencyDropDown();
		 System.out.println("Test case : Currency dropdown retrieved successfully");
	 }
	 @Test(priority = 19, dataProvider = "commentData")
	    public void verifySignUpForm(String comment,String name,String email,String website,String expectedResult,boolean isValid) {
		  	String url=product.fillLeaveReplyForm(comment, name, email, website);
		  	product.clickSend();
	        if (isValid) {
	               Assert.assertTrue(url.contains("comment") ,"User was NOT redirected to comment after valid leaving reply");
	               System.out.println("Test case : Valid data - expecting Dashboard redirection");
	               
	        } else {
	             System.out.println("Test case : Invalid data - expecting to stay on product page");
	             String screenshotName =getClass().getSimpleName() +expectedResult;
	             takeScreenshot(screenshotName);    
	        }
	        System.out.println("Test case : Sign up form completed successfully");
	    }

	    @DataProvider(name = "commentData")
	    public Object[][] commentFormData() {
	    	String base="test";
	    	String email=getRandomString(2);
	        return new Object[][]{
	                // INVALID
	                {"", "", "", "", "invalid", false},
	                {"", "Test",email,"https://academybugs.com/store", "invalid", false},
	                {"Test", "", email, "https://academybugs.com/store","invalid", false},
	                {"Test", "User", "", "https://academybugs.com/store","invalid", false},
	                {"Test", "User", email, "","invalid", false},
	                {"Test", "User", "test@test.com", "https://academybugs.com/store","valid", true},
	        };
	    }
	    private static String getRandomString(int length) {
	        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
	        String base="test";
	        Random random = new Random();
	        StringBuilder sb = new StringBuilder();

	        for (int i = 0; i < length; i++) {
	            sb.append(chars.charAt(random.nextInt(chars.length())));
	        }
	        String email= base + sb.toString() + "@gmail.com";
	        return email;
	    }
	    @Test(priority=20)
	    public void verifyInvalidCouponCode() {
	    	product.clickInvalidCoupon();
	    	System.out.println("Test case : Invalid coupon code added sucessfully");
	    }
	    @Test(priority=21)
	    public void verifyInvalidGiftCard() {
	    	product.clickInvalidGiftCard();
	    	System.out.println("Test case : Invalid gift card added sucessfully");
	    }
}
