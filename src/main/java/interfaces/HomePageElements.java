package interfaces;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public interface HomePageElements {
    String menuBtn = "//button[1]//span[2]";
    String homeBtn = "//div[normalize-space()='Home']";
    String exercisesBtn = "//div[@class='q-item__section column q-item__section--main justify-center'][normalize-space()='Exercises']";
    String workoutsBtn = "//div[@class='q-item__section column q-item__section--main justify-center'][normalize-space()='Workouts']";
    String songBtn = "//div[@class='q-item__section column q-item__section--main justify-center'][normalize-space()='Songs']";
    String recorderBtn = "//div[@class='q-item__section column q-item__section--main justify-center'][normalize-space()='Recorder']";
    String accountBtn = "//div[normalize-space()='Account']";

}
