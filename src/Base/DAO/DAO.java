package Base.DAO;

import java.util.List;

public interface DAO<T> {

    void insertDB(T t);

    List<T> getAll();

}
