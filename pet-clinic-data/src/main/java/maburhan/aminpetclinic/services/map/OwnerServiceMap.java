package maburhan.aminpetclinic.services.map;

import maburhan.aminpetclinic.model.Owner;
import maburhan.aminpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class OwnerServiceMap extends AbstractMapService<Owner> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
//        for (Map.Entry<Long, Owner> entry : map.entrySet()) {
//            if (entry.getValue().getLastName().equalsIgnoreCase(lastName)) {
//                return entry.getValue();
//            }
//        }

        for (Owner owner : map.values()) {
            if (owner.getLastName().equalsIgnoreCase(lastName)) {
                return owner;
            }
        }
        return null;
    }

}
