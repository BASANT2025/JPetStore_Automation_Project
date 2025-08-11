package Tests;

import Pages.P01_Login;
import Pages.P03_Product_Page;
import Utilities.U02_DriverManager;
import Utilities.U04_Logs;
import io.qameta.allure.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


@Link(name = "Product Page Test Cases", url = "https://docs.google.com/spreadsheets/d/1PaKDKSPb3JA8PZNz61u4CwjPHF61m2OH-8MdLT0VNN8/edit?usp=sharing")
@Parameters({"owner"})
public class T03_Product_Page {

    WebDriver driver;

    P03_Product_Page productPage;

    @BeforeMethod
    public void setUp() {
        driver = U02_DriverManager.getDriver(); // Get managed driver
        U04_Logs.info("Driver is opened");
        driver.get(U02_DriverManager.getProductURL());
        U04_Logs.info("Product page is opened");
        productPage = new P03_Product_Page(driver); // Pass driver to page object

    }

    @Test
    public void verifyProductId(){
        Assert.assertEquals(productPage.getProductId(),"FI-SW-01");
    }

    @Test
    public void addItemToCart(){
        String price = productPage.getItemPrice();
        productPage.addItemToCart();
        Assert.assertEquals(driver.getCurrentUrl(),"https://jpetstore.aspectran.com/cart/viewCart");
        Assert.assertEquals(price,driver.findElement(By.xpath("//tbody//tr//td[7]")).getText());
    }

    @Test
    public void navigateToCategoryPage(){
        productPage.navigateToCategoryPage();
        Assert.assertEquals(driver.getCurrentUrl(),U02_DriverManager.getCategoryURL());
    }


    @AfterMethod
    public void tearDown() {
        U02_DriverManager.quitDriver();
    }




}
