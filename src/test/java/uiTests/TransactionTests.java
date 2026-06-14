package uiTests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.ui.BaseTest;
import pages.LoginPage;
import pages.TransactionPage;

public class TransactionTests extends BaseTest {
	
	TransactionPage transactionPage;
	LoginPage loginPage;
	SoftAssert softAssert=new SoftAssert();

	private static final Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("UserName", "manikandanmk0218@gmail.com");
        credentials.put("Password", "Manikandan@12345678");
    }
	
	@Test(dataProvider = "transactionData", dataProviderClass = dataproviders.TransactionData.class)
	public void addTransactionTest(Map<String, String> details)
	{
		loginPage= new LoginPage(driver);
		loginPage.login(credentials);
		TransactionPage transactionPage=new TransactionPage(driver);
		String actualSuccessMessage=transactionPage.addTransaction(details);
		String expectedSuccessMessage="Successfully created new transaction \""+details.get("Description")+"\"";
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage), "Transaction Not successful");
	}
	
	@Test
	public void deleteTransactionTest()
	{
		loginPage= new LoginPage(driver);
		loginPage.login(credentials);
		transactionPage=new TransactionPage(driver);
		String actualDeletionMsg=transactionPage.deleteTransaction();
		String expectedDeletionMsg="Successfully deleted transfer";
		if (!"No success message displayed".equals(actualDeletionMsg)) 
		{
		Assert.assertTrue(actualDeletionMsg.contains(expectedDeletionMsg), "deletion not successful");
		}
	}
	
}
