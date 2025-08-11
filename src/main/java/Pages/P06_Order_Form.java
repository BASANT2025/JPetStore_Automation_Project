package Pages;

import Utilities.U01_BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class P06_Order_Form {
WebDriver driver;

    public P06_Order_Form(WebDriver driver) {
        this.driver = driver;
    }

    //TODO: All Locators in the Order Form Page
    private final By cardType = By.xpath("//select[@name='cardType']");
    private final By cardNo = By.xpath("//input[@name='creditCard']");
    private final By expDate =By.xpath("//input[@name='expiryDate']");
    private final By firstName =By.xpath("//input[@name='billToFirstName']");
    private final By lastName=By.xpath("//input[@name='billToLastName']");
    private final By address1=By.xpath("//input[@name='billAddress1']");
    private final By address2=By.xpath("//input[@name='billAddress2']");
    private final By cityField=By.xpath("//input[@name='billCity']");
    private final By stateField=By.xpath("//input[@name='billState']");
    private final By zipCode=By.xpath("//input[@name='billZip']");
    private final By countryField=By.xpath("//input[@name='billCountry']");
    private final By checkBox=By.xpath("//input[@type='checkbox']");
    private final By continueButton=By.xpath("//button[@type='button']/preceding-sibling::button[@type='submit']");
    private final By cancelButton=By.linkText("Cancel");
    private final By errorMsg =By.xpath("//span[@class='error-msg']");
    private final By confirmMsg = By.xpath("//div /p[contains(.,'confirm')]");

    //TODO: All Actions in the Order Form Page

    //Clear all Fields
    public P06_Order_Form clearFields(){
        List<WebElement> elements1 = driver.findElements(By.name("creditCard"));
        List<WebElement> elements2 = driver.findElements(By.name("expiryDate"));
        List<WebElement> allElements= new ArrayList<>();
        allElements.addAll(elements1);
        allElements.addAll(elements2);
        for(WebElement element : allElements){
        element.clear();
        }
        return this;
    }
    //Payment Details
    public P06_Order_Form selectCardType(String Type){
        U01_BaseClass.selectDropdownByText(driver,cardType,Type);
        return this;
    }
    public P06_Order_Form enterCardNo(String number){
        U01_BaseClass.clearField(driver,cardNo);
        U01_BaseClass.enterText(driver,cardNo,number);
        return this;
    }
    public P06_Order_Form enterExpDate(String date){
        U01_BaseClass.clearField(driver,expDate);
        U01_BaseClass.enterText(driver,expDate,date);
        return this;
    }
    //Billing Details

    public P06_Order_Form enterFirstName(String first){
        U01_BaseClass.clearField(driver,firstName);
        U01_BaseClass.enterText(driver,firstName,first);
        return this;
    }
    public P06_Order_Form enterLastName(String last){
        U01_BaseClass.clearField(driver,lastName);
        U01_BaseClass.enterText(driver,lastName,last);
        return this;
    }
    public P06_Order_Form enterAddress1(String add1){
        U01_BaseClass.enterText(driver,address1,add1);
        return this;
    }

    public P06_Order_Form enterAddress2(String add2){
        U01_BaseClass.enterText(driver,address2,add2);
        return this;
    }

    public P06_Order_Form enterCity(String city){
        U01_BaseClass.enterText(driver,cityField,city);
        return this;
    }

    public P06_Order_Form enterState(String state){
        U01_BaseClass.enterText(driver,stateField,state);
        return this;
    }

    public P06_Order_Form enterZip(String zip){
        U01_BaseClass.enterText(driver,zipCode,zip);
        return this;
    }

    public P06_Order_Form enterCountry(String country){
        U01_BaseClass.enterText(driver,countryField,country);
        return this;
    }

    public P06_Order_Form checkShipToDifferentAddress(){
        U01_BaseClass.ClickOnButton(driver,checkBox);
        return this;
    }
    //Buttons

    public P07_Order_Confirmation confirmOrder(){
        U01_BaseClass.ClickOnButton(driver,continueButton);
    return new P07_Order_Confirmation(driver);
    }

    public P05_View_Cart cancelOrder(){
        U01_BaseClass.ClickOnButton(driver,cancelButton);
    return new P05_View_Cart(driver);
    }

    public boolean errorMessageIsDisplayed(){
        return U01_BaseClass.elementIsDisplayed(driver,errorMsg);
    }

    public boolean confirmMessageIsDisplayed(){
        return U01_BaseClass.elementIsDisplayed(driver,confirmMsg);
    }

}
