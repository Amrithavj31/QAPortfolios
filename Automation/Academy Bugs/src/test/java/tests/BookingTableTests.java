package tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.BookingTablePage;

public class BookingTableTests extends BaseTest {
	private BookingTablePage table;
	 @BeforeMethod
	    public void initPage() {
		 	table = new BookingTablePage(driver);
	    }
	 @Test(priority=1)
	 public void verifyBookingTableTabRedirection() {
		 String url=table.clickBookingTableTab();
		 Assert.assertTrue(url.contains("academybugs.com"));
		 System.out.println("Test case : Booking table tab redirection");
	 }
	 @Test(priority=2)
	 public void verifyDateField() {
		 table.clickDateField();
		 System.out.println("Test case : Date field verified successfully");
	 }
	 
	 @Test(priority=3)
	 public void verifyTimeField() {
		 table.clickTimeField();
		 System.out.println("Test case : Time field verified successfully");
	 }
	 @Test(priority=4)
	 public void verifyPartyField() {
		 table.clickPartyField();
		 System.out.println("Test case : Party field verified successfully");
	 }
	 @Test(priority = 5, dataProvider = "bookingTableData")
	    public void verifyBookingTableForm(String name,String email,String phone,String message,String expectedResult,boolean isValid) {
		  	String url=table.fillBookingTableForm(name, email, phone,message);
		  	table.clickSend();
	
	        if (isValid) {
	               Assert.assertTrue(url.contains("my-bookings") ,"User was NOT redirected to Dashboard after valid signup");
	               System.out.println("Test case : Valid data - expecting Dashboard redirection");
	               
	        } else {
	             System.out.println("Test case : Invalid data - expecting to stay on booking table  page");
	             String screenshotName =getClass().getSimpleName() +expectedResult;
	             takeScreenshot(screenshotName);    
	        }
	        System.out.println("Test case : Booking table form completed successfully");
	    }

	    @DataProvider(name = "bookingTableData")
	    public Object[][] bookingTableData() {
	    	String base="test";
	    	String email=getRandomString(2);
	        return new Object[][]{
	                // INVALID
	                {"", "", "", "",  "invalid", false},
	                {"", email, "1234567890", "test message",  "invalid", false},
	                {"Test", "", "1234567890", "test message",  "invalid", false},
	                {"Test", email, "", "test message",  "invalid", false},
	                {"Test", email, "1234567890", "",  "invalid", false},
	                {"Test",email, "1234567890", "test message",  "valid", true},
	               
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
