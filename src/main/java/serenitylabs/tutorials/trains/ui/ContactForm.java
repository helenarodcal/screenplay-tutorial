package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ContactForm {
    public static final Target TITLE =
            Target.the("Title").locatedBy("#PersonalDetails_Title");
    public static final Target FIRST_NAME =
            Target.the("Title").located(By.name("PersonalDetails.FirstName"));
    public static final Target LAST_NAME =
            Target.the("Title").located(By.name("PersonalDetails.LastName"));
}
