package serenitylabs.tutorials.trains.questions;

import net.serenitybdd.screenplay.questions.targets.TargetTextValues;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import serenitylabs.tutorials.trains.ui.StatusUpdatesPage;

public class TheServiceLines {
    public static TargetTextValues displayed() {
        return TheTarget.textValuesOf(StatusUpdatesPage.SERVICE_LINES);
    }
}
