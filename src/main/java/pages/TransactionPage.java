package pages;

import java.beans.Visibility;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.WaitUtils;

public class TransactionPage {
	WebDriver driver;
	WaitUtils waitUtils;
	Actions actions;

	private By transactionMenu=By.xpath("//span[text()='Transactions']");
	private By expenseMenu=By.xpath("//span[text()='Expenses']");
	private By createTransaction=By.xpath("//a[normalize-space()='Create a new transaction']");
	private By description=By.xpath("//input[@title='Description']");
	private By sourceAccount=By.xpath("//input[@title='Source account']");
	private By sourceAmountElement=By.xpath("(//div/div/input[@title='Source account']/following::section/ul/li/a/span)[1]");
	private By destinationAccount=By.xpath("//input[@title='Destination account']");
	private By destinationAmountElement=By.xpath("(//div/div/input[@title='Source account']/following::section/ul/li/a/span)[2]");
	private By amount=By.cssSelector("input[title='Amount']");
	private By category=By.cssSelector("input[title='Category']");
	private By submitTransaction=By.id("submitButton");
	private By transactionSuccessMsg=By.xpath("//a[contains(normalize-space(),'Successfully created new transaction')]");


	private By transfermenu=By.xpath("//span[text()='Transfers']");
	private By action=By.xpath("//button[@type='button' and normalize-space()='Actions']");
	private By deleteTransaction=By.xpath("//a[normalize-space()='Delete']");
	private By deleteConfirmation=By.cssSelector("input[value='Delete permanently']");
	private By deleteSuccessMessage=By.xpath("(//div[contains(normalize-space(), 'Successfully deleted transfer')])[3]");

	// Constructor
	public TransactionPage(WebDriver driver) {
		this.driver = driver;
		waitUtils=new WaitUtils(driver);
		actions=new Actions(driver);
	}

	public String addTransaction(Map<String, String> details)
	{
		driver.findElement(transactionMenu).click();
		driver.findElement(expenseMenu).click();
		driver.findElement(createTransaction).click();
		driver.findElement(description).sendKeys(details.get("Description"));
		driver.findElement(sourceAccount).sendKeys(details.get("SourceAccount"));
		waitUtils.ElementToBeClickable(sourceAmountElement);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		actions.sendKeys(Keys.ENTER).build().perform();
		String sourceAmount=driver.findElement(sourceAmountElement).getText();
		System.out.println(sourceAmount);
		driver.findElement(destinationAccount).sendKeys(details.get("DestinationAccount"));
		waitUtils.ElementToBeClickable(destinationAmountElement);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		actions.sendKeys(Keys.ENTER).build().perform();
		String destinationAmount=driver.findElement(destinationAmountElement).getText();
		System.out.println(destinationAmount);
		driver.findElement(amount).sendKeys(details.get("Amount"));
		driver.findElement(category).sendKeys(details.get("Category"));
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		//		actions.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(submitTransaction).click();
waitUtils.VisibilityOfElement(transactionSuccessMsg);
		List<WebElement> successMsg= driver.findElements(transactionSuccessMsg);

		String actualSuccessMsg;
		if(!successMsg.isEmpty() && successMsg.get(0).isDisplayed())
		{
			actualSuccessMsg=successMsg.get(0).getText();
			return actualSuccessMsg;
		}
		else {
			return "No Such Message Displayed";
		}



	}
	public String deleteTransaction()
	{
		driver.findElement(transactionMenu).click();
		waitUtils.VisibilityOfElement(transfermenu);
		driver.findElement(transfermenu).click();
		String deleteSuccessMessageAlert="No Account is available";
		List<WebElement> actionElement = driver.findElements(action);
		if (actionElement.size()>=2) {
			for(int i=1;i<actionElement.size()-1;i++)
			{
			// re-fetch element each time to avoid stale reference
	        List<WebElement> refreshedList = driver.findElements(action);
	        WebElement currentAction = refreshedList.get(i);
	        if (currentAction.isDisplayed()) {
	            currentAction.click();
	            actions.moveToElement(driver.findElement(deleteTransaction));	   
	            waitUtils.ElementToBeClickable(deleteTransaction);
	            driver.findElement(deleteTransaction).click();
	            driver.findElement(deleteConfirmation).click();
	        }		
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
