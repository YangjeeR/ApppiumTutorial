package newpark;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class appiumtest1 {

	AppiumDriver<MobileElement> driver;
	String path;
	
	@BeforeMethod
	public void setup() 

	{
		
		System.out.println("Session is creating");
	
     path=System.getProperty("user.dir");
	 DesiredCapabilities cap=new DesiredCapabilities();
	 cap.setCapability("platformName","Android");
	 //cap.setCapability("platformVersion", "7.1.1");
	 cap.setCapability("deviceName","192.168.188.101:5555");
	 cap.setCapability("app",path+"\\app\\ApiDemos.apk");
	 //cap.setCapability("app","C:\\Users\\Acer\\eclipse-workspace\\Appium\\app");
	 try
	 {
	 driver= new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
	 
	 }
	 catch(MalformedURLException e)
	 {
		 e.printStackTrace();
	 }
	 driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
	 System.out.println("Session is created");
	}
	
	@Test
	public  void validateText()
	{
		
		driver.findElementByAccessibilityId("Accessibility").click();
		String text=driver.findElementByAccessibilityId("Accessibility Node Provider").getText();
		
		
		if (text.equalsIgnoreCase("Accessibility Node Provider"))
		{
			System.out.println("Passed");
			
		}
		else
		{
			System.out.println("Failed");
		}
		}
	
	@AfterMethod
	public void TearDown()
	{
		
	driver.quit();
	}
	
	
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		appiumtest1 obj=new appiumtest1();
		obj.setup();
		obj.validateText();
		obj.TearDown();
	}
*/
}
