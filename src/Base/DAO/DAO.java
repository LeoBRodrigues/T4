package Base.DAO;

import java.util.List;

public interface DAO<T> {

    void insertDB(T t);

    void deleteDB(T t, int i);

    void alterDB(T t, int i);

    List<T> getAll();

}
