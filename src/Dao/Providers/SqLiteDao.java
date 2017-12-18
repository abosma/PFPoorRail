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
                IItem instance = (IItem) Class.forName(type).newInstance();

                if(instance == null)
                    continue;

                instance.SetId(id);
                instance.SetName(name);
            }
            catch (Exception ex)
            {
                //ignore
            }

        }
        return items;
    }

    @Override
    public void Store(IItem item)
    {

    }

    /**
     * Create tables
     */
    private void EnsureCreated()
    {
        String sql = "CREATE TABLE IF NOT EXISTS Items (\n"
                + "	Id integer PRIMARY KEY,\n"
                + "	Name text NOT NULL,\n"
                + "	Type text NOT NULL"
                + ");";

        _connection.NonQuery(sql);
    }
}
