package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.TypesOfBugsPage;

public class TypeOfBugsTests extends BaseTest{
	private TypesOfBugsPage type;
	@BeforeMethod
    public void initPage() {
	 	type = new TypesOfBugsPage(driver);
    }
	 @Test(priority=1)
	 public void verifyFunctionalLinkRedirection() {
		 type.clickFunctionalLink();
		 System.out.println("Test case : Functional link redirected successfully");
	 }
	@Test(priority=2)
	public void verifyTypeOfBugTabRedirection() {
		 String url = type.clickTypesOfBugs();
	     Assert.assertTrue(url.contains("types"),"Types of Bugs page was not opened");
	     System.out.println("Test case : Pop up handled successfully ");
	}
	@Test(priority=3)
	public void verifyApplyButtonRedirection() {
		String url=type.clickApplyNowButton();
		Assert.assertTrue(url.contains("apply"));
		System.out.println("Test case : Apply button clicked successfully");
		
	}
	@Test(priority=4)
	public void verifyVisualTabRedirection() {
		 String url = type.clickVisualTab();
	     Assert.assertTrue(url.contains("types"),"Visuals page was not opened");
	     System.out.println("Test case : Visual tab retrieved successfully ");
	}
	@Test(priority=5)
	public void verifyContentTabRedirection() {
		 String url = type.clickContentTab();
	     Assert.assertTrue(url.contains("types"),"Content page was not opened");
	     System.out.println("Test case : Content tab retrieved successfully ");
	}
	@Test(priority=6)
	public void verifyPerformanceTabRedirection() {
		 String url = type.clickPerformanceTab();
	     Assert.assertTrue(url.contains("types"),"Performance page was not opened");
	     System.out.println("Test case : Performance tab retrieved successfully ");
	}
	@Test(priority=7)
	public void verifyCrashTabRedirection() {
		 String url = type.clickCrashTab();
	     Assert.assertTrue(url.contains("types"),"Crash page was not opened");
	     System.out.println("Test case : Crash tab retrieved successfully ");
	}
	@Test(priority=8)
	public void verifyReportQuotesRedirection() {
		 type.clickReportQuote();
	     System.out.println("Test case : Report quote retrieved successfully ");
	}
	@Test(priority=9)
	public void verifyHomePageRedirection() {
		 String title =type.clickHomePageTab();
		 System.out.println("title  ="+title);
		 Assert.assertTrue(title.contains("AcademyBugs.com"));
	     System.out.println("Test case : Home page retrieved successfully ");
	}
	@Test(priority=10)
	public void verifyTypeOfBugsRedirection() {
		 String url =type.clickTypeOfBugsTab();
		 Assert.assertTrue(url.contains("Type of bugs"));
	     System.out.println("Test case : Type of bugs retrieved successfully ");
	}
	@Test(priority=11)
	public void verifyFindBugsRedirection() {
		 String title =type.clickFindBugsTab();
		 Assert.assertTrue(title.contains("Find Bugs"));
	     System.out.println("Test case : Find bugs retrieved successfully ");
	}
	@Test(priority=12)
	public void verifyReportBugsRedirection() {
		 String title=type.clickReportBugsTab();
		 Assert.assertTrue(title.contains("Report Bugs"));
	     System.out.println("Test case : Report bugs tab retrieved successfully ");
	}
	
	
}
