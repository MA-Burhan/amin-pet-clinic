package maburhan.aminpetclinic.services.map;

import maburhan.aminpetclinic.repositories.map.CrudMapRepository;
import maburhan.aminpetclinic.services.CrudService;

import java.util.Set;

public abstract class AbstractMapService<T, ID, U extends CrudMapRepository<T, ID>>
        implements CrudService<T, ID> {

    protected final U repository;

    public AbstractMapService(U repository) {
        this.repository = repository;
    }

    @Override
    public Set<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public T save(T object) {
        return repository.save(object);
    }

    @Override
    public void delete(T object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}
