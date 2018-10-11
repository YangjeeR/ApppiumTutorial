package newpark;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.chrome.ChromeDriver;



public class carecentre {
	
	

	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Acer\\Desktop\\selenium\\chromedriver\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\Acer\\Desktop\\selenium\\geckodriver\\geckodriver.exe");
		/*SSL set up
		ProfilesIni prof = new ProfilesIni();				
		FirefoxProfile ffProfile= prof.getProfile ("NewProfile");
		ffProfile.setAcceptUntrustedCertificates(true) ;
		ffProfile.setAssumeUntrustedCertificateIssuer(false);
		WebDriver driver = new FirefoxDriver(ffProfile);*/
		
		driver.get("https://www.google.com/gmail/about/#");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='gmail-nav__nav-link gmail-nav__nav-link__sign-in']")).click();
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
		Thread.sleep(5000);
	
		//String value=driver.findElement(By.xpath("//div[@class='dEOOab RxsGPe']")).getText();
		String value=driver.findElement(By.xpath("//div[@class='dEOOab RxsGPe']")).getAttribute("innerHTML");
		String mess="Enter an email or phone number";
		
		Assert.assertEquals(value, mess);
		
		
		Assert.assertTrue(value.contains("Enter an email or phone number"));
		
	     System.out.println("Test Completed");
		driver.quit();
	}

}
