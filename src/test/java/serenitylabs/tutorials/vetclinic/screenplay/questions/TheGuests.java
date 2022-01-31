package serenitylabs.tutorials.vetclinic.screenplay.questions;

import net.serenitybdd.screenplay.Question;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

import java.util.Collection;
import java.util.List;

public class TheGuests {

    public static Question<Collection<Pet>> onTheWaitingListAt(PetHotel petHotel) {
        return TheGuestsOnTheWaitingList.forThe(petHotel);
    }

    public static Question<List<Pet>> registeredInTheHotel(PetHotel petHotel) {
        return TheRegisteredGuests.in(petHotel);
    }
}
