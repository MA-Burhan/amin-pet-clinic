package maburhan.aminpetclinic.services.jpa;

import maburhan.aminpetclinic.services.CrudService;
import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractJpaService<T, ID, U extends CrudRepository<T, ID>>
        implements CrudService<T, ID> {

    protected final U repository;

    public AbstractJpaService(U repository) {
        this.repository = repository;
    }

    @Override
    public Set<T> findAll() {
        Set<T> set = new HashSet<>();
        repository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public T findById(ID id) {
        return repository.findById(id).orElse(null);
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
