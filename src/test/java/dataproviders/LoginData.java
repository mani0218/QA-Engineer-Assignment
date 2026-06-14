package dataproviders;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class LoginData {

	@DataProvider(name = "loginData")
	public Object[][] getLoginData()
	{
		Map<String, String> loginData=new HashMap<>();
		loginData.put("UserName", "manikandanmk0218@gmail.com");
		loginData.put("Password", "Manikandan@12345678");
		loginData.put("InvalidName", "mani");
		loginData.put("InvalidPassword", "Manikandan");
		
		return new Object[][] {
			{loginData}
		};
	}
}
