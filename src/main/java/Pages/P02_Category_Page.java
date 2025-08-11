package Pages;

import Utilities.U01_BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_Category_Page {
    WebDriver driver;

    public P02_Category_Page(WebDriver driver) {
        this.driver=driver;
    }


    //TODO: All Locators in the Fish Category Page

    private final By pageTitle = By.xpath("//div /h3");
    private final By productIdList = By.xpath("//tbody /tr /th[.='Product ID']");
    private final By productNameList = By.xpath("//tbody /tr /th[.='Name']");
    private final By logo = By.xpath("//img[@src='/images/logo-topbar.gif']");
    private final By returnToMainMenu = By.linkText("Return to Main Menu");
    private final By productId = By.linkText("FI-SW-01");


    //TODO: All Actions in the Category Page



    public P03_Product_Page navigateToProductPage () {
        U01_BaseClass.ClickOnButton(driver,productId);
        return new P03_Product_Page(driver);
    }
    public String pageTitle(){
        return driver.findElement(pageTitle).getText();
    }
    public boolean productIdList(){
        return driver.findElement(productIdList).isDisplayed();
    }
    public boolean productNameList(){
        return driver.findElement(productNameList).isDisplayed();
    }

    public void navigateToHomePage () {
        U01_BaseClass.ClickOnButton(driver,logo);
    }

    public void redirectionToMainMenu () {
        U01_BaseClass.ClickOnButton(driver,returnToMainMenu);
    }




}