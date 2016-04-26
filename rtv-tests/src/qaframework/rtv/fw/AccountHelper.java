package qaframework.rtv.fw;

import org.openqa.selenium.By;
import qaframework.rtv.tests.AccountData;

public class AccountHelper extends HelperBase {

	public AccountHelper(ApplicationManager manager) {
		super(manager);
	}

	public void fillLoginForm(ApplicationManager applicationManager,
			AccountData accountData) {
		type(By.id("auth_login"), accountData.username);
		type(By.id("auth_password"), accountData.password);
	}

}
