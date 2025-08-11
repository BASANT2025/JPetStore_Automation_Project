package Tests;

import Pages.*;
import Utilities.U01_BaseClass;
import Utilities.U02_DriverManager;
import Utilities.U04_Logs;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


@Parameters({"owner"})
public class T09_E2E_Scenario_Positive1 {
    WebDriver driver;
    P00_Home_Page home;
    P01_Login Login;
    P02_Category_Page Category;
    P03_Product_Page Product;
    P06_Order_Form orderForm;
    P07_Order_Confirmation confirmOrder;
    P08_Order_Details orderDetails;



    @BeforeMethod
    public void setUp() {
        driver = U02_DriverManager.getDriver(); // Get managed driver
        U04_Logs.info("Driver is opened");
        driver.get(U02_DriverManager.getURL());
        U04_Logs.info("Home page is opened");
        home = new P00_Home_Page(driver);
        Login = new P01_Login(driver); // Pass driver to page object
        Product = new P03_Product_Page(driver);
        orderDetails= new P08_Order_Details(driver);
        Category = new P02_Category_Page(driver);
        orderForm = new P06_Order_Form(driver);
    }

    @Description("Login-->Navigate To Product Page-->Add item to cart-->change Quantity-->Checkout-->Confirm Order Details")
    @Test
    //Login-->Navigate To Product Page-->Add item to cart-->change Quantity-->Checkout-->Confirm Order Details
    public void E2EScenario(){
        home.navigateToSignIn();
          Assert.assertEquals(driver.getCurrentUrl(),"https://jpetstore.aspectran.com/account/signonForm");
        Login.clearInputFields()
                .enterUsername("j2ee")
                .enterPassword("j2ee")
                .clickLoginButton();
        Assert.assertEquals(Login.getWelcomeMessage(),"Welcome Sofia!");
        home.navigateToFishCategory();
       Assert.assertEquals(Category.pageTitle(),"Fish");
        Assert.assertTrue(Category.productNameList() && Category.productIdList());
        Category.navigateToProductPage();
        Assert.assertEquals(Product.getProductId(),"FI-SW-01");

        Product.addItemToCart().changeQuantity("3")
                .proceedToCheckOut();
        Assert.assertEquals(driver.getCurrentUrl(),"https://jpetstore.aspectran.com/order/newOrderForm");

        orderForm.selectCardType("MasterCard")
                .enterCardNo("999666999666999")
                .enterExpDate("12/2025")
                .confirmOrder()
                .confirmOrderDetails();
            U01_BaseClass.takeScreenshot(driver,"Successful Order Scenario");
          Assert.assertTrue(orderDetails.checkConfirmationMessage());

    }


    @AfterMethod
    public void tearDown() {
        U02_DriverManager.quitDriver();
    }

}
