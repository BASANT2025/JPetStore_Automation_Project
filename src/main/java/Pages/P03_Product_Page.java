package Pages;

import Utilities.U01_BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_Product_Page {
    WebDriver driver;

    public P03_Product_Page(WebDriver driver) {
        this.driver=driver;
    }




    //TODO: All Locators in the Fish Category Page
    private final By productId = By.xpath("//tbody /tr /td[2]");
    private final By add1stItemToCart = By.xpath("//tbody /tr /td /a[@class='button'][1]");
    private final By price = By.xpath("//tbody /tr /td[4]");
    private final By categoryPageLink = By.linkText("Return to FISH");

    //TODO: All Actions in the Category Page

    public String getProductId (){
       return U01_BaseClass.getTextFromElement(driver,productId);
    }
    public P05_View_Cart addItemToCart(){
            U01_BaseClass.ClickOnButton(driver,add1stItemToCart);
            return new P05_View_Cart(driver);
    }
    public String getItemPrice(){
        return U01_BaseClass.getTextFromElement(driver,price);
    }
    public void navigateToCategoryPage(){
        U01_BaseClass.ClickOnButton(driver,categoryPageLink);
    }

}
