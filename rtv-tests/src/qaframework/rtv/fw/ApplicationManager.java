package qaframework.rtv.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
	public WebDriver driver;
	public String baseUrl;
	public String urlForSetPayment;
	public StringBuffer verificationErrors = new StringBuffer();

	private NavigationHelper navigationHelper;
	private AccountHelper accountHelper;

	public ApplicationManager() {  
		driver = new FirefoxDriver();
		baseUrl = "http://rithm-time.tv/";
		urlForSetPayment = "http://irlem-practice.ru/admin/QA_scripts/set_payment.php";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		accountHelper = new AccountHelper(this);
	}

	public void stop() {
		driver.quit();

	}

	public NavigationHelper getNavigationHelper() {
		if (navigationHelper == null) {
			navigationHelper = new NavigationHelper(this);
		}
		return navigationHelper;
	}

	public AccountHelper getAccountHelper() {
		if (accountHelper == null) {
			accountHelper = new AccountHelper(this);
		}
		return accountHelper;
	}

}
