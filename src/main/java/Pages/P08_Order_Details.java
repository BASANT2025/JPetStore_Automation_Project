package Pages;

import Utilities.U01_BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P08_Order_Details {
    WebDriver driver;

    public P08_Order_Details(WebDriver driver) {
        this.driver = driver;
    }
    //TODO: All Locators used in the Order Details Page
    private final By confirmationMessage= By.xpath("//div /p[contains(.,'Thank')]");
    private final By deleteOrder= By.xpath("//button[contains(.,'Delete')]");

    //TODO: All Actions in the Order Details Page
    public boolean checkConfirmationMessage(){
        return U01_BaseClass.elementIsDisplayed(driver,confirmationMessage);
    }

    public void deleteOrder(){
        U01_BaseClass.ClickOnButton(driver,deleteOrder);
    }

    public void orderList(){
        driver.getCurrentUrl();
    }



}
