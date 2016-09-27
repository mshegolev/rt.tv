package qaframework.rtv.fw;

import org.openqa.selenium.By;
import qaframework.rtv.tests.AccountData;

public class AccountHelper extends HelperWithWebDriverBase{

	public AccountHelper(ApplicationManager manager) {
		super(manager);
	}

	public void fillLoginForm(ApplicationManager applicationManager,
			AccountData accountData) {
		type(String.valueOf(By.id("auth_login")), accountData.username);
		type(String.valueOf(By.id("auth_password")), accountData.password);
	}




}
