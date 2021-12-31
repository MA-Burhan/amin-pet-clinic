package maburhan.aminpetclinic.repositories.map;

import java.util.Set;

public interface CrudMapRepository<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
