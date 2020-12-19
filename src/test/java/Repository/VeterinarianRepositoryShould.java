package Repository;

import Enums.VeterinarianSpeciality;
import Model.Veterinarian;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VeterinarianRepositoryShould {

    VeterinarianRepository veterinarianRepository = new VeterinarianRepository ();

    @Test
    public void seeAllVeterinarians(){

        //setup
        Veterinarian vet1 = new Veterinarian();
        veterinarianRepository.addVeterinarian(vet1);

        //execute
        List<Veterinarian> veterinarianList = veterinarianRepository.seeAllVeterinarians();

        //verify
        assertEquals(vet1.toString (), veterinarianList.get(0).toString());

        //cleanup
        veterinarianRepository.deleteVeterinarian (vet1);
        veterinarianList.clear();
    }

    @Test
    public void addVeterinarian(){

        //setup
        Veterinarian vet2 = new Veterinarian();

        //execute
        veterinarianRepository.addVeterinarian(vet2);

        //verify
        assertEquals(1, veterinarianRepository.seeAllVeterinarians().size());

        //clear
        veterinarianRepository.deleteVeterinarian (vet2);

    }

    @Test
    public void updateVeterinarian(){

        //setup
        Veterinarian vet3 = new Veterinarian("Dog", "Dogson", "DogLand", VeterinarianSpeciality.DOGS);

        //execute
        vet3.setFirstName ("Miaw");
        veterinarianRepository.updateVeterinarian (vet3);
        //verify
        assertEquals("Miaw", vet3.getFirstName());

        //clear
        veterinarianRepository.deleteVeterinarian (vet3);
    }

    @Test
    public void deleteVeterinarian(){

        //setup
        Veterinarian vet4 = new Veterinarian();

        //execute
        veterinarianRepository.deleteVeterinarian (vet4);

        //verify
        assertEquals(null, veterinarianRepository.getVeterinarianById (27));

        //clear
        veterinarianRepository.deleteVeterinarian (vet4);

    }

    @Test
    public void getVeterinarianById(){

        //setup
        Veterinarian vet5 = new Veterinarian();
        veterinarianRepository.addVeterinarian(vet5);
        vet5.setVeterinarianId(0);
        veterinarianRepository.updateVeterinarian(vet5);

        //execute

        vet5.setVeterinarianId(0);
        veterinarianRepository.updateVeterinarian(vet5);

        //verify
        assertEquals (0, vet5.getVeterinarianId());

        veterinarianRepository.deleteVeterinarian (vet5);


    }
}