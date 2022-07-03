package seleniumWebAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumWebAutomation.utilities.Driver;

public class CartPage {
    public CartPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
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
