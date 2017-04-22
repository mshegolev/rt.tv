package time.tv.pages;

import org.openqa.selenium.WebDriver;

/**
 * Abstract class representation of a AnyPages in the UI. AnyPages object pattern
 */
public class AnyPages {

    protected static WebDriver driver;

    /*
     * Constructor injecting the WebDriver interface
     *
     * @param webDriver
     */
    public AnyPages(WebDriver driver) {
        this.driver = driver;
    }

    public AnyPages() {
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
