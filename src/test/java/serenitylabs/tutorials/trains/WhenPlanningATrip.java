package serenitylabs.tutorials.trains;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenitylabs.tutorials.trains.ui.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;
import static org.openqa.selenium.Keys.ENTER;
import static serenitylabs.tutorials.trains.ui.MenuBar.HELP_AND_CONTACTS;
import static serenitylabs.tutorials.trains.ui.MenuBar.STATUS_UPDATES;

@RunWith(SerenityRunner.class)
public class WhenPlanningATrip {

    @Managed
    WebDriver browser;

    Actor carrie = Actor.named("Carrie");

    @Before
    public void setTheStage() {
        carrie.can(BrowseTheWeb.with(browser));
    }

    @Test
    public void the_TFL_page_title_should_be_visible() {

        carrie.attemptsTo(
//                Open.url("https://tfl.gov.uk")
                Open.browserOn().the(TFLHomePage.class)
        );

        carrie.should(seeThat(TheWebPage.title(), containsString("Transport for London")));
    }

    @Test
    public void the_status_updates_page_title_should_be_visible() {
        carrie.attemptsTo(
                Open.url("https://tfl.gov.uk/tube-dlr-overground/status/")
        );

        carrie.should(seeThat(TheWebPage.title(), containsString("status updates")));
    }

    @Test
    public void should_be_able_to_search_for_station_details() {
        carrie.attemptsTo(
                Open.browserOn().the(TFLHomePage.class),
                Enter.theValue("Waterloo").into(TFLHomePage.SEARCH).thenHit(ENTER)
        );

        carrie.should(seeThat(
                TheTarget.textOf(SearchResultsPage.SEARCH_RESULTS_HEADING), equalTo("Search: Waterloo")
        ));

    }

    @Test
    public void should_list_all_relevant_station_information() {
        carrie.attemptsTo(
                Open.browserOn().the(TFLHomePage.class),
                Enter.theValue("Jubilee").into(TFLHomePage.SEARCH).thenHit(ENTER)
        );

        //check first title contains searched string
        carrie.should(seeThat(
                TheTarget.textOf(SearchResultsPage.ARTICLE_HEADINGS), containsString("Jubilee")
        ));
        //check all descriptions contain searched string
        carrie.should(seeThat(
                TheTarget.textValuesOf(SearchResultsPage.ARTICLE_ABSTRACTS), everyItem(containsString("Jubilee"))
        ));

    }

    @Test
    public void should_see_status_updates() {
        carrie.attemptsTo(
                Open.browserOn().the(TFLHomePage.class),
                CookiesSettings.acceptAll(),
                Click.on(STATUS_UPDATES.menuOption())
        );

//        WebDriverManager.chromedriver().setup();
//        ChromeDriver driver = new ChromeDriver();
//        driver.navigate().to("https://tfl.gov.uk");
//        driver.findElement(By.linkText("Status updates")).click();
//        String disruptionText = driver.findElement(By.cssSelector(".service-name.northern + .disruption-summary")).getText();
//
//        System.out.println(disruptionText);
        carrie.should(seeThat(
                TheTarget.textValuesOf(StatusUpdatesPage.SERVICE_LINES), hasItems("Bakerloo", "Circle", "District")
        ));

    }

    @Test
    public void should_be_able_to_contact_tfl() {
        //GIVEN
        carrie.attemptsTo(
                Open.browserOn().the(TFLHomePage.class),
                CookiesSettings.acceptAll(),
                Click.on(HELP_AND_CONTACTS.menuOption()),
                Click.on(HelpAndContacts.AboutOyster.TFLApp)
        );

        //WHEN
        carrie.attemptsTo(
                SelectFromOptions.byVisibleText("Mrs").from(ContactForm.TITLE),
                Enter.theValue("Sarah-Jane").into(ContactForm.FIRST_NAME),
                Enter.theValue("Smith").into(ContactForm.LAST_NAME)
        );

        //THEN
        carrie.should(
                seeThat(TheTarget.selectedValueOf(ContactForm.TITLE), equalTo("Mrs")),
                seeThat(TheTarget.valueOf(ContactForm.FIRST_NAME), equalTo("Sarah-Jane")),
                seeThat(TheTarget.valueOf(ContactForm.LAST_NAME), equalTo("Smith"))
        );
    }


}
