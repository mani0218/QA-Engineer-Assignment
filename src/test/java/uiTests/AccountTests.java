package uiTests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.ui.BaseTest;
import pages.AccountPage;
import pages.LoginPage;

public class AccountTests extends BaseTest{
	AccountPage accountPage;
	LoginPage loginPage;
	SoftAssert softAssert=new SoftAssert();

	private static final Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("UserName", "manikandanmk0218@gmail.com");
        credentials.put("Password", "Manikandan@12345678");
    }
	

	@Test(dataProvider = "accountData", dataProviderClass = dataproviders.AccountData.class, priority = 1)
	public void assetAccountCreationTest(Map<String, String> dataset) {
		loginPage= new LoginPage(driver);
		loginPage.login(credentials);
		accountPage = new AccountPage(driver);

		// Perform account creation
		Map<String, String> dataValidation = accountPage.assetAccountCreation(dataset);

		// Extract expected values from dataset
		String expectedAccountCreationMsg="New account \"" + dataset.get("AccountName") + "\" stored!";
		String expectedAccountNameMsg = "This account name is already in use.";
		String expectedAccountNumberMsg ="It looks like this account number is already in use.";

		// Extract actual values from page method
		String actualSuccessMsg = dataValidation.get("SuccessMessage");
		String actualNameExistMsg = dataValidation.get("NameExistAlert");
		String actualNumberExistMsg = dataValidation.get("NumberExistAlert");
		
		// Assertions with actual vs expected message
		softAssert.assertTrue(actualSuccessMsg.contains(expectedAccountCreationMsg),"Account creation not successful");

		if (!"No success message displayed".equals(actualNameExistMsg)) 
		{
			softAssert.assertTrue(
					actualNameExistMsg.contains(expectedAccountNameMsg)
					,"Account name validation failed for: " +dataset.get("AccountName"));
		}
		if (!"No success message displayed".equals(actualNumberExistMsg)) {
			softAssert.assertEquals(actualNumberExistMsg.contains(expectedAccountNumberMsg),"Account number validation failed.");
		}
		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void assetAccountDeletionTest()
	{
		loginPage= new LoginPage(driver);
		loginPage.login(credentials);
		accountPage=new AccountPage(driver);
		String actualAlertMessage=accountPage.assetAccountDeletion();
		String expectedAlertMessage="Successfully deleted asset account";
		Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage), "No account is available for deletion");

	}
}
