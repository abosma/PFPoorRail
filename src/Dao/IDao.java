package Dao;

import Model.IItem;

import java.util.List;
import java.util.Map;

public interface IDao
{
    List<IItem> GetAll();
    void Store(IItem item);

}
