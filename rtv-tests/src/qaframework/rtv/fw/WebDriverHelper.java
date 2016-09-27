package qaframework.rtv.fw;
import com.opera.core.systems.OperaDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;
/**
 * Created by mikhail on 26.09.2016.
 */
public class WebDriverHelper extends HelperBase {
    private String urlForSetPayment;

    private static WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();
    private final ApplicationManager manager;

    public WebDriverHelper(ApplicationManager manager) {
        super(manager);
        this.manager = manager;
        String browser = manager.getProperty("browser");
        if ("firefox".equals(browser)) {
            driver = new FirefoxDriver();
        } else if ("ie".equals(browser)) {
            driver = new InternetExplorerDriver();
        } else if ("chrome".equals(browser)) {
            driver = new ChromeDriver();
        } else if ("opera".equals(browser)) {
            driver = new OperaDriver();
        } else {
            driver = new HtmlUnitDriver();
        }
        driver.manage().timeouts().implicitlyWait(
                Integer.parseInt(manager.getProperty("implicitWait", "10")),
                TimeUnit.SECONDS);
        driver.get(manager.getProperty("baseUrl"));
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

}