package Tests;
import Listeners.IInvokedListenerClass;
import Listeners.ITestListenerClass;
import Pages.P00_Home_Page;
import Utilities.U01_BaseClass;
import Utilities.U02_DriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners({IInvokedListenerClass.class, ITestListenerClass.class})
@Link(name = "Home Page Test Cases", url = "https://docs.google.com/spreadsheets/d/1PaKDKSPb3JA8PZNz61u4CwjPHF61m2OH-8MdLT0VNN8/edit?usp=sharing")
@Parameters({"owner"})
public class T00_Home_Page {
    WebDriver driver;
    P00_Home_Page Home_Page;

    @Description("Home Page Test Cases")
    @BeforeMethod
    public void setUp() {
        driver = U02_DriverManager.getDriver(); // Get managed driver
        driver.get(U02_DriverManager.getURL());
        Home_Page = new P00_Home_Page(driver); // Pass driver to page object

    }


    @Test
    public void Verify_Navigation_To_SignUp_Page(){
        Home_Page.navigateToSignUp();
        Assert.assertEquals(driver.getCurrentUrl(),"https://jpetstore.aspectran.com/account/newAccountForm");
    }
    @Test
    public void Verify_Navigation_To_SignIn_Page(){
        Home_Page.navigateToSignIn();
        U01_BaseClass.takeScreenshot(driver,"Successful navigation to Sign up page");
        Assert.assertEquals(driver.getCurrentUrl(),"https://jpetstore.aspectran.com/account/signonForm");

    }

    @Test
    public void Search_for_existing_product (){
        Home_Page.enterSearchKeyword("Fish").clickSearchButton();
        Assert.assertTrue(Home_Page.researchResultMessage());
    }

    @Test
    public void Search_with_special_chars_keyword (){
        Home_Page.enterSearchKeyword("###").clickSearchButton();
        Assert.assertTrue(Home_Page.researchResultMessage());
    }


    @Test
    public void Search_with_empty_keyword (){
        Home_Page.enterSearchKeyword("").clickSearchButton();
        Assert.assertTrue(Home_Page.researchResultMessage());
    }

    @Test
    public void Verify_Redirection_GitHub(){
        Home_Page.navigateToGitHub();
        Home_Page.switchToNewTab(driver);
        Assert.assertEquals(driver.getCurrentUrl(),"https://github.com/aspectran");

    }
    @Test
    public void Verify_Redirection_ContactUs(){
        Home_Page.navigateToContactUs();
        Assert.assertEquals(driver.getCurrentUrl(),"https://aspectran.com/en/support/contact/");
    }

    @Test
    public void Verify_Redirection_FAQ(){
        Home_Page.navigateToFAQ();
        Assert.assertEquals(driver.getCurrentUrl(),"https://aspectran.com/en/support/faq/");
    }

    @Test
    public void Verify_Redirection_FishCategory(){
        Home_Page.navigateToFishCategory();
        Assert.assertEquals(driver.getCurrentUrl(),"https://jpetstore.aspectran.com/categories/FISH");

    }
    @Test
    public void Verify_Redirection_DogsCategory(){
        Home_Page.navigateToDogsCategory();
        Assert.assertEquals(driver.getCurrentUrl(),"https://jpetstore.aspectran.com/categories/DOGS");
    }
    @Test
    public void Verify_Redirection_ReptilesCategory(){
        Home_Page.navigateToReptilesCategory();
        Assert.assertEquals(driver.getCurrentUrl(),"https://jpetstore.aspectran.com/categories/REPTILES");
    }
    @Test
    public void Verify_Redirection_CatsCategory(){
        Home_Page.navigateToCatsCategory();
        Assert.assertEquals(driver.getCurrentUrl(),"https://jpetstore.aspectran.com/categories/CATS");
    }
    @Test
    public void Verify_Redirection_BirdsCategory(){
        Home_Page.navigateToBirdsCategory();
        Assert.assertEquals(driver.getCurrentUrl(),"https://jpetstore.aspectran.com/categories/BIRDS");
    }



    @AfterMethod
    public void tearDown() {
        U02_DriverManager.quitDriver();
    }



}
