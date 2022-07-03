package seleniumWebAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumWebAutomation.utilities.Driver;

public class ProductPage {
    public ProductPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h1[@id='sp-title']")
    public WebElement productInfo;

    @FindBy(xpath = "(//span[@id='sp-price-highPrice'])[1]")
    public WebElement productPrice;
    @FindBy(xpath = "//button[@id='add-to-basket']")
    public WebElement addCart;

    @FindBy(xpath = "(//a[@rel='nofollow'])[6]")
    public WebElement clickCart;
}
