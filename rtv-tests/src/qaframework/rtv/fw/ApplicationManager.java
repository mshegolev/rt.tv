package qaframework.rtv.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
	public WebDriver driver;
	public String baseUrl;
	public StringBuffer verificationErrors = new StringBuffer();

	private NavigationHelper navigationHelper;
	private AccountHelper accountHelper;
	private VideoPlayerHelper videoHelper;

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
	public VideoPlayerHelper getVideoHelper() {
		if (videoHelper == null) {
			videoHelper = new VideoPlayerHelper(this);
		}
		return videoHelper;
	}

}
