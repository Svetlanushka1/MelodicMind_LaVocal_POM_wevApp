package pages;

import helpers.PageHelper;
import models.UserModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageHelper {
    // Logger logger = LoggerFactory.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[normalize-space()='Sign in/up']")
    WebElement signInBtn;
    @FindBy(xpath = "//span[contains(text(),'Continue with Email')]")
    WebElement continueWithEmailBtn;
    @FindBy(xpath = "//div[@role='listitem']//div[@class='q-focus-helper']")
    WebElement logout;
    @FindBy(xpath = "//div[@class='app-btn__content'][normalize-space()='Yes']")
    WebElement logoutYes;
    @FindBy(xpath = "//input[@aria-label='Email']")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@aria-label='Password']")
    WebElement inputPassword;
    @FindBy(css = "button[class='app-btn primary medium text- q-mt-md full-width'] div[class='app-btn__content']")
    WebElement signIn;
    @FindBy(xpath = "//i[normalize-space()='person']")

    WebElement yourProfileBnt;
    // @FindBy(css = "div[class='main-btns row'] div:nth-child(1) button:nth-child(1) div:nth-child(2) div:nth-child(1)")
    @FindBy(linkText = "//div[@class='col'][normalize-space()='Exercises']")
    WebElement exercisesIcon;//Exercises


   /* public HomePage(String browser) {
        properties = new Properties();
        this.browser = browser;
    }*/

    public void signInBtn(){
        click(signInBtn,5);
    }
    public void clickOnContinueWithEmail() {
        click(continueWithEmailBtn,3);

    }

    public void logout() {
        click(logout,2);
        click(logoutYes,3);
    }
    public void fillSignInForm(String email, String password) {
        type(inputEmail,"",2);
        type(inputPassword,"",5);
    }
    public void fillSignInForm(UserModel user) {
        type(inputEmail, user.getEmail(), 2);
        type(inputPassword, user.getPassword(),2);
    }
    public void signIn(){
        click(signIn,10);
        //logger.info("user signed in");
    }


    public void isMyProfileVisible() {
        click(yourProfileBnt,3);
        // logger.info("Profile btn is present");

    }
    /* private boolean isMyProfileVisible(WebElement yourProfileBnt) {

         return yourProfileBnt.isDisplayed();

     }*/
    public void clickOnExerciseIcon(){
        //waitUntilElementVisible(exercisesIcon,8);
        click(exercisesIcon,10);
    }
}
