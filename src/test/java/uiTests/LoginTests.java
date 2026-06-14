package uiTests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ui.BaseTest;
import pages.LoginPage;

public class LoginTests extends BaseTest {
	LoginPage loginPage;

	@Test(dataProvider ="loginData", dataProviderClass = dataproviders.LoginData.class, priority = 1)
	public void validLoginTest(Map<String,String> credentials) {
		loginPage = new LoginPage(driver);
		loginPage.login(credentials);
		Assert.assertTrue(driver.getPageSource().contains("Dashboard"), "User Successfully LoggedIn");
	}

	@Test(dataProvider ="loginData", dataProviderClass = dataproviders.LoginData.class, priority = 2)
	public void invalidPasswordTest(Map<String,String> credentials) {
		loginPage = new LoginPage(driver);
		loginPage.invalidLogin(credentials);
		Assert.assertTrue(driver.getPageSource().contains("These credentials do not match our records."), "Invalid credentials");
	}

	@Test(dataProvider ="loginData", dataProviderClass = dataproviders.LoginData.class, priority = 3)
	public void missingUsernameTest(Map<String,String> credentials) {		loginPage = new LoginPage(driver);
		loginPage.missingUsername(credentials);
		Assert.assertTrue(driver.getPageSource().contains("Sign in"), "UserName is not Entered");
	}

	@Test(priority = 4)
	public void unauthorizedAccessTest() {
		driver.get("http://localhost:8080/dashboard");
		Assert.assertTrue(driver.getPageSource().contains("404 Not Found"), "Unauthorized access ");
	}
}
