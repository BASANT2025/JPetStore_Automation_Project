package Tests;

import Pages.P00_Home_Page;
import Pages.P01_Login;
import Pages.P06_Order_Form;
import Utilities.U02_DriverManager;
import Utilities.U04_Logs;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class T08_Order_Details {
    WebDriver driver;
    P00_Home_Page home;
    P06_Order_Form form;
    P01_Login login;
    @BeforeMethod
    public void setUp() {
        driver = U02_DriverManager.getDriver(); // Get managed driver
        U04_Logs.info("Driver is opened");
        driver.get(U02_DriverManager.getOrderFormURL());
        U04_Logs.info("Order Form is opened");
        form = new P06_Order_Form(driver); // Pass driver to page object
        home = new P00_Home_Page(driver);
        login= new P01_Login(driver);
    }


    @AfterMethod
    public void tearDown() {
        U02_DriverManager.quitDriver();
    }
}
