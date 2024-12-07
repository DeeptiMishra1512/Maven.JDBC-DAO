import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    /**
     * Connect to Database
     * @author hany.said
     */

    public static String URL = "jdbc:mysql://localhost:3306/JDBCExampleDB";
    public static String userName = "root";
    public static String passWord = "Oracle@1512";

    /**
     * Get a connection to database
     * @return Connection object
     */
    public static Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, userName, passWord);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }


}
