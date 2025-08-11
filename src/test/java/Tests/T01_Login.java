package Tests;

import Listeners.IInvokedListenerClass;
import Listeners.ITestListenerClass;

import Pages.P01_Login;
import Utilities.U02_DriverManager;
import Utilities.U04_Logs;
import com.google.gson.JsonObject;
import io.qameta.allure.Link;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import testData.DataProvider;


@Listeners({IInvokedListenerClass.class,ITestListenerClass.class})
@Link(name = "Login Page Test Cases", url = "https://docs.google.com/spreadsheets/d/1PaKDKSPb3JA8PZNz61u4CwjPHF61m2OH-8MdLT0VNN8/edit?usp=sharing")
@Parameters({"owner"})
public class T01_Login {
    WebDriver driver;
    P01_Login Login;

    @BeforeMethod
    public void setUp() {
        driver = U02_DriverManager.getDriver(); // Get managed driver
        U04_Logs.info("Driver is opened");
        driver.get(U02_DriverManager.getLoginURL());
        U04_Logs.info("Login page is opened");
        Login = new P01_Login(driver); // Pass driver to page object

    }

    @Test(dataProvider = "loginDataProvider",dataProviderClass = DataProvider.class)
    public void Login_TestCases(JsonObject testData){
        String username = testData.get("username").getAsString();
        String password = testData.get("Password").getAsString();
        String testCaseType = testData.get("testCaseType").getAsString();
        Login.clearInputFields()
             .enterUsername(username)
             .enterPassword(password)
             .clickLoginButton();
        switch (testCaseType){
            case "Valid_Credentials":
                Assert.assertEquals(Login.getWelcomeMessage(),"Welcome Sofia!");
                break;

            case "UpperCase_Credentials":
            case "inValid_Username":
            case "inValid_Password":
            case "Blank_Username":
            case "Blank_Password":
            case "Blank_Credentials":
            case "SQL_Injection":
                Login.scrollToElement();
                Assert.assertEquals(Login.getErrorMessage(),"Invalid username or password. Signon failed.");
                break;

        }

    }

    @Test
    public void Register_Redirection(){
        Login.navigateToRegisterPage();
        Assert.assertEquals(driver.getCurrentUrl(),"https://jpetstore.aspectran.com/account/newAccountForm");
    }

    @Test
    public void Home_Page_Redirection(){
        Login.navigateToHomePage();
        Assert.assertEquals(driver.getCurrentUrl(),"https://jpetstore.aspectran.com/");
    }



    @AfterMethod
    public void tearDown() {
        U02_DriverManager.quitDriver();
    }
}
