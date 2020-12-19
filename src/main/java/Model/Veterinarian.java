package Model;

import Enums.VeterinarianSpeciality;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "petclinic", name = "veterinarian")

public class Veterinarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int veterinarianId;

    @Column(name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "address")
    private String address;

    @Enumerated(value = EnumType.STRING)
    @Column (name = "speciality")
    private VeterinarianSpeciality speciality;

    @OneToMany(mappedBy = "veterinarian")
    private List<Consult> consultList;

    public Veterinarian(){}

    public Veterinarian (String firstName, String lastName, String address, VeterinarianSpeciality speciality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.speciality = speciality;
    }

    public int getVeterinarianId () {
        return veterinarianId;
    }

    public void setVeterinarianId (int veterinarianId) {
        this.veterinarianId = veterinarianId;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public VeterinarianSpeciality getSpeciality () {
        return speciality;
    }

    public void setSpeciality (VeterinarianSpeciality speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString () {
        return "Veterinarian{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
