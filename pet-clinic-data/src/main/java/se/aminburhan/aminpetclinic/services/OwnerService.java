package se.aminburhan.aminpetclinic.services;

import se.aminburhan.aminpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);


}
