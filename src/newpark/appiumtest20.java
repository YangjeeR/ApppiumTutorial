package newpark;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class appiumtest20 {
	
	AppiumDriver<MobileElement>driver;
	String path;
	public void setup() throws MalformedURLException
	{
		path=System.getProperty("user.dir");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("PlatformName", "Android");
		cap.setCapability("deviceName", "192.168.188.101:5555");
		cap.setCapability("app",path+"\\app\\ApiDemos.apk");
		cap.setCapability("appPackage", "com.android.mms");
		cap.setCapability("appActivity", "com.android.mms.ui.ConversationList");
		 
		driver= new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS);
		
	}
	
	public void test() throws InterruptedException, IOException
	{
		try{
			TouchAction TC=new TouchAction(driver);
		MobileElement el=driver.findElementById("com.android.mms:id/subject");
		TC.longPress(el).perform().release();
		Thread.sleep(2000);
		
		boolean flag=driver.findElementById("com.android.mms:id/addcontact").isDisplayed();
		if(flag)
		{
			System.out.println("Passed");
		}
		else 
		{
			System.out.println("failed");
			getscreenshot(driver);
		}
		}
		catch(Exception e)
		{
			getscreenshot(driver);
		}
	
	}
	
	public void getscreenshot(AppiumDriver<MobileElement> d) throws IOException
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd MM yyyy hh mm ss");
		Date date=new Date();
		String Filename=sdf.format(date);
		File ds= d.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ds, new File(System.getProperty("user.dir")+"//Screenshot//"+Filename+".png"));
		System.out.println("Screenshot has been captured");
	}
	public static void main(String[] args) throws InterruptedException, IOException {
		
		// TODO Auto-generated method stub
		
		appiumtest20 obj=new appiumtest20();
		obj.setup();
		obj.test();

	}

}
