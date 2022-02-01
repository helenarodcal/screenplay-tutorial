package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.targets.Target;

public class StatusUpdatesPage {


    public static final Target SERVICE_LINES
            = Target.the("Service Lines").locatedBy(".service-name span");
    public static final Target SELECTED_SERVICE_LINE
            = Target.the("Selected service lina").locatedBy(".service-name.{0} + .disruption-summary");
}
