package seleniumWebAutomation.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import seleniumWebAutomation.pages.CartPage;
import seleniumWebAutomation.pages.HomePage;
import seleniumWebAutomation.pages.PageTwoPage;
import seleniumWebAutomation.pages.ProductPage;
import seleniumWebAutomation.utilities.ConfigReader;
import seleniumWebAutomation.utilities.Driver;
import seleniumWebAutomation.utilities.LoggerHelper;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class PageStepDefinitions {
    HomePage homePage=new HomePage();
    PageTwoPage pageTwoPage=new PageTwoPage();
    ProductPage productPage=new ProductPage();
    CartPage cartPage=new CartPage();
    public static String price="";
    Logger log = LoggerHelper.getLogger(PageStepDefinitions.class);


    @Given("open web page")
    public void openWebPage() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        homePage.alert.click();
        homePage.acceptCookies.click();
        log.info("www.gittigidiyor.com sitesi açılır.");

    }

    @When("search computer on search box")
    public void searchComputerOnSearchBox() {
        homePage.searchPlaceholder.sendKeys("bilgisayar"+Keys.ENTER);
        log.info("Arama kutucuğuna bilgisayar kelimesi girilir.");
    }

    @Then("open page two")
    public void openPageTwo() {
        pageTwoPage.page2.click();
        log.info("Arama sonuçları sayfasından 2.sayfa açılır.");
    }

    @And("check whether page two open or not")
    public void checkWhetherPageTwoOpenOrNot() {
        Assert.assertEquals(ConfigReader.getProperty("page_two"),Driver.getDriver().getCurrentUrl());
        log.info("2.sayfanın açıldığı kontrol edilir.");
    }

    @And("choose a rondom product from results")
    public void chooseARondomProductFromResults() {
        Random random=new Random();



        Driver.getDriver().navigate().refresh();
        Driver.getDriver().findElement(By.xpath("(//h2)["+random.nextInt(pageTwoPage.products.size())+"]")).click();
        log.info("Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.");
    }

    @And("write product info and price to file")
    public void writeProductInfoAndPriceToFile() throws IOException {

        price=productPage.productPrice.getText();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        FileWriter fWriter = new FileWriter("product.txt",true);
        fWriter.write(formatter.format(date)+" : ");
        fWriter.write(productPage.productInfo.getText()+" : ");
        fWriter.write(productPage.productPrice.getText()+"\n");
        fWriter.write("----------------------------------------"+"\n");
        fWriter.close();
        log.info("Seçilen ürünün ürün bilgisi ve tutar bilgisi txt dosyasına yazılır.");

    }

    @And("add product to cart")
    public void addProductToCart() throws InterruptedException {
        productPage.addCart.click();
        Thread.sleep(5000);
        log.info("Seçilen ürün sepete eklenir.");
    }

    @Then("compare cart and product page  price")
    public void compareCartAndProductPagePrice() {
        productPage.clickCart.click();
        Assert.assertEquals(price,cartPage.cartPrice.getText());
        log.info("Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.");

    }

    @And("increase the product quantity and verify that it is two")
    public void increaseTheProductQuantityAndVerifyThatItIsTwo() {
        Select select=new Select(cartPage.productInDropDown);
        select.selectByVisibleText("2");
        Assert.assertEquals("2",select.getFirstSelectedOption().getText());
        log.info("Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.");


    }

    @Then("delete product and check cart is empty or not")
    public void deleteProductAndCheckCartIsEmptyOrNot() throws InterruptedException {
        cartPage.clearCart.click();
        Thread.sleep(5000);
        Assert.assertEquals("Sepetinizde ürün bulunmamaktadır.",cartPage.cartStatus.getText());
        log.info("Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.");
    }
}
