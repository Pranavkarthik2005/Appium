package Basic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class TestLeafApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException{
		
		String expectedAlertMessage = "Your changes are submitted for review and approval.";
		Boolean flag = false; 
		
		DesiredCapabilities dc =new DesiredCapabilities();
		//dc.setCapability("app", "C:\\Users\\dell\\Desktop\\Appium\\leaforg.apk");
		dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
		dc.setCapability("deviceName", "OnePlus 7T");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator1");
		dc.setCapability("unicodeKeyboard", true);
		dc.setCapability("resetKeyboard", true);
		dc.setCapability("noReset", true);
		
		AndroidDriver<WebElement> ad =new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		
		ad.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		ad.findElementByXPath("(//android.widget.EditText)[1]").sendKeys("rajkumar@testleaf.com");
		
		Thread.sleep(2000);
		
		ad.findElementByXPath("(//android.widget.EditText)[2]").sendKeys("Leaf@123");
		
		Thread.sleep(2000);
		
		ad.findElementByXPath("//android.widget.Button").click();
		
		Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait(ad, 30);
		
		WebElement settingsElement=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TabWidget/android.view.View[@text='settings Settings']")));
		
		settingsElement.click();
		
		Thread.sleep(3000);
		
		ad.findElementByXPath("//android.view.View[@text='Participant Details']").click();
		
		String participationId = Integer.toString(new Random().nextInt(9000000)+1000000);
		
		String driverLicenseId = "A"+Integer.toString(new Random().nextInt(9000000)+1000000);
		
		ad.findElementByXPath("(//android.widget.EditText)[3]").clear();
		
		Thread.sleep(2000);
		
		ad.findElementByXPath("(//android.widget.EditText)[3]").sendKeys(participationId);
		
		Thread.sleep(2000);
		
		ad.findElementByXPath("(//android.widget.EditText)[6]").clear();
		
		Thread.sleep(2000);
		
		ad.findElementByXPath("(//android.widget.EditText)[6]").sendKeys(driverLicenseId);
		
		Thread.sleep(2000);
		
		ad.findElementByXPath("(//android.widget.Button)[4]").click();
		
		WebElement alertInfoMsg = ad.findElementByXPath("(//android.app.Dialog//android.view.View)[3]");
		
		if(alertInfoMsg.isDisplayed()){
			
			String actualMessage= alertInfoMsg.getText();
			
			if(expectedAlertMessage.equals(actualMessage)){
				
				flag = true; 
				
				System.out.println("Expected Value");
				
			}
			
			Assert.assertTrue(flag);
			
		}
		
		
		
	}

}
