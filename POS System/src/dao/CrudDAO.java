package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T, ID> extends SuperDAO {
    public boolean add(T t);

    public boolean update(T t);

    public boolean delete(T id);

    public ArrayList<T> getAll();

    public T search(ID id);
}
