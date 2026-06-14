package dataproviders;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class AccountData {
	
	@DataProvider(name = "accountData")
	public Object[][] getAccountData() {
		Map<String, String> dataSet1 = new HashMap<>();
		dataSet1.put("AccountName", "Current Account");
		dataSet1.put("Currency", "Indian rupee (₹)");
		dataSet1.put("AccountNumber", "1001");
		dataSet1.put("OpeningBalance", "5000");
		dataSet1.put("OpeningBalanceDate", "11/06/2026");

		Map<String, String> dataSet2 = new HashMap<>();
		dataSet2.put("AccountName", "Savings Account");
		dataSet2.put("Currency", "Indian rupee (₹)");
		dataSet2.put("AccountNumber", "1002");
		dataSet2.put("OpeningBalance", "10000");
		dataSet2.put("OpeningBalanceDate", "12/06/2026");

		Map<String, String> dataSet3 = new HashMap<>();
		dataSet3.put("AccountName", "Investment Account");
		dataSet3.put("Currency", "Indian rupee (₹)");
		dataSet3.put("AccountNumber", "1003");
		dataSet3.put("OpeningBalance", "15000");
		dataSet3.put("OpeningBalanceDate", "13/06/2026");

		return new Object[][] {
			{dataSet1},
			{dataSet2},
			{dataSet3}
		};
	}


}
