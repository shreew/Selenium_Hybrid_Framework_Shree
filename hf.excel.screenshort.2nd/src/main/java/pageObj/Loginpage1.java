package pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Loginpage1 {
	@FindBy(name="username")
	WebElement uname;
	
	@FindBy(name="password")
	WebElement upass;
	
	@FindBy(xpath="//input[@type='submit' or value='login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUpLink;
	
	WebDriver driver;

	 public Loginpage1(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 public String verifyFreecrmProLoginPagetitle()
	 {
		 return driver.getTitle();
	 }
	 
	 public boolean verifyCrmProLogo()
	 {
		return driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/a/img")).isDisplayed();
	 }  
	 public void verifyloginintofreecrm(String username,String userpass)
	 {
	uname.sendKeys(username);
	upass.sendKeys(userpass);
	loginBtn.click();
}

	
	 public Signup1 navigateToCreateAccountPage()
	 {
		 try {
				Thread.sleep(5000);
				
				signUpLink.click();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return new Signup1(driver);
	}
	 public void verifyLogoutCrmPro()
	 {
		 driver.switchTo().frame("mainpanel");
			
			driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[2]/td[1]/div/table/tbody/tr/td[4]/a")).click();
		
			driver.switchTo().defaultContent();
		}
	 }


