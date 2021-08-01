package maburhan.aminpetclinic.services;

import maburhan.aminpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);


}
