package seleniumWebAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import seleniumWebAutomation.utilities.Driver;

import java.util.List;


public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//div[@class='wis_clsbtn']")
    public WebElement alert;

    @FindBy(xpath = "//a[@class='tyj39b-5 lfsBU']")
    public WebElement acceptCookies;

    @FindBy(xpath = "//input[@name='k']")
    public WebElement searchPlaceholder;

}
