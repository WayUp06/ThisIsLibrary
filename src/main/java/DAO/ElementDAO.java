package DAO;

import java.util.Collection;

public interface ElementDAO<E> {
    void add(E e);
    void update(E e);
    E get(Long eID);
    Collection<E> getAll();
    void delete(E e);
}
