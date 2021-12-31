package maburhan.aminpetclinic.services.map;

import maburhan.aminpetclinic.model.Specialty;
import maburhan.aminpetclinic.repositories.map.SpecialityMapRepository;
import maburhan.aminpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class SpecialtyServiceMap extends AbstractMapService<Specialty, Long, SpecialityMapRepository>
        implements SpecialtyService {

    public SpecialtyServiceMap(SpecialityMapRepository repository) {
        super(repository);
    }
}
