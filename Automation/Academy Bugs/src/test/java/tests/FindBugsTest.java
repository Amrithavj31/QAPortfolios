package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.FindBugsPage;

public class FindBugsTest extends BaseTest {
	private FindBugsPage bugs;
	 @BeforeMethod
	    public void initPage() {
		 	bugs = new FindBugsPage(driver);
	    }
	 @Test(priority=1)
	 public void verifyDefaultFilterRedirection() {
		 String url = bugs.clickDefaultFilterLink();
		 Assert.assertTrue(url.contains("find-bugs"));
		 System.out.println("Test case : Default filter retrieved successfully");
	 }
	 @Test(priority=2)
	 public void verifyLowerLimitRedirection() {
		 String url=bugs.clickLowerLimitLink();
		 Assert.assertTrue(url.contains("limit"));
		 System.out.println("Test case : Lower limit  retrieved successfully");
	 }
	 @Test(priority=3)
	 public void verifyUpperLimitRedirection() {
		 String url=bugs.clickUpperLimitLink();
		 Assert.assertTrue(url.contains("limit"));
		 System.out.println("Test case : Upper limit filter  retrieved successfully");
	 }
	 @Test(priority=4)
	 public void verifyTitleAZRedirection() {
		 String url=bugs.clickTitleAZFilter();
		 Assert.assertTrue(url.contains("filternum=3"));
		 System.out.println("Test case : Title A-Z filter retrieved successfully");
	 }
	 @Test(priority=5)
	 public void verifyTitleZARedirection() {
		 String url=bugs.clickTitleZAFilter();
		 Assert.assertTrue(url.contains("filternum=4"));
		 System.out.println("Test case : Title Z-A  filter retrieved successfully");
	 }
	 @Test(priority=6)
	 public void verifyNewestRedirection() {
		 String url=bugs.clickNewestFilter();
		 Assert.assertTrue(url.contains("filternum=5"));
		 System.out.println("Test case : Newest filter  retrieved successfully");
	 }
	 @Test(priority=7)
	 public void verifyOldestRedirection() {
		 String url=bugs.clickOldestFilter();
		 Assert.assertTrue(url.contains("filternum=8"));
		 System.out.println("Test case : Oldest filter  retrieved successfully");
	 }
	 @Test(priority=8)
	 public void verifyBestRatingRedirection() {
		 String url=bugs.clickBestRatingFilter();
		 Assert.assertTrue(url.contains("filternum=6"));
		 System.out.println("Test case : Best Rating filter  retrieved successfully");
	 }
	 @Test(priority=9)
	 public void verifyMostReviewdRedirection() {
		 String url=bugs.clickMostViewedFilter();
		 Assert.assertTrue(url.contains("filternum=7"));
		 System.out.println("Test case : Most viewed filter  retrieved successfully");
	 }
	 @Test(priority=10)
	 public void verifyAddToCartRedirection() {
		 String url=bugs.clickAddToCart();
		 Assert.assertTrue(url.contains("Successfully Added to your Shopping Cart"));
		 System.out.println("Test case : Added to cart retrieved successfully");
	 }
	 @Test(priority=11)
	 public void verifyJeansProductRedirection() {
		 String url=bugs.clickJeansPrduct();
		 Assert.assertTrue(url.contains("jeans"));
		 System.out.println("Test case : Jeans product retrieved successfully");
	 }
	 @Test(priority=12)
	 public void verifyShoesProductRedirection() {
		 String url=bugs.clickShoesPrduct();
		 Assert.assertTrue(url.contains("dnk-yellow-shoes"));
		 System.out.println("Test case : Shoes product retrieved successfully");
	 }
	
}
