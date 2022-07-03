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

    @FindBy(xpath = "//a[@aria-label='2. sayfa']")
    public WebElement page2;

    @FindBy(xpath = "//li[@class='sc-1nx8ums-0 dyekHG']")
    public List<WebElement> products;

    @FindBy(xpath = "//h1[@id='sp-title']")
    public WebElement productInfo;

    @FindBy(xpath = "(//span[@id='sp-price-highPrice'])[1]")
    public WebElement productPrice;
    @FindBy(xpath = "//button[@id='add-to-basket']")
    public WebElement addCart;

    @FindBy(xpath = "(//a[@rel='nofollow'])[6]")
    public WebElement clickCart;

    @FindBy(xpath = "//p[@class='new-price']")
    public WebElement cartPrice;

    @FindBy(xpath = "//p[@class='count-desc']")
    public WebElement productInfoInCart;

    @FindBy(xpath = "//select[@class='amount']")
    public WebElement productInDropDown;

    @FindBy(xpath = "(//i[@class='gg-icon gg-icon-bin-medium'])[1]")
    public WebElement clearCart;

    @FindBy(xpath = "(//h2)[1]")
    public WebElement cartStatus;

}
