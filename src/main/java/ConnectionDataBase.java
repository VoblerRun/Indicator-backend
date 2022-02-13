import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class ConnectionDataBase {

    public void readDataBase() throws ClassNotFoundException, SQLException {
        try {

            DatabaseConnectionData databaseConnectionData = new DatabaseConnectionData();
            databaseConnectionData.setUrl("jdbc:postgresql://localhost:5432/indicatorbase");
            databaseConnectionData.setUser("postgres");
            databaseConnectionData.setPassword("3219652");

            ConnectionPostgresAuthorization connectionPostgresAuthorization = new ConnectionPostgresAuthorization(databaseConnectionData);

            Connection connection = connectionPostgresAuthorization.createConnection();

//            Statement statement = null;

//            PreparedStatement st = connection.prepareStatement("INSERT INTO userdata (id, login, password) VALUES (?, ?, ?)");
//            st.setString(1, "vov123");
//            st.setString(2, "vovchik");
//            st.setString(3, "123456789");
//            st.executeUpdate();

//                statement = connection.createStatement();

                // выполнить SQL запрос
//                statement.execute(createTableSQL);


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