package Pages;

import Utilities.U01_BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_Item_Page {

    WebDriver driver;

    public P04_Item_Page(WebDriver driver) {
        this.driver = driver;
    }
//TODO: All Locators in the Fish Item Page

    private final By itemImg =By.xpath("//td /img");
    private final By productPage =By.linkText("Return to FI-SW-01");
    private final By addToCartButton= By.xpath("//div /a[@class='button']");
    private final By itemId = By.xpath("//tr /td /strong");



    //TODO: All Actions in the Item Page
    public boolean checkItemImgIsDisplayed(){
        return U01_BaseClass.elementIsDisplayed(driver,itemImg);
    }

    public String getItemId(){
        return U01_BaseClass.getTextFromElement(driver,itemId);
    }

    public void addItemToCart(){
        U01_BaseClass.ClickOnButton(driver,addToCartButton);
    }
    public void navigateToProductPage(){
        U01_BaseClass.ClickOnButton(driver,productPage);
    }








}
