package serenitylabs.tutorials.vetclinic.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

import java.util.Collection;

@Subject("the pets in the waiting list")
public class TheGuestsOnTheWaitingList implements Question<Collection<Pet>> {

    private final PetHotel petHotel;

    public TheGuestsOnTheWaitingList(PetHotel petHotel) {
        this.petHotel = petHotel;
    }

    @Override
    public Collection<Pet> answeredBy(Actor actor) {
        return petHotel.getWaitingList();
    }

    public static Question<Collection<Pet>> forThe(PetHotel petHotel) {
        return new TheGuestsOnTheWaitingList(petHotel);
    }
}
