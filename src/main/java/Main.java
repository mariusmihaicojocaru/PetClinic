import Connection.HibernateUtils;
import Enums.Race;
import Enums.Species;
import Enums.VeterinarianSpeciality;
import Model.Consult;
import Model.Pet;
import Model.Veterinarian;
import Repository.ConsultRepository;
import Repository.PetRepository;
import Repository.VeterinarianRepository;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.util.Date;

import static javafx.application.Application.launch;

public class Main extends Application {
    public static void main (String[] args) {

        Application.launch (args);

//        Session session = HibernateUtils.getSessionFactory().openSession();
//
//        if(session != null){
//            System.out.println ("da");
//        }else{
//            System.out.println ("nu");
//        }

        //TODO VeterinarianRepository terminat(pana acum)

        Veterinarian vet1 = new Veterinarian("Dog", "Dogson", "DogLand", VeterinarianSpeciality.DOGS);
        Veterinarian vet2 = new Veterinarian("Miaw", "Miawson", "MiawLand", VeterinarianSpeciality.CATS);
        Veterinarian vet3 = new Veterinarian("Cojocaru", "Marius", "Romania", VeterinarianSpeciality.PARROTS);

        VeterinarianRepository veterinarianRepository = new VeterinarianRepository ();

        veterinarianRepository.addVeterinarian(vet1);
        veterinarianRepository.addVeterinarian(vet2);
        veterinarianRepository.addVeterinarian(vet3);

//        veterinarianRepository.seeAllVeterinarians();

//        System.out.println (veterinarianRepository.getVeterinarianById(2).toString ());

//        veterinarianRepository.deleteVeterinarian (vet1);

        //TODO PetRepository terminat(pana acum)

        Pet pet1 = new Pet (Species.DOG, Race.GOLDEN_RETREIVER, true, new Date (115,12,12), "Cainescu");
        Pet pet2 = new Pet (Species.CAT, Race.BIRMANEZA, true, new Date (117,05,15), "Pisicescu");
        Pet pet3 = new Pet (Species.PARROT, Race.AFRICAN, false, new Date (108,04,22), "Papalagman");

        PetRepository petRepository = new PetRepository();

        petRepository.addPet (pet1);
        petRepository.addPet (pet2);
        petRepository.addPet (pet3);

//        petRepository.getAllPets ();

//        System.out.println(petRepository.getPetById(2).toString());

//        petRepository.deletePet (pet2);

        //TODO ConsultRepository terminat(pana acum)

        ConsultRepository consultRepository = new ConsultRepository ();

        Consult consult1 = new Consult(new Date(120,4,4), "probleme cu vederea");
        Consult consult2 = new Consult(new Date(120,5,13), "supraponderal, necesita tratament");
        Consult consult3 = new Consult(new Date(120,11,1), "vorbeste prea mult");

        consult1.setVeterinarian (vet1);
        consult1.setPet (pet1);
        consultRepository.addConsult(consult1);

        consult2.setVeterinarian (vet2);
        consult2.setPet (pet2);
        consultRepository.addConsult(consult2);

        consult3.setVeterinarian (vet3);
        consult3.setPet (pet3);
        consultRepository.addConsult(consult3);

//        consult2.setDescription ("a murit, trebuie reanimat ca are credit la banci");
//        consultRepository.updateConsult(consult2);

//        consultRepository.viewAllConsults ();

//        System.out.println (consultRepository.getConsultById(2).toString());

//        consultRepository.deleteConsult (consult1);
    }

    @Override
    public void start (Stage primaryStage) {

        Button button = new Button ();
        button.setText ("Press me");
        button.setOnAction (new EventHandler<ActionEvent>(){

            @Override
            public void handle (ActionEvent event) {
                System.out.println ("Hello World");
            }
        });

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button);

        Scene scene = new Scene (stackPane, 500, 500);

        primaryStage.setTitle("Hello World Demo");
        primaryStage.setScene (scene);
        primaryStage.show();
    }
}
