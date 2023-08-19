package tests;

import models.UserModel;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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

        homePage.rectangleSignInTab();
        homePage.fillSignInForm(UserModel.builder()
                .email("petrkislansky@gmail.com")
                .password("Test123456&")
                .build());
        homePage.submitSignIn();

        Assert.assertTrue(homePage.isSignedIn());

      //  Assert.assertTrue(homePage.isSignedIn() == false);
       // Assert.assertNotSame(homePage.isSignedIn(),"You are not signed in.");


    }
    @Test
    public void logout(){
        homePage.openProfileToolbar();
        homePage.clickOnLogOutBtn();
        homePage.logoutYes();

    }

}

