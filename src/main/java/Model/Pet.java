package Model;

import Enums.Race;
import Enums.Species;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "petclinic", name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int petId;

    @Enumerated(value = EnumType.STRING)
    @Column
    private Species species;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "race")
    private Race race;

    @Column(name = "vaccinated")
    private boolean isVaccinated;

    @Column(name = "birth_date")
    private Date dateOfBirth;

    @Column(name = "owner_name")
    private String ownerName;

    @OneToMany(mappedBy = "pet")
    private List<Consult> consultList;

    public Pet(){}

    public Pet (Species species, Race race, boolean isVaccinated, Date dateOfBirth, String ownerName) {

        this.species = species;
        this.race = race;
        this.isVaccinated = isVaccinated;
        this.dateOfBirth = dateOfBirth;
        this.ownerName = ownerName;
    }

    public int getPetId () {
        return petId;
    }

    public void setPetId (int petId) {
        this.petId = petId;
    }

    public boolean isVaccinated () {
        return isVaccinated;
    }

    public void setVaccinated (boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public Date getDateOfBirth () {
        return dateOfBirth;
    }

    public void setDateOfBirth (Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getOwnerName () {
        return ownerName;
    }

    public void setOwnerName (String ownerName) {
        this.ownerName = ownerName;
    }

    public Species getSpecies () {
        return species;
    }

    public void setSpecies (Species species) {
        this.species = species;
    }

    public Race getRace () {
        return race;
    }

    public void setRace (Race race) {
        this.race = race;
    }

    @Override
    public String toString () {
        return "Pet{" +
                "species='" + species + '\'' +
                ", race='" + race + '\'' +
                ", isVaccinated=" + isVaccinated +
                ", dateOfBirth=" + dateOfBirth +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
