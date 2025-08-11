package Tests;

import Pages.P01_Login;
import Pages.P04_Item_Page;
import Utilities.U02_DriverManager;
import Utilities.U04_Logs;
import io.qameta.allure.Link;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


@Link(name = "Item Page Test Cases", url = "https://docs.google.com/spreadsheets/d/1PaKDKSPb3JA8PZNz61u4CwjPHF61m2OH-8MdLT0VNN8/edit?usp=sharing")
@Parameters({"owner"})
public class T04_Item_Page {

    WebDriver driver;
    P04_Item_Page item;


    @BeforeMethod
    public void setUp() {
        driver = U02_DriverManager.getDriver(); // Get managed driver
        U04_Logs.info("Driver is opened");
        driver.get(U02_DriverManager.getItemURL());
        U04_Logs.info("Item page is opened");
        item = new P04_Item_Page(driver); // Pass driver to page object

    }


    @Test
    public void Verify_Item_ID(){
        Assert.assertEquals(item.getItemId(),"EST-1");

    }

    @Test
    public void Verify_Item_Image(){
        Assert.assertTrue(item.checkItemImgIsDisplayed());
    }

    @Test
    public void Verify_Product_Page_Link(){
        item.navigateToProductPage();
        Assert.assertEquals(driver.getCurrentUrl(),"https://jpetstore.aspectran.com/products/FI-SW-01");
    }

    @Test
    public void add_To_Cart(){
        item.addItemToCart();
        Assert.assertEquals(driver.getCurrentUrl(),"https://jpetstore.aspectran.com/cart/viewCart");
    }




    @AfterMethod
    public void tearDown() {
        U02_DriverManager.quitDriver();
    }












}
