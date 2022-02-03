package serenitylabs.tutorials.mvc.pageObjects;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TodoPage {
//    public static final By NEW_TODO_FIELD = By.cssSelector(".new-tod");
    public static final Target NEW_TODO_FIELD
        = Target.the("new todo field").located(By.cssSelector(".new-todo"));
}
