package Dao.Connections;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqLiteConnection implements IConnection
{
    @Override
    public String GetConnectionString()
    {
        return "jdbc:sqlite:C:/temp/railway.db";
    }

    @Override
    public Connection CreateConnection() throws SQLException
    {
         return DriverManager.getConnection(GetConnectionString());
    }

    @Override
    public boolean NonQuery(String query, Object... params)
    {
        try
        {
            PreparedStatement statement = CreateConnection()
                    .prepareStatement(query);

            for(int i = 0; i < params.length; i++)
            {
                statement.setObject((i + 1),params[i]);
            }
            return statement.execute();

        }
        catch (SQLException ex)
        {
            return false;
        }

    }

    @Override
    public <T> T Scalar(String query, Object... params)
    {
        try
        {
            PreparedStatement statement = CreateConnection()
                    .prepareStatement(query);

            for(int i = 0; i < params.length; i++)
            {
                statement.setObject((i + 1),params);
            }
            ResultSet result = statement.executeQuery();
            while (result.next())
            {
                ResultSetMetaData meta = result.getMetaData();
                int columns = meta.getColumnCount();
                for (int i = 0; i < columns; i++)
                {
                    return (T)result.getObject(i + 1);
                }
            }

        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Map<String, Object>> Query(String query, Object... params)
    {
        try
        {
            PreparedStatement statement = CreateConnection()
                    .prepareStatement(query);

            for(int i = 0; i < params.length; i++)
            {
                statement.setObject((i + 1),params);
            }
            ResultSet result = statement.executeQuery();
            List<Map<String, Object>> values = new ArrayList<>();

            while (result.next())
            {
                ResultSetMetaData meta = result.getMetaData();
                int columns = meta.getColumnCount();
                Map<String, Object> data = new HashMap<>();
                for (int i = 0; i < columns; i++)
                {
                    data.put(meta.getColumnName(i + 1),result.getObject(i + 1));
                }
                values.add(data);
            }

            return values;

        }
        catch (SQLException ex)
        {
            return new ArrayList<>();
        }
    }
}
