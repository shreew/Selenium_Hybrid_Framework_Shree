package pageObj;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utility1.Helper1;

public class Signup1 {
	@FindBy(id = "payment_plan_id")
	WebElement selectDD;

	@FindBy(name = "first_name")
	WebElement firstname;

	@FindBy(name = "surname")
	WebElement lastname;

	@FindBy(name= "email")
	WebElement eid;

	@FindBy(name = "email_confirm")
	WebElement confirmEid;

	@FindBy(name = "username")
	WebElement uname;

	@FindBy(name= "password")
	WebElement upass;

	@FindBy(name= "passwordconfirm")
	WebElement confirmPassword;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkBox;

	@FindBy(name= "submitButton")
	WebElement submitBtn;
	
	 WebDriver driver;
	 
		public Signup1(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}

		public void SignUp(WebDriver driver) {
			this.driver = driver;		
			PageFactory.initElements(driver, this);
		}

		public void createAnFreeCrmProAccount(String fname, String lname, String email, String confirmEmail,
				String unameField, String upassField, String confirmUserpass, String company, String phone, String desText, String addText) {
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			Helper1.selectValueFromDD(selectDD, "Free Edition");

			firstname.sendKeys(fname);

			lastname.sendKeys(lname);

			eid.sendKeys(email);

			confirmEid.sendKeys(confirmEmail);

			uname.sendKeys(unameField);

			upass.sendKeys(upassField);

			confirmPassword.sendKeys(confirmUserpass);

			checkBox.click();
			
			submitBtn.click();
		}
}
