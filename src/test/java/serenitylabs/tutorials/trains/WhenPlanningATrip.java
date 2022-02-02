package serenitylabs.tutorials.trains;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenitylabs.tutorials.trains.dto.Customer;
import serenitylabs.tutorials.trains.questions.SearchResults;
import serenitylabs.tutorials.trains.questions.TheContactDetails;
import serenitylabs.tutorials.trains.questions.TheSearchResults;
import serenitylabs.tutorials.trains.questions.TheServiceLines;
import serenitylabs.tutorials.trains.tasks.EnterContactDetails;
import serenitylabs.tutorials.trains.tasks.Navigate;
import serenitylabs.tutorials.trains.tasks.Search;
import serenitylabs.tutorials.trains.tasks.SelectMenu;
import serenitylabs.tutorials.trains.ui.CookiesSettings;
import serenitylabs.tutorials.trains.ui.HelpAndContacts;
import serenitylabs.tutorials.trains.ui.TFLHomePage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;
import static serenitylabs.tutorials.trains.dto.Customer.ACustomer;
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
        carrie.attemptsTo(
                Open.browserOn().the(TFLHomePage.class),
                CookiesSettings.acceptAll()
        );
    }

    @Test
    public void the_TFL_page_title_should_be_visible() {

        carrie.should(seeThat(TheWebPage.title(), containsString("Transport for London")));
    }

    @Test
    public void the_status_updates_page_title_should_be_visible() {
        carrie.attemptsTo(
                SelectMenu.option(STATUS_UPDATES)
        );

        carrie.should(seeThat(TheWebPage.title(), containsString("status updates")));
    }

    @Test
    public void should_be_able_to_search_for_station_details() {
        carrie.attemptsTo(Search.forStation("Waterloo"));

        carrie.should(seeThat(
                SearchResults.heading(), equalTo("Search: Waterloo")
        ));

    }

    @Test
    public void should_list_all_relevant_station_information() {
        carrie.attemptsTo(Search.forStation("Jubilee"));

        //check first title contains searched string
        carrie.should(seeThat(
                TheSearchResults.firstArticleHeading(), containsString("Jubilee")
        ));
        //check all descriptions contain searched string
        carrie.should(seeThat(
                TheSearchResults.descriptions(), everyItem(containsString("Jubilee"))
        ));

    }

    @Test
    public void should_see_status_updates() {
        carrie.attemptsTo(
                SelectMenu.option(STATUS_UPDATES)
        );

//        WebDriverManager.chromedriver().setup();
//        ChromeDriver driver = new ChromeDriver();
//        driver.navigate().to("https://tfl.gov.uk");
//        driver.findElement(By.linkText("Status updates")).click();
//        String disruptionText = driver.findElement(By.cssSelector(".service-name.northern + .disruption-summary")).getText();
//
//        System.out.println(disruptionText);
        carrie.should(seeThat(
                TheServiceLines.displayed(), hasItems("Bakerloo", "Circle", "District")
        ));

    }

    @Test
    public void should_be_able_to_contact_tfl() {
        //GIVEN
        carrie.attemptsTo(
                SelectMenu.option(HELP_AND_CONTACTS),
                Navigate.to(HelpAndContacts.AboutOyster.TFLApp)
        );

        //WHEN
        Customer sarahJane = ACustomer.withTitle("Mrs").andFirstName("Sarah-Jane").andLastName("Smith");
        carrie.attemptsTo(EnterContactDetails.forCustomer(sarahJane));

        //THEN
        carrie.should(
                seeThat(TheContactDetails.title(), equalTo("Mrs")),
                seeThat(TheContactDetails.firstName(), equalTo("Sarah-Jane")),
                seeThat(TheContactDetails.lastName(), equalTo("Smith"))
        );
    }


}
