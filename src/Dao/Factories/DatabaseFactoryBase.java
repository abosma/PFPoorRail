package Dao.Factories;

import Dao.Connections.IConnection;
import Dao.IDao;

public abstract class DatabaseFactoryBase
{
    public abstract IConnection GetConnection();
    public abstract IDao GetDoa();
}
