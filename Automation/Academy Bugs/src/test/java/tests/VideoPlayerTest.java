package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.VideoPlayerPage;

public class VideoPlayerTest extends BaseTest {
	private VideoPlayerPage video;
	@BeforeMethod
    public void initPage() {
	 	video = new VideoPlayerPage(driver);
    }
	 @Test(priority=1)
	 public void verifyVideoPlayerRedirection() {
		 String url=video.clickVideoPlayerPage();
		 Assert.assertTrue(url.contains("latest-news"));
		 System.out.println("Test case : Video player redirected successfully");
	 }
	 @Test(priority=2)
	 public void verifyPlayPauseButton() {
		 video.clickPlayPauseButton();
		 System.out.println("Test case : Play button check");
	 }
	 @Test(priority=3)
	 public void verifyFullScreenMode() {
		 video.clickFullScreenMode();
		 System.out.println("Test case : Full screen mode retireved successfully");
	 }
	 @Test(priority=4)
	 public void verifyUnMuteButton() {
		 video.clickUnMuteButton();
		 System.out.println("Test case : Uumute mode retrieved successfully");
	 }
	 @Test(priority=5)
	 public void verifyVolumeButton() {
		 video.clickVolumeButton();
		 System.out.println("Test case : Volumebutton retrieved successfully");
	 }
	 
	
}
