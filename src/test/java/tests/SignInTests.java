package tests;

import models.UserModel;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;


public class SignInTests extends TestBase {
    HomePage homePage;
    @BeforeMethod
    public void pageInit(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.signInBtn();

        homePage.clickOnContinueWithEmail();

    }
    @Test
    public void signInSuccess() {
        homePage.fillSignInForm(UserModel.builder()
                .email("petrkislansky@gmail.com")
                .password("Test123456&")
                .build());
        homePage.signIn();
        homePage.isMyProfileVisible();

    }
  /*  @Test
    public void login(){
        String email = "petrkislansky@gmail.com";
        String password = "Test123456&";
        homePage.fillSignInForm(email, password);
        homePage.signIn();
        homePage.isMyProfileVisible();
    }*/




}

