package TestPkage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.BuyShare;
import POM.LoginPage;
import Utilities.ReadExcel;
import Utilities.ScreenShot;

public class ValidateBuyShare {

	WebDriver driver;
	
	@BeforeMethod
	public void login() throws IOException {
		driver = ValidateLogin.browser();
		LoginPage login = new LoginPage(driver);
		login.enterUsername(ReadExcel.readExcel(1, 0));
		login.enterPassword(ReadExcel.readExcel(1, 1));
		login.clickLoginButton();
		login.enterPin(ReadExcel.readExcel(1, 2));
		login.clickSubmitButton();
		
	}
	
	@Test (priority = 1,enabled=true)
	public void validateBuyShareIntraday() {
		
		BuyShare buy = new BuyShare(driver);
		buy.enterSearchCo();
		buy.clickOnCo(driver);
		buy.clickBuy();
		//buy.clickRegular();
		buy.clickIntraday(driver);
		buy.clickMarket(driver);
		buy.clickLimitO(driver);
		buy.clearPrice();
		buy.enterPrice();
		buy.buyShare();
		//buy.clickCancel();
	}
	@Test(priority = 2,enabled=true)
	public void validateBuyShareAmo() {
		BuyShare buy = new BuyShare(driver);
		buy.enterSearchCo();
		buy.clickOnCo(driver);
		buy.clickBuy();
		buy.clickAmo(driver);
		buy.clickIntraday(driver);
		buy.clickMarket(driver);
		buy.clickLimitO(driver);
		buy.clearPrice();
		buy.enterPrice();
		buy.buyShare();
		
	}
	
	@AfterMethod
	public void clickSnap() throws IOException, InterruptedException {
		ScreenShot.captureScreenshot("Buyshare", driver);
	}
}
