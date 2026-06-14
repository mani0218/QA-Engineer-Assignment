package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class LoginPage {
    WebDriver driver;
    WaitUtils waitUtils;

    By usernameField = By.name("email");
    By passwordField = By.id("password");
    By loginButton   = By.xpath("//button[normalize-space()='Sign in']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        waitUtils=new WaitUtils(driver);
    }
    
    public void login(Map<String, String> credentials)
    {
    	driver.findElement(usernameField).sendKeys(credentials.get("UserName"));
    	driver.findElement(passwordField).sendKeys(credentials.get("Password"));
    	driver.findElement(loginButton).click();
    }
    
    public void invalidLogin(Map<String, String> credentials)
    {
    	waitUtils.VisibilityOfElement(usernameField);
    	driver.findElement(usernameField).sendKeys(credentials.get("UserName"));
    	driver.findElement(passwordField).sendKeys(credentials.get("InvalidPassword"));
    	driver.findElement(loginButton).click();
    }
    
    public void missingUsername(Map<String, String> credentials)
    {
    	waitUtils.VisibilityOfElement(usernameField);
    	driver.findElement(usernameField).sendKeys("");
    	driver.findElement(passwordField).sendKeys(credentials.get("Password"));
    	driver.findElement(loginButton).click();
    }

  }
