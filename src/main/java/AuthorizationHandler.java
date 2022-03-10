import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class AuthorizationHandler {

    public void readDataBase(String index) throws ClassNotFoundException, SQLException {
        try {

            AuthorizationData authorizationData = new AuthorizationData();
            authorizationData.setUrl("jdbc:postgresql://localhost:5432/indicatorbase");
            authorizationData.setUser("postgres");
            authorizationData.setPassword("3219652");

            ConnectionPostgresAuthorization connectionPostgresAuthorization = new ConnectionPostgresAuthorization(authorizationData);

            Connection connection = connectionPostgresAuthorization.createConnection();

//
            PreparedStatement ps = null;
            ps = connection.prepareStatement("SELECT * FROM public.userdata WHERE id ='" + index + "'");

               // Get data from Oracle Database
              ResultSet result = ps.executeQuery();
               while (result.next())
               {
                    System.out.println(">>>>> value " + result.getString(3));
               }

            if (connection != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {

        }
    }
}