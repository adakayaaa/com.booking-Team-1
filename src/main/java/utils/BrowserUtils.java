package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class BrowserUtils {

	/**
	 * Captures a screenshot of the current browser window and saves it with a unique
	 * name.
	 * @param name the name of the screenshot
	 * @return the file path of the captured screenshot
	 */
	public static String getScreenshot(String name) {
		// Adding date and time to the screenshot name to make it unique
		name = new Date().toString().replace(" ", "_").replace(":", "-") + "_" + name;
		String path = System.getProperty("user.dir") + "\\test-output\\screenshots\\" + name + ".png";
		TakesScreenshot screenshot = (TakesScreenshot) DriverManager.getWebDriver();
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		try {
			FileUtils.copyFile(source, destination);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public static void scrollDownWithPageDown() {
		Actions actions = new Actions(DriverManager.getWebDriver());
		actions.keyDown(Keys.PAGE_DOWN).release().build().perform();
		wait(1);
	}

	public static void scrollUpWithPageUp() {
		Actions actions = new Actions(DriverManager.getWebDriver());
		actions.keyDown(Keys.PAGE_UP).release().build().perform();
		wait(1);
	}

	public static void wait(double timeout) {
		try {
			Thread.sleep((long) timeout * 1000);
		}
		catch (InterruptedException e) {
			throw new RuntimeException();
		}
	}

	public static void wait(int timeout) {
		try {
			Thread.sleep(timeout * 1000L);
		}
		catch (InterruptedException e) {
			throw new RuntimeException();
		}
	}

	public static String getTitle() {
		return DriverManager.getWebDriver().getTitle();
	}

}
