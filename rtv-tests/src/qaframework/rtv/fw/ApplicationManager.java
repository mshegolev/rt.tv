package qaframework.rtv.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
	public WebDriver driver;
	public String baseUrl;
	public String urlForSetPayment;
    public ChromeDriverService service;
    public StringBuffer verificationErrors = new StringBuffer();

	private NavigationHelper navigationHelper;
	private AccountHelper accountHelper;

	public ApplicationManager() throws IOException {
        //service = new ChromeDriverService.Builder()
        //        .usingDriverExecutable(new File("tools\\driver\\chromedriver.exe"))
        //       .usingAnyFreePort()
        //       .build();
        //driver = new ChromeDriver(service);
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
