package qaframework.rtv.fw;

import org.openqa.selenium.By;
import qaframework.rtv.tests.AccountData;

public class AccountHelper extends HelperBase {

	public AccountHelper(ApplicationManager manager) {
		super(manager);
	}

	public void fillLoginForm(ApplicationManager applicationManager,
			AccountData accountData) {
		type(By.id("id__4_3"), accountData.username);
		type(By.id("id__4_4"), accountData.password);
	}
	

}
