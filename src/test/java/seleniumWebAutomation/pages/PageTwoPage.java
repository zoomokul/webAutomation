package seleniumWebAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumWebAutomation.utilities.Driver;

import java.util.List;

public class PageTwoPage {
    public PageTwoPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@aria-label='2. sayfa']")
    public WebElement page2;

    @FindBy(xpath = "//li[@class='sc-1nx8ums-0 dyekHG']")
    public List<WebElement> products;
}
