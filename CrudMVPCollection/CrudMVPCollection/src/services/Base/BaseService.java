package services.Base;

import models.*;

import java.util.List;

public interface BaseService <T>
{

    List<T> GetAllData();
    void Insert(T t);

    T getById(Integer id);

    void update(T t,Integer id);

    void delete(Integer id);
}
