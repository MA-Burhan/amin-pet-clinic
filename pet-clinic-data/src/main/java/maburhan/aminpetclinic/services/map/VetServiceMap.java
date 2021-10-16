package maburhan.aminpetclinic.services.map;

import maburhan.aminpetclinic.model.Vet;
import maburhan.aminpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class VetServiceMap extends AbstractMapService<Vet> implements VetService {

}
