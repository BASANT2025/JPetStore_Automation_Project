package Tests;

import Listeners.IInvokedListenerClass;
import Listeners.ITestListenerClass;
import Pages.P01_Login;
import Pages.P02_Category_Page;
import Utilities.U02_DriverManager;
import Utilities.U04_Logs;
import io.qameta.allure.Link;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


@Listeners({IInvokedListenerClass.class,ITestListenerClass.class})
@Link(name = "Category Page Test Cases", url = "https://docs.google.com/spreadsheets/d/1PaKDKSPb3JA8PZNz61u4CwjPHF61m2OH-8MdLT0VNN8/edit?usp=sharing")
@Parameters({"owner"})
public class T02_Category_Page {
    WebDriver driver;
    P02_Category_Page Category;

    @BeforeMethod
    public void setUp() {
        driver = U02_DriverManager.getDriver(); // Get managed driver
        U04_Logs.info("Driver is opened");
        driver.get(U02_DriverManager.getCategoryURL());
        U04_Logs.info("Fish Category page is opened");
        Category = new P02_Category_Page(driver); // Pass driver to page object
    }


    @Test
    public void Category_Page_Name(){
        Assert.assertEquals(Category.pageTitle(),"Fish");
    }

    @Test
    public void checkProductAreDisplayed(){
       Assert.assertTrue(Category.productNameList() && Category.productIdList());

    }


    @Test
    public void navigateToHomePage(){
        Category.navigateToHomePage();
        Assert.assertEquals(driver.getCurrentUrl(),"https://jpetstore.aspectran.com/");

    }
    @Test
    public void redirectionToMainMenu(){
        Category.redirectionToMainMenu();
        Assert.assertEquals(driver.getCurrentUrl(),"https://jpetstore.aspectran.com/");
    }

    @Test
    public void navigateToProductPage(){
        Category.navigateToProductPage();
        Assert.assertEquals(driver.getCurrentUrl(),"https://jpetstore.aspectran.com/products/FI-SW-01");
    }

    @AfterMethod
    public void tearDown() {
        U02_DriverManager.quitDriver();
    }
}
