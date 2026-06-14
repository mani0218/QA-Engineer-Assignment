package pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.WaitUtils;

public class AccountPage {

	WebDriver driver;
	WaitUtils waitUtils;

	private By accountMenu=By.xpath("//span[text()='Accounts']");
	private By assetAccountMenu=By.xpath("//span[text()='Asset accounts']");
	private By createAssetAccount=By.xpath("//a[contains(normalize-space(), 'Create an asset account')]");
	private By accountName=By.name("name");
	private By currencyID=By.id("ffInput_currency_id");
	private By accountNumber=By.id("ffInput_account_number");
	private By openingBalance=By.id("ffInput_opening_balance");
	private By openingBalanceDate=By.id("ffInput_opening_balance_date");
	private By attachment=By.id("ffInput_attachments");
	private By storeAssetAccount=By.xpath("//button[normalize-space()='Store new asset account']");
	private By successAlert=By.xpath("(//div[contains(normalize-space(), 'New account')])[3]");
	private By createAssetMany=By.xpath("(//a[contains(normalize-space(), 'Create a new asset account')])[2]");
	private By actionButton=By.xpath("//button[normalize-space()='Actions']");
	private By accountDeletion=By.xpath("//a[normalize-space()='Delete']");
	private By deleteConfirmation=By.cssSelector("input[value='Delete permanently']");
	private By deleteSuccessMessage=By.xpath("(//div[contains(normalize-space(), 'Successfully deleted asset account')])[3]");
	private By accountNameExist=By.xpath("//p[text()='This account name is already in use.']");
	private By accountNumberExist=By.xpath("//p[text()='It looks like this account number is already in use.']");

	private String fileAttachment=System.getProperty("user.dir")+"/src/test/resources/testData/QA_TakeHome_Finance.pdf";


	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		waitUtils=new WaitUtils(driver);
	}
	

	public Map<String, String>  assetAccountCreation(Map<String, String> dataset)
	{
		Map<String, String> dataValidaton=new HashMap<>();
		driver.findElement(accountMenu).click();
		driver.findElement(assetAccountMenu).click();
		try {
			if(driver.findElement(createAssetMany).isDisplayed())
			{
				driver.findElement(createAssetMany).click();
			}
			else {
				driver.findElement(createAssetAccount).click();
			}
		}
		catch (NoSuchElementException e) {
			driver.findElement(createAssetAccount).click();
		}

		driver.findElement(accountName).sendKeys(dataset.get("AccountName"));
		Select currencySelection=new Select(driver.findElement(currencyID));
		currencySelection.selectByVisibleText(dataset.get("Currency"));
		driver.findElement(accountNumber).sendKeys(dataset.get("AccountNumber"));
		driver.findElement(openingBalance).sendKeys(dataset.get("OpeningBalance"));
		driver.findElement(openingBalanceDate).sendKeys(dataset.get("OpeningBalanceDate"));
		driver.findElement(attachment).sendKeys(fileAttachment);
		driver.findElement(storeAssetAccount).submit();
		List<WebElement> successAlertMsg = driver.findElements(successAlert);

		if (!successAlertMsg.isEmpty() && successAlertMsg.get(0).isDisplayed()) {
			String addSuccessMessage = successAlertMsg.get(0).getText().trim();
			dataValidaton.put("SuccessMessage", addSuccessMessage);
		} else {
			dataValidaton.put("SuccessMessage","No success message displayed");
		}

		List<WebElement> accountExistAlert = driver.findElements(accountNameExist);

		if (!accountExistAlert.isEmpty() && accountExistAlert.get(0).isDisplayed()) {
			String nameAlert=accountExistAlert.get(0).getText().trim();
			dataValidaton.put("NameExistAlert", nameAlert);
			dataValidaton.put("AccountName", dataset.get("AccountName"));
		} else {
			dataValidaton.put("NameExistAlert", "No success message displayed");
		}
		List<WebElement> accountNumberExistAlert = driver.findElements(accountNumberExist);

		if (!accountNumberExistAlert.isEmpty() && accountNumberExistAlert.get(0).isDisplayed()) {
			String numberAlert=accountNumberExistAlert.get(0).getText().trim();
			dataValidaton.put("NumberExistAlert", numberAlert);
			dataValidaton.put("AccountNumber", dataset.get("AccountName"));
		} else {
			dataValidaton.put("NumberExistAlert", "No success message displayed");
		}

		return dataValidaton;
	}
	public String assetAccountDeletion()
	{
		String deleteSuccessMessageAlert="No Account is available";
		driver.findElement(accountMenu).click();
		driver.findElement(assetAccountMenu).click();
		List<WebElement> action = driver.findElements(actionButton);

		
			if (!action.isEmpty() && action.get(0).isDisplayed()) {
				for(int i=0;i<action.size();i++)
				{
				driver.findElement(actionButton).click();
				driver.findElement(accountDeletion).click();
				driver.findElement(deleteConfirmation).submit();			
				}
				deleteSuccessMessageAlert=driver.findElement(deleteSuccessMessage).getText().trim();
				return deleteSuccessMessageAlert;
			} 
			else 
			{
			return deleteSuccessMessageAlert;
			}
		
		
		

		
		
	}

}
