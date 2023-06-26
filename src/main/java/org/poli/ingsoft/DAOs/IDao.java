package org.poli.ingsoft.DAOs;

import java.util.List;

/**
 * Pattern DAO to abstract and encapsulate access to the data persistence layer
 * @param <T>
 * @param <V>
 */
public interface IDao<T,V> {
    public boolean createRecord(T model);
    public T readRecord(V idModel);
    public boolean updateRecord(T model, V idModel);
    public boolean deleteRecord(V idModel);
    public List<T> readRecords();
}
