package Dao.Connections;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public interface IConnection
{
    String GetConnectionString();
    Connection CreateConnection() throws SQLException;
    Statement CreateStatement() throws SQLException;
    boolean NonQuery(String query, Object... params);
    <T> T Scalar(String query, Object... params);
    List<Map<String, Object>> Query(String query, Object... params);
}
