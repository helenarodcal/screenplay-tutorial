package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class CookiesSettings {
    private static final Target ACCEPT_COOKIES_BUTTON = Target.the("Accept all cookies button").locatedBy("//button[contains(., 'Accept')]");
    private static final  Target END_COOKIE_CONFIGURATION = Target.the("Finish configuration button").locatedBy("#cb-confirmedSettings button");

    public static Performable acceptAll() {
        return Task.where(
                Click.on(ACCEPT_COOKIES_BUTTON),
                Click.on(END_COOKIE_CONFIGURATION)
        );
    }
}
