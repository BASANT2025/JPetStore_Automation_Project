package Pages;

import Utilities.U01_BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P00_Home_Page {
    WebDriver driver;
    // Passes driver to BaseClass
    public P00_Home_Page(WebDriver driver) {
        this.driver=driver;
    }


    //TODO: All Locators in the Home Page
    //For Sign Up Redirection
    private final By signUpLink= By.linkText("Sign Up");
    //For Sign in Redirection
    private final By signInLink= By.linkText("Sign In");
    //For Search Function
    private final By searchBar= By.xpath("//input[@placeholder='Product Search']");
    private final By searchButton= By.xpath("//button[.='Search']");
    private final By searchResult = By.xpath("//div /h3");
    //For Redirections Links
    private final By GitHubLink =By.linkText("GitHub");
    private final By ContactUsLink=By.linkText("Contact Us");
    private final By FAQLink=By.linkText("FAQ");
    //For Categories Redirections
    private final By FishCategory =By.linkText("Fish");
    private final By DogsCategory=By.linkText("Dogs");
    private final By ReptilesCategory=By.linkText("Reptiles");
    private final By CatsCategory=By.linkText("Cats");
    private final By BirdsCategory=By.linkText("Birds");

    //TODO: All Actions in the Home Page

    public void navigateToSignUp (){
        U01_BaseClass.ClickOnButton(driver,signUpLink);
    }
    public void navigateToSignIn (){
        U01_BaseClass.ClickOnButton(driver,signInLink);
    }

    public P00_Home_Page enterSearchKeyword (String keyword){
        U01_BaseClass.enterText(driver,searchBar,keyword);
        return this;
    }
    public void clickSearchButton (){
        U01_BaseClass.ClickOnButton(driver,searchButton);
    }

    public boolean researchResultMessage(){
      return   U01_BaseClass.elementIsDisplayed(driver,searchResult);
    }

    public void navigateToGitHub(){
        U01_BaseClass.ClickOnButton(driver,GitHubLink);
    }

    public void switchToNewTab(WebDriver driver){
        U01_BaseClass.switchToNewTab(driver);
    }
    public void navigateToContactUs(){
        U01_BaseClass.ClickOnButton(driver,ContactUsLink);
    }
    public void navigateToFAQ(){
        U01_BaseClass.ClickOnButton(driver,FAQLink);
    }

    public P02_Category_Page navigateToFishCategory(){

        U01_BaseClass.ClickOnButton(driver,FishCategory);
        return new P02_Category_Page(driver);
    }
    public void navigateToDogsCategory(){
        U01_BaseClass.ClickOnButton(driver,DogsCategory);
    }
    public void navigateToReptilesCategory(){
        U01_BaseClass.ClickOnButton(driver,ReptilesCategory);
    }
    public void navigateToCatsCategory(){
        U01_BaseClass.ClickOnButton(driver,CatsCategory);
    }
    public void navigateToBirdsCategory(){
        U01_BaseClass.ClickOnButton(driver,BirdsCategory);
    }

}
