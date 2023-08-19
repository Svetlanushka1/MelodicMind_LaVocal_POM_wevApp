package helpers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;

public class PageHelper {
    protected WebDriver driver;
    public PageHelper(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='nav-icon']")
    WebElement dropDown;
    @FindBy(xpath = "//")
    WebElement messageText;
    @FindBy(xpath = "//")
    WebElement  yesButton;

    protected HomePage clickDropDown(){
        click(dropDown, 5);
        return new HomePage(driver);
    }

    protected void waitUntilElementClickable(WebElement element, int time){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.elementToBeClickable(element));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void waitUntilElementVisible(WebElement element, int time){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOf(element));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void pause(int time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void click(WebElement element, int time){
        waitUntilElementClickable(element, time);
        element.click();
    }
    public void clickWithoutWaiting(WebElement element){
        element.click();
        //element.isSelected();

    }

    public void type(WebElement element, String text, int time){
        click(element, time);
        element.sendKeys(Keys.CONTROL+"a"); //element.clear() doesn't work
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);
    }



    public boolean isElementVisible(WebElement element, int time) {
        try {
            new WebDriverWait(driver,Duration.ofSeconds(time))
                    .until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch (Exception e){
            return false;
        }
    }
  /*  public boolean isErrorMessageTest(String message) {

        should(messageText, 5);
        if (messageText.getText().equals(message)) {
            yesButton.click();
            pause(1000);
            driver.navigate().back();
            return true;
        }
        return false;
    }
    public void should(WebElement element, int time){
        new WebDriverWait(driver,time)
                .until(ExpectedConditions.visibilityOf(element));
    }*/
}


