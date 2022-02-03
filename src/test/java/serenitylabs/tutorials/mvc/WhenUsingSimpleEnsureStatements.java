package serenitylabs.tutorials.mvc;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ensure.web.NamedExpectation;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.mvc.dto.Pet;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@RunWith(SerenityRunner.class)
public class WhenUsingSimpleEnsureStatements {

    LocalDate januaryFirst2017 = LocalDate.of(2017, Month.JANUARY, 1);
    LocalDate januaryFirst2019 = LocalDate.of(2019, Month.JANUARY, 1);
    Actor penny = Actor.named("Penny");
//    Pet fido = new Pet("Fido the dog", 5) ;
    Pet fido = new Pet("Fido the dog", januaryFirst2017) ;

    @Test
    public void we_should_be_able_to_make_assertions_about_strings() {

        penny.attemptsTo(
                Ensure.that(fido.getName()).isEqualTo("Fido the dog"),
                Ensure.that(fido.getName()).startsWith("Fido"),
                Ensure.that(fido.getName()).endsWith("dog")
        );

    }

    @Test
    public void we_should_be_able_to_make_assertions_about_integers() {

        penny.attemptsTo(
                Ensure.that(fido.getAge()).isEqualTo(5),
                Ensure.that(fido.getAge()).isGreaterThan(1),
                Ensure.that(fido.getAge()).isStrictlyBetween(3,6)
        );
    }

    @Test
    public void we_should_be_able_to_compare_dates() {
        penny.attemptsTo(
                Ensure.that(fido.getDateOfBirth()).isBefore(januaryFirst2019)
        );
    }

    //COLLECTIONS
    List<String> colours = Arrays.asList("red", "green", "blue");
    List<String> primaryColours = Arrays.asList("red", "blue", "yellow");
    List<String> secondaryColours = Arrays.asList("green", "pink", "orange");

    @Test
    public void matchingColours() {
        penny.attemptsTo(
                Ensure.that(colours).contains("red", "blue"),
                Ensure.that(colours).isNotEmpty(),
                Ensure.that(colours).hasSize(3),
                Ensure.that(colours).doesNotHaveDuplicates(),
                Ensure.that(colours).containsAnyOf("green", "pink"),
                Ensure.that(colours).doesNotContain("black")
        );
    }

    @Test
    public void containsAPrimaryColor() {
        penny.attemptsTo(
                Ensure.that(colours).anyMatch(
                        "a primary colour",
                        colour -> colour.equals("red") || colour.equals("blue") || colour.equals("yellow")

                )
        );

        penny.attemptsTo(
                Ensure.that(colours).noMoreThan(2,
                        "a primary colour",
                        colour -> colour.equals("red") || colour.equals("blue") || colour.equals("yellow")

                )
        );

        penny.attemptsTo(
                Ensure.that(primaryColours).allMatch(
                        "a primary colour",
                        colour -> colour.equals("red") || colour.equals("blue") || colour.equals("yellow")

                )
        );

        penny.attemptsTo(
                Ensure.that(secondaryColours).noneMatch(
                        "a primary colour",
                        colour -> colour.equals("red") || colour.equals("blue") || colour.equals("yellow")

                )
        );
    }

    public static final NamedExpectation<String> IS_A_PRIMARY_COLOUR = new NamedExpectation<>(
            "a primary colour",
            colour -> colour.equals("red") || colour.equals("blue") || colour.equals("yellow")
    );
    @Test
    public void containsAPrimaryColorRefactored() {
        penny.attemptsTo(
                Ensure.that(colours).anyMatch(IS_A_PRIMARY_COLOUR)
        );

        penny.attemptsTo(
                Ensure.that(colours).noMoreThan(2, IS_A_PRIMARY_COLOUR)
        );

        penny.attemptsTo(
                Ensure.that(primaryColours).allMatch(IS_A_PRIMARY_COLOUR)
        );

        penny.attemptsTo(
                Ensure.that(secondaryColours).noneMatch(IS_A_PRIMARY_COLOUR)
        );
    }
}
