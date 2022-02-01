package serenitylabs.tutorials.utils;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class StopAndDebug {

    public static Performable here() {
        return Task.where("Stop and debug",
                actor -> {
                    System.out.println("DEBUGGING");
                }
        );
    }
}
