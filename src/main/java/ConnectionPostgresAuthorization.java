import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPostgresAuthorization extends ConnectionDataBase{

    private Connection connection = null;

    private DatabaseConnectionData databaseConnectionData = new DatabaseConnectionData();

    ConnectionPostgresAuthorization(DatabaseConnectionData databaseConnectionData){
        this.databaseConnectionData = databaseConnectionData;
    }

    public Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return connection = DriverManager.getConnection(databaseConnectionData.getUrl(), databaseConnectionData.getUser(), databaseConnectionData.getPassword());
    }

}
