package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	WebDriverWait w;
	public WaitUtils(WebDriver driver)
	{
		
		w=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public WebElement VisibilityOfElement(By locator) 
	{
		return w.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public WebElement ElementToBeClickable(By locator) 
	{
		return w.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
}
