package Base.DAO;

import java.util.List;

public interface DAO<T> {

    void insertDB();

    List<T> getAll();

}
