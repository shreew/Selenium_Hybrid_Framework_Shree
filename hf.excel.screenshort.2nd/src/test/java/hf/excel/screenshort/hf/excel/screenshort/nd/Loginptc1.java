package hf.excel.screenshort.hf.excel.screenshort.nd;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObj.Loginpage1;
import testdata1.Basecls1;

public class Loginptc1 extends Basecls1 {
	public Loginpage1 login;

	@BeforeMethod
	public void setUp() {
		String browserName = configDataProvider.getConfigProperties("chBrowser");
		String url = configDataProvider.getConfigProperties("url");

		browserStartUp(browserName, url);
		login = new Loginpage1(driver);
	}
	/*
	 * @Test(priority=1) public void verifyfreecrmprologinpageTitletest() { String
	 * expectedTitle="CRMPRO - CRM software for customer relationship management, sales, and support."
	 * ; String actualTitle=login.verifyFreecrmProLoginPagetitle();
	 * Assert.assertEquals(actualTitle, expectedTitle); }
	 * 
	 * 
	 * @Test(priority =2 ) public void verifyCRMPROLogoTest() {
	 * //Assert.assertTrue(login.
	 * verifyCrmProLogo("CRMOPRO logo on login page is not displayed"));
	 * Assert.assertTrue(login.verifyCrmProLogo()); }
	 * 
	 * @Test(priority = 3) public void navigateToCreateAnAccountPageTest() {
	 * login.navigateToCreateAccountPage(); }
	 */

	@Test(priority = 4, dataProvider = "getExcelData")
	public void verifyloginToCrmProTest(String uname, String upass) {

		logger = extent.createTest("LoginToFreeCrm Test");

		logger.info("Before going to login into an appication...");
		
		login.verifyloginintofreecrm(uname, upass);
		
		//driver.switchTo().frame("mainpanel");
		
		if (driver.getTitle().contains("..")) {
			
			Assert.assertTrue(true);
			
			logger.pass("login successfully..");
			
			//login.verifyLogoutCrmPro();
		} else {
			System.out.println("not able to login into app");
			
			logger.fail("login in failed...");
			Assert.assertTrue(false);
			
		}
	}

	@DataProvider
	public Object[][] getExcelData() {
		Object[][] data = excelDataProvider.getExcelData("Sheet1");
		return data;

	}

}
