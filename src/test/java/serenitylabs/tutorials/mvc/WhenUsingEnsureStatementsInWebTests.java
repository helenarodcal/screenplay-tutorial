package serenitylabs.tutorials.mvc;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static serenitylabs.tutorials.mvc.pageObjects.TodoPage.NEW_TODO_FIELD;

@RunWith(SerenityRunner.class)
public class WhenUsingEnsureStatementsInWebTests {

    @Managed
    WebDriver driver;

    Actor warren = Actor.named("Warren");

    @Before
    public void setStage() {
        warren.can(BrowseTheWeb.with(driver));
    }

    @Test
    public void weCanMakeAssertionsAboutPageTitles() {

        warren.attemptsTo(
                Open.url("http://todomvc.com"),
                Ensure.thatTheCurrentPage().title().isEqualTo("TodoMVC")
        );
    }

    @Test
    public void weCanCheckThatFieldsAreDisplayed() {
        warren.attemptsTo(
                Open.url("https://todomvc.com/examples/angularjs/#/"),
                Ensure.that(NEW_TODO_FIELD).isDisplayed()
                );
    }

    @Test
    public void weCanReadTheValueOfAField() {
        warren.attemptsTo(
                Open.url("https://todomvc.com/examples/angularjs/#/"),
                Enter.theValue("Walk the dog").into(NEW_TODO_FIELD),
                Ensure.that(NEW_TODO_FIELD).value().isEqualTo("Walk the dog")
        );
    }

    @Test
    public void weCanReadAttributes() {
        warren.attemptsTo(
                Open.url("https://todomvc.com/examples/angularjs/#/"),
                Ensure.that(NEW_TODO_FIELD).attribute("placeholder").isEqualTo("What needs to be done?")
        );
    }
}
