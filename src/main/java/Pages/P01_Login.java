package Pages;

import Utilities.U01_BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_Login {
    WebDriver driver;
    public P01_Login(WebDriver driver) {
        this.driver=driver;
    }

    //TODO: All Locators in the Login Page
    //To Enter Login Credentials
    private final By usernameField = By.xpath("//input[@name='username']");
    private final By passwordField = By.xpath("//input[@name='password']");
    private final By LoginButton = By.xpath("//button[text()='Login']");
    private final By welcomeMessage = By.xpath("//div[@id='WelcomeContent']");
    private final By loginFailedMessage = By.xpath("//div[contains(@class, 'failed')]");
    //For Redirection to Register Page
    private final By registerLink = By.linkText("Register Now!");
    //For Redirection to Home Page through logo
    private final By logo = By.xpath("//img[@src='/images/logo-topbar.gif']");


    //TODO: All Actions in the Login Page

    public P01_Login clearInputFields(){
        U01_BaseClass.clearField(driver,usernameField);
        U01_BaseClass.clearField(driver,passwordField);
        return this;
    }
    public P01_Login enterUsername (String username) {
    U01_BaseClass.enterText(driver, usernameField, username);
    return this;
    }
    public P01_Login enterPassword (String passWord){
        U01_BaseClass.enterText(driver,passwordField,passWord);
        return this;
    }
    public P00_Home_Page clickLoginButton(){

        U01_BaseClass.ClickOnButton(driver,LoginButton);
        return new P00_Home_Page(driver);
    }

    public String getWelcomeMessage(){
       return U01_BaseClass.getTextFromElement(driver,welcomeMessage);
    }
    public String getErrorMessage(){
        return U01_BaseClass.getTextFromElement(driver,loginFailedMessage);
    }
    public void scrollToElement(){
            U01_BaseClass.scrollToElement(driver,loginFailedMessage);
    }

    public void navigateToRegisterPage () {
    U01_BaseClass.ClickOnButton(driver,registerLink);
    }
    public void navigateToHomePage () {
        U01_BaseClass.ClickOnButton(driver,logo);
    }




}
