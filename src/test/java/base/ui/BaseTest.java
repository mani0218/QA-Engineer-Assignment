package base.ui;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.LoginPage;

public class BaseTest {
    protected WebDriver driver; 
    protected LoginPage loginPage;
    
    @BeforeMethod
    public void setUp() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/login"); // login page
        
        
        
    }

	
	
	/*
	 * @AfterMethod public void tearDown() { if(driver != null) { driver.quit();
	 * 
	 * }
	 * 
	 * }
	 */
	 
	 
}
