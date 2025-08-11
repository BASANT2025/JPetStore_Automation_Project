package Pages;

import Utilities.U01_BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class P07_Order_Confirmation {
    WebDriver driver;

    public P07_Order_Confirmation(WebDriver driver) {
        this.driver = driver;
    }
    //TODO: All Locators used in the Order Confirmation Page

    private final By confirmButton= By.xpath("//button[contains(text(), 'Confirm')]");
    private final By homePageLink= By.linkText("Return to Main Menu");
    private final By orderDate = By.xpath("//td[text()='Order Date']/following-sibling::td");



    //TODO: All Actions in the Order Confirmation Page
public String checkOrderDate(){
    LocalDate today = LocalDate.now();
    // Format as "yyyy/MM/dd"
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    String currentDate = today.format(formatter);

    return U01_BaseClass.getTextFromElement(driver,orderDate);
}
    public P08_Order_Details confirmOrderDetails(){
        U01_BaseClass.ClickOnButton(driver,confirmButton);
        return new P08_Order_Details(driver);
    }

    public P00_Home_Page returnToHomePage(){
        U01_BaseClass.ClickOnButton(driver,homePageLink);
        return new P00_Home_Page(driver);
    }

}
