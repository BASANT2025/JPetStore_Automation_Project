package Tests;

import Pages.P00_Home_Page;
import Pages.P01_Login;
import Pages.P06_Order_Form;
import Pages.P07_Order_Confirmation;
import Utilities.U02_DriverManager;
import Utilities.U04_Logs;
import io.qameta.allure.Link;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


@Link(name = "Order Confirmation Test Cases", url = "https://docs.google.com/spreadsheets/d/1PaKDKSPb3JA8PZNz61u4CwjPHF61m2OH-8MdLT0VNN8/edit?usp=sharing")
@Parameters({"owner"})
public class T07_Order_Confirmation {
    WebDriver driver;
    P00_Home_Page home;
    P06_Order_Form form;
    P01_Login login;
    P07_Order_Confirmation confirm;

    @BeforeMethod
    public void setUp() {
        driver = U02_DriverManager.getDriver(); // Get managed driver
        U04_Logs.info("Driver is opened");
        driver.get(U02_DriverManager.getOrderFormURL());
        U04_Logs.info("Order Form is opened");
        form = new P06_Order_Form(driver); // Pass driver to page object
        home = new P00_Home_Page(driver);
        login= new P01_Login(driver);
        confirm = new P07_Order_Confirmation(driver);
    }

    @Test




    @AfterMethod
    public void tearDown() {
        U02_DriverManager.quitDriver();
    }
}
