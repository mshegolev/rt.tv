package qaframework.rtv.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
	public WebDriver driver;
	public String baseUrl;
	public StringBuffer verificationErrors = new StringBuffer();

	private NavigationHelper navigationHelper;
	private AccountHelper accountHelper;

	public ApplicationManager() {
		driver = new FirefoxDriver();
		baseUrl = "http://rithm-time.tv/";
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
