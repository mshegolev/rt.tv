package qaframework.rtv.fw;

import org.openqa.selenium.By;
import qaframework.rtv.tests.AccountData;

public class AccountHelper extends HelperBase {

	public AccountHelper(ApplicationManager manager) {
		super(manager);
	}

	public void fillLoginForm(ApplicationManager applicationManager,
			AccountData accountData) {
		type(By.id("id__2_3"), accountData.username);
		type(By.id("id__2_4"), accountData.password);
	}
	

}
