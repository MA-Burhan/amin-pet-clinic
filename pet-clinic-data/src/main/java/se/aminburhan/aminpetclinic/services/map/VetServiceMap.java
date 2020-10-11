package se.aminburhan.aminpetclinic.services.map;

import org.springframework.stereotype.Service;
import se.aminburhan.aminpetclinic.model.Vet;
import se.aminburhan.aminpetclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Vet save(Vet object) {
        return map.put(object.getId(), object);
    }
}
