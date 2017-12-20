package Dao;

import Model.IItem;

import java.util.List;

public interface IDao
{
    List<IItem> GetAll();
    void Store(IItem item);

}
