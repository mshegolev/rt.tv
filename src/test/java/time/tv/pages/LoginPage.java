package time.tv.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import time.tv.util.PropertyLoader;

import java.io.IOException;

/**
 * Sample page
 */
public class LoginPage extends Page {


    @FindBy(how = How.TAG_NAME, using = "h1")
    @CacheLookup
    public WebElement header;

    public LoginPage(WebDriver webDriver) throws IOException {
        super(webDriver);
    }

    PropertyLoader propertyLoader = new PropertyLoader();
    public String getIdfromResources(){
        String id = null;
        return id;
    }
    private String buttonLogin = propertyLoader.loadProperty("buttonLogin","loginPage.properties");

}
