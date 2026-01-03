package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.FooterPage;

public class FooterTest extends BaseTest{
	private FooterPage footer;
	@BeforeMethod
    public void initPage() {
	 	footer = new FooterPage(driver);
    }
	 @Test(priority=1)
	 public void verifyTermsAndConditionRedirection() {
		 String url=footer.clickTermsAndConditionLink();
		 Assert.assertTrue(url.contains("terms-and-conditions"));
		 System.out.println("Test case : Terms and condition redirected successfully");
	 }
	 @Test(priority=2)
	 public void verifyPrivacyPolicyRedirection() {
		 String url=footer.clickPrivacyPolicyLink();
		 Assert.assertTrue(url.contains("privacy-policy"));
		 System.out.println("Test case : Privacy policy redirected successfully");
	 }
	 @Test(priority=3)
	 public void verifyIconRedirection() {
		 String url=footer.clickIconLink();
		 Assert.assertTrue(url.contains("https://www.utest.com/"));
		 System.out.println("Test case : Icon redirected successfully");
	 }
	 @Test(priority=4)
	 public void verifyXcomLinkRedirection() {
		 String url=footer.clickXcomIcon();
		 Assert.assertTrue(url.contains("https://x.com/"));
		 System.out.println("Test case : Xcom icon redirected successfully");
	 }
	 @Test(priority=5)
	 public void verifyInstagramLinkRedirection() {
		 String url=footer.clickInstagramIcon();
		 Assert.assertTrue(url.contains("https://www.utest.com/"));
		 System.out.println("Test case : Instagram icon redirected successfully");
	 }
	 @Test(priority=6)
	 public void verifyFacebookLinkRedirection() {
		 String url=footer.clickFacebookIcon();
		 Assert.assertTrue(url.contains("https://www.utest.com/"));
		 System.out.println("Test case : Facebook icon redirected successfully");
	 }
	 @Test(priority=7)
	 public void verifyLinkedInLinkRedirection() {
		 String url=footer.clickLinkedInIcon();
		 Assert.assertTrue(url.contains("https://www.utest.com/"));
		 System.out.println("Test case : LinkedIn icon redirected successfully");
	 }
	 @Test(priority=8)
	 public void verifyRedditLinkRedirection() {
		 String url=footer.clickRedditIcon();
		 Assert.assertTrue(url.contains("https://www.utest.com/"));
		 System.out.println("Test case : Reddit icon redirected successfully");
	 }
}
