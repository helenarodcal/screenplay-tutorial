package serenitylabs.tutorials.vetclinic.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;
import serenitylabs.tutorials.vetclinic.screenplay.APetHotel;
import serenitylabs.tutorials.vetclinic.screenplay.CheckIn;
import serenitylabs.tutorials.vetclinic.screenplay.questions.TheGuests;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;

@RunWith(SerenityRunner.class)
public class WhenCheckingIntoThePetHotel {

    @Test
    public void petra_books_her_pet_cat_into_the_hotel() {

        //GIVEN
        Actor petra = Actor.named("Petra the cat owner");
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel petHotel = PetHotel.called("Pet Hotel Fluffy Cares");

        //WHEN
        petra.attemptsTo(
//                new CheckIn(ginger, petHotel)
                CheckIn.thePet(ginger).into(petHotel)
        );

        //THEN
//        assertThat(petHotel.getPets()).contains(ginger);
        petra.should(seeThat(TheGuests.registeredInTheHotel(petHotel), hasItem(ginger)));
    }

    @Test
    public void petra_books_her_pet_cat_into_the_hotel_that_is_already_full() {
        //CAST
        Actor petra = Actor.named("Petra the cat owner");
        Pet ginger = Pet.cat().named("ginger");
        Actor harry = Actor.named("Harry the hotel manager");

        //GIVEN
        PetHotel petHotel = APetHotel.with(20).petsCheckedIn();

        //WHEN
        petra.attemptsTo(
                CheckIn.thePet(ginger).into(petHotel)
        );

        //THEN
        harry.should(
                seeThat(TheGuests.onTheWaitingListAt(petHotel), hasItem(ginger)),
                seeThat(TheGuests.registeredInTheHotel(petHotel), not(hasItem(ginger)))
        );
    }
}
