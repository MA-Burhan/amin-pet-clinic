package maburhan.aminpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vet")
public class Vet extends Person{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialty",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    Set<Specialty> specialties = new HashSet<>();

    public boolean addSpecialty(Specialty specialty) {
        return specialties.add(specialty);
    }

    public Set<Specialty> getSpecialties(){
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties){
        this.specialties = specialties;
    }

}
