package qaframework.rtv.fw;

import java.util.Properties;

public class ApplicationManager {
    private static ApplicationManager singleton;

    private NavigationHelper navigationHelper;
    private WebDriverHelper webDriverHelper;
	private AccountHelper accountHelper;


    private Properties props;

    public static ApplicationManager getInstance() {
        if (singleton == null) {
            singleton = new ApplicationManager();
        }
        return singleton;
    }
    public void stop() {
        if (webDriverHelper != null) {
            webDriverHelper.stop();
        }
    }

    public WebDriverHelper getWebDriverHelper() {
        if (webDriverHelper == null) {
            webDriverHelper = new WebDriverHelper(this);
        }
        return webDriverHelper;
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
