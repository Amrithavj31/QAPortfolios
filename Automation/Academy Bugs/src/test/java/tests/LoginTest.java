package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseTest {
	private LoginPage login;
	 @BeforeMethod
	    public void initPage() {
		 login = new LoginPage(driver);
	    }
	 @Test(priority=1,dataProvider = "loginData")
	 public void verifyLoginForm(String email,String password,String expectedResult,boolean isValid) {
		  	String url=login.fillLoginForm(email, password);
		  	login.clickSend();
	
	        if (isValid) {
	               Assert.assertTrue(url.contains("ec_page=register") ,"User was NOT redirected to Dashboard after valid login");
	               Assert.assertFalse(login.isOnLoginForm(),"Login form should not be visible after successful registration");
	              
	               System.out.println("Test case : Valid data - expecting Dashboard redirection");
	               
	        } else {
	        	 
	             Assert.assertTrue(login.isOnLoginForm(),"User should remain on login page for invalid data");
	             System.out.println("Test case : Invalid data - expecting to stay on login page");
	             String screenshotName =getClass().getSimpleName() + expectedResult;
	             takeScreenshot(screenshotName);    
	        }
	        System.out.println("Test case : Login form completed successfully");
	    }

	    @DataProvider(name = "loginData")
	    public Object[][] loginData() {
	        return new Object[][]{
	                // Invalid
	                {"", "abc@123","invalid", false},
	                {"test@test.com	", "","invalid", false},
	                {"", "","invalid", false},
	                //Valid
	                {"testsample@test.com", "test@123","valid", true},
	        };
	    }
	    @Test(priority=2)
	    public void verifyForgotPasswordRedirection() {
	    	String title = login.clickForgotPasswordLink();
	    	Assert.assertTrue(title.contains("Account"));
	    	System.out.println("Test case : Forgot password completed successfully");
	    }
	    @Test(priority=3,dataProvider="redirectionEmailData")
	    public void verifyRedirectionLink(String email,String expectedResult,boolean isValid) {
	    	String url = login.clickRedirectionMailField(email);
	    	Assert.assertTrue(url.contains("ec_page=forgot_password"));
	    	  if (isValid) {
	               Assert.assertTrue(url.contains("?ec_page=forgot_password") ,"User was NOT redirected to email redirection after forgot password");
	               String screenshotName =getClass().getSimpleName() + expectedResult;
		           takeScreenshot(screenshotName);    
	               System.out.println("Test case : Valid data - expecting successful message redirection");    
	               
	        } else {
	        	 
	             Assert.assertTrue(login.isOnLoginForm(),"User should remain on login page for invalid data");
	             System.out.println("Test case : Invalid data - expecting to stay on login page");
	             String screenshotName =getClass().getSimpleName() + expectedResult;
	             takeScreenshot(screenshotName);    
	        }
	    	System.out.println("Test case : Email redirection field verified successfully");
	    }
	    @DataProvider(name = "redirectionEmailData")
	    public Object[][] redirectionEmailData() {
	        return new Object[][]{
	                // Invalid
	                {"abc@123","invalid", false},
	                {"","invalid", false},
	                {"test","invalid", false},
	                //Valid
	                {"testsample@test.com","valid", true},
	        };
	    }
}
