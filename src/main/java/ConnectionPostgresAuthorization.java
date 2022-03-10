import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPostgresAuthorization extends AuthorizationHandler {

    private Connection connection = null;

    private AuthorizationData authorizationData = new AuthorizationData();

    ConnectionPostgresAuthorization(AuthorizationData databaseConnectionData){
        this.authorizationData = databaseConnectionData;
    }

    public Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return connection = DriverManager.getConnection(authorizationData.getUrl(), authorizationData.getUser(), authorizationData.getPassword());
    }

}
