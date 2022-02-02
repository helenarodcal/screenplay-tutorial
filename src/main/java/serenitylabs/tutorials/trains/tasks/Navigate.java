package serenitylabs.tutorials.trains.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class Navigate {
    public static Performable to(Target link) {
        return Task.where("{0} navigates to #link",
                Click.on(link)).with("link").of(link.toString());
    }
}
