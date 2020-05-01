package Basic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class TestLeafApp {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException{
		
		DesiredCapabilities dc =new DesiredCapabilities();
		//dc.setCapability("app", "C:\\Users\\dell\\Desktop\\Appium\\leaforg.apk");
		dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
		dc.setCapability("deviceName", "OnePlus 7T");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator1");
		dc.setCapability("noReset", true);
		
		AndroidDriver<WebElement> ad =new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		
		ad.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		ad.findElementByXPath("(//android.widget.EditText)[1]").sendKeys("sakthivel@testleaf.com");
		
		Thread.sleep(2000);
		
		ad.findElementByXPath("(//android.widget.EditText)[2]").sendKeys("Leaf@123");
		
		Thread.sleep(2000);
		
		ad.findElementByXPath("//android.widget.Button").click();
		
		Set<String> allCh = ad.getContextHandles();
		
		System.out.println(allCh);
	}

}
