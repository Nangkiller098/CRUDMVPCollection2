package repositories.Base;
import java.util.List;

public interface BaseRepository<T>
{
    List<T> FindAllData();
    void insert(T t);
    T findById(Integer id);
    void update(T t,Integer id);
    void delete(Integer id);
}
