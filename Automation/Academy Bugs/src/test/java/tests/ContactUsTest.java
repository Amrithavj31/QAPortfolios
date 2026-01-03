package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.ContactUsPage;

public class ContactUsTest extends BaseTest{
	private ContactUsPage contact;
	 @BeforeMethod
	    public void initPage() {
		 	contact = new ContactUsPage(driver);
	    }
	 @Test(priority=1)
	 public void verifyContactUsTabRedirection() {
		 int resp = contact.clickContactTabLink();
		 Assert.assertTrue(resp > 0, "Contact us send button tab retrieved successfully");
		 System.out.println("Test case : Contact us send button retrieved successfully");
	 }
	 
	  @Test(priority = 2, dataProvider = "contactFormData")
	    public void verifyContactForm(String firstName,String lastName,String email,String subject,String message,String expectedResult,boolean isValid) {
	        contact.fillContactForm(firstName, lastName, email, subject, message);
	        contact.clickSend();
	
	        // Boolean-based assertion
	        if (isValid) {
	            Assert.assertFalse(contact.isOnContactForm(),"Form should submit for valid data");
	        } else {
	            Assert.assertTrue(contact.isOnContactForm(),"Form should not submit for invalid data");
	            String screenshotName =getClass().getSimpleName() + "_InvalidContactUsForm_" + expectedResult;
	            takeScreenshot(screenshotName); 
	        }
	
	        System.out.println("Test case : Contact form tested successfully");
	    }

	    @DataProvider(name = "contactFormData")
	    public Object[][] contactFormData() {
	        return new Object[][]{
	                // VALID
	                {"Test", "User", "test@test.com", "Query", "Test message", "valid", true},

	                // INVALID
	                {"", "User", "test@test.com", "Query", "Test message", "invalid", false},
	                {"1234", "User", "test@test.com", "Query", "Test message", "invalid", false},
	                {"Test", "", "test@test.com", "Query", "Test message", "invalid", false},
	                {"Test", "User", "invalidEmail", "Query", "Test message", "invalid", false},
	                {"Test", "User", "test@test.com", "", "Test message", "invalid", false},
	                {"Test", "User", "test@test.com", "Query", "", "invalid", false},
	                {"", "", "", "", "", "", false},
	                {"Test", "User", "", "Query", "Test message", "invalid", false},
	                {"Test", "User", "test@test.com", "", "Test message", "invalid", false},
	                {"Test", "User", "test@test.com", "Query", "", "invalid", false},
	        };
	    }


}
