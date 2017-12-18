package Dao.Factories;

import Dao.Connections.IConnection;
import Dao.Connections.SqLiteConnection;
import Dao.IDao;
import Dao.Providers.SqLiteDao;

public class DatabaseFactory extends DatabaseFactoryBase
{
    @Override
    public IConnection GetConnection()
    {
        return new SqLiteConnection();
    }

    @Override
    public IDao GetDoa()
    {
        return new SqLiteDao(GetConnection());
    }
}
