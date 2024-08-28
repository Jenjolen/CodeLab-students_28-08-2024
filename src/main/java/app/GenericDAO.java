package app;

public interface GenericDAO<T,D> {
    void saveEntity(T entity);

    int deleteEntity(D id);

    T findEntity(D id);

    T updateEntity(T entity, D id);

}
