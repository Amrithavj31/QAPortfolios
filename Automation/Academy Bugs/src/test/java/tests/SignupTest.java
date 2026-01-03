package tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.SignupPage;

public class SignupTest extends BaseTest{
	private SignupPage signup;
	 @BeforeMethod
	    public void initPage() {
		 	signup = new SignupPage(driver);
	    }
	 @Test(priority=1)
	 public void verifySearchTabRedirection() {
		 int resp = signup.clickSearchTabLink();
		 Assert.assertTrue(resp > 0, "Search error tab retrieved successfully");
		 System.out.println("Test case : Search error tab retrieved successfully");
	 }
	 @Test(priority=2)
	 public void verifyPopUpLinkRedirection() {
		 int resp = signup.clickPopUpLink();
		 Assert.assertTrue(resp > 0, "Pop up  link retrieved successfully");
		 System.out.println("Test case : Pop up  link retrieved successfully");
	 }
	
	  @Test(priority = 3, dataProvider = "signUpData")
	    public void verifySignUpForm(String firstName,String lastName,String email,String retypeEmail,String password,String retypePassword,String expectedResult,boolean isValid) {
		  	String url=signup.fillSignUpForm(firstName, lastName, email, retypeEmail,password,retypePassword);
		  	signup.clickSend();
	
	        if (isValid) {
	               Assert.assertTrue(url.contains("ec_page=register") ,"User was NOT redirected to Dashboard after valid signup");
	               Assert.assertFalse(signup.isOnSignUpForm(),"Signup form should not be visible after successful registration");
	               int resp = signup.clickSignOutLink();
	               Assert.assertTrue(resp > 0, "Signout page retrieved successfully");
	               System.out.println("Test case : Valid data - expecting Dashboard redirection");
	               
	        } else {
	        	 
	             Assert.assertTrue(signup.isOnSignUpForm(),"User should remain on Signup page for invalid data");
	             System.out.println("Test case : Invalid data - expecting to stay on Signup page");
	             String screenshotName =getClass().getSimpleName() +expectedResult;
	             takeScreenshot(screenshotName);    
	        }
	        System.out.println("Test case : Sign up form completed successfully");
	    }

	    @DataProvider(name = "signUpData")
	    public Object[][] contactFormData() {
	    	String base="test";
	    	String email=getRandomString(2);
	        return new Object[][]{
	                // INVALID
	                {"", "", "", "", "","", "invalid", false},
	                {"", "User", "test@test.com", "test@test.com", "pass@123","pass@123", "invalid", false},
	                {"Test", "", "test@test.com", "test@test.com", "pass@123","pass@123", "invalid", false},
	                {"Test", "User", "", "", "pass@123","pass@123", "invalid", false},
	                {"Test", "User", "test@test.com", "", "pass@123","pass@123", "invalid", false},
	                {"Test", "User", "test@test.com", "test@test.com", "","pass@123", "invalid", false},
	                {"Test", "User", "test@test.com", "test@test.com", "pass@123","", "invalid", false},
	                {"Test", "User", "test@test.com", "test123@test.com", "pass@123","pass@123", "invalid", false},
	                {"Test", "User", "test@test.com", "test@test.com", "pass@123","pass123@123", "invalid", false},
	                {"", "#^$^%$", "test@test.com", "test@test.com", "pass@123","pass@123", "invalid", false},
	                {"1234", "User", "test@test.com", "test@test.com", "pass@123","pass@123", "invalid", false},
	                {"Test", "User", "test", "test", "pass@123","pass@123", "invalid", false},
	                // VALID
	                {"Bob", "User", email, email, "bob.bob@123","bob.bob@123", "valid", true}     
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
}
