package Model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(schema = "petclinic", name = "consultation")
public class Consult { //manytoone la veterinarian (in paranteza se trece cu cine este mapata)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int consultId;

    @ManyToOne
    @JoinColumn(name = "veterinarianId", foreignKey = @ForeignKey(name = "fk_veterinarian_consult"))
    private Veterinarian veterinarian; //era lista

    @ManyToOne
    @JoinColumn (name = "petId", foreignKey = @ForeignKey(name = "fk_pet_consult"))
    private Pet pet; //era lista

    @Column(name = "date")
    private Date date;

    @Column(name = "description")
    private String description;

    public Consult(){}

    public Consult (Date date, String description) {
        this.date = date;
        this.description = description;
    }

    public Consult (Veterinarian veterinarian, Pet pet, Date date, String description) {
        this.veterinarian = veterinarian;
        this.pet = pet;
        this.date = date;
        this.description = description;
    }

    public int getConsultId () {
        return consultId;
    }

    public void setConsultId (int consultId) {
        this.consultId = consultId;
    }

    public Veterinarian getVeterinarians () {
        return veterinarian;
    }

    public void setVeterinarian (Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }

    public Pet getPet () {
        return pet;
    }

    public void setPet (Pet pet) {
        this.pet = pet;
    }

    public Date getDate () {
        return date;
    }

    public void setDate (Date date) {
        this.date = date;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    @Override
    public String toString () {
        return "Consult{" +
                "date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
