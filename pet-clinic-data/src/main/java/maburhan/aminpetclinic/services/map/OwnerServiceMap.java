package maburhan.aminpetclinic.services.map;

import org.springframework.stereotype.Service;
import maburhan.aminpetclinic.model.Owner;
import maburhan.aminpetclinic.services.OwnerService;

import java.util.Map;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        for (Map.Entry<Long, Owner> entry : map.entrySet()) {
            if (entry.getValue().getLastName().equals(lastName)) {
                return entry.getValue();
            }
        }
        return null;
    }

}