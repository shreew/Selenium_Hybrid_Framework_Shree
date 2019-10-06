package utility1;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Helper1 {

	public static void selectValueFromDD(WebElement ddEle, String ddValue) {
		Select sel = new Select(ddEle);

		sel.selectByVisibleText(ddValue);
	}

	public static String capturescreenshorts(WebDriver driver) {
		
		String sreenshortPath = System.getProperty("user.dir") + "//Screenshot//Freecrm_" + getcurrentDataTime()
		+ ".png";
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(srcFile, new File(sreenshortPath));
			System.out.println("screenshort captured");
		} catch (IOException e) {
			System.out.println("unable to capture sreenshorts" + e.getMessage());
		}
		return sreenshortPath;
	}

	public static String getcurrentDataTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");

		Date currentDate = new Date();

		return customFormat.format(currentDate);

	}
}
