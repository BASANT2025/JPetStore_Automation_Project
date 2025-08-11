package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class U02_DriverManager {

    private static WebDriver driver;
    private static final ChromeOptions chromeOptions= new ChromeOptions();
    private static final FirefoxOptions firefoxOptions=new FirefoxOptions() ;
    private static final EdgeOptions edgeOptions = new EdgeOptions();
    private static Properties properties = null;


    //TODO: Setup the browser before each test
    //To Check if the drive is null to initialize it
    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    private static void loadProperties() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream("D:\\ITI DATA\\00-Individual Project\\Swag Labs\\Swag_Labs\\src\\main\\resources\\config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }


    //To get the properties of the driver to initialize it
    private static WebDriver initializeDriver() {
        loadProperties();
        String browser = properties.getProperty("browser");
        switch (browser.toLowerCase()) {

            case ("firefox"):
//                System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
                firefoxOptions.addArguments("--start-maximized","-private");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case ("edge"):
//                System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
                edgeOptions.addArguments("--start-maximized","inprivate");
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
//                System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
                chromeOptions.addArguments("--start-maximized","--incognito");
                driver = new ChromeDriver(chromeOptions);

                        }
                        return driver;
    }


    //TODO: Get the Base URL

    public static String getURL (){
        loadProperties();
        return properties.getProperty("base.url");
    }

    //TODO: Get the Login Page URL
    public static String getLoginURL (){
        loadProperties();
        return properties.getProperty("login.url");
    }

    //TODO: Get the Category Page URL
    public static String getCategoryURL (){
        loadProperties();
        return properties.getProperty("fishCategory.url");
    }

    //TODO: Get the Product Page URL
    public static String getProductURL (){
        loadProperties();
        return properties.getProperty("fishProduct.url");
    }

    //TODO: Get the Item Page URL
    public static String getItemURL (){
        loadProperties();
        return properties.getProperty("item.url");
    }


    //TODO: Get the Cart URL
    public static String getCartURL (){
        loadProperties();
        return properties.getProperty("cart.url");
    }

    //TODO: Get the Order Form URL
    public static String getOrderFormURL (){
        loadProperties();
        return properties.getProperty("orderForm.url");
    }
    //TODO: Quit the browser after each test

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    //TODO: Pause the test so that the execution can be recorded
    public static void PauseTest(int seconds, WebDriver chromeDriver){
        try {
            new WebDriverWait(chromeDriver, Duration.ofSeconds(seconds))
                    .until(driver -> false);  // Always false, just to cause wait
        } catch (TimeoutException e) {
            // Expected timeout — this acts like a pause
        }
    }
}




