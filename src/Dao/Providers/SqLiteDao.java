package Dao.Providers;

import Dao.Connections.IConnection;
import Dao.IDao;
import Model.IItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SqLiteDao implements IDao
{
    private IConnection _connection;

    public SqLiteDao(IConnection connection)
    {
        _connection = connection;
        EnsureCreated();
    }


    @Override
    public List<IItem> GetAll()
    {
        String query = "SELECT Id, Name, Type FROM Items;";

        //Get all the items
        List<Map<String,Object>> data = _connection.Query(query);
        List<IItem> items = new ArrayList<>();
        for(Map<String,Object> item : data)
        {
            int id = (int)item.get("Id");
            String name = (String)item.get("Name");
            String type = (String)item.get("Type");

            try
            {
                //Create a new instance of the type and set data
                IItem instance = (IItem) (Class.forName(type.replace("class ","")).newInstance());

                if(instance == null)
                    continue;

                instance.SetId(id);
                instance.SetName(name);
                items.add(instance);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
                //ignore
            }

        }
        return items;
    }

    @Override
    public int Store(IItem item)
    {
        if(item.getId() > 0)
        {
            String sql = "UPDATE Items SET Name = ?, Type = ? WHERE Id = ?";
            _connection.NonQuery(sql,item.getName(),item.getClass(),item.getId());
            return item.getId();
        }


        String sql = "INSERT INTO Items (Name,Type) VALUES (?,?);";
        return _connection.Scalar(sql,item.getName(),item.getClass());
    }

    @Override
    public boolean Remove(IItem item)
    {
        String sql = "DELETE FROM Items WHERE Id = ?";
        return _connection.NonQuery(sql,item.getId());
    }

    /**
     * Create tables
     */
    private void EnsureCreated()
    {
        String sql = "CREATE TABLE IF NOT EXISTS Items (\n"
                + "	Id integer PRIMARY KEY,\n"
                + "	Name text NOT NULL,\n"
                + "	Type text NOT NULL);";

        _connection.NonQuery(sql);
    }
}