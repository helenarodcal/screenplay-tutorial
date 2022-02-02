package serenitylabs.tutorials.trains.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import serenitylabs.tutorials.trains.ui.MenuBar;

public class SelectMenu {
        public static Performable option(MenuBar menuOption) {
            return Task.where("{0} selects the menu option #menuOption",
                    Click.on(menuOption.menuOption())).with("menuOption").of(menuOption.name());
    }
}
