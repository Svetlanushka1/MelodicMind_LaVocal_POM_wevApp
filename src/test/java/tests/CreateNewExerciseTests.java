package tests;

import models.UserModel;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ExercisesPage;
import pages.HomePage;


import java.util.Random;

public class CreateNewExerciseTests extends TestBase {
    HomePage homePage;
    ExercisesPage exercisePage;
    int i = new Random().nextInt(1000) + 1000;
    String exerciseName;

 @BeforeMethod
    public void preCondition() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickOnContinueWithEmail();

        homePage.fillSignInForm(UserModel.builder()
                .email("petrkislansky@gmail.com")
                .password("Test123456&")
                .build());
        homePage.signIn();
    }


    @Test
    public void createNewExercise() {
        exerciseName = "test " +i;

        homePage.clickOnExerciseIcon();

        exercisePage = PageFactory.initElements(driver, ExercisesPage.class);

        exercisePage.clickOnNewExercisePlus();
        exercisePage.typeExerciseName(exerciseName);
        logger.info("name of test " + exerciseName);

        exercisePage.selectTrad(0);

        exercisePage.addNotes();
        exercisePage.saveSelect();
        logger.info("Call saveExercise START");
        exercisePage.saveExercise();
        logger.info("Call saveExercise SAVED");
        exercisePage.searchExercise(exerciseName);
        exercisePage.isElementContains("test2","test2");
        exercisePage.startExercise();
    }


}

