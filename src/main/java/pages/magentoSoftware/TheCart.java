package pages.magentoSoftware;

import engine.ActionBot;
import engine.PropertiesReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

public class TheCart extends Pages{

    private final String url = PropertiesReader.props.getProperty("baseUrlSoft")+"men/tops-men/jackets-men.html";

    private By itemSizeButton = By.xpath("(//div[@id='option-label-size-143-item-169'])[4]");
    private By itemColorButton = By.xpath("(//div[@id='option-label-color-93-item-53'])[3]");
    private By carButton = By.xpath("(//button[contains(@class,'tocart')])[4]");
    private By carItem = By.className("message-success");
    private By nameLabel = By.xpath("(//a[@href='https://magento.softwaretestingboard.com/typhon-performance-fleece-lined-jacket.html'])[4]");
    private By sizeLabel = By.xpath("(//dl/dd)[5]");
    private By colorLabel = By.xpath("(//dl/dd)[6]");
    private By deleteButton = By.className("action-delete");
    private By deleteLabel = By.xpath("(//p)[3]");
    public TheCart(WebDriver driver, ActionBot bot) {
        super(driver, bot);
    }

    @Step("Navigate to Men>Tops>Jackets")
    public TheCart goTo() {
        bot.navigate(url);
        return this;
    }
    @Step("Navigate to the cart")
    public void goToCart(){
        bot.navigate(PropertiesReader.props.getProperty("baseUrlSoft")+"checkout/cart/");
    }
    @Step("Add an item to the cart")
    public String [] addToCar(){
        for (By by : Arrays.asList(itemSizeButton,itemColorButton, carButton)) bot.click(by);
        String massage = bot.getText(carItem);
        goToCart();
        return new String[]{massage,bot.getText(nameLabel), bot.getText(sizeLabel),bot.getText(colorLabel)};
    }
    @Step("Delete an item from the cart")
    public String deleteItem(){
        goToCart();
        bot.click(deleteButton);
        return bot.getText(deleteLabel);

    }
}
