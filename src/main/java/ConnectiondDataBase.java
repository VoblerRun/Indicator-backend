import java.sql.Connection;
import java.sql.ResultSet;

abstract public class ConnectiondDataBase {

    abstract Connection createConnection();

    abstract ResultSet getSqlQuery(String sql);

}
