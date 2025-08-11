package Pages;

import Utilities.U01_BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_View_Cart {
    WebDriver driver;
    public P05_View_Cart(WebDriver driver) {
        this.driver=driver;
    }

    //TODO: All Locators in the Cart Page
    private final By totalPrice = By.xpath("//tbody /tr /td[7]");
    private final By productPrice = By.xpath("//tbody /tr /td[6]");
    private final By productId = By.xpath("//tbody//tr//td[2]");
    private final By remove = By.linkText("Remove");
    private final By quantity = By.xpath("//td /input");
    private final By updateCart = By.xpath("//td /button");
    private final By returnToMainMenu = By.linkText("Return to Main Menu");
    private final By checkout =By.linkText("Proceed to Checkout");
    private final By emptyCart= By.xpath("//tbody /tr /td[.='Your cart is empty.']");
    //TODO: All Actions in the Cart Page
public P05_View_Cart changeQuantity(String newQuantity){
    U01_BaseClass.clearField(driver,quantity);
    U01_BaseClass.enterText(driver,quantity,newQuantity);
    return new P05_View_Cart(driver);
}
public void updateCart(){
    U01_BaseClass.ClickOnButton(driver,updateCart);
    U01_BaseClass.waitForVisibility(driver,quantity,4);
}
public String getQuantity(){
       return U01_BaseClass.getValue(driver,quantity);
}


public void removeProduct(){
    U01_BaseClass.ClickOnButton(driver,remove);
}
public boolean emptyCartMessage(){
    return U01_BaseClass.getTextFromElement(driver,emptyCart).equalsIgnoreCase("Your cart is empty.");
}

public String getTotalPrice(){
    return U01_BaseClass.getTextFromElement(driver,totalPrice);
}
public String getProductPrice(){
    return U01_BaseClass.getTextFromElement(driver,productPrice);
}
public String getProductId(){
    return U01_BaseClass.getTextFromElement(driver,productId);
}
public void ReturnToMainMenu (){
    U01_BaseClass.ClickOnButton(driver,returnToMainMenu);
}
public P06_Order_Form proceedToCheckOut(){
    U01_BaseClass.ClickOnButton(driver,checkout);
    return new P06_Order_Form(driver);
}

}
