package app;

import java.util.List;

public interface GenericDAO<T,D> {

    void saveEntity(T entity);

    int deleteEntity(D id);

    T findEntity(D id);

    T updateEntity(T entity, D id);

    List<T> findAll();

}
