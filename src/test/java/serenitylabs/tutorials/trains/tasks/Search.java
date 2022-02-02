package serenitylabs.tutorials.trains.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import serenitylabs.tutorials.trains.ui.TFLHomePage;

import static org.openqa.selenium.Keys.ENTER;

public class Search {
    public static Performable forStation(String station) {
        return Task.where("{0} searches for station #station",
                Enter.theValue(station).into(TFLHomePage.SEARCH).thenHit(ENTER)
        ).with("station").of(station);
    }
}
