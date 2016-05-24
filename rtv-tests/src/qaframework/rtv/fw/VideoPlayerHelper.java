package qaframework.rtv.fw;

import com.google.gson.internal.bind.TimeTypeAdapter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.File;
import java.text.ParseException;

/**
 * Created by mikhail on 5/14/16.
 */
public class VideoPlayerHelper extends HelperBase {
    public VideoPlayerHelper(ApplicationManager manager) {
        super(manager);
    }

    public WebElement videoArchivePlayer() {
        driver.findElement(By.id("videoArchivePlayer"));
        return null;
    }


    public void videoArchivePlayerPlayerIframe() throws InterruptedException {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(By.xpath(".//*[@id='partsTranslations']/iframe").findElement(driver));
        driver.findElement(By.cssSelector(".uppod-control_play>canvas")).click();
        Thread.sleep(5000);
    }

    public WebElement buttonArchivePlayerPause() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(By.xpath(".//*[@id='partsTranslations']/iframe").findElement(driver));
        return driver.findElement(By.cssSelector(".uppod-control_pause>canvas"));
    }

    public WebElement buttonArchivePlayerPlay() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(By.xpath(".//*[@id='partsTranslations']/iframe").findElement(driver));
        return By.cssSelector(".uppod-control_play>canvas").findElement(driver);

    }

    public WebElement fieldArchivePlayerDuration() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(By.xpath(".//*[@id='partsTranslations']/iframe").findElement(driver));
        return driver.findElement(By.xpath(".//*[@class='uppod-control_time_play']"));
    }

    public WebElement fieldArchivePlayerLayer() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(By.xpath(".//*[@id='partsTranslations']/iframe").findElement(driver));
        return By.id("layer").findElement(driver);
    }

    public WebElement scrollbarArchiveVideoLine() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(By.xpath(".//*[@id='partsTranslations']/iframe").findElement(driver));
        return By.cssSelector(".uppod-control_line_btn").findElement(driver);
    }

    public WebElement scrollbarArchiveVideoButton() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(By.xpath(".//*[@id='partsTranslations']/iframe").findElement(driver));
        return By.cssSelector(".uppod-control_run_line").findElement(driver);
    }

    public WebElement fieldArchivePlayerDrationAllTime() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(By.xpath(".//*[@id='partsTranslations']/iframe").findElement(driver));
        return By.cssSelector(".uppod-control_time_all").findElement(driver);
    }

    public WebElement buttonArchivePlayerSoundON() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(By.xpath(".//*[@id='partsTranslations']/iframe").findElement(driver));
        return By.cssSelector(".uppod-control_volume").findElement(driver);
    }

    public WebElement buttonArchivePlayerSoundMute() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(By.xpath(".//*[@id='partsTranslations']/iframe").findElement(driver));
        return By.cssSelector(".uppod-control_volume_mute>canvas").findElement(driver);
    }

    public WebElement scrollbarArchivePlayerSound() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(By.xpath(".//*[@id='partsTranslations']/iframe").findElement(driver));
        return By.cssSelector(".uppod-control_volume_bar>canvas").findElement(driver);
    }

    public WebElement buttonArchivePlayerFullScreenEnter() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(By.xpath(".//*[@id='partsTranslations']/iframe").findElement(driver));
        return By.cssSelector(".uppod-control_enter_fullscreen").findElement(driver);
    }

    public WebElement buttonArchivePlayerFullScreenExit() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(By.xpath(".//*[@id='partsTranslations']/iframe").findElement(driver));
        return By.cssSelector(".uppod-control_exit_fullscreen").findElement(driver);
    }

    private Integer getPossitionScrollbarArchivePlayerButton() {
        int scrollValue = Integer.parseInt(scrollbarArchiveVideoButton().getCssValue("left").toString().replace("px", ""));
        return scrollValue;
    }

    public String getDurationArchivePlayer() throws ParseException {
        return fieldArchivePlayerDuration().getText();
    }

    public WebElement etherPlayer() {
        //driver.switchTo().defaultContent();
        //driver.switchTo().frame(By.xpath(".//*[@id='partsTranslations']/iframe").findElement(driver));
        return By.id("player_videoflash").findElement(driver);

    }

    private boolean setScrollBarArchivePlayerToTime(TimeTypeAdapter time) {
        return true;
    }


    //time     driver.findElement(By.cssSelector("div.uppod-control_line_btn")).click();
    //set time  driver.findElement(By.cssSelector("div.uppod-control_time_all")).click();
    //driver.findElement(By.cssSelector("div.uppod-control_volume > canvas")).click();
    //driver.findElement(By.cssSelector("div.uppod-control_volume_mute > canvas")).click();
    //driver.findElement(By.cssSelector("div.uppod-control_volume_bar")).click();

    public boolean clickButtonPause() throws InterruptedException {
        if (buttonArchivePlayerPause().isDisplayed()) {
            buttonArchivePlayerPause().click();
            return true;
        } else if (buttonArchivePlayerPause().isDisplayed() == false) {
            Actions builder = new Actions(driver);
            builder.moveToElement(buttonArchivePlayerPause(), buttonArchivePlayerPause().getLocation().getX(), buttonArchivePlayerPause().getLocation().getY());
            Thread.sleep(5000);
            if (buttonArchivePlayerPause().isEnabled()) {
                buttonArchivePlayerPause().click();
                return true;
            }
        }
        return false;

    }

    public boolean clickArchivePlayer() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath(".//*[@id='partsTranslations']/iframe")));
        driver.findElement(By.cssSelector(".uppod-control_play>canvas")).click();
        return true;
    }

    // TODO: replace waite to wait and chack video stream;
    public boolean clickButtonPlay() {
        if (buttonArchivePlayerPlay().isEnabled()) {
            buttonArchivePlayerPlay().click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        } else return false;
    }


    //TODO: depraceted this code after automation ff player
    public void testHTML5ArchivePlayer() throws Exception {
        File scrFile = null;

        //Get the HTML5 Video Element
        WebElement videoPlayer = driver.findElement(By.id("videoArchivePlayer"));
        driver.manage().window().fullscreen();
//        driver.get("https://fpdl.vimeocdn.com/vimeo-prod-skyfire-std-us/01/2663/5/138319692/411670000.mp4?token=57389b3f_0xed17bac20106661da22cdc156a337d9e7e7ab768");
        Thread.sleep(12000L);

        //We will need a JavaScript Executor for interacting
        //with Video Element's
        //methods and properties for automation
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        //Get the Source of Video that will be played in Video Player
        String source = (String) jsExecutor.executeScript("return arguments[0].currentSrc;", videoPlayer);

        //Get the Duration of Video
        long duration = (Long) jsExecutor.executeScript("return arguments[0].duration", videoPlayer);
        System.out.println(duration);

        //Verify Correct Video is loaded and duration
        Assert.assertSame("https://fpdl.vimeocdn.com/vimeo-prod-skyfire-std-us/01/2663/5/138319692", source);
        Assert.assertEquals(25, duration);

        //Play the Video
        jsExecutor.executeScript("return arguments[0].play()", videoPlayer);
        Thread.sleep(5000);

        //Pause the video
        jsExecutor.executeScript("arguments[0].pause()", videoPlayer);

        //Take a screen-shot for later verification
        scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("c:\\tmp\\pause_play.png"));
    }


}
