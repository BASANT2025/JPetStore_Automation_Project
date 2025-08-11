package Utilities;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static Utilities.U02_DriverManager.PauseTest;

public class U01_BaseClass {

    private static final String SCREENSHOTS_PATH = "test_output/Screenshots/";
    protected WebDriver driver;
    protected WebDriverWait wait;

    //Constructor
    public U01_BaseClass(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //TODO: Methods used in pages classes

    //TODO: Wait for element to be visible
    public static void waitForVisibility(WebDriver driver, By locator, int timeoutInSeconds) {
         new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //TODO: Wait for element to be clickable
    public static void waitForClickable(WebDriver driver, By locator, int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }


    //TODO: Select by visible text

    public static void selectDropdownByText(WebDriver driver, By locator, String text) {
        new Select(driver.findElement(locator)).selectByVisibleText(text);
        PauseTest(2,driver);

    }

    //TODO: Select by value attribute
    public static void selectDropdownByValue(WebDriver driver, By locator, String value) {
        new Select(driver.findElement(locator)).selectByValue(value);
        PauseTest(2,driver);

    }

    //TODO: Switch to frame by element
    public static void switchToFrame(WebDriver driver, By locator) {
        driver.switchTo().frame(driver.findElement(locator));
        PauseTest(2,driver);

    }

    //TODO: Switch to default content
    public static void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
        PauseTest(2,driver);

    }


    //TODO: Send text to input field
    public static void enterText (WebDriver driver, By locator, String username){
        waitForVisibility(driver,locator,4);
        scrollToElementWithJS(driver,locator);
        driver.findElement(locator).sendKeys(username);
        PauseTest(2,driver);
    }


    //TODO: Click the element

    public static void ClickOnButton(WebDriver driver, By locator){
        waitForClickable(driver,locator,3);
        scrollToElementWithJS(driver,locator);
//        scrollDownSlightly(driver);
        driver.findElement(locator).click();
        PauseTest(2,driver);
    }

    //TODO: Hover over the element
    public static void hoverOverElement(WebDriver driver, By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).perform();
        PauseTest(2,driver);
    }
    //TODO: Get message
    public static String getTextFromElement(WebDriver driver, By locator) {
        PauseTest(2,driver);
        scrollToElementWithJS(driver,locator);
        return driver.findElement(locator).getText();
    }

    public static String getValue(WebDriver driver, By locator){
        scrollToElementWithJS(driver,locator);
        return driver.findElement(locator).getAttribute("value");
    }
    //TODO: Get verify message is displayed

    public static boolean elementIsDisplayed (WebDriver driver, By locator){
        return driver.findElement(locator).isDisplayed();
    }
    //TODO: Switch to new tab
    public static void switchToNewTab(WebDriver driver){
       String CurrentTab=  driver.getWindowHandle();
       Set<String> openedTabs = driver.getWindowHandles();
       for(String handle: openedTabs){
           if(!CurrentTab.equals(handle))
               driver.switchTo().window(handle);
       }
    }

    //TODO: Scroll to element in view
    public static void clearField(WebDriver driver,By locator){
        scrollToElementWithJS(driver,locator);
        driver.findElement(locator).clear();
    }
    //TODO: Scroll to element in view
public static void scrollToElement(WebDriver driver,By locator){
        Actions actions = new Actions(driver);

        waitForVisibility(driver,locator,4);
        actions.moveToElement(driver.findElement(locator)).perform();
}
    //TODO: To record the timing of any action

    public static String getTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd-h-m-ssa").format(new Date());
    }
    //TODO: Take Screenshot function

    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        try {
            // Capture screenshot using TakesScreenshot
            File screenshotSrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Save screenshot to a file if needed
            File screenshotFile = new File(SCREENSHOTS_PATH + screenshotName + "-" + getTimeStamp() + ".png");
            FileUtils.copyFile(screenshotSrc, screenshotFile);

            // Attach the screenshot to Allure
            Allure.addAttachment(screenshotName, Files.newInputStream(Path.of(screenshotFile.getPath())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void scrollToElementWithJS(WebDriver driver, By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }
    public static void scrollDownSlightly(WebDriver driver) {
        // This script scrolls the window by 100 pixels vertically
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");
    }
}
