package dataproviders;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class TransactionData {
	
	@DataProvider(name="transactionData")
	public Object[][] getTransactionData()
	{
		Map<String, String> dataSet1 = new HashMap<>();
		dataSet1.put("Description", "tiffen");
		dataSet1.put("SourceAccount", "Savings Account");
		dataSet1.put("DestinationAccount", "Current Account");
		dataSet1.put("Amount", "50");
		dataSet1.put("Category", "Food");

		Map<String, String> dataSet2 = new HashMap<>();
		dataSet2.put("Description", "lunch");
		dataSet2.put("SourceAccount", "Savings Account");
		dataSet2.put("DestinationAccount", "Current Account");
		dataSet2.put("Amount", "150");
		dataSet2.put("Category", "Food");

		Map<String, String> dataSet3 = new HashMap<>();
		dataSet3.put("Description", "dinner");
		dataSet3.put("SourceAccount", "Savings Account");
		dataSet3.put("DestinationAccount", "Current Account");
		dataSet3.put("Amount", "100");
		dataSet3.put("Category", "Food");
		return new Object[][] {
			{dataSet1},
			{dataSet2},
			{dataSet3}
		};
	}

}
