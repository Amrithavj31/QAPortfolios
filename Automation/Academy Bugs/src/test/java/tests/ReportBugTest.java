package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ReportBugsPage;

public class ReportBugTest extends BaseTest{
	private ReportBugsPage report;
	 @BeforeMethod
	 public void initPage() {
	 	report = new ReportBugsPage(driver);
	 }
	 @Test(priority=1)
	 public void verifyIssueTitleRedirection() {
		 report.clickIssueTitleLink();
		 System.out.println("Test case : Issue title selected successfully");
	 }
	 @Test(priority=2)
	 public void verifyIssueTypeRedirection() {
		 report.clickIssueTypeField();
		 System.out.println("Test case : Issue type selected successfully");
	 }
	 @Test(priority=3)
	 public void verifyFreequencyRedirection() {
		 report.clickFreequencyField();
		 System.out.println("Test case : Freequency field selected successfully");
	 }
	 @Test(priority=4)
	 public void verifyPriorityRedirection() {
		 report.clickPriorityField();
		 System.out.println("Test case : Priority field selected successfully");
	 }
	 @Test(priority=5)
	 public void verifyDropDownRedirection() {
		 report.clickDragAndDropField();
		 System.out.println("Test case : Drag and Drop performed successfully");
	 }
	 @Test(priority=6)
	 public void verifyExpectedResultRedirection() {
		 report.clickExpectedResultField();
		 System.out.println("Test case : Expected Result retrieved successfully");
	 }
	 @Test(priority=7)
	 public void verifyActualResultRedirection() {
		 report.clickActualResultField();
		 System.out.println("Test case : Actual Result retrieved successfully");
	 }
	 @Test(priority=8)
	 public void verifyErrorMessageRedirection() {
		 report.clickErrorMessageField();
		 System.out.println("Test case : Error message retrieved successfully");
	 }
	 @Test(priority=9)
	 public void verifyScreenshotRedirection() {
		 report.clickScreenshotField();
		 System.out.println("Test case : Screenshot  retrieved successfully");
	 }
	 @Test(priority=10)
	 public void verifyScreenshotRecordRedirection() {
		 report.clickScreenRecordField();
		 System.out.println("Test case : Screen record retrieved successfully");
	 }
	 @Test(priority=11)
	 public void verifyLogRecordRedirection() {
		 report.clickLogField();
		 System.out.println("Test case : Log  retrieved successfully");
	 }
}
