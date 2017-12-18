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
        return "jdbc:sqlite:C:/sqlite/db/tests.db";
    }

    @Override
    public Connection CreateConnection() throws SQLException
    {
         return DriverManager.getConnection(GetConnectionString());
    }

    @Override
    public Statement CreateStatement() throws SQLException
    {
        return CreateConnection().createStatement();
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
                statement.setObject(i,params);
            }
            return statement.execute();

        }
        catch (SQLException ex)
        {
            return false;
        }

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
                statement.setObject(i,params);
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
                    data.put(meta.getColumnName(i),result.getObject(i));
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
