package maburhan.aminpetclinic.services.map;

import maburhan.aminpetclinic.model.Visit;
import maburhan.aminpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class VisitServiceMap extends AbstractMapService<Visit> implements VisitService {
}
