package maburhan.aminpetclinic.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Table(name = "pet_type")
public class PetType extends NamedEntity {

    public PetType(String name) {
        super(name);
    }
}
