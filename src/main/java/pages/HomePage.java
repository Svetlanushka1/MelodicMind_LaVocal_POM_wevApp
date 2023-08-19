package pages;

import helpers.PageHelper;
import interfaces.HomePageElements;
import models.UserModel;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageHelper implements HomePageElements {
    // Logger logger = LoggerFactory.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //     signIn
    @FindBy(xpath = "//span[normalize-space()='Sign in/up']")
    WebElement signInUpBtn;
    @FindBy(xpath = "//span[contains(text(),'Continue with Email')]")
    WebElement continueWithEmailBtn;
    @FindBy(css = "div[class='q-tab relative-position self-stretch flex flex-center text-center q-tab--active q-tab--no-caps q-focusable q-hoverable cursor-pointer'] div[class='q-tab__label']")
    WebElement signInTab;
    @FindBy(xpath = "//input[@aria-label='Email']")
    //@FindBy(tagName = "input")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@aria-label='Password']")
    WebElement inputPassword;
    @FindBy(css = "button[class='app-btn primary medium text- q-mt-md full-width'] div[class='app-btn__content']")
    WebElement submitSignInBnt;

    /////// check your Account /////////

    @FindBy(css = "header[class='q-header q-layout__section--marginal fixed-top bg-dark'] button:nth-child(1) span:nth-child(2)")
    WebElement menuToolBar;
    @FindBy(xpath = "//div[contains(text(),'You are not signed in.')]")
    WebElement notSignIn;//You are not signed in.



    //////// log out ///////////

    @FindBy(css = "button:nth-child(3) span:nth-child(2)")
    WebElement profileToolBar;

    @FindBy(css = "button:nth-child(1) span:nth-child(2)")
    WebElement accountToolBar;//?????????
    @FindBy(xpath = "//div[contains(text(),'Logout')]")
    WebElement logoutBtn;
    @FindBy(xpath = "//div[@class='app-btn__content'][normalize-space()='Yes']")
    WebElement logoutYes;


    ////// sections: ////

    @FindBy(linkText = "//div[@class='col'][normalize-space()='Exercises']")
    WebElement exercisesIcon;//Exercises


   /* public HomePage(String browser) {
        properties = new Properties();
        this.browser = browser;
    }*/
//==================================================   methods ======================================
// sign in:
    public void signInBtn() {
        click(signInUpBtn, 5);
    }

    public void clickOnContinueWithEmail() {
        click(continueWithEmailBtn, 3);

    }

    public void fillSignInForm(UserModel user) {
        type(inputEmail, user.getEmail(), 2);
        type(inputPassword, user.getPassword(), 2);

    }

    public void submitSignIn() {
        click(submitSignInBnt, 10);
        //click(By.xpath("//div[contains(text(),'Sign in')]"));
        // click(By.cssSelector("button[type='button'] div[class='app-btn__content'] span"));// = I forgot  my password
        // click(By.cssSelector(".text-weight-medium.text-subtitle1")); // = Use other method

    }

    public void openMenuBar() {

        click(menuToolBar, 5);
    }

    public boolean isSignedIn() {
          if (notSignIn.isDisplayed())
            return false;
        return true;
    }
////////// icons: ////////////
    public void clickOnExerciseIcon() {
        //waitUntilElementVisible(exercisesIcon,8);
        click(exercisesIcon, 10);
    }
    //// log out ////
    public void openProfileToolbar() {
        click(profileToolBar, 10);
    }

    public void clickOnLogOutBtn() {
         click(logoutBtn, 2);
    }
    public void logoutYes(){
        //alert :  Are you sure?  - yesBtn = //div[@class='app-btn__content'][normalize-space()='Yes']
        click(logoutYes, 3);
    }

/////////      ///////////////////////////////////////////////////////
    public void signInFast() {
        signInBtn();
        clickOnContinueWithEmail();
        rectangleSignInTab();
        click(signInTab,3);
        type(inputEmail, "", 2);
        type(inputPassword, "", 5);
        click(submitSignInBnt, 3);

    }

    public void rectangleSignInTab() {

        // variant 1:
        //click(By.cssSelector("input[aria-label='Email']"));
        // variant 2:
        //  JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("document.querySelector('input[aria-label='Email']').click();");
        // variant 3:
        Rectangle rect = driver.findElement(By.cssSelector("div[role='tablist']"))
                .getRect();
        int x = rect.getX() + 1/4 * rect.getWidth();
        int y = rect.getY() + 1/2 * rect.getHeight();
        Actions actions = new Actions(driver);
        actions.moveByOffset(x, y).click().perform();
        click(signInTab,3);
    }


}


