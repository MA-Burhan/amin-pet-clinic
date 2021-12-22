package maburhan.aminpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
abstract public class NamedEntity extends BaseEntity{

    @Column(name = "name")
    private String name;

    public NamedEntity(Long id, String name) {
        super(id);
        this.name = name;
    }

}
