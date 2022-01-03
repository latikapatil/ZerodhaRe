package TestPkage;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POJO.LaunchBrowser;
import POM.LoginPage;
import Utilities.ReadExcel;
import Utilities.ScreenShot;


public class ValidateLogin extends LaunchBrowser{
	 
	 WebDriver driver;
	
	 int row,col;
	static Logger log = LogManager.getLogger(ValidateLogin.class);
			 
	 /*@BeforeMethod
	 public void launchBrowser() {
		 
		  BasicConfigurator.configure();  
		 driver = ValidateLogin.browser();
		log.info("Browser Launch Successfully");
	 }
	 */


	@Test (priority = 1)
	public  void validLogintest() throws IOException, InterruptedException {
	BasicConfigurator.configure();  
	 driver = ValidateLogin.browser();
	log.info("Browser Launch Successfully");
	
	LoginPage LP = new LoginPage(driver);
	Assert.assertEquals(LP.checkLoginHeader(),"Login to Kite"); 
	LP.enterUsername(ReadExcel.readExcel(1, 0));
	LP.enterPassword(ReadExcel.readExcel(1, 1));
	Assert.assertTrue(LP.CheckLoginEnabled());
	LP.clickLoginButton();
	LP.enterPin(ReadExcel.readExcel(1, 2));
	LP.clickSubmitButton();
	
}


@AfterMethod
public void clickSnap() throws IOException, InterruptedException {
	
ScreenShot.captureScreenshot("LoginPage",driver);
}


}
