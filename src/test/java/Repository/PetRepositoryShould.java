package Repository;

import Enums.Race;
import Enums.Species;
import Model.Consult;
import Model.Pet;
import Model.Pet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PetRepositoryShould {

    PetRepository petRepository = new PetRepository ();

    @AfterEach
    public void cleanup() {
        petRepository.deleteAll();
    }

    @Test
    public void getAllPets(){
        Pet pet1 = buildPet();
        petRepository.addPet(pet1);

        List<Pet> petList = petRepository.getAllPets();

        assertEquals(1, petRepository.getAllPets().size());
        assertPet(pet1, petList.get(0));
    }

    @Test
    public void addPet() {
        Pet pet1 = buildPet();
        pet1.setPetId(25);
        petRepository.addPet(pet1);

        Pet pet2 = petRepository.getPetById(pet1.getPetId());

        assertEquals(pet1.getPetId(), pet2.getPetId ());
    }

    @Test
    public void updatePet(){
        Pet pet1 = buildPet();
        Pet pet2 = petRepository.addPet(pet1);
        pet2.setOwnerName ("Dogson");

        petRepository.updatePet(pet2);

        Pet updatedPet = petRepository.getPetById (pet2.getPetId());
        assertEquals("Dogson", updatedPet.getOwnerName());
    }

    @Test
    public void deletePet(){
        Pet pet1 = buildPet();
        Pet pet2 = petRepository.addPet(pet1);

        petRepository.deletePet(pet1);
        assertNull(petRepository.getPetById(pet2.getPetId ()));
    }

    @Test
    public void getPetById(){
        Pet pet1 = buildPet();
        petRepository.addPet(pet1);

        List<Pet> petList = petRepository.getAllPets ();

        assertEquals(1, petList.size());
        assertPet(pet1, petList.get(0));
    }

    private void assertPet(Pet firstPet, Pet secondPet){
        DateFormat df = new SimpleDateFormat ("dd-MM-yyyy");
        assertEquals(firstPet.getSpecies(), secondPet.getSpecies());
        assertEquals(firstPet.getRace(), secondPet.getRace());
        assertEquals(firstPet.isVaccinated(), secondPet.isVaccinated());
        assertEquals(df.format(firstPet.getDateOfBirth()), df.format(secondPet.getDateOfBirth()));
        assertEquals(firstPet.getOwnerName(), secondPet.getOwnerName());
        assertEquals(firstPet.getPetId (), secondPet.getPetId ());
    }

    private Pet buildPet(){
        Pet pet = new Pet();
        pet.setSpecies (Species.CAT);
        pet.setRace (Race.BIRMANEZA);
        pet.setVaccinated(true);
        pet.setDateOfBirth (new Date ());
        pet.setOwnerName ("Miawson");

        return pet;
    }

}