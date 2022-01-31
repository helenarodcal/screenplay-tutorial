package serenitylabs.tutorials.vetclinic.screenplay;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

public class CheckIn implements Performable {
    private Pet pet;
    private PetHotel petHotel;

    public CheckIn(Pet pet, PetHotel petHotel) {
        this.pet = pet;
        this.petHotel = petHotel;
    }

    public static CheckInBuilder thePet(Pet pet){
        return new CheckInBuilder(pet);
    }

    @Step("{0} checks #pet into the hotel #petHotel")
    @Override
    public <T extends Actor> void performAs(T actor) {
        petHotel.checkIn(pet);
    }

    public static class CheckInBuilder {
        private final Pet pet;

        public CheckInBuilder(Pet pet) {
            this.pet = pet;
        }

        public Performable into(PetHotel petHotel) {
            return new CheckIn(pet, petHotel);
        }
    }
}
