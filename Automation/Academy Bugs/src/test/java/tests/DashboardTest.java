package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.DashboardPage;

public class DashboardTest extends BaseTest {
	private DashboardPage dashboard;
	
	 @BeforeMethod
	    public void initPage() {
		 dashboard = new DashboardPage(driver);
	    }
	 @Test(priority=1)
	 public void verifyExampleOfBugLinkRedirection() {
		  int resp = dashboard.exampleOfBugLink();
		  Assert.assertTrue(resp > 0, "Example of bug tab retrieved successfully");
		  System.out.println("Test case : Example of bug navigated successfully!! ");
	 }
	 @Test(priority=2)
	 public void verifyTypeOfBugLinkRedirection() {
		 int resp = dashboard.typeOfBugLink();
		 Assert.assertTrue(resp > 0, "Type of bug tab retrieved successfully");
		 System.out.println("Test case : Type of bug navigated successfully!! ");
	 }
	 @Test(priority=3)
	 public void verifyFindBugLinkRedirection() {
		 int resp = dashboard.findBugLink();
		 Assert.assertTrue(resp > 0, "Find bug tab retrieved successfully");
		 System.out.println("Test case : Find bug navigated successfully!! ");
	 }
	@Test(priority=4)
    public void verifyReportBugLinkRedirection() {
		int resp = dashboard.reportBugLink();
		Assert.assertTrue(resp > 0, "Report bug tab retrieved successfully");
		System.out.println("Test case : Report bug navigated successfully!! ");
    }
	@Test(priority=5)
    public void verifySocialShareLinkRedirection() {
		int resp = dashboard.socialShare();
		Assert.assertTrue(resp > 0, "Social share bug tab retrieved successfully");
		System.out.println("Test case : Social share bug navigated successfully!! ");
    }

	@Test(priority=6)
    public void verifySendButtonLinkRedirection() {
		int resp = dashboard.sendButtonBug();
		Assert.assertTrue(resp > 0, " Send button tab bug retrieved successfully");
		System.out.println("Test case : Send button bug navigated successfully!! ");
    }
	@Test(priority=7)
    public void verifyVideoPlayerLinkRedirection() {
		int resp = dashboard.videoLinkBug();
		Assert.assertTrue(resp > 0, "Video player bug retrieved successfully");
		System.out.println("Test case : Video player bug navigated successfully!! ");
    }
	@Test(priority=8)
    public void verifyArticlesBugLinkRedirection() {
		int resp= dashboard.articlesBug();
		Assert.assertTrue(resp > 0, " Articles bug retrieved successfully");
		System.out.println("Test case : Articles bug navigated successfully!! ");
    }
	@Test(priority=9)
    public void verifySearchButtonLinkRedirection() {
		int resp = dashboard.searchBug();
		Assert.assertTrue(resp > 0, " Search button bug retrieved successfully");
		System.out.println("Test case : Search button bug navigated successfully!! ");
    }
	@Test(priority=10)
    public void verifybookingTableLinkRedirection() {
		int resp = dashboard.bookingBug();
		Assert.assertTrue(resp > 0, "Booking table tab bug retrieved successfully");
		System.out.println("Test case : Booking table bug navigated successfully!! ");
    }
	@Test(priority=11)
    public void verifyHelpLinkRedirection() {
		int resp=dashboard.helpLink();
		Assert.assertTrue(resp > 0, "Help link icon bug retrieved successfully");
		System.out.println("Test case : Help link icon navigated successfully!! ");
    }
	  
}
