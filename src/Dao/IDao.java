package Dao;

import Model.IItem;

import java.util.List;

public interface IDao
{
    List<IItem> GetAll();
    int Store(IItem item);
    boolean Remove(IItem item);

}
