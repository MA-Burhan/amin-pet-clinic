package se.aminburhan.aminpetclinic.services.map;

import se.aminburhan.aminpetclinic.model.Owner;
import se.aminburhan.aminpetclinic.services.OwnerService;

import java.util.Map;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        for (Map.Entry<Long, Owner> entry : map.entrySet()) {
            if (entry.getValue().getLastName().equals(lastName)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public Owner save(Owner object) {
        return map.put(object.getId(), object);
    }
}
