package maburhan.aminpetclinic.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Table(name = "specialty")
public class Specialty extends NamedEntity{

    public Specialty(String name) {
        super(name);
    }
}
