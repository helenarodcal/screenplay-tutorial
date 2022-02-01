package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

//public class MenuBar {
//    public static final Target STATUS_UPDATES
//            = Target.the("Status updates menu").located(By.linkText("Status updates"));
//    public static final Target HELP_AND_CONTACTS
//            = Target.the("Status updates menu").located(By.linkText("Help & contacts"));
//}
public enum MenuBar {
    STATUS_UPDATES(By.linkText("Status updates")),
    HELP_AND_CONTACTS(By.linkText("Help & contacts"));

    private final By byLocator;

    MenuBar(By byLocator) {
        this.byLocator = byLocator;
    }

    public Target menuOption(){
        return Target.the(this.name()).located(byLocator);
    }
}