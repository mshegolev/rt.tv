package qaframework.rtv.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver driver;
    public String baseUrl;
    public String urlForSetPayment;
    public StringBuffer verificationErrors = new StringBuffer();
    private qaframework.rtv.fw.NavigationHelper navigationHelper;
    private AccountHelper accountHelper;

    private Properties props;

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

    public void setProperties(Properties props) {
        this.props = props;
    }

    public String getProperty(String key) {
        return props.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }




}
