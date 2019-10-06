package hf.excel.screenshort.hf.excel.screenshort.nd;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObj.Loginpage1;
import pageObj.Signup1;
import testdata1.Basecls1;

public class Signptc1 extends Basecls1{
	Loginpage1 login;
	Signup1 signup;
	
	
	@BeforeMethod
	public void setUp() {
		// brrName(prop.getProperty("browser"), prop.getProperty("url"));
	
		login = new Loginpage1(driver);
		signup = login.navigateToCreateAccountPage();
	}
	
	@Test(priority=1)
	public void createAnFreeCrmProAccountTest()
	{
		signup.createAnFreeCrmProAccount("Shridevi", "Wakpate", "shreepoorvi@gmail.com", "shreepoorvi@gmail.com",
				"pallavi_678", "shree$257", "shree$257", "VisionIt2","7790775996","Hello Am coming", "VisionIt Tech");
		
	}
	
}
