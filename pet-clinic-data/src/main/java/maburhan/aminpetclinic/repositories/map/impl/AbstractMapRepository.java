package maburhan.aminpetclinic.repositories.map.impl;

import maburhan.aminpetclinic.model.BaseEntity;
import maburhan.aminpetclinic.repositories.map.CrudMapRepository;

import java.util.*;

abstract public class AbstractMapRepository<T extends BaseEntity> implements CrudMapRepository<T, Long> {

    protected final Map<Long, T> map = new HashMap<>();

    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public T findById(Long id) {
        return map.get(id);
    }

    @Override
    public T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
            return object;
        }
        else {
            throw new IllegalArgumentException("Object cannot be null");
        }
    }

    private Long getNextId(){
        if (map.isEmpty()) {
            return 1L;
        } else {
            return Collections.max(map.keySet()) + 1;
        }
    }

    @Override
    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    @Override
    public void deleteById(Long id) {
        map.remove(id);
    }
}
