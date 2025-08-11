package Tests;

import Pages.P03_Product_Page;
import Pages.P05_View_Cart;
import Utilities.U01_BaseClass;
import Utilities.U02_DriverManager;
import Utilities.U04_Logs;
import io.qameta.allure.Link;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


@Link(name = "Cart Page Test Cases", url = "https://docs.google.com/spreadsheets/d/1PaKDKSPb3JA8PZNz61u4CwjPHF61m2OH-8MdLT0VNN8/edit?usp=sharing")
@Parameters({"owner"})
public class T05_View_Cart {

    WebDriver driver;
    P05_View_Cart cart;
    P03_Product_Page productPage;

    @BeforeMethod
    public void setUp() {
        driver = U02_DriverManager.getDriver(); // Get managed driver
        U04_Logs.info("Driver is opened");
        driver.get(U02_DriverManager.getProductURL());
        U04_Logs.info("Cart page is opened");
        productPage = new P03_Product_Page(driver);
        cart = new P05_View_Cart(driver); // Pass driver to page object

    }


    @Test
    public void changeQuantity(){
        String quantity = "4";
        productPage.addItemToCart().changeQuantity(quantity).updateCart();
        Assert.assertEquals(cart.getQuantity(),quantity);
    }

    @Test
    public void removeProduct(){
        productPage.addItemToCart().removeProduct();
        Assert.assertTrue(cart.emptyCartMessage());
    }

    @Test
    public void ReturnToMainMenu(){
        productPage.addItemToCart().ReturnToMainMenu();
        Assert.assertEquals(driver.getCurrentUrl(),"https://jpetstore.aspectran.com/");
    }
    @Test
    public void proceedToCheckOut(){
        productPage.addItemToCart().proceedToCheckOut();
        Assert.assertEquals(driver.getCurrentUrl(),"https://jpetstore.aspectran.com/account/signonForm?referer=%2Forder%2FnewOrderForm");
    }



    @AfterMethod
    public void tearDown() {
        U02_DriverManager.quitDriver();
    }

}
