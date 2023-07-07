package pages;

import helpers.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;


public class ExercisesPage extends PageHelper {
    public ExercisesPage(WebDriver driver) {
        super(driver);
    }

    Logger logger = LoggerFactory.getLogger(ExercisesPage.class);

    //@FindBy(xpath = "//button[@class='app-btn outlined small text-black']")
    @FindBy(xpath = "//span[@class='text-white']")
    WebElement newExercisePlus;
    @FindBy(xpath = "//input[@placeholder='Exercise name']")
    WebElement exerciseNameInput;

    ///     Select triad
    //@FindBy(css = ".q-icon.notranslate.material-icons.q-btn-dropdown__arrow.q-btn-dropdown__arrow-container")

    //////
    @FindBy(xpath = "//span[@class='block']")
    WebElement majorTriadScroll;
    @FindBy(css = "body > div:nth-child(7) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3)")
    WebElement selectTrio;
    @FindBy(xpath = "//div[@role='menu']")
    WebElement triadMenu;
    @FindBy(xpath = "//div[contains(text(),'Perfect Fifth')]")
    WebElement perfectFifth;
    @FindBy(xpath = "//div[contains(text(),'Minor Triad')]")
    WebElement minorTriad;
    @FindBy(css = "body > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1)")
    WebElement majorTriad;

    //@FindBy(css = "body > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1)")
    @FindBy(xpath = "//body/div/div[@role='menu']/div[@class='q-list q-list--dark']/div[1]")
    WebElement unison;
    ////////////////////////////////////////////////////////////////////////////////////////////////
    @FindBy(xpath = "//div[@class='harmony']//div//span[@class='q-btn__content text-center col items-center q-anchor--skip justify-center row']")
    WebElement repeatSound;

    //*************   Add Notes   ***************************************************************
    // @FindBy(css = ".outlined.inline-block.text-weight-bold.text-body1")
    @FindBy(xpath = "//button[@class='app-btn plain medium text-black']")
    WebElement addNotesBtn;
    // @FindBy(xpath = "//body/div[@id='q-portal--dialog--7']/div[@role='dialog']/div/div/div/div/div[3]/div[1]/div[1]/div[1]/div[1]")
    // WebElement selectLeftNote;
    @FindBy(css = "div[class='text-center'] button:nth-child(1) div:nth-child(1)")
    WebElement addRest;

    @FindBy(css = ".full-width.text-black.text-center")
    WebElement moreInfo;

    @FindBy(xpath = "//div[@class='row text-center q-pt-md']//button[@class='app-btn primary medium text-black']")
    WebElement previewBtn;
    @FindBy(xpath = "//div[@class='col']//button[@class='app-btn primary medium text-black']//div[@class='app-btn__content']")
    WebElement saveSaveBtn;

    //**********************    Piano ************************************
    @FindBy(css = ".white")//27 elements
            WebElement pianoWhite;
    @FindBy(css = ".black")
    WebElement pianoBlack;


    @FindBy(css = "body > div:nth-child(7) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")
    WebElement css2;
    @FindBy(css = "div[class='piano row no-wrap overflow-auto'] div:nth-child(1) div:nth-child(1) div:nth-child(1) div:nth-child(1)")
    WebElement css1;

    @FindBy(css = "div[class='row text-center q-pt-md'] button[class='app-btn secondary medium text-black']")
    WebElement saveCreatedPattern;
    //scrollDown

    @FindBy(css = "div[class='col'] button[class='app-btn secondary medium text-black']")
    WebElement preview_Stop_NewExerciseBtn;
    @FindBy(css = "div[class='col'] button[class='app-btn primary medium text-black']")
    WebElement saveNewExerciseBtn;

    @FindBy(css = "div[class='row text-center q-pt-md'] button[class='app-btn secondary medium text-black'] div[class='app-btn__content']")
    WebElement saveSelectBtn;//div[@class='col']//button[@class='app-btn primary medium text-black']
    @FindBy(css = "button[class='app-btn primary medium text-black'] div[class='app-btn__content']")
    WebElement saveExerciseBtn;

    //**********************************************************************
    @FindBy(xpath = "//div[normalize-space()='Change']")//div[@class='q-gutter-y-md']//button[1]//div[1]
            WebElement changeBtn;
    @FindBy(xpath = "//div[normalize-space()='Edit']")//div[@class='create-exercise-section']//button[1]
    WebElement editBtn;
    @FindBy(xpath = "//i[normalize-space()='close']")
    WebElement closeBtn;
    @FindBy(xpath = "//input[@aria-label='Search']")
    WebElement searchBtn;
    @FindBy(xpath = "//h6")
    WebElement containsExerciseName;


    @FindBy(xpath = "//div[@class='app-btn__content'][normalize-space()='Start']")
    WebElement startBtn;
    @FindBy(xpath = "//i[normalize-space()='more_vert']")
    WebElement moreOptions;
    @FindBy(xpath = "//div[contains(text(),'Delete')]")
    WebElement deleteBtn;
    @FindBy(xpath = "//div[@class='col']//button[@class='app-btn secondary medium text-black']")
    WebElement sureDelete;
    @FindBy(css = ".col.text-h5")
    WebElement nothingFound;


    public void clickOnNewExercisePlus() {
        click(newExercisePlus, 2);
    }

    public void typeExerciseName(String text) {
        type(exerciseNameInput, text, 5);
    }

    public void selectTrad(int label) {
        click(majorTriadScroll, 5);

        Rectangle menuRect = triadMenu.getRect();
        int x = menuRect.getX() + menuRect.getWidth() / 2;
        int step = menuRect.getHeight() / 8;
        int y = menuRect.getY() + step;
        Actions actions = new Actions(driver);
/*
        for( ;y < (menuRect.getY() + menuRect.getHeight()); y += step){
            //click(x, y);

            click(majorTriadScroll, 5);

            actions.moveByOffset(x, y).click();
            actions.build().perform();

            //String selectedText = actions.getSelectedText().toString();

            click(perfectFifth,2);
            //click(minorTriad,2);
        }*/


        switch (label) {
            case 0:
                click(unison, 2);
                break;
            case 1:
                click(majorTriad, 2);
                break;
            case 2:
                click(minorTriad, 2);
                break;
            case 3:
                click(perfectFifth, 2);
                break;
            //
        }
    }


    public void select(By locator, String option) {
        new Select(driver.findElement(locator)).selectByValue(option);
    }

    public void addNotes() {
        click(addNotesBtn, 2);
        click(css1, 2);
        click(css2, 2);

    }


    public void previewBtn() {
        click(previewBtn, 2);
    }

    public void saveSelect() {
        click(saveSelectBtn, 2);

    }

    public void saveExercise() {
        try {
            logger.info("saveExercise START");
            click(saveSaveBtn, 3);
            logger.info("saveExercise END OF CLICK");
        }catch(Exception e){
            String msg = e.getMessage();
        }
    }

    public void searchExercise(String name) {

        type(searchBtn, name, 3);

    }

    public void isElementContains(String name1, String name2) {

        Assert.assertEquals(name1, name2);
    }

    public void startExercise() {
        click(startBtn, 5);
    }


    public void moveToLeft() {

    }

    public void closeBtn() {
        click(closeBtn, 2);
    }

    public void scrollingListTriad() {
        click(majorTriadScroll, 5);

    }

    public void deleteExercise() {
        click(deleteBtn, 5);
        click(sureDelete, 5);
        Assert.assertTrue(isElementVisible(nothingFound, 2));
    }


}


